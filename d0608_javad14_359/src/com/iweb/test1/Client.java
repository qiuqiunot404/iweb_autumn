package com.iweb.test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Guan
 * @date 2023/6/8 9:05
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //创建本地客户端 并且指定客户端所连接的服务器端的
        //ip地址和端口 客户端自己的端口号由jvm自行分配
        Socket s = new Socket("127.0.0.1",8888);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        Scanner sc = new Scanner(System.in);
        while (true){
            dos.writeUTF(sc.nextLine());
            System.out.println("收到服务器消息为:"+dis.readUTF());
        }
    }
}
