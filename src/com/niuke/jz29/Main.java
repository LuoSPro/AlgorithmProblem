package com.niuke.jz29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        int[] input = {4,5,1,6,2,7,3,8};
        int k = 0;
        ArrayList<Integer> list = new Main().GetLeastNumbers_Solution(input, k);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null ||input.length == 0 || k == 0 || input.length < k){
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(4,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //递减
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            int peek = queue.peek();
            if (peek > input[i]){
                queue.poll();
                queue.add(input[i]);
            }
        }

        while (!queue.isEmpty()){
            list.add(queue.poll());
        }
        Collections.reverse(list);
        return list;
    }

}
