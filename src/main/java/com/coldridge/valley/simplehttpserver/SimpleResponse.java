package com.coldridge.valley.simplehttpserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/3/25.
 */
public class SimpleResponse {

    private static final int BUFFER_SIZE = 1024;
    private OutputStream outputStream;
    private SimpleRequest request;

    public SimpleResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(SimpleRequest request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {

        byte[] bytes = new byte[BUFFER_SIZE];
        String uri = request.getUri();
        File file = new File(SimpleHttpServer.WEB_ROOT, uri);
        FileInputStream fis = null;
        try {
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes);
                while (ch != -1) {
                    outputStream.write(bytes, 0, ch);
                    ch = fis.read(bytes);
                }


            } else {

                String errorMsg = "HTTP/1.1 4O4 File Not Found \r\n" +
                        "Content-Type:text/html \r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                outputStream.write(errorMsg.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }


    }
}
