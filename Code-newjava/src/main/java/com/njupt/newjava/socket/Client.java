package com.njupt.newjava.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author wall
 * @date 2019/8/9  10:26
 * @description
 */
public class Client {
    public static void main(String[] args) {
        try (//连接服务端
             Socket socket = new Socket("localhost",10086);
             //2、获取输出流，向服务器端发送信息
             OutputStream os = socket.getOutputStream();//字节输出流
             //将输出流包装成打印流
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
//             PrintWriter pw =new PrintWriter(os);
             ){
            //3、获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //效果一样的
            bufferedWriter.write("我是客户端");
            //清空缓冲区
            bufferedWriter.flush();
//            pw.write("我是客户端");
//            pw.flush();
            socket.shutdownOutput();
            System.out.println("服务器说："+br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
