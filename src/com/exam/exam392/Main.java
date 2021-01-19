package com.exam.exam392;

import com.exam.exam2.Solution;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String s = "axc";
        String t = "ahbgdc";
        boolean subsequence = main.isSubsequence(s, t);
        System.out.println(subsequence);
    }

//    public boolean isSubsequence(String s, String t) {
//        int i, j;
//        for (i = 0, j = 0; i < t.length() && j < s.length(); i++) {
//            if (t.charAt(i) == s.charAt(j)) {
//                j++;
//            }
//        }
//        return j == s.length();
//    }

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < 26; j++) {
                System.out.print(f[i][j] + "  ");
            }
            System.out.println();
        }

        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

}
