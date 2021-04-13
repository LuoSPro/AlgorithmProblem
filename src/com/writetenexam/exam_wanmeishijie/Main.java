package com.writetenexam.exam_wanmeishijie;

public class Main {

    public static void main(String[] args) {
        String s = work("15723468","9852347");
        System.out.println(s);
    }

    private static String work(String s1, String s2) {
        char[] arrS1 = s1.toCharArray();
        char[] arrS2 = s2.toCharArray();
        int[][] arr = new int[s2.length()+1][s1.length()+1];
        //这里下标从1开始，就避免了i-1越界，同时使用 i-1和j-1去判断，避免了 i,j的越界
        //用匹配的字符串去查询原字符串
        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                //注意i,j的使用对象
                if (arrS2[i-1] == arrS1[j-1]){
                    arr[i][j] = arr[i-1][j-1]+1;
                }
            }
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (max < arr[i][j]){
                    max = arr[i][j];
                    index = i;
                }
            }
        }
        String s = "";
        for (int i = index-max; i < index; i++) {
            s += arrS1[i];
        }
        return s;
    }

}
