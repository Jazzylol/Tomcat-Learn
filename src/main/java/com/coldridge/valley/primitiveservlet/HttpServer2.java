package com.coldridge.valley.primitiveservlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/3/26.
 */
public class HttpServer2 {

    private static final int port = 12306;
    private static final String host = "127.0.0.1";
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer2 server2 = new HttpServer2();
        server2.await();
    }

    private void await() {

        ServerSocket socket = null;

        try {
            socket = new ServerSocket(port, 1, InetAddress.getByName(host));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!shutdown) {
            InputStream in = null;
            OutputStream out = null;
            try {
                Socket accept = socket.accept();
                in = accept.getInputStream();
                out = accept.getOutputStream();

                Request1 request1 = new Request1(in);
                request1.parse();

                Response1 response1 = new Response1(out);
                response1.setRequest(request1);

                String uri = request1.getUri();
                if (uri.startsWith("/servlet/")) {
                    ServletProcesser2 processer = new ServletProcesser2();
                    processer.process(request1, response1);
                } else {
                    StaticResourceProcesser processer = new StaticResourceProcesser();
                    processer.process(request1, response1);
                }
                if (uri.equals(SHUTDOWN_COMMAND)) {
                    shutdown = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

        }
    }

}
