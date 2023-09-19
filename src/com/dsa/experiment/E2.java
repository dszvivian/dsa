package com.dsa.experiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E2 {

    public static void main(String[] args) {

        ArrayList<String> a = helper(1,8,"()");

        ArrayList<String> ans = new ArrayList<String>();

        for(String b:a){
            if(!(ans.contains(b))){
                ans.add(b);
            }
        }

        System.out.println(Arrays.toString(a.toArray()));


    }

    static ArrayList<String> helper(int count,int n,String p){
        if(count==n){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<String>();

        for(int i=0;i<p.length();i++){
            StringBuilder a = new StringBuilder();
            a.append(p);
            a.insert(i,"()");
            ans.addAll(helper(count+1,n,a.toString()));
        }

        return ans;
    }

}
