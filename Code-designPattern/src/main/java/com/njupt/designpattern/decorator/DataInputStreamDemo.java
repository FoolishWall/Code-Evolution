package com.njupt.designpattern.decorator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * @author wall
 * @date 2019/6/26  20:45
 * @description
 */
public class DataInputStreamDemo {

    public static void main(String[] args) {
        String name = "张三";
        int age = 23;
        String email = "892524460@qq.com";
        String phone = "13165044534";

        //数据型数据的输入输出流
        FileOutputStream fos = null;
        FileInputStream fis = null;
        DataOutputStream  dos = null;
        DataInputStream dis = null;
        try {
            try {
                //生成新文件user
                fos = new FileOutputStream("D:\\user.txt");
                dos = new DataOutputStream(fos);    //DataOutputStream中放的是对象
                //将数据输出到user中         UTF String类型
                dos.writeUTF(name);
                dos.writeInt(age);
                dos.writeUTF(email);
                dos.writeUTF(phone);

                //输入user中的数据
                fis = new FileInputStream("D:\\user.txt");
                fis.read();
                dis = new DataInputStream(fis);
                String uName = dis.readUTF();
                int uAge = dis.readInt();
                String uEamil = dis.readUTF();
                String uPhone = dis.readUTF();
                System.out.println("姓名:"+uName+"年龄:"+uAge+"邮箱:"+uEamil+"电话:"+uPhone);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }  finally{
            try {
                fos.close();
                fis.close();
                dos.close();
                dis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
