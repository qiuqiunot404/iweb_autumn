package com.iweb.test3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Guan
 * @date 2023/6/8 10:58
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            //分别启动发送消息和接受消息的线程
            new SendThread(s).start();
            new ReceiveThread(s).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
