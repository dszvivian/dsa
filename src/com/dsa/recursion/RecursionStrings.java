package com.dsa.recursion;

public class RecursionStrings {

    public static void main(String[] args) {

        String name = "bigapplemynewappdocheckmyapp";
        System.out.println(skipAppNotApple(name));
    }

    //region skipA Problem

    //Type 1: Using String Builder
    static StringBuilder ans = new StringBuilder();
    static void skipA1(String a,int start){
        if(start==a.length()) {
            return;
        }
        if(!(a.charAt(start)=='a' )){
            ans.append(a.charAt(start));
            skipA1(a,++start);
        }else{
            skipA1(a,++start);
        }
    }

    //Type 2: Using two string Method--processed,unprocessed
    static void skipA2(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char a = up.charAt(0);

        if(a=='a'){
            skipA2(p,up.substring(1));//skip the first index
        }else{
            skipA2(p+a,up.substring(1));
        }
    }

    //Type 3: returning the answer Recursively
    static String skipA3(String a){
        if(a.isEmpty()){
            return "";
        }
        char c = a.charAt(0);
        if(c=='a'){//skip it
            return skipA3(a.substring(1));
        }else{
            return c + skipA3(a.substring(1));
        }
    }

    //endregion skipA Problem
    //region skipString Problem

    static String skipApple(String a){
        if(a.isEmpty()){
            return "";
        }
        boolean c = a.startsWith("apple");
        if(c){//skip it
            return skipApple(a.substring(5));
        }else{
            return a.charAt(0) + skipApple(a.substring(1));
        }
    }

    //skip app when it's not equal to apple
    static String skipAppNotApple(String a){
        if(a.isEmpty()){
            return "";
        }

        if(a.startsWith("app") && !a.startsWith("apple")){//skip it
            return skipAppNotApple(a.substring(3));
        }else{
                return a.charAt(0)+skipAppNotApple(a.substring(1));
        }
    }

    //endregion skipString Problem

    //region subset problems



    //endregion subset problems



}
