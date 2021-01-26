package com.niuke.jz21;

import java.util.Stack;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 示例1
 * 输入
 * 复制
 * [1,2,3,4,5],[4,3,5,1,2]
 * 返回值
 * 复制
 * false
 *
 */
public class Main {

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(new Main().IsPopOrder(pushA, popA));
    }

    /**
     * 看到这个题没什么思路，因为找不到什么时候这个数据才能弹出去，但是光是看数据还是能知道的，只是不知道代码怎么写
     *
     * 看了一遍题解，他是对栈内的情况进行了模拟，即看是否能按照pop的顺序进行压入
     * 条件：
     * 1. push[i] != pop[j] : 如果两个不相等，表示该数据没有进入辅助栈，则把数据压入辅助栈中，并且push的坐标+1
     * 2. push[i] == pop[j] : 如果两个相等，表示这个数据进栈之后马上出栈。这个时候把push和pop的下标都+1
     * 3. 上面两种情况是在push的下标小于push的长度。如果i == push.length 之后，需要把辅助栈内的所有的数据弹出并和pop的数据做比较
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i=0,j=0;
        Stack<Integer> stack = new Stack<>();
        while (i < pushA.length){
            if (pushA[i] != popA[j]){
                //压栈
                stack.push(pushA[i]);
                i++;
            }else{
                i++;
                j++;
                //先用peek()判断栈顶元素是否和pop[j]一样，一样的话再pop()
                while (!stack.empty()&&stack.peek() == popA[j]){
                    stack.pop();
                    j++;
                }
            }
        }
        return stack.empty();
    }

}
