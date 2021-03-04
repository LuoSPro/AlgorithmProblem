package com.test.test10;

public class Person{
        
    protected String name;

    public Person() {
        System.out.println("person constructor ..");
        print();
        System.out.println("person constructor ..");
    }

    public void print(){
        System.out.println("person name --> " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}