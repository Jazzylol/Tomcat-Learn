package com.coldridge.valley.simplehttpserver;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zzt on 2016/3/22.
 */
public class SimpleServer {

    public static void main(String[] args) throws Exception {
        init();
    }

    private static void init() throws Exception {


        ServerSocket server = new ServerSocket(12306, 1, InetAddress.getByName("127.0.0.1"));

        System.out.println("i have already to watch 127.0.0.1:12306 port wating......");
        Socket accept = server.accept();
        System.out.println("I have accept one socket running");

        InputStream in = accept.getInputStream();
        OutputStream out = accept.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = 0;
            while (i != -1) {
                i = in.read();
                sb.append((char) i);
            }
            break;
        }
        System.out.println("mssage is " + sb.toString());
        if (sb.toString().contains("HTTP")) {
            PrintWriter writer = new PrintWriter(out);
            writer.write("fffffffffffffffuuuuuuuuuuuuuuuuuuuccccccccccccccckkkkkkkkk");
            writer.write(sb.toString());
            writer.flush();
            writer.close();
        }
        reader.close();
    }

}
