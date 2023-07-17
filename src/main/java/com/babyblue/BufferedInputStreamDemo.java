package com.babyblue;

import java.io.*;

/*
    用普通的输入输出流和带缓存的输入输出流分别拷贝同一部电影，耗时结果如下：
 */
public class BufferedInputStreamDemo {

    static File source = new File("/Users/lichenke/Desktop/1917.2019.1080p.SCREENER.x264.AAC-FoE.mkv");
    static File target1 = new File("/Users/lichenke/Desktop/1917.2019.1080p.SCREENER.x264.AAC-FoE_copy1.mkv");
    static File target2 = new File("/Users/lichenke/Desktop/1917.2019.1080p.SCREENER.x264.AAC-FoE_copy2.mkv");

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
            byte[] buf = new byte[1024];
            while((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
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
