package com.dsa.recursionAssignments;

import java.util.ArrayList;
import java.util.Arrays;

public class SumTriangleOfArray {

    public static void main(String[] args) {

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(3);
        ans.add(4);
        ans.add(5);

        sumTriangleOfArray(ans);
        System.out.println(ans);
    }

    /*
    https://www.geeksforgeeks.org/sum-triangle-from-array/
    */


    //with a While Loop
    static void sumTriangleOfArray(ArrayList<Integer> arr){

        if(arr.size()==0){
            return;
        }

        ArrayList<Integer> ithAns = new ArrayList<Integer>();

        int start = 0;
        int end = 1;

        while(end<arr.size()){
            int count;
            count = arr.get(start)+arr.get(end);
            ithAns.add(count);
            start++;end++;
        }

        sumTriangleOfArray(ithAns);

        System.out.println(Arrays.toString(ithAns.toArray()));
    }

}
