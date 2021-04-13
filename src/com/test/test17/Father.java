package com.test.test17;

public class Father {

    private String name;
    private int age;

    static {
        System.out.println("Father static");
    }

    {
        System.out.println("Father");
    }

    public Father() {
        System.out.println("Father constructor");
    }

    public Father(String name, int age) {
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
