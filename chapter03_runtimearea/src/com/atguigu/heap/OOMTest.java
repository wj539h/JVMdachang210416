package com.atguigu.heap;

import java.util.ArrayList;
import java.util.Random;

/**
 * 测试OOM
 *
 * -Xms600m -Xmx600m
 * @author shkstart  shkstart@126.com
 * @create 2020  21:12
 */
public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<Picture>();
        while(true){
            try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            list.add(new Picture(1024 * 1024));
        }
    }
}

class Picture{
    private byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }
}
