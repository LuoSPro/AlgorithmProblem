package com.exam.exam6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String s = "A";
        int numRows = 14;
        System.out.println(main.convert(s,numRows));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            //第0行和最后一行
            if (curRow == 0|| curRow == numRows - 1){
                goingDown = !goingDown;
            }
            curRow+= goingDown?1:-1;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            builder.append(stringBuilder);
        }
        return builder.toString();
    }

//    public String convert(String s, int numRows) {
//        if (numRows < 2){
//            return s;
//        }
//        int strLen = s.length();
//        float temp = (float) ((strLen / (2.0 * numRows - 2)) * (numRows - 1));
//        int column;
//        if (temp - (int)temp > 0 ){
//            column = (int)temp+1;
//        }else{
//            column = (int)temp;
//        }
//        char[][] arr = new char[numRows][column];
//        int index = 0;
//
//        for (int i = 0; index<strLen; i++) {
//            for (int j = 0; j<numRows&&index<strLen ; j++) {
//                if (i % (numRows-1) == 0){
//                    arr[j][i] = s.charAt(index);
//                    index++;
//                }else{
//                    int row = numRows - i % (numRows-1) - 1;
//                    arr[row][i] = s.charAt(index);
//                    index++;
//                    break;
//                }
//            }
//        }
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j] != '\0'){
//                    builder.append(arr[i][j]);
//                }
//            }
//        }
//        return String.valueOf(builder);
//    }
}
