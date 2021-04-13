package com.test.test20;

public class Product implements Runnable {

    private Resource resource;

    public Product(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true){
                resource.add();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
