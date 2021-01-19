package com.offer.offer40;

public class Main {


    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int k = 2;
        int[] result = new Main().getLeastNumbers(arr, k);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(0,arr.length - 1,arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /**
     * 快排，
     * 每次遍历，可能会有很多次交换，所以应该先把一次的交换做好，再考虑多次遍历
     * @param begin
     * @param end
     * @param arr
     */
    public void quickSort(int begin,int end,int[] arr){
        //先判断是否有必要排序，即递归的终止条件
        if (begin < end){
            //从begin到end，需要一次一次的遍历
            int i= begin, j = end;
            //选择一个基数,默认begin到end的第一个
            int x = arr[begin];
            //从i~j，去交换数据
            while (i < j){
                //先从后往前查找比x小的数
                while (i<j&&arr[j]>x){
                    j--;
                }
                if (i < j){
                    arr[i] = arr[j];//把比x小的数（arr[j]）放到arr[i]上面来
                    i++;
                }
                //从前往后查找比x大的数
                while (i<j&&arr[i]<x){
                    i++;
                }
                if (i < j){
                    arr[j] = arr[i];//把比x大的数（arr[i]）放到arr[j]上面来
                    j--;
                }
            }
            //遍历一遍之后（从i~j），此时i = j，在i=j这个位置上，放上我们的基数去划分左右两边的大小
            arr[i] = x;
            //继续递归
            //对x左边的数据进行排序
            quickSort(begin,i-1,arr);
            //对x右边的数据进行排序
            quickSort(i+1,end,arr);
        }
    }

}
