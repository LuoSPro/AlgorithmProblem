package com.test.test4;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 7851684935749821648L;

    private String name;
    private int age;
    private boolean isMale;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
