package com.test.test8;

import java.util.function.Supplier;

public class Son<T> {

    public static <T extends String> T test(Supplier<T> t){
        return t.get();
    }

}
