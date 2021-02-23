package com.test.test8;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static Map<String, String> map;

    public static void main(String[] args) {
//        Set<String> set = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
//
//        Person<String> person = new Person<>();
//        try {
//            System.out.println(Person.class.newInstance().test);
//            System.out.println(person.getClass().newInstance().test);
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        Son<String> son = new Son<>();
//        System.out.println(son.test(String::new));

        map = new HashMap<>();

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    map.put("1","1");
                    map.put("2","2");
                    map.put("3","3");
                    map.put("4","4");
                    map.put("5","5");
                    Thread.sleep(10);
                    map.put("6","6");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    map.put("1","2");
                    map.put("2","3");
                    map.put("3","4");
                    map.put("4","5");
                    map.put("5","6");
                    Thread.sleep(10);
                    map.put("6","7");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
//        map = Collections.synchronizedMap(map);

        new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
    }

}
