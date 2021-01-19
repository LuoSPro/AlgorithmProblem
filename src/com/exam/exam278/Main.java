package com.exam.exam278;

public class Main {
    public static void main(String[] args) {
        new Main().firstBadVersion(5);
    }

    private int low = 0;
    private int high = 0;

    public int firstBadVersion(int n) {
        high = n;
        int mid = (low + high)/2;
        low = ++mid;
        high = --mid;
        if (low > high){
            return -1;
        }
        firstBadVersion(low);
        firstBadVersion(high);
        return mid;
    }
}
