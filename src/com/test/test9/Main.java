package com.test.test9;

public class Main {

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.interrupt();
        thread.run();
        if (!thread.isInterrupted()){
            System.out.println("-");
            thread.interrupt();
        }
        thread.interrupt();
        thread.interrupt();
    }

}
