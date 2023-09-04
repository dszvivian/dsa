package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionArrays {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,5};
        System.out.println(Arrays.toString(linearSearch3(a,5,0).toArray()));
    }

    static boolean isSortedAsc(int[] a){
        return helper1(a,0);
    }

    private static boolean helper1(int[] a, int i) {
        if(i==a.length-1) return true;
        return ((a[i]<a[i+1])&&(helper1(a,i+1)));
    }


    static int linearSearch(int[] arr,int target){
        return helperLS(arr,target,0);
    }

    private static int helperLS(int[] arr, int target, int i) {
        if(i< arr.length){
            if(arr[i]==target) return i;
            else{
                return helperLS(arr,target,i+1);
            }
        }
        return -1;
    }

    static ArrayList<Integer> linearSearch2(int[] arr, int target, int index, ArrayList<Integer> list) {
        if(index == arr.length) {
            return list;
        }

        if(arr[index]==target){
            list.add(index);
        }

        return linearSearch2(arr, target,index+1,list);
    }


    static ArrayList<Integer> linearSearch3(int[] arr, int target, int index) {

        ArrayList<Integer> list=new ArrayList<>();

        if(index == arr.length) {
            return list;
        }

        if(arr[index]==target){
            list.add(index);
        }

        ArrayList<Integer> listFromBelow = linearSearch3(arr, target,index+1);
        list.addAll(listFromBelow);

        return list;
    }

}
