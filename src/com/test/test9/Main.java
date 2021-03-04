package com.test.test9;

import com.test.test8.Person;

public class Main {

    public static void main(String[] args) throws Exception{
        TestThread thread = new TestThread();
        System.out.println("Main main --> " + Thread.currentThread());
        thread.setMyListener(new TestThread.MyListener() {
            @Override
            public void finish() {
                System.out.println("Main finish --> " + Thread.currentThread());
                Person person = thread.getPerson();
                System.out.println(person.getName());
            }
        });
        thread.start();

        //Thread.sleep(1000);
//        Person person = thread.getPerson();
//        System.out.println(person.getName());


//        MyThread myThread = new MyThread();
//        myThread.run();
//        System.out.println("myThread --> " + myThread.getPerson().getName());
    }

}
