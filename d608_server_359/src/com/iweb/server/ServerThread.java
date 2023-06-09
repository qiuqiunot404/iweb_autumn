package com.iweb.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 服务器端用来处理客户端socket的线程
 *
 * @author Guan
 * @date 2023/6/8 11:11
 */
public class ServerThread extends Thread {
    Socket socket;
    ArrayList<Socket> list;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;

    //提供一个构造方法 用来给服务器端启动线程的时候
    //进行引用传递

    public ServerThread(Socket socket, ArrayList<Socket> list) {
        this.socket = socket;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //获取当前接入的客户端用户对应的输入流
                is = socket.getInputStream();
                dis = new DataInputStream(is);
                //借助输入流 读取用户的socket对象中借助流所传递的消息
                String str = dis.readUTF();
                System.out.println(socket.getInetAddress() + ":" + str);
                //遍历所有的socket 向用户广播接受到的消息
                //为了方便遍历删除 使用迭代器进行删除
                Iterator<Socket> it = list.iterator();
                while (it.hasNext()) {
                    Socket st = it.next();
                    if (st.isConnected()) {
                        os = st.getOutputStream();
                        dos = new DataOutputStream(os);
                        dos.writeUTF(this.socket.getInetAddress() + ":" + str);
                    } else {
                        synchronized (list) {
                            it.remove();
                            System.out.println(st.getInetAddress() + "已经退出聊天室,当前在线人数为:" + list.size());
                        }
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            try {

                synchronized (list) {
                    socket.close();
                    list.remove(socket);
                    System.out.println(socket.getInetAddress() + "已经退出聊天室,当前在线人数为:" + list.size());
                }


            } catch (Exception e) {

            }
        }
    }
}
