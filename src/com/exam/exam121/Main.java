package com.exam.exam121;

public class Main {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Main main = new Main();
        System.out.println(main.maxProfit(prices));
    }

//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length-1; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                int result = prices[j] - prices[i];
//                if (result>maxProfit){
//                    maxProfit =result;
//                }
//            }
//        }
//        return maxProfit;
//    }

    //遍历一遍就找出来
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
