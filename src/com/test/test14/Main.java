package com.test.test14;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 0, 3};
        //快排
//        quickSort(arr, 0, arr.length - 1);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        //归并
//        int[] tmp = new int[arr.length];
//        mergeSort(arr,tmp,0,arr.length - 1);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        insertSort(arr);
    }

    private static void insertSort(int[] arr) {
//        while ()
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high, temp = arr[low];
        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j){
                i++;
            }
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        arr[low] = arr[j];
        arr[j] = temp;
        //左边
        quickSort(arr, low, i-1);
        //右边
        quickSort(arr, i+1, high);
    }

    public static void mergeSort(int[] arr, int[] tmp, int start, int end){
        if (start < end){
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start,mid);
            mergeSort(arr, tmp, mid+1, end);
            mergeDoubleSort(arr,tmp,start,mid,end);
        }
    }

    private static void mergeDoubleSort(int[] arr, int[] tmp, int left, int mid, int right) {
        int i = left,j = mid + 1,k = left;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }
        //可能还未完
        while (i <= mid){
            tmp[k++] = arr[i++];
        }
        while (j <= right){
            tmp[k++] = arr[j++];
        }
        for (int l = left; l <= right; l++) {
            arr[l] = tmp[l];
        }
    }

}
