package com.test.test18;

import com.test.test11.Thread1;

/**
 * thread.join()方法：表示当前
 */
public class Main {

    private static Thread thread1;

    public static void main(String[] args) {
        thread1 = new Thread("thread1"){
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println(getName() + "running");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread("thread2"){
            @Override
            public void run() {
                while (true){
                    try {
                        thread1.join();
                        System.out.println(getName() + "running");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread1.wait(1000);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
