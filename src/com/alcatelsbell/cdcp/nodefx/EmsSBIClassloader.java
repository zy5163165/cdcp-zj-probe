package com.alcatelsbell.cdcp.nodefx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/26
 * Time: 9:54
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class EmsSBIClassloader extends URLClassLoader  {
    private Log logger = LogFactory.getLog(getClass());
    public EmsSBIClassloader(ClassLoader cl) {
        super(new URL[] {},cl);
    }

    public void addURL(URL... urls) {
        if (urls != null) {
            for (URL url : urls) {
                super.addURL(url);
            }
        }
    }

    public void addFile(File... files) throws IOException {
        if (files != null) {
            for (File file : files) {
                if (file != null) {
                    super.addURL(file.toURI().toURL());
                }
            }
        }
    }

    public static void main(String[] args) {
        ClassLoader classLoader = EmsAdapter.class.getClassLoader();
        EmsSBIClassloader cl = new EmsSBIClassloader(classLoader);
        Thread.currentThread().setContextClassLoader(cl);
        System.out.println("classLoader = " +((URLClassLoader)classLoader).getURLs());
    }
}
