package com.exam.exam22;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        //“(”的个数
        int lc = 0;
        //“)”的个数
        int rc = 0;
        String cur = "";
        dfs(res,cur,n,lc,rc);
        return res;
    }

    private void dfs(List<String> res, String cur, int n, int lc, int rc) {
        //只有当右边的括号大于左边的括号的时候，才通过-->继续增加左边的括号
        if (rc > lc || lc > n || rc > n){
            return;
        }
        if (lc == rc && lc == n){
            res.add(cur);
            return;
        }
        //左边括号+1
        dfs(res, cur + "(", n, lc + 1, rc);
        //在上面左边括号+1前的字符串上进行  右边的括号+1(回溯的体现)
        dfs(res, cur + ")", n, lc, rc + 1);
    }
}
