package com.dsa.recursionAssignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {
    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2};
        Arrays.sort(arr);
        ArrayList<Integer> p = new ArrayList<>();
        for(List<Integer> list:helper2(p,arr,4,0)){
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    //permutation of all possible numbers that sum up to target
    static List<List<Integer>> helper(List<Integer> p, int[] arr, int target){

        int sum = sum(p);

        if(sum==target){
            List<List<Integer>> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        if(sum>target){
            return new ArrayList<>();
        }

        List<List<Integer>> outer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> inner = new ArrayList<Integer>(p);
            inner.add(arr[i]);
            List<List<Integer>> list = helper(inner,arr,target);
            outer.addAll(list);
        }

        return outer;
    }

    static int sum(List<Integer> arr){

        int count = 0;
        for(int n:arr){
            count += n;
        }

        return count;
    }

    //combination sum 2 with unique combinations with no repetition of number
    static List<List<Integer>> helper2(List<Integer> p, int[] arr, int target,int index){

        int sum = sum(p);

        if(sum==target){
            List<List<Integer>> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        if(sum>target){
            return new ArrayList<>();
        }

        List<List<Integer>> outer = new ArrayList<>();


        for(int i = index; i<arr.length;i++){
            List<Integer> inner = new ArrayList<Integer>(p);

            if(arr[i]>target){
                break;
            }

            if((i>index)&&(arr[i]==arr[i-1])){
                continue;
            }
            inner.add(arr[i]);
            List<List<Integer>> list = helper2(inner,arr,target,i+1);
            outer.addAll(list);
        }



        return outer;
    }








}
