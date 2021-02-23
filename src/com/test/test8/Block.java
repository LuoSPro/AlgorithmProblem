package com.test.test8;

public abstract class Block {

    public abstract void body() throws Throwable;

    public Thread toThread(){
        return new Thread(){
            @Override
            public void run() {
                try {
                    body();
                } catch (Throwable t) {
                    Block.<RuntimeException>throwAs(t);
                }
            }
        };
    }

    private static <T extends Throwable> void throwAs(Throwable t) throws T{
        throw (T)t;
    }

}
