package com.niuke.jz31;

/**
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 示例1
 * 输入
 * 复制
 * 13
 * 返回值
 * 复制
 * 6
 */
public class Main {

    public static void main(String[] args) {
        int target = 13;
        System.out.println(new Main().NumberOf1Between1AndN_Solution(target));
    }

    /**
     * 看到这道题，想到了自己当初想进ACM的时候，就是这种题不会，没想到过了2年，还是TM的不会，恶心人啊
     * 能想到的方法，一个是暴力，对每个数据进行统计，这样效率肯定大打折扣，首先排除
     * 还有就是采用分治，把数据 /10  /100 /1000 这样处理，然后再加起来
     *
     * 解题：我这样一个一个的判断太多了，想想都恐怖，最后只得放弃，然后看大佬的思路，发现很有意思，太巧妙了
     * 其实也就三种情况，三个公式。
     * 先行条件：
     * if cur == 0:
     * 数字： 2 1 0 5
     * 每一位： cur:0   high：2 1   low:5  digit:10
     * 范围：0010 ~ 2019
     * 1出现的次数：209 - 000 + 1 = 210
     * 所以cur=0的时候，公式就是 high*10
     *
     * if cur == 1:
     * 数字：2 1 1 5
     * 每一位：cur:1 high:2 1  low: 5  digit:10
     * 范围：0010~2115
     * 1出现的次数 215 - 000 + 1 = 216
     * 所以cur=1时，公式：high*digit + low + 1
     *
     * if cur == 2,3,4,5...
     * 数字 2 1 2 2
     * 每一位：cur:2 high:2 1  low: 2  digit:10
     * 范围：0010~2119
     * 1出现的次数 219 - 000 + 1 = 220
     * 所以cur=1时，公式：(high+1)*digit
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        //初始化
        int cur = n%10;//个位
        int high = n/10;
        int low = 0;
        int digit = 1;//个位
        int result = 0;
        while (cur != 0 || high != 0){
            //根据cur来判断1的个数
            if (cur == 0){
                result += high * digit;
            }else if (cur == 1){
                result += high*digit + low + 1;
            }else{
                result += (high + 1) * digit;
            }
            //更新数据(顺序不能变)
            low += cur*digit;
            cur = high%10;
            high = high/10;
            digit = digit*10;
        }
        return result;
    }

//    private int split(int n) {
//        //n在0~9里面的时候
//        if (n / 10 == 0){
//            return 1;
//        }
//        //计算n有多少位
//        int temp = n;
//        int num = 0;
//        while (temp != 0){
//            num++;
//            temp = temp / 10;
//        }
//        //判断temp的最高位
//        int base = (int) Math.pow(10,num-1);
//        int high = num / base;
//        if (high >= 2){
//            //大于2，说明包含了整个1的部分
//            return base + (high - 1)*split(base - 1) + split(n%base);
//        }else if (high == 1){
//            //等于1
//            return n%base + split(n%base) + ;
//        }
//        return ;
//    }

}
