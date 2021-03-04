package com.test.test10;

public class Son extends Person{

    public Son() {
        System.out.println("son constructor ..");
        print();
        System.out.println("son constructor ..");
    }

    @Override
    public void print(){
        System.out.println("son name --> " + name);
    }

}