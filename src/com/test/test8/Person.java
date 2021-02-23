package com.test.test8;

public class Person<T extends String> implements Comparable<T> {

    private T name;
    private T age;
    public String test = "hhh";

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    @Override
    public int compareTo(T o) {

        return 0;
    }
}
