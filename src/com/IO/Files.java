package com.IO;

import java.io.File;
import java.io.IOException;

public class Files {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println("绝对路径："+file.getAbsolutePath());
        System.out.println("相对路径："+file.getPath());
        System.out.println("名字："+file.getName());
        //File的方法  exists()是判断这个文件有没有。如果有就返回true。没有就返回false。
        System.out.println(file.exists());
        File createNewFile = new File("D:\\project\\algorithms4\\src\\com\\test1.txt");
        //这个是创建在项目的目录下。和src同一级别
        File mkdir = new File("test");
        mkdir.mkdir();
        File mkdirs = new File("aaa\\test");
        mkdirs.mkdirs();
        for (String string:mkdirs.list()) {
            System.out.println("String[]:"+string);
        }
        for (String string:mkdirs.list()) {
            if(string.endsWith(".jpg")){
                System.out.println("有没有jpg的文件："+string);
            }
            System.out.println("String[]:"+string);
        }
        for (File file1 : mkdirs.listFiles()) {
            System.out.println("File[]:"+file1);
        }
        System.out.println(mkdirs.list());
        System.out.println(mkdirs.listFiles());
        System.out.println(mkdirs.delete());

        //修改
        File file2 = new File("D:\\project\\algorithms4\\src\\com\\change.txt");
        file.renameTo(file2);
        try {
            //createNewFile()：创建文件，如果没有就创建一个这样的文件。
            file.createNewFile();
            createNewFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
