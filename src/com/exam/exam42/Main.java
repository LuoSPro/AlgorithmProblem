package com.exam.exam42;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Main {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Main().trap(height));
    }

    /**
     * 思路：刚开始想的是从两边向内找，但是感觉又不是那么回事，发现可以从头开始找
     * 从前往后遍历，每个数又往回找
     * +
     *
     *
     * 题解：这道题我的思路不对啊，他不是看的两个数据之间的差，而看当前位置和两边的比较结果
     * @param height
     * @return
     */
    public int trap(int[] height) {
//        //保存最大的容量
//        int[] dp = new int[height.length];
//
//        for (int i = 1; i < height.length; i++) {
//            if (i - 2 >= 0 && height[i-2] <= height[i]){
//                //如果当前的数比i-2要大，或者相等，那么i到i-2的容量就已经确定了
//
//            }
//        }

        //保存当前位置到左边的墙的最大高度
        int[] maxLeft = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i-1],maxLeft[i-1]);
        }

        //保存当前位置到最右边的墙的最大高度
        int[] maxRight = new int[height.length];
        for (int i = height.length-2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i+1],maxRight[i+1]);
        }

        //遍历每一个的高度，只有当前的高度小于两边最小的高度的时候才能装水
        //两端的墙肯定不能装水，所以不考虑
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (height[i] < min){
                sum += min - height[i];
            }
        }
        return sum;

    }

}
