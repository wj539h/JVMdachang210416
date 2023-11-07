package com.atguigu.java;

public class Math {
    public int compute() {
        int a = 10, b = 5;
        int c = calc(a + b);
        return c;
    }
    public int calc(int i) {
        i = i >> 2;
        return i;
    }
    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}