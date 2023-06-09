package com.iweb.test3;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Guan
 * @date 2023/6/8 11:00
 */
public class Client  {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",8888);
            //分别启动发送消息和接受消息的线程
            new SendThread(s).start();
            new ReceiveThread(s).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
