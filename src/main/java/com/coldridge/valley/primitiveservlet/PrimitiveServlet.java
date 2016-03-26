package com.coldridge.valley.primitiveservlet;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/3/26.
 */
public class PrimitiveServlet implements Servlet {


    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("primitive servlet has init");
    }

    public ServletConfig getServletConfig() {
        System.out.println("get servlet config running");
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter writer = servletResponse.getWriter();
        writer.println("<h1>service has running</h1><script>" +
                "alert('fucking shanghai goverment')" +
                "</script>");
        writer.close();
    }

    public String getServletInfo() {
        System.out.println("get servlet info running");
        return null;
    }

    public void destroy() {
        System.out.println("destroy running");
    }
}
