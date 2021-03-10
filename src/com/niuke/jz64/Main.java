package com.niuke.jz64;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> list = new Main().maxInWindows(num, size);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 思路：维护一个大根堆
     * 每次遇到一个
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0||num == null||size > num.length){
            return list;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //降序
                return o2 - o1;
            }
        });
        maxHeap.add(num[0]);
        for (int i = 1; i < size; i++) {
            maxHeap.add(num[i]);
        }
        list.add(maxHeap.peek());
        for (int j = size; j < num.length; j++) {
            //移除第j-size位置上的元素
            maxHeap.remove(num[j-size]);
            //添加第j个位置上的元素
            maxHeap.add(num[j]);
            list.add(maxHeap.peek());
        }
        return list;
    }

}
