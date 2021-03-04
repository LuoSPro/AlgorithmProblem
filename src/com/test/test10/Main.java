package com.test.test10;

public class Main {

    public static void main(String[] args) {
        Person person = new Son();
        print(person);

        System.out.println("-------------------------");

        Son son = new Son();
        print(son);
    }

    public static void print(Person person){
        System.out.println("print person ---");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(person);
            }
        });
        person.print();
    }

    public static void print(Son son){
        System.out.println("print son ---");
        son.print();
    }

}
