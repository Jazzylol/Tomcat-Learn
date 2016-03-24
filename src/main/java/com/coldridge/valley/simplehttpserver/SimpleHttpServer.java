package com.coldridge.valley.simplehttpserver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/3/25.
 */
public class SimpleHttpServer {


    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "web_root";

    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public static void main(String[] args) {
        SimpleHttpServer server = new SimpleHttpServer();
        server.await();
    }

    private void await() {

        ServerSocket serverSocket = null;
        int port = 8080;

        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        //loop waiting for a request
        while (!shutdown) {

            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;

            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                SimpleRequest request = new SimpleRequest(input);
                request.parse();

                //create Response
                SimpleResponse response = new SimpleResponse(output);
                response.setRequest(request);
                response.sendStaticResource();

                socket.close();
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }


}
