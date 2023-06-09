package com.iweb.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Guan
 * @date 2023/6/8 11:31
 */
public class Server {
    public volatile static ArrayList<Socket> list = new ArrayList<>();

    public static void main(String[] args) {
        try {
            //创建服务器端socket对象并且指定监听端口
            ServerSocket ss = new ServerSocket(8888);
            //服务器端需要不断的去接受来自客户端的请求 并且将
            //客户端发送过来的socket对象进行存储
            while (true){
                //获取客户端socket
                Socket socket = ss.accept();
                //将获取到的客户端socket对象的引用存入到list集合中
                    list.add(socket);
                    System.out.println(socket.getInetAddress()+"已经成功连接,当前人数为:"+list.size());

                new ServerThread(socket,list).start();
            }
        } catch (Exception e) {

        }
    }
}
