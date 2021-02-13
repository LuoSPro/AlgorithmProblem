package com.test.test5;

public class Main extends Father{

    {
        System.out.println("子类的构造代码快");
    }

    static {
        System.out.println("子类的静态代码块");
    }

    public Main(){
        System.out.println("子类的构造方法块");
    }

    public static void main(String[] args) {
        new Main();
        new Main();
        System.out.println("子类的mian方法块");
    }

}

class Father{

    static {
        System.out.println("父类的静态代码块");
    }

    {
        System.out.println("父类的构造代码块");
    }

    public Father() {
        System.out.println("父类的构造方法块");
    }

}
