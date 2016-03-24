package com.coldridge.valley.simplehttpserver;

import java.io.IOException;
import java.io.InputStream;

/**
 * 代表一个请求
 */
public class SimpleRequest {

    private InputStream inputStream;
    private String uri;

    public SimpleRequest(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() {
        StringBuffer request = new StringBuffer();
        int i = 0;
        byte[] buffer = new byte[1024];
        try {
            i = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < i; j++) {
            request.append((char) buffer[j]);
        }
        System.out.println(request.toString());
        uri = parseUri(request.toString());
    }

    private String parseUri(String requestString) {
        int i = requestString.indexOf(" ");
        if (i != -1) {
            int j = requestString.indexOf(" ", i + 1);
            if (j > i) {
                return requestString.substring(i + 1, j);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
