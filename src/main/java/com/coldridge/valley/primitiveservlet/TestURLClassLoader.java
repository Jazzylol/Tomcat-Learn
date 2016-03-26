package com.coldridge.valley.primitiveservlet;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Administrator on 2016/3/26.
 */
public class TestURLClassLoader {

    public static void main(String[] args) throws Exception {
        test();
    }
    private static void test() throws Exception {
        //classPath = E:\Idea\Tomcat-Learn/target/class/
        //载入class的根目录 也就是仓库目录
        String classPath = System.getProperty("user.dir") + "/target/class/";
        /**
         * 创建URLClassloader 对象
         * 使用构造方法 public URLClassLoader(URL[] urls) <br>
         */
        URL[] urls = new URL[1];
        /**
         * 构造一个url
         * 使用构造方法 public URL(String protocol, String host, String file)<br>
         * @param      protocol   the name of the protocol to use.//协议  http超文本传输协议  file 文件协议
         * @param      host       the name of the host.
         * @param      file       the file on the host. //可以是目录也可以是文件
         */
        URL url = new URL("file", "127.0.0.1", 12306, classPath + "com/coldridge/valley/primitiveservlet/");
        urls[0] = url;
        URLClassLoader loader = new URLClassLoader(urls);
        /**
         * loadClass 需要指定加载的类的全包名
         */
        Class<?> myclass = loader.loadClass("com.coldridge.valley.primitiveservlet.PrimitiveServlet");
        //创建实例对象
        PrimitiveServlet o = (PrimitiveServlet) myclass.newInstance();
        //调用方法
        o.getServletConfig();
        o.getServletInfo();
        o.destroy();
    }

}
