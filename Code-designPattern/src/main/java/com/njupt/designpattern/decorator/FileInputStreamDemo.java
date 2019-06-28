package com.njupt.designpattern.decorator;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wall
 * @date 2019/6/26  21:18
 * @description
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\test.txt");
            //以字节为单位读取文件内容，一次读一个字节
            System.out.println(fis.read());
            System.out.println((char) fis.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
