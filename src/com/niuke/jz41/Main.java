package com.niuke.jz41;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 返回值描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 示例1
 * 输入
 * 复制
 * 9
 *
 * 返回值
 * 复制
 * [[2,3,4],[4,5]]
 *
 */
public class Main {

    public static void main(String[] args) {
        int sum = 100;
        ArrayList<ArrayList<Integer>> arrayLists = new Main().FindContinuousSequence(sum);
        for (ArrayList<Integer> list : arrayLists) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    /**
     * 思路：
     * 简单的思考之后，我觉得可以用动态规划，先把 (n/2)*(n/2)的二维数组求出来，然后遍历，找到其中和target相等的数。时间复杂度O(n*n)
     * 上面的思路，在题解中时前缀和的思想。但是我比前缀和少了一个剪枝的步骤，这将比我的方法更优
     *
     * 题解，最优秀的题解应该是滑动窗口。时间复杂度O(n)，贼牛逼
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int right = 1;
        int left = 1;
        int num = 0;//刚开始，窗口的大小为0，里面的数据和也就为0
        while (left <= sum/2){//当left走到中点时终止
            if (num < sum){
                //窗口的和小于sum，应该扩大窗口
                num += right;
                right++;
            }else if(num>sum){
                //窗口和大于sum，应该缩小窗口
                num -= left;
                left++;
            }else{
                //两个相等了
                ArrayList<Integer> temp = new ArrayList<>();
                for (int k = left; k < right; k++) {
                    //由于i是下标，所以对于的数字需要+1
                    temp.add(k);
                }
                lists.add(temp);
                //做完之后，还要缩小窗口，否则会一直死循环
                num -= left;
                left++;
            }
        }
        return lists;


//        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//        //构建二维矩阵(上矩阵)
//        int size = sum/2 + 1;
//        int[][] arr = new int[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = i+1; j < size; j++) {
//                if (j - i == 1){
//                    //每行起始的位置
//                    arr[i][j] = (i+1) + (j+1);
//                }else{
//                    arr[i][j] = arr[i][j-1] + (j+1);
//                }
//                //如果找到了，就添加进结果
//                if (arr[i][j] == sum){
//                    ArrayList<Integer> temp = new ArrayList<>();
//                    for (int k = i; k <= j; k++) {
//                        //由于i是下标，所以对于的数字需要+1
//                        temp.add(k+1);
//                    }
//                    lists.add(temp);
//                }else if (arr[i][j] > sum){
//                    //剪枝，提前结束，这个思想很好，我是没想到的
//                    break;
//                }
//            }
//        }
//        return lists;
    }
}
