package com.test.test23;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args) {
        //一位：[0~9]
        //两位：[1-9][0-9]
        //三位：1[0-9][0-9]
        //三位：2[0-4][0-9]
        //四位：25[0-5]
        String IP = "192.168.10.1";
        String[] split = IP.split("\\.");
        int i = 0;
        while (i < split.length){
            //([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])
            //([0~9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])
            String patter = "([0~9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
            Pattern pattern = Pattern.compile(patter);
            Matcher matcher = pattern.matcher(split[i++]);
            while (matcher.find()){
                System.out.println(matcher.group());
                System.out.println("start --> "+ matcher.start());
                System.out.println("end --> " + matcher.end());
            }
        }
    }
}