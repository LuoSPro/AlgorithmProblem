package com.writetenexam.exam_alibaba;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        System.out.println(split(n));
        System.out.printf("%.4f",split(8,true));
//        System.out.printf("%.4f",split(n,true));
    }

    //falg表示是否可以再分
    public static float split(int n,boolean flag){
        //这里要给f提供数据，还要把数据合起来
        double[] arr = new double[n-1];
        for (int i = 1; i < n; i++) {
            arr[i-1] = f(i,n-i,flag);
        }
        //集合数据
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]*1.0/(n-1);
        }
        return sum;
    }

    private static float f(int i, int j,boolean flag) {
        //始终保持j最大
        if (i > j){
            int temp = i;
            i = j;
            j = temp;
        }
        //剪枝
        if (i == j){
            return i;
        }
        if (i == 0&& j == 2){
            //不能再划分就返回2，能划分就返回1
            return !flag ?2:1;
        }
        //判断
        if (i == 0 && j>= 2){
            if (flag){
                //可以再分
                //划分
                return split(j,false);
            }else{
                //不能再划分了
                return j;
            }
        }else if(i == 0 && j< 2){
            //不做划分
            return j;
        }
        //剩下的肯定是i不等于0的了
        return i + f(0,j-i,flag);
    }


}
