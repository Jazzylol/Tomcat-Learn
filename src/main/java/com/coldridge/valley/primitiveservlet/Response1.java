package com.coldridge.valley.primitiveservlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * Created by Administrator on 2016/3/26.
 */
public class Response1 implements ServletResponse {

    private Request1 request;
    private OutputStream outputStream;

    public void sendStaticResource() throws IOException {

        String uri = request.getUri();
        String dest = "E:\\Idea\\Tomcat-Learn\\web_root";
        File file = new File(dest + uri);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) > 0) {
                outputStream.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            String errMsg = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-length:23\r\n" +
                    "\r\n" +
                    "<h1>File Not Found</h1>";
            outputStream.write(errMsg.getBytes());
        }
    }


    public Response1(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request1 request) {
        this.request = request;
    }


    public String getCharacterEncoding() {
        return null;
    }

    public String getContentType() {
        return null;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(outputStream, true);
    }

    public void setCharacterEncoding(String s) {

    }

    public void setContentLength(int i) {

    }

    public void setContentType(String s) {

    }

    public void setBufferSize(int i) {

    }

    public int getBufferSize() {
        return 0;
    }

    public void flushBuffer() throws IOException {

    }

    public void resetBuffer() {

    }

    public boolean isCommitted() {
        return false;
    }

    public void reset() {

    }

    public void setLocale(Locale locale) {

    }

    public Locale getLocale() {
        return null;
    }
}
