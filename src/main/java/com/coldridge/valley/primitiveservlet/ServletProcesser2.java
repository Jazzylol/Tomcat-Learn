package com.coldridge.valley.primitiveservlet;

import com.coldridge.valley.Constants;

import javax.servlet.Servlet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * Created by Administrator on 2016/3/26.
 */
public class ServletProcesser2 {
    public void process(Request1 request1, Response1 response1) {

        String uri = request1.getUri();

        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        //create a urlloader
        URL[] urls = new URL[1];
        URLStreamHandler handler = null;
        URLClassLoader loader = null;
        try {
            File classPath = new File(Constants.WEB_ROOT);
            String repostory = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
            urls[0] = new URL(null, repostory, handler);
            loader = new URLClassLoader(urls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class myClass = null;
        try {
            myClass = loader.loadClass("com.coldridge.valley.primitiveservlet."+servletName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Servlet servlet = null;

        try {
            servlet = (Servlet) myClass.newInstance();
            Request1Facade request = new Request1Facade(request1);
            Response1Facade response = new Response1Facade(response1);
            servlet.service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
