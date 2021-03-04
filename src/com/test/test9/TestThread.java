package com.test.test9;

import com.test.test8.Person;

public class TestThread extends Thread {

    private Person person;
    private MyListener listener;

    @Override
    public void run() {
        System.out.println("TestThread --> " + Thread.currentThread());
        person = new Person();
        if (listener != null){
            listener.finish();
        }
    }

    public Person getPerson() {
        return person;
    }

    public void setMyListener(MyListener listener){
        this.listener = listener;
    }

    public interface MyListener{
        void finish();
    }
}
