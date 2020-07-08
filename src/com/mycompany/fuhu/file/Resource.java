package com.mycompany.fuhu.file;

import java.io.File;

public class Resource {
    public static void main(String[] args) throws Exception {
        System.out.println("haha1");
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println("haha2");
        System.out.println(Resource.class.getClassLoader().getResource(""));
        System.out.println("haha3");
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println("haha4");
        System.out.println(Resource.class.getResource("")); //Class文件所在路径
        System.out.println("haha5");
        System.out.println(Resource.class.getResource("/")); //package根路径
        System.out.println("haha6");
        System.out.println(new File("/").getAbsolutePath());
        System.out.println("haha7");
        System.out.println(System.getProperty("user.dir"));
    }
}
