package com.writetenexam.exam_cvte;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对于输入的X，可以进行 + 或 *2 操作，请问X 操作最少多少次能达到Y
 *
 * 如  X = 3  Y = 10   输出  3
 * 因为  X = 3 * 2 = 6      X = 6 - 1 = 5    X = 5 * 2 = 10 = Y
 */
public class Main {



    public static void main(String[] args) {
        int X = 3;
        int Y = 10;
//        int n = dfs(X,Y,0);
        int n = sort(X,Y,1);
        System.out.println(n);
    }

    private static Queue<Integer> queue = new LinkedList<>();

    private static int sort(int x, int y, int deep){
        queue.add(x);
        return bfs(y, deep);
    }

    /**
     * 上次用的是DFS，每次都要在一边找到结果之后，才能遍历另外一边，这样效率明显低了啊，所以为什么不考虑使用BFS呢，只要一找到，
     * 必定是最少次数
     * @param y
     * @return
     */
    private static int bfs(int y, int deep) {
        int size = queue.size();
        while (size-- > 0){
            int item = queue.poll();
            if (item*2 == y){
                //找到了，返回
                return deep;
            } else{
                //没找到，添加到queue后面
                if (item <= y){//适当剪枝
                    queue.add(item*2);
                }
            }
            if (item - 1 == y){
                //找到了，返回
                return deep;
            } else{
                //没找到，添加到queue后面
                queue.add(item - 1);
            }
        }
        //没找到，继续往下执行
        return bfs(y,deep+1);
    }


    private static int minDeep = Integer.MAX_VALUE;

    /**
     * 思路：每次都是两部操作，其实就是对树的一个深度优先算法了
     * @param x
     * @param y
     * @return
     */
    private static int dfs(int x, int y, int deep) {
        if (minDeep < deep){
            //剪枝
            return minDeep;
        }
        if (x == y){
            minDeep = deep;
            return deep;
        }else if (x > y){
            int temp = deep + x - y;
            //剪枝
            if (minDeep > temp){
                minDeep = temp;
            }
            return temp;
        }else {
            int left = dfs(x * 2,y,deep + 1);
            int right = dfs(x - 1, y, deep + 1);
            return Math.min(left,right);
        }
    }

}
