package com.writetenexam.exam_xiecheng;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() != 0){
            s = s.substring(1,s.length()-1);
        }
        int[] arr = null;
        if (s.length() != 0){
            String[] arrStr = s.split(",");
            arr = new int[arrStr.length];
            for (int i = 0,k=0; i < arrStr.length; i++) {
                try {
                    arr[k] = Integer.parseInt(arrStr[i]);
                    if (arr[k] < 0){
                        arr = null;
                        break;
                    }
                    k++;
                } catch (NumberFormatException e) {
                    arr = null;
                    break;
                }
            }
        }
        int[] result = work(arr);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i != 0){
                System.out.print(",");
            }
            System.out.print(result[i]);
        }
        System.out.print("]");
    }

    private static int[] work(int[] arr) {
        //先判断数据不合法的情况
        if (arr == null || arr.length == 0){
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        int x = 0,y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                //低价买进，高价卖出
                if (arr[j] - arr[i] > max){
                    x = i;
                    y = j;
                    max = arr[j] - arr[i];
                }
            }
        }
        if (max < 0){
            return new int[0];
        }else{
            int[] temp = new int[y-x+1];
            for (int i = x,k=0; i <= y; i++) {
                temp[k++] = arr[i];
            }
            return temp;
        }
    }


}
