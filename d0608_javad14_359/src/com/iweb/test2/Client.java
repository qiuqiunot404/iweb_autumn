package com.iweb.test2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Guan
 * @date 2023/6/8 10:39
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",8888);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            Scanner sc = new Scanner(System.in);
            while (true){
                dos.writeUTF(sc.nextLine());
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
