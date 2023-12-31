package com.atguigu.java;

/**
 * @author shkstart
 * @create 12:31
 */
class StaticA {
    static {
        try {Thread.sleep(1000);} catch (InterruptedException e) {}

        try {
            Class.forName("com.atguigu.java.StaticB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticA init OK");
    }
}

class StaticB {
    static {
        try {Thread.sleep(1000);} catch (InterruptedException e) {}

        try {
            Class.forName("com.atguigu.java.StaticA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticB init OK");
    }
}

public class StaticDeadLockMain extends Thread {
    private char flag;

    public StaticDeadLockMain(char flag) {
        this.flag = flag;
        this.setName("Thread" + flag);
    }

    @Override
    public void run() {
        try {
            Class.forName("com.atguigu.java.Static" + flag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " over");
    }

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        ClassLoader classLoader = StaticB.class.getClassLoader();
        System.out.println(classLoader);
        Class<JinWang> aClass = (Class<JinWang>) StaticB.class.getClassLoader().loadClass("com.atguigu.java.JinWang");
        System.out.println(aClass);
        /*StaticDeadLockMain loadA = new StaticDeadLockMain('A');
        loadA.start();
        StaticDeadLockMain loadB = new StaticDeadLockMain('B');
        loadB.start();*/
    }
}
class JinWang {
    //public static int a = 1;
    public static final int num2 = 1;
}