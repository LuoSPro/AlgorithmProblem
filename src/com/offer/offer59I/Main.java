package com.offer.offer59I;

import java.util.*;

/**
 * 有的同学可能会想用一个大顶堆（优先级队列）来存放这个窗口里的k个数字，这样就可以知道最大的最大值是多少了，
 * 但是问题是这个窗口是移动的，而大顶堆每次只能弹出最大值，我们无法移除其他数值，
 * 这样就造成大顶堆维护的不是滑动窗口里面的数值了。所以不能用大顶堆。
 *
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {-1,1};
        int k = 1;
        int[] result = new Main().maxSlidingWindow(nums, k);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        if (nums.length == 0||k == 0){
            return nums;
        }
        int j = 0;
        Deque<Integer> deque = new LinkedList<>();
        int x = 1-k,y = 0;
        for (y = 0; y < nums.length; x++,y++) {
            //当deque里面的数据有k个才开始删除
            if (x > 0&&deque.size() == k){//删除nums[x]
                deque.removeFirst();
            }
            //删除比nums[y]小的所有数据,保证deque不为null
            while (!deque.isEmpty()&&deque.peekFirst() < nums[y]){
                deque.pollFirst();
            }
            deque.addFirst(nums[y]);
            //记录最大的数据
            if (x >= 0){
                result[j] = deque.peekLast();
                j++;
            }
        }
        return result;
    }

}
