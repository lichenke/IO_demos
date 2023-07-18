package com.babyblue.july17;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

import static java.nio.file.Files.newInputStream;
import static java.nio.file.Files.newOutputStream;

public class ObjectOutputStreamDemo {

    public static void main(String[] args) {

        String file = "/Users/lichenke/Desktop/data.dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(newOutputStream(Paths.get(file)))) {
            oos.writeObject(new Dog("旺财", 10));
        } catch (IOException e) {
            System.out.println("报错了");
        }

        try (ObjectInputStream ois = new ObjectInputStream(newInputStream(Paths.get(file)))) {
            System.out.println(ois.readObject().toString());
        } catch (Exception e) {
            System.out.println("报错了");
        }

    }
}
