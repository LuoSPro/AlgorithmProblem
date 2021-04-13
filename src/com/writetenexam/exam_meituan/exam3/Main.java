package com.writetenexam.exam_meituan.exam3;

import java.util.*;

/**
 * 题目描述：
 * 小美发明了一个函数：f(x)，表示将x的所有正整数因子提取出来之后从小到大排列，再将数字拼接之后得到的数字串。例如：10的所有因子为1,2,5,10，那么将这些因子从小到大排序之后再拼接得到的数字串为12510，即f(10)=12510。
 *
 * 小美十分讨厌数字k，如果f(x)中含有某个子串对应的数字等于k，那么她的不高兴度就会增加1。例如：f(8)=1248，那么其所有的子串为：1,2,4,8,12,24,48,124,248,1248，只要k等于其中任意一个值，那么小美的不高兴度就会增加1。对于每一个数，其不高兴度至多增加1。
 *
 * 现在，有一个长度为n的正整数序列，定义其不高兴度为序列中所有数的不高兴度的总和。小美想要知道自己对于这个序列的总不高兴度为多少。
 *
 *
 *
 * 输入描述
 * 第一行两个正整数n,k；
 *
 * 第二行n个正整数ai，表示该序列。
 *
 * 1≤n≤105，1≤k，ai≤2x104
 *
 * 输出描述
 * 输出一行一个正整数，表示小美的总不高兴度。
 *
 *
 * 样例输入
 * 5 13
 * 13 31 10 9 20
 * 样例输出
 * 3
 *
 * 提示
 * f(13)=113,含有13；
 * f(31)=131,含有13；
 * f(10)=12510,不含有13；
 * f(9)=139，含有13；
 * f(20)=12451020,不含有13。
 * 综上，不高兴度为3。
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = work(k,arr);
        System.out.println(count);
    }

    private static int work(int k, int[] arr) {
        if (arr == null||arr.length == 0){
            return 0;
        }
        List<String> list = new ArrayList<>();
        //求arr每项数据的因数
        for (int i = 0; i < arr.length; i++) {
            list.add(work2(arr[i]));
        }
        //求每一项数据的子序列
        int count = 0;
        for (String s : list) {
//            System.out.println(s);
            if(work3(s,k)){
                //是否是讨厌的数
                count++;
            }
        }
        return count;
    }

    private static boolean work3(String s, int k) {
        if (s.contains(k+"")){
            return true;
        }
        return false;
    }

    private static String work2(int num) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        int max = num;
        while (i < max){
            if (num % i ==0){
                //更新max
                max = num/i;
                list.add(i);
                list.add(num/i);
            }
            i++;
        }
        Collections.sort(list);
        StringBuilder factors = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            if (!factors.toString().contains(list.get(j)+"")){
                factors.append(list.get(j));
            }
        }
        return factors.toString();
    }


}
