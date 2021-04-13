package com.test.test24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] arr = {9,4,33,0,12,45};
        System.out.println(new Main().work(arr));
    }

    private String work(int[] arr) {
        if (arr == null||arr.length == 0){
            return "0";
        }
        List<String> list = new ArrayList<>();
        allSort(list,arr,"",0);
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    private void allSort(List<String> list, int[] arr, String s, int i) {
        if (i == arr.length){
            list.add(s);
            return;
        }
        for (int j = i; j < arr.length; j++) {
            swap(j,i,arr);
            allSort(list, arr, s+arr[i], i+1);
            swap(j,i,arr);
        }

    }

    private void swap(int j, int i, int[] arr) {
        if (i == j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
