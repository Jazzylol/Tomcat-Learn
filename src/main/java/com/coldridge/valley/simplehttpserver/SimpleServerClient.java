package com.coldridge.valley.simplehttpserver;

import java.io.*;
import java.net.Socket;

/**
 * Created by zzt on 2016/3/22.
 */
public class SimpleServerClient {


    public static void main(String[] args) throws  Exception{
        init();
    }

    private static void init() throws  Exception{

        Socket client = new Socket("127.0.0.1",12306);
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();


        PrintWriter printWriter = new PrintWriter(out,true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        //send an Http request to the web server

        printWriter.println("GET /index.jsp HTTP/1.1");
        printWriter.println("Host: localhost:12306");
        printWriter.println("Connection:Close");
        printWriter.println();
        printWriter.flush();
        //read the response


        System.out.println("I have print some message!");


        StringBuilder sb = new StringBuilder();
        while (true){
            if(reader.ready()){

                int i = 0;
                while (i!=-1){
                    i =reader.read();
                    sb.append((char)i);
                }
               break;
            }
        }

        System.out.println(sb.toString());
        client.close();
    }

}
