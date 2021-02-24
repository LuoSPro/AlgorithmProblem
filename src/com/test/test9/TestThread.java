package com.test.test9;

public class TestThread extends Thread {

    @Override
    public void run() {
        while (!isInterrupted()){
            System.out.println(isInterrupted()+" ");
            try {
                System.out.println("thread is sleep before");
                Thread.sleep(1000);
                System.out.println("thread is sleep after");
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        System.out.println("thread is stop");
    }
}
