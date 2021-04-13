package com.test.test20;

public class Resource {

    private volatile int num = 0;

    public synchronized void remove() throws InterruptedException {
        while (num == 0){
            System.out.println("资源为0");
            this.wait();
        }
        num--;
        System.out.println("资源减一，当前资源数 -> " + num);
        this.notifyAll();
    }

    public synchronized void add() throws InterruptedException {
        while (num > 5){
            System.out.println("资源大于5");
            this.wait();
        }
        num++;
        System.out.println("资源加一，当前资源数 -> "+ num);
        this.notifyAll();
    }

}
