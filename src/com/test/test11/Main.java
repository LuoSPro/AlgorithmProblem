package com.test.test11;

import com.test.test10.Person;

public class Main {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(new Thread1(o1,o2));
        Thread t2 = new Thread(new Thread2(o1,o2));
        t1.start();
        t2.start();


    }

}
