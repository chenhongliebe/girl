package com.liebe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {


    /**
     * 力扣第七题
     * @param x
     * @return
     */
    public static  int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 第八题
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        str=str.trim();

        String pattern="^[\\+\\-\\d]\\d*";//正则表达式，表示以正号或负号或数字开头，且后面是0个或多个数字
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(str);

        String res="";
        if(m.find()){//能匹配到
            res=str.substring(m.start(),m.end());
        }else{//不能匹配到
            return 0;
        }

        //能匹配到但只有一个+-号，也返回0
        if(res.length()==1&&(res.charAt(0)=='+'||res.charAt(0)=='-')){
            return 0;
        }

        try{
            int r=Integer.parseInt(res);
            return r;
        }catch(Exception e){
            return res.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        int x= -1463847412;
        System.out.println(Solution.reverse(x));

    }
}
