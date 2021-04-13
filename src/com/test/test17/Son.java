package com.test.test17;

public class Son extends Father{



    private String lick;

    static {
        System.out.println("Son static");
    }

//    Father father = new Father();

    {
        System.out.println("Son");
    }

    public Son() {
        System.out.println("Son constructor");
    }

    public Son(String lick) {
        this.lick = lick;
    }

    public String getLick() {
        return lick;
    }

    public void setLick(String lick) {
        this.lick = lick;
    }
}
