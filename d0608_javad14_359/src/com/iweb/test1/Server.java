package com.iweb.test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/** 服务器端
 * @author Guan
 * @date 2023/6/8 9:01
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //创建服务器端 并且指定服务器端所使用端口为8888
        ServerSocket ss = new ServerSocket(8888);
        //在8888端口上进行监听 如果没有客户端发送请求
        //服务器就会一直处于监听状态
        Socket s = ss.accept();
        //客户端和服务器端数据的传输 都依赖与流实现
        //根据服务器端接受到的客户端 获取对应的输入流
        InputStream is = s.getInputStream();
        //基于这个输入流 获取对应的数据输入流
        DataInputStream dis = new DataInputStream(is);
        //再根据服务器端接受到的客户端获取对应的输出流
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true){
            String msg = dis.readUTF();
            System.out.println("收到客户端消息为:"+msg);
            dos.writeUTF(sc.nextLine());
        }

    }
}
