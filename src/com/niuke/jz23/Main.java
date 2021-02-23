package com.niuke.jz23;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 * 示例1
 * 输入
 * 复制
 * [4,8,6,12,16,14,10]
 * 返回值
 * 复制
 * true
 */
public class Main {

    public static void main(String[] args) {
        int[] sequence = {7,4,6,5};
        System.out.println(new Main().VerifySquenceOfBST(sequence));
    }

    /**
     * 思路，这里说了是二叉搜索树，所以就是要根据搜索树的特性来判断
     * <p>
     * 特性1：左子树的最大的节点要小于根节点，又小于右子树最小的节点，所以我们可以根据这个来划分数据(主要是根据这一点来实现的)
     * 特性2：把搜索树排序，就可以得到搜索树的中序遍历结果
     * 特性3：根节点的下标和尾节点的下标是一样的
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        return splitArray(sequence, sequence.length - 1, 0);
    }

    private boolean splitArray(int[] sequence, int rootIndex, int beginIndex) {
        //终止条件
        if (beginIndex >= rootIndex) {
            return true;
        }
        int i;
        for (i = beginIndex; i < rootIndex; i++) {
            if (sequence[i] > sequence[rootIndex]){
                //此时的i就是左右子树的分界点
                break;
            }
        }
        for (int j = i; j < rootIndex; j++) {
            if (sequence[j] < sequence[rootIndex]){
                //后面有比rootIndex小的数就不符合
                return false;
            }
        }
        return splitArray(sequence, i-1, beginIndex)&&splitArray(sequence,rootIndex-1,i);
    }


}
