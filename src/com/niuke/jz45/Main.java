package com.niuke.jz45;

/**
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 * 示例1
 * 输入
 * 复制
 * [0,3,2,6,4]
 * 返回值
 * 复制
 * true
 */
public class Main {

    public static void main(String[] args) {
        int[] numbers = {};
        System.out.println(new Main().IsContinuous(numbers));
    }

    /**
     * 思路：
     * 看到这道题，首先想到的是先排序，然后再用0去弥补空缺的数。今天早上才学习了归并、快排、插入这些排序算法，所以我就先拿最常考的快排来做
     *
     * @param numbers
     * @return
     */
    public boolean IsContinuous(int[] numbers) {
        if (numbers == null||numbers.length == 0){
            return false;
        }
        QuickSort(numbers, 0, numbers.length - 1);
        //记录0的个数
        int count = 0;
        for (int i = 0; i < numbers.length- 1; i++) {
            if (numbers[i] == 0){
                count++;
            }else{
                int temp = numbers[i+1] - numbers[i] - 1;
                count -= temp;
                //0不够时，或者有重复的数的时候
                if (count < 0||temp == -1){
                    return false;
                }
            }
        }
        return true;
    }

    private void QuickSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        //拿这段数组的最开始的位置作为参考点
        int temp = numbers[left];
        while (i < j) {
            //顺序很重要啊，从后往前
            while (i < j && numbers[j] > temp) {
                //把数组中大于temp的都过滤掉
                j--;
            }
            if (i<j){
                numbers[i++] = numbers[j];
            }
            while (i < j && numbers[i] <= temp) {
                //把数组中小于temp的都过滤掉
                i++;
            }
            if (i<j) {
                numbers[j--] = numbers[i];
            }
        }
        numbers[i] = temp;
        //继续递归
        //左边
        QuickSort(numbers, left, i - 1);
        //右边
        QuickSort(numbers, i + 1, right);
    }

}
