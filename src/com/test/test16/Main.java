package com.test.test16;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        //定义字符串字母、数字、汉字和其他，用于存放从文中提取出的对应内容
        String character=null,figure=null,sinogram=null,others=null;
        //用于累计文档中字母、数字、汉字和其他字符的个数
        int c=0,f=0,s=0,o=0,b=0;
        String str=null;
        File read_file=new File("test.txt");//建立读入文件对象
        try{
            InputStreamReader reader = new InputStreamReader(new FileInputStream(read_file)); // 将输入的字节流转换成字符流
            BufferedReader buf=new BufferedReader(reader);	//将字符流添加到缓冲流
            while ((str = buf.readLine()) != null){
                for(int i=0;i<str.length();i++)
                {
                    //判断是否是字母
                    if( ((str.charAt(i))>='A' && (str.charAt(i))<='Z') || ((str.charAt(i))>='a' && (str.charAt(i))<='z') )
                    {
                        c++;
                        continue;
                    }
                    if(str.charAt(i)>='0' && str.charAt(i)<='9')//判断数字
                    {
                        f++;
                        continue;
                    }
                    if(str.charAt(i)>=0x4e00 && str.charAt(i)<=0x9fbb)//判断汉字
                    {
                        s++;
                        continue;
                    }

                    Character.UnicodeBlock pun = Character.UnicodeBlock.of(str.charAt(i)); //获取此字符的UniCodeBlock
                    if (pun == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || pun == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                            || pun == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || pun == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                            || pun == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || pun == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                            || pun == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
                        b++;
                    }
                    else
                    {
                        o++;
                        continue;
                    }
                }
            }
            System.out.println("test.txt中的文段");
            System.out.println("字母的个数："+c);
            System.out.println("汉字的个数："+s);
            System.out.println("数字的个数："+f);
            System.out.println("标点的个数："+b);
            System.out.println("其他字符："+o);
            System.out.println("总字符数："+(c+s+f+b+o));
        }
        catch(IOException e){//捕获异常
            e.printStackTrace();
        }
    }

}
