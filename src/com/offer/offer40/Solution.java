package com.offer.offer40;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {0,0,0,2,0,5};
        int k = 0;
        new Solution().getLeastNumbers(arr,k);
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0){
            return result;
        }
        //创建一个优先级队列，每次插入进去的数据对通过排序存在队列中
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //先存四个数进去
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        //再遍历剩下的数据，如果比堆顶（堆中最大的数）还小，那么就进堆，把堆顶弹出
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()){
                //堆顶弹出
                queue.poll();
                queue.add(arr[i]);
            }
        }
        for (int i = 0; queue.size() > 0; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
