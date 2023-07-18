package com.babyblue.july17;

import java.io.*;

public class CopyDemo {
    static File source = new File("/Users/lichenke/IdeaProjects/personal/IO/代码.zip");
    static File target1 = new File("/Users/lichenke/IdeaProjects/personal/IO/代码1.zip");
    static File target2 = new File("/Users/lichenke/IdeaProjects/personal/IO/代码2.zip");

    static void copy() {
        try(FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(target1)) {
            int len;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void copyWithBuffer() {
        try(FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(target2);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            int len;
            while((len = bis.read()) != -1) {
                bos.write(len);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        copy();
        System.out.println("普通复制时间：");
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        copyWithBuffer();
        System.out.println("缓冲区复制时间：");
        System.out.println(System.currentTimeMillis() - start);
    }
}
