package com.writetenexam.exam_meituan.exam2;

import java.util.*;

/**
 * 题目描述：
 * 今天是小美的生日，妈妈给她专门订制了一个球形的大蛋糕。小美决定对这个蛋糕切n刀。每次切小美会选择是横着切还是竖着切。将整个球划分经纬度。如果是横着切的话那么小美会选择一个纬度将整个球切成上下两部分；如果是竖着切的话那么小美会选择一个经度将整个球切成两半。
 *
 * 小美想知道，切n刀之后整个球被划分成了多少个部分？
 *
 * 请注意本题中经纬度的表示如图：
 *
 *
 *
 * 另外，在经度上，例如切90°和270°、0°和180°等视为两种不同的切法。
 *
 *
 *
 * 输入描述
 * 第一行一个正整数n，表示切了n刀
 *
 * 接下来n行，每行两个整数t,x，如果t=0，那么x表示小美选择横着切的纬度；如果t=1，那么x表示小美选择竖着切的经度。
 *
 * 数据保证：
 *
 * （1）经度的取值范围为[0,360)，纬度的取值范围为(0,360)；
 *
 * （2）所有选择的经度和纬度各自均不会重复；
 *
 * 1≤n≤700,t∈{0,1},x∈[0,360)（此数据没有t=0,x=0的情况）
 *
 * 输出描述
 * 输出一个整数，表示答案。
 *
 *
 * 样例输入
 * 2
 * 1 0
 * 0 180
 * 样例输出
 * 4
 *
 * 提示
 * 相当于把整个蛋糕横着、竖着各切一刀，一共4块。
 *
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int count = work(arr);
        System.out.println(count);

    }

    private static int work(int[][] arr) {
        if (arr == null||arr.length == 0){
            return 0;
        }
        int sum = 0;
        //纬度
        int ver = 0;
        //经度
        int hor = 0;
        //保存已经划分过的经度
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 1){
                if (set.contains(Math.abs(arr[i][1] - 180) == 0)){
                    //已经计算过了
                    continue;
                }
                set.add(arr[i][1]);
                //经度
                hor += 1;
            }else{
                //纬度
                ver += 1;
            }
        }
        return 2*hor*(ver+1);
    }

}
