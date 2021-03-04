package com.test.test11;

public class Thread2 implements Runnable{

    private Object o1;
    private Object o2;

    public Thread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2){
            System.out.println("Thread2 拿到o1了，现在准备去拿o1的锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("Thread2 现在两把锁都拿到了");
            }
        }
    }
}
