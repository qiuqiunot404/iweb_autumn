package com.iweb.client;

import jdk.internal.util.xml.impl.Input;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author Guan
 * @date 2023/6/8 11:52
 */
public class ReceiveThread extends Thread {
    Socket socket;

    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true){
                if(socket.isConnected()){
                    InputStream is = socket.getInputStream();
                    DataInputStream dis = new DataInputStream(is);
                    System.out.println(dis.readUTF());
                }
            }
        } catch (IOException e) {

        }finally {
            try {
                socket.close();
                System.out.println("聊天结束!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
