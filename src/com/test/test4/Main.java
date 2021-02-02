package com.test.test4;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("hhh",123);

        //序列化
//        try {
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cache.txt"));
//            out.writeObject(person);
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //反序列化
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("cache.txt"));
            Person p = (Person) in.readObject();
            System.out.println(p.getName());
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
