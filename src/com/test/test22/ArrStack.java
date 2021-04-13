package com.test.test22;

import java.util.Arrays;

public class ArrStack<T> {

    //默认长度
    private static final int DEFAULT_SIZE = 20;
    private int MAX_SIZE = DEFAULT_SIZE;
    private int cur = 0;
    private Object[] arr;
    private T[] arr2;

    public ArrStack(){
        arr = new Object[MAX_SIZE];
        arr2 = (T[])new Object[MAX_SIZE];
    }

    public void push(Object obj) throws Exception{
        if (cur >= MAX_SIZE){
            MAX_SIZE = MAX_SIZE*2;
            arr = Arrays.copyOf(arr,MAX_SIZE);
        }
        arr[cur++] = obj;
        //扩容
    }

    public Object pop() throws Exception{
        if (isEmpty()){
            throw new Exception("栈为空");
        }
        return arr[--cur];
    }

    public boolean isEmpty(){
        return cur == 0;
    }
}
