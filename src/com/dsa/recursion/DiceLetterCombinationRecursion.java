package com.dsa.recursion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class DiceLetterCombinationRecursion {

    public static void main(String[] args) {

        //n = 1, k = 6, target = 3
        dice(30,30,500,0,30);
        System.out.println(count);

    }

    static String map(String number){
        StringBuilder ans = new StringBuilder();

        for (char i :number.toCharArray()) {
            if(i=='2'){
                ans.append("abc");
            }else if(i=='3'){
                ans.append("def");
            }else if(i=='4'){
                ans.append("ghi");
            }else if(i=='5'){
                ans.append("jkl");
            }else if(i=='6'){
                ans.append("mno");
            }else if(i=='7'){
                ans.append("pqrs");
            }else if(i=='8'){
                ans.append("tuv");
            }else if(i=='9'){
                ans.append("wxyz");
            }
        }
        return ans.toString();
    }


    //First try
    static ArrayList<String> helper(int n,String p,String up){

        if(up.isEmpty() && p.length()!=n){
            return new ArrayList<>();
        }

        if(p.length()==n){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = helper(n,p+ch,up.substring(1));
        ArrayList<String> right = helper(n,p,up.substring(1));

        left.addAll(right);

        return left;
    }

    //After seeing the Recursion tree form video
    static ArrayList<String> helper2(int n,String p,String up){

        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        String map = map(String.valueOf(up.charAt(0)));

        for (int i = 0; i < map.length(); i++) {
            ArrayList<String> comb = helper2(n,p+String.valueOf(map.charAt(i)),up.substring(1));
            ans.addAll(comb);
        }

        return ans;
    }


    static int count = 0;

    //return the dice possibilities
    //Working on Small Numbers --- not on Large Numbers
    static void dice(int n, int k,int target,int p,int up){

        if(up==0){
            if(p==target){
                count++;
            }
            return;
        }

        int level = up-1;

        for (int i = 1; i <=k ; i++) {
            dice(n,k,target,p+i,level);
        }


    }








}
