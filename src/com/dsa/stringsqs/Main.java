package com.dsa.stringsqs;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }


    static String sortSentence(String s) {

        String[] arr = s.split(" ");
        String[] ans = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int a = Integer.parseInt(String.valueOf((arr[i].charAt(arr[i].length() - 1))));
            System.out.println(a);
            ans[a-1] = arr[i].substring(0,arr[i].length()-1);
        }

        StringBuilder a = new StringBuilder();
        for(String i:ans){
            a.append(i+" ");
        }


        return a.toString();
    }





}
