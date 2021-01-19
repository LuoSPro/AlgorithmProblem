package com.exam.exam40;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> list = main.combinationSum2(candidates, target);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = candidates.length;
        if (len == 0){
            return lists;
        }
        //可能是用动规，但是我不会
        Arrays.sort(candidates);
        //保存路径
        Deque<Integer> path = new ArrayDeque<>();
        dfs(lists,len,0,target,candidates,path);
        return lists;
    }

    private void dfs(List<List<Integer>> lists,int len,int begin,int target,int[] candidates,Deque<Integer> path){
        //退出条件
        if (target == 0){
            lists.add(new ArrayList<>(path));
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0 ){
                break;
            }

            if (i>begin && candidates[i] == candidates[i-1]){
                continue;
            }

            path.addLast(candidates[i]);

            dfs(lists, len, i+1, target-candidates[i], candidates, path);

            path.removeLast();
        }
    }
}
