package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionPermutation {

    public static void main(String[] args) {
        String a = "Vivian";
        System.out.println(permutationStringRet("",a).size());


        System.out.println(permutationStringCount("",a));

    }

    static void permutationString(String p,String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        int size = p.length()+1;

        for (int i = 0; i < size; i++) {
            String f = p.substring(0,i);
            String e = p.substring(i);
            permutationString(f+ch+e,up.substring(1));
        }

    }


    static ArrayList<String> permutationStringRet(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        char ch = up.charAt(0);

        int size = p.length()+1;

        for (int i = 0; i < size; i++) {
            String f = p.substring(0,i);
            String e = p.substring(i);
            ans.addAll(permutationStringRet(f+ch+e,up.substring(1)));
        }

        return ans;

    }


    //Return no of Possible Permutations
    static int permutationStringCount(String p,String up){

        if(up.isEmpty()){
            return 1;
        }

        char ch = up.charAt(0);

        int size = p.length()+1;

        int ans = 0;

        for (int i = 0; i < size; i++) {
            String f = p.substring(0,i);
            String e = p.substring(i);
            ans += permutationStringCount(f+ch+e,up.substring(1));
        }

        return ans;

    }





}
