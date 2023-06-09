package com.iweb.test3;

import jdk.internal.util.xml.impl.Input;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author Guan
 * @date 2023/6/8 10:55
 */
public class ReceiveThread extends Thread {
    private Socket s;
    public ReceiveThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        try {
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true){
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
