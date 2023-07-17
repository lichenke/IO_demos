package com.babyblue.july17;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

public class FourInputWay {

    // 来自文件
    @Test
    public void fromFile() {
        String path = "/Users/lichenke/IdeaProjects/personal/IO/hello.txt";
        int len;
        char[] buf = new char[8];
        try (FileReader fr = new FileReader(path, Charset.defaultCharset())) {
            while ((len = fr.read(buf)) != -1) {
                System.out.print(new String(buf, 0, len));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 来自内存
    @Test
    public void fromMemory() {
        String str = "我的天，你真高";
        byte[] bytes = str.getBytes(Charset.defaultCharset());
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            int len;
            byte[] buf = new byte[3];
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
            System.out.println(bos.toString(Charset.defaultCharset()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 来自键盘
    @Test
    public void fromKeyboard() throws IOException {
        InputStream in = System.in;
        int i;
        while((i = in.read()) != -1) {
            System.out.print((char) i);
        }
    }
}
