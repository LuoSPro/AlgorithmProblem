package com.niuke.jz11;

/**
 *
 * 题目描述
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 示例1
 * 输入
 * 复制
 * 10
 * 返回值
 * 复制
 * 2
 *
 */
public class Main {

    /**
     * 看到题我的知道肯定有便捷方法，但是我不知道怎么处理，所以这里如果要做的话，就必须得手动把十进制转化成二进制了，但是对于负数，补码=反码+1，
     * 转换成二进制后，通过  /10  和  %2  的操作可以对十进制进行计数
     *
     * 避坑
     * 这里有一个大坑，其实我们直接把数当成二进制来用的话，编译器是自动就把数给转换了的，不需要我们自己再去手动的变成二进制和补码之类的了
     *
     * 题解：
     * 这里通过除2取模运算，对于-2147483648,二进制为1000...000，一共有31个0.因为计算机使用补码存储二进制数据的。
     * 对于这个数据，我们的方***输出0，实际上为1.所以这种方法不对。
     *
     * 所以我们将数据直接当做二进制看，采用位移的方法——二进制位移法
     * ==============过渡方法，不实用====================
     * int val; // input data
     * int ans = 0;
     * while (val != 0) {
     *     if (val & 1) ++ans;
     *     val >>= 1;
     * }
     * val >>= 1;的操作会导致数整体往右移一位，然后最高位补0，但是这样对于负数来说就不行，一位负数的符号位位要为1。所以采用下面的方法
     * ================二进制位移法的正确使用=======================
     * int val; // input data
     * int ans = 0;
     * int mark = 0x01;
     * while (mark != 0) {
     *     if (mark & val) ++ans;
     *     mark <<= 1;
     * }
     * 这里采用0x01这样的十六进制，就可以转变为二进制的 0000 0001 这样的数。这里是让0x01和val的数从右往左(<<运算)的每一位进行&操作
     *
     *
     * ==================这些都过于复杂，还是这个简单（最优解）=========================
     * 如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
     * 原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
     * 举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，
     * 而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
     * 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
     * 如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     *
     * JAVA解：
     * public class Solution {
     * public int NumberOf1(int n) {
     *     int count=0;
     *     while(n!=0){
     *         count++;
     *         n=n&(n-1);
     *     }
     *     return count;
     * }
     * }
     * @param args
     */
    public static void main(String[] args) {
        int n = 214748367;
        System.out.println(new Main().NumberOf1(n));
    }


    public int NumberOf1(int n) {
        if (n == 0){
            return 0;
        }
        long b;
        //转化数据
        if (n >= 0){
            b = generateBinary(n);
        }else{
            b = generateNegativeBinary(n);
        }
        //统计
        String value = String.valueOf(b);
        int num = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '1'){
                num++;
            }
        }
        return num;
    }

    /**
     * 生成负的二进制
     * @param n
     * @return
     */
    private long generateNegativeBinary(int n) {
        //负的二进制的补码等于  反码+1。所以还是先得到二进制，再对其进行处理
        //得到二进制(这里的数肯定是负数)
        long binary = generateBinary(-n);
        //二进制变成反码
        String value = String.valueOf(binary);
        char[] charArray = value.toCharArray();
        for (int i = 0; i < value.length(); i++) {
            char c = charArray[i];
            if (c == '0'){
                charArray[i] = '1';
            }else{
                charArray[i] = '0';
            }
        }
        //二进制反码加一
        for (int i = charArray.length-1; i >= 0 ; i--) {
            if (charArray[i] == '1'){
                charArray[i] = '0';
            }else{
                charArray[i] = '1';
                break;
            }
        }
        //符号位 + (反码+1)
        return Long.parseLong('1'+String.valueOf(charArray));
    }

    /**
     * 生成二进制
     * @param n
     * @return
     */
    private long generateBinary(int n) {
        //二进制的处理，while
        StringBuilder builder = new StringBuilder();
        while(n != 0){
            builder.append(n % 2);
            n = n / 2;
        }
        return Long.parseLong(builder.reverse().toString());
    }
}
