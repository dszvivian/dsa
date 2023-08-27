package com.dsa.experiment;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(longToBinary(
                binaryToLong("1010")+
                        binaryToLong("1011")));

        System.out.println(binaryToLong("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"));
        System.out.println(new BigInteger("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",2));
    }

    static long binaryToLong(String a){

        long ans = 0;

        int i=a.length()-1;
        int power = 0;
        while(i>=0){
            int digit = Character.getNumericValue(a.charAt(i));
            ans += digit*Math.pow(2,power);
            power++;
            i--;
        }
        return ans;
    }

    static String longToBinary(long n){

        if(n==0) return "0";

        StringBuilder ans = new StringBuilder();
        while(n>0){
            if((n%2)==0){
                ans.append(0);
            }else{
                ans.append(1);
            }
            n=n/2;
        }
        return ans.reverse().toString();
    }


}
