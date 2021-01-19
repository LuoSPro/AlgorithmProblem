package com.exam.exam67;

public class Main {
    public static void main(String[] args) {
        String a = "0";
        String b = "1011";
        System.out.println(new Main().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2));

//        char[] charA = a.toCharArray();
//        char[] charB = b.toCharArray();
//        int lenA = a.length();
//        int lenB = b.length();
//        int[] result = new int[Math.max(lenA, lenB)+1];
//        int k = 0;
//        int i,j;
//        for (i = lenA - 1,j = lenB - 1; i >= 0  && j >= 0 ; i--,j--) {
//            int aNum = charA[i] - '0';
//            int bNum = charB[j] - '0';
//            result[k] = aNum + bNum;
//            k++;
//        }
//        if (i != -1){
//            for (int x = i; x >= 0; x--) {
//                result[k] = charA[i] - '0';
//                k++;
//            }
//        }
//        if (j != -1){
//            for (int x = j; x >= 0; x--) {
//                result[k] = charB[x] - '0';
//                k++;
//            }
//        }
//        StringBuilder temp = new StringBuilder();
//        for (i = 0; i < result.length -1; i++) {
//            if (result[i] > 1){
//                result[i+1] +=  1;
//                result[i] = result[i] - 2;
//            }
//        }
//        if (result[result.length-1] == 0&&result[result.length-2] == 1){
//            i = result.length-2;
//        }else{
//            i = result.length-1;
//        }
//        for (; i >= 0; i--) {
//            temp.append(result[i]);
//        }
//        return temp.reverse().toString();
    }
}
