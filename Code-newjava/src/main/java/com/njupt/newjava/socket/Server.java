package com.njupt.newjava.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wall
 * @date 2019/8/9  10:25
 * @description
 */
public class Server {
    public static void main(String[] args) {
        try (
                //指定监听端口
                ServerSocket server = new ServerSocket(10086);
                //监听客户端
                Socket  socket =server.accept();
                //获取输入流，读取客户端的消息
                InputStream in = socket.getInputStream();
                //利用装饰器，增加输入流的功能
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                //4、获取输出流，响应客户端的请求
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os);

                ){

            //读取客户端消息
            System.out.println("客户端说:"+bufferedReader.readLine());
            socket.shutdownInput();//关闭输入流
            pw.write("欢迎您！");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
