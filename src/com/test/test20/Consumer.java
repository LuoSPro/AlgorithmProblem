package com.test.test20;

public class Consumer implements Runnable {


    private Resource resource;

    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            while (true){
                resource.remove();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
