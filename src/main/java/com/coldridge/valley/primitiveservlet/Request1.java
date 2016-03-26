package com.coldridge.valley.primitiveservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/26.
 */
public class Request1 implements ServletRequest {
    private InputStream in;
    private String uri;

    public Request1(InputStream in) {
        this.in = in;
    }

    public void parse() throws IOException {
        byte[] buf = new byte[2048];

        StringBuffer sb = new StringBuffer();
        int i = in.read(buf);
        if(i > 0){
            sb.append(new String(buf, 0, i));
        }
        System.out.println(sb.toString());
        parseUri(sb.toString());
    }

    private void parseUri(String request) {
        int begin = request.indexOf(" ");
        if (begin > 0) {
            int end = request.indexOf(" ", begin + 1);
            if (end > begin) {
                this.uri = request.substring(begin + 1, end);
            }
        }
    }

    public String getUri() {
        return uri;
    }


    public Object getAttribute(String s) {
        return null;
    }

    public Enumeration getAttributeNames() {
        return null;
    }

    public String getCharacterEncoding() {
        return null;
    }

    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

    }

    public int getContentLength() {
        return 0;
    }

    public String getContentType() {
        return null;
    }

    public ServletInputStream getInputStream() throws IOException {
        return null;
    }

    public String getParameter(String s) {
        return null;
    }

    public Enumeration getParameterNames() {
        return null;
    }

    public String[] getParameterValues(String s) {
        return new String[0];
    }

    public Map getParameterMap() {
        return null;
    }

    public String getProtocol() {
        return null;
    }

    public String getScheme() {
        return null;
    }

    public String getServerName() {
        return null;
    }

    public int getServerPort() {
        return 0;
    }

    public BufferedReader getReader() throws IOException {
        return null;
    }

    public String getRemoteAddr() {
        return null;
    }

    public String getRemoteHost() {
        return null;
    }

    public void setAttribute(String s, Object o) {

    }

    public void removeAttribute(String s) {

    }

    public Locale getLocale() {
        return null;
    }

    public Enumeration getLocales() {
        return null;
    }

    public boolean isSecure() {
        return false;
    }

    public RequestDispatcher getRequestDispatcher(String s) {
        return null;
    }

    /**
     * @param s
     * @deprecated
     */
    public String getRealPath(String s) {
        return null;
    }

    public int getRemotePort() {
        return 0;
    }

    public String getLocalName() {
        return null;
    }

    public String getLocalAddr() {
        return null;
    }

    public int getLocalPort() {
        return 0;
    }
}
