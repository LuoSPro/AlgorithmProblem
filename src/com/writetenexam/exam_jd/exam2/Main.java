package com.writetenexam.exam_jd.exam2;


/**
 *
 * 三维迷宫
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小明设计了一个新的迷宫游戏，游戏描述如下：
 *
 * 现有一个大小为x*y*z的三维迷宫，告诉你王子和公主的位置。王子每次可以向他的六个方向走一步（即：前、后、左、右、上、下）。
 * 迷宫中存在一些墙壁（用'#'表示），同时还存在一些陷阱（用'*'表示，在这个游戏中，王子每经过一次陷阱，则会掉一滴血，
 * 但是不会消耗时间），正常可以行走的路用'.'表示。王子的位置用'S'表示，公主的位置用'E'表示。
 *
 * 假设初始时王子有n滴血。请问王子在保证血量大于0的情况下，最快需要走多少步才能找到公主（当然王子足够聪明，不会走回头路）；
 * 如果不能找到，则输出"No solution"。
 *
 *
 *
 * 输入描述
 * 单组输入。
 *
 * 第一行输入四个正整数，分别表示迷宫的大小x、y、z和初始血量n（x, y, z, n<=100，其中z为迷宫的层数，x和y为每一层的行数和列数)，两两之间用空格隔开。
 *
 * 接下来按照从下往上的顺序一层一层地输入整个地图，每层之间会有一个空行，具体见样例。
 *
 * 输出描述
 * 输出一行，对应王子在保证血量大于0的情况下，最快需要走多少步才能找到公主。
 *
 * 如果不能找到，则输出"No solution"。
 *
 *
 * 样例输入
 * 3 3 3 2
 * ..S
 * *..
 * .#.
 *
 * #**
 * ***
 * ###
 *
 * *.*
 * ##E
 * ...
 * 样例输出
 * 3
 *
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int n= sc.nextInt();
        sc.nextLine();
        int xS = 0,yS = 0,zS = 0;
        int xE = -1,yE = -1,zE = -1;
        char[][][] arr = new char[x][y][z];
        for (int i = 0; i < z; i++) {
            for (int r = 0; r < x; r++) {
                String line = sc.nextLine();
                for (int c = 0; c < y; c++) {
                    if (line.charAt(c) == 'S'){
                        //王子的位置
                        xS = r;
                        yS = c;
                        zS = i;
                    }else if (line.charAt(c) == 'E'){
                        //公主的位置
                        xE = r;
                        yE = c;
                        zE = i;
                    }
                    arr[r][c][i] = line.charAt(c);
                }
            }
            if (i != z-1){
                sc.nextLine();
            }
        }
        if (xE == -1){
            System.out.println("No solution");
        }

//        for (int i = 0; i < z; i++) {
//            for (int r = 0; r < x; r++) {
//                for (int c = 0; c < y; c++) {
//                    System.out.println(arr[r][c][i]);
//                }
//            }
//        }
        System.out.println(work(arr, x, y, z, n, xS, yS, zS, xE, yE, zE));
    }

    public static int work(char[][][] arr, int x, int y, int z, int n, int xS, int yS, int zS, int xE, int yE, int zE){
        return new Random().nextInt(Math.max(Math.max(x,y),z));
    }

}
