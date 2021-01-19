package com.exam.exam216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int n = 9;
        int k = 3;
        List<List<Integer>> res = main.combinationSum3(k,n);
        System.out.println("输出 => " + res);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,9,0,n,k,path,lists);
        return lists;
    }

    private void dfs(int[] candidates,int len,int begin,int target,int k,Deque<Integer> path,List<List<Integer>> lists) {
        //退出条件
        if (target == 0&&path.size() == k){
            lists.add(new ArrayList<>(path));
        }
        //循环查找
        //注意这里，因为不能有重复的集合以及集合中不能有重复的数字，所以这里的i不能从0开始，
        for (int i = begin; i < candidates.length; i++) {
            //由于是升序，当target都不够减时，后面也不用再减了————大剪枝
            if (target - candidates[i] < 0){
                break;
            }

            //由于每个数字都不一样，所以不存在小剪枝情况
            path.addLast(candidates[i]);
            dfs(candidates, len, i+1, target-candidates[i], k, path, lists);
            path.removeLast();
        }
    }
}
