package com.test.test20;

public class Main {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Consumer consumer = new Consumer(resource);
        Product product = new Product(resource);
        Thread threadCon = new Thread(consumer);
        threadCon.start();
        Thread threadPro = new Thread(product);
        threadPro.start();
    }

}
