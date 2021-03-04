package com.test.test9;

import com.test.test8.Person;

public class MyThread extends Thread{

    private Person person;

    @Override
    public void run() {
        System.out.println("myThread run --> " + this);
        synchronized (this){
            person = new Person();
        }
    }

    public Person getPerson() {
        System.out.println("myThread getPerson --> " + this);
        synchronized (this){
            return person;
        }
    }
}
