package com.mycompany.fuhu.file;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilenameFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        //System.out.println(dir);
        //System.out.println(name);
        File file = new File(dir, name);
        return file.isFile() && file.getName().endsWith(".jpg");
    }
    public static void main(String[] args) {
        MyFilenameFilter myFilter = new MyFilenameFilter();
        String rootDir = MyFilenameFilter.class.getResource("/resource").getPath();
        File dir = new File(rootDir);
        String[] arr = dir.list(myFilter);
        //list all the jpg under /resource
        for (String string : arr) {
            System.out.println(string);
        }
    }
}
