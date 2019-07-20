package com.njupt.exception;

/**
 * @author wall
 * @date 2019/7/19  21:22
 * @description 内存屏蔽，输出结果为：2
 */
public class TryCatchFinally {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test(){
        try {
            int a = 1;
            a = a / 0;
            return a;
        } catch (Exception e) {
            return -1;
        } finally{
            return -2;
        }
    }
}
