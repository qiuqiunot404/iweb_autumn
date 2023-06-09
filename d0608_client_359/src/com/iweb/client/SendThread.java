package com.iweb.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Guan
 * @date 2023/6/8 11:44
 */
public class SendThread extends Thread {
    Socket socket;

    //    传递客户端的socket对象引用给发送消息的线程
    public SendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(System.in);
            while (true){
                String str = sc.nextLine();
                if(socket.isConnected()){
                    OutputStream os = socket.getOutputStream() ;
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeUTF(str);
                }
            }
        } catch (IOException e) {

        }finally {
            try {
                socket.close();
                System.out.println("聊天结束");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
