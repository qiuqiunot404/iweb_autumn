package com.iweb.test2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Guan
 * @date 2023/6/8 10:34
 */
public class Server {
    private static List<String> defaultReplies = new ArrayList<>();
    static {
        defaultReplies.add("你干嘛,哎哟");
        defaultReplies.add("你是不是小黑子?说人话");
        defaultReplies.add("你是不是ikun?说话这么抽象");
        defaultReplies.add("我直接爆炸");
    }

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            while (true){
                String msg = dis.readUTF();
                System.out.println(msg);
                List<Reply> rs = ReplyDAO.query(msg);
                String response = "";
                if(rs.isEmpty()){
                    Collections.shuffle(defaultReplies);
                    response = defaultReplies.get(0);
                }else {
                    Collections.shuffle(rs);
                    response = rs.get(0).getResponse();
                }
                dos.writeUTF(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
