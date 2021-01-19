package com.exam.exam78;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Main().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList list = new ArrayList();
        for (int i = 0; i <= nums.length; i++) {
            dfs(i,0,nums,list,new ArrayList<>());
        }
        return list;
    }

    private void dfs(int size,int begin,int[] nums,List<List<Integer>> listList,List<Integer> list){
        if (size == list.size()){
            //这里不使用new ArrayList的话，后面保存进listList的数据还是被引用着，会发生改变
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int k = begin; k < nums.length; k++) {
            list.add(nums[k]);
            dfs(size, k+1, nums, listList, list);
            list.remove(list.size() - 1);
        }
    }
}
