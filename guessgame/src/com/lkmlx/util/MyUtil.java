package com.lkmlx.util;

import java.util.Random;

/**
 * 工具类
 */
public class MyUtil {
    private MyUtil() {

    }

    /*    public static int getRandom(int max) {
        return new Random().nextInt(max + 1); // 因为nextInt是 [0,max) ，所以[0-max] 要+1
    }*/

    /**
     * 返回min - max 的随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机整数
     */
    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(getRandom(10,20));
//        }
//    }
}
