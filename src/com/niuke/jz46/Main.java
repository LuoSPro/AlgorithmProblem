package com.niuke.jz46;

import java.util.*;

/**
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 * 示例1
 * 输入
 * 复制
 * 5,3
 * 返回值
 * 复制
 * 3
 *
 * 2  4
 *
 */
public class Main {

    public static void main(String[] args) {

        int n = 5;
        int m = 2;
        System.out.println(new Main().LastRemaining_Solution(n, m));
    }

    /**
     * ——约瑟夫环
     *
     * 思路：
     * 这道题看例题的时候看到过，上面是用队列（循环队列）解决的，但是我没太看到他用队列的做法。这里尝试一下吧
     * 为什么要用队列，因为我们走过一个人之后，他暂时就不需要计数了，所以这个时候应该把她放到最后去
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0){
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int num = 0;
        while (list.size() > 1){
            num = 0;
            while (num < m-1){
                Integer first = list.getFirst();
                list.remove(first);
                list.add(first);
                num++;
            }
            list.remove(list.getFirst());
        }
        return list.get(0);
    }

}
