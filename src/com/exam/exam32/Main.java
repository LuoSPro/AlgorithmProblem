package com.exam.exam32;

/**
 *给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(new Main().longestValidParentheses(s));
    }

    /**
     * 思路：这个和最长回文串是差不多类型的，除了动态规划，还可以采用中心分散的思想去做
     *
     * 题解：我这个思路想不通啊，这个和正向查找其实差不多的，放在中间开始查找没啥用。
     * 不过，题解的动态规划倒是看懂了，这里记录一下
     *
     * 场景一： ()((())   len = 7
     * 对于这个，我们从下标1开始查找
     * 步骤：
     * 1. 自己(下标i)当前是否是 ‘)’
     * 2. 如果是的话，查找i-1是否是 '('，是的话，就 dp[i-2] + 2   因为前面可能已经有配对的括号了，
     * 所以要把括号数加起来（记得判断i-2是否大于0），类似于   ()()这种情况
     * 3. 如果不是，则判断 dp[i - dp[i-1] - 1] 是否是 '(',这相当于越过了中间已有的括号，类似于 (..()()..)这种
     * 计算的时候就等于 dp[i - dp[i - 1] - 2] + dp[i-1] + 2
     * 这个2是由于匹配成功+2，而dp[i - dp[i - 1] - 2]是因为要考虑在这个括号之前的括号，类似于 ()(....)的情况
     *
     *
     * 综上：状态转移方程就的出来了
     * if(s.charAt(i) == '(')
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null||s.length() < 2){
            return 0;
        }
//        //找到中心点
//        int mid = s.length()/2;
//        char[] arr = s.toCharArray();
//        int left = mid,right = mid;
//        while (left )
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
//            for (int j = i-1; j >= 0; j++) {
                if (s.charAt(i) == ')'){
                    if (s.charAt(i-1) == '('){
                        //两个括号挨着的
                        dp[i] = (i - 2 > 0 ? dp[i-2] + 2 : 2);
                    }else if (i - dp[i-1] - 1>= 0&&s.charAt(i - dp[i-1] - 1) == '('){
                        //没挨着，就要判断两个中间是否有括号对
                        //这里需要特别注意数组越界的问题
                        dp[i] = (i - dp[i-1] - 2 >= 0 ? dp[i - dp[i-1] - 2] + dp[i - 1] + 2 : dp[i - 1] + 2);
                    }
                }
//            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

}
