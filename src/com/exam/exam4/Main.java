package com.exam.exam4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        int[] numArr1 = new int[arr1.length];
        int[] numArr2 = new int[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            numArr1[i] = Integer.parseInt(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            numArr2[i] = Integer.parseInt(arr2[i]);
        }
        Main mMain = new Main();
        System.out.println(mMain.findMedianSortedArrays(numArr1,numArr2));
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] arr = new int[nums1.length+nums2.length];
//        for (int i = 0,x=0,y=0; i < arr.length; i++) {
//            int num1 = Integer.MAX_VALUE;
//            if (x<nums1.length){
//                num1 = nums1[x];
//            }
//            int num2 = Integer.MAX_VALUE;
//            if (y<nums2.length){
//                num2 = nums2[y];
//            }
//            if (num1>num2){
//                arr[i] = num2;
//                y++;
//            }else{
//                arr[i] = num1;
//                x++;
//            }
//        }
//        if (arr.length%2 == 1){
//            return arr[arr.length/2];
//        }else{
//            return (arr[arr.length/2]+arr[arr.length/2-1])/2.0;
//        }
//    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n,当m>n时，就将两个交换，确保m<n
            int[] temp = A; A = B; B = temp;//交换数组
            int tmp = m; m = n; n = tmp;//交换长度
        }
        //A中有m个元素，所以我们有m+1种划分方法，即i的取值为[0,m]，
        // 此时如果长度为奇数，中位数就是左边的最大值
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;//规定i的取值范围
        while (iMin <= iMax) {//搜索i的正确位置
            int i = (iMin + iMax) / 2;//得到i
            int j = halfLen - i;//计算j
            if (i < iMax && B[j-1] > A[i]){//B[j-1] > A[i]，说明i太小，增大i后，j自动变小，因为j是由i计算得来的
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {//A[i-1] > B[j]，说明i太大，应该减小i
                iMax = i - 1; // i is too big
            }
            else { // i is perfect，i合适的时候
                int maxLeft = 0;//定义变量保存左边最大的值
                if (i == 0) { maxLeft = B[j-1]; }//当i为边界值时，选B[j-1]为左边最大的
                else if (j == 0) { maxLeft = A[i-1]; }//同理
                else { maxLeft = Math.max(A[i-1], B[j-1]); }//否则判断左边的A[i-1]和B[j-1]谁最大，以此作为左边的最大值
                if ( (m + n) % 2 == 1 ) { return maxLeft; }//当数组长度和为奇数时，直接返回左边最大

                //当长度和为偶数时，要计算出右边的最小值，思路和计算左边最大值一样
                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;//返回左边最大和右边最小值的平均值作为中位数
            }
        }
        return 0.0;
    }
}
