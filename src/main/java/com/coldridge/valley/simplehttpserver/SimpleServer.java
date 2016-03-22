package com.coldridge.valley.simplehttpserver;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zzt on 2016/3/22.
 */
public class SimpleServer {

    public static void main(String[] args) throws Exception{
        init();
    }

    private static void init() throws Exception{


        ServerSocket server = new ServerSocket(12306,1,InetAddress.getByName("127.0.0.1"));

        Socket accept = server.accept();

        InputStream in = accept.getInputStream();
        OutputStream out = accept.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = "";
        while((line = reader.readLine())!=null){
            sb.append(line);
        }

        if(sb.toString().contains("HTTP")){
            PrintWriter writer =new PrintWriter(out);
            writer.write("fffffffffffffffuuuuuuuuuuuuuuuuuuuccccccccccccccckkkkkkkkk");
            writer.write(sb.toString());
            writer.flush();
            writer.close();
        }
        reader.close();
    }

}
