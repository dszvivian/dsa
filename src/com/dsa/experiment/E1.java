package com.dsa.experiment;

import java.util.ArrayList;
import java.util.Arrays;

public class E1 {

    public static void main(String[] args) {

        System.out.println(helperMultiply(0.00001,0.00001,2147483647));


    }

    static double helperMultiply(double digit,double x,int n){
        if(n==1){
            return x;
        }
        return helperMultiply(digit,x*digit,n-1);
    }

    static double helperDivide(double digit,double x,int n){
        if(n==1){
            return x;
        }
        return helperDivide(digit,(1/digit)*x,n-1);
    }

    static int myAtoi(String s) {
        int a = Integer.parseInt(helper("",s));


        for(int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if(symbol=='-'){
                return a*-1;
            }
        }

        return a;
    }

    private static String helper(String p, String up) {
        if(up.isEmpty()){
            return p;
        }

        char a = up.charAt(0);

        if(isNumber(a)){
             return helper(p+a,up.substring(1));
        }
        return helper(p,up.substring(1));

    }

    private static boolean isNumber(char c) {
        if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'){
            return true;
        }

        return false;
    }


}
