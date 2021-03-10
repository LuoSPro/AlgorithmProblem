package com.test.test12;

import com.test.test11.Thread1;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };
        Thread thread = new Thread(runnable);
        thread.run();
        System.out.println("main");
    }

}
