package com.dsa.recursionAssignments;

public class MaxMinInAnArray {

    public static void main(String[] args) {

        int[] arr = {1, 4, 3, -5, -14, 8, 6};
        System.out.println(minInAnArray(arr,arr[0],0));

    }

    /*
    Array is Unsorted
    */


    static int maxInAnArray(int[] arr,int max,int i){
        if(i==arr.length){
            return max;
        }

        if(arr[i]>max){
            max = arr[i];
            return maxInAnArray(arr,max,i+1);
        }

        return maxInAnArray(arr,max,i+1);
    }

    static int minInAnArray(int[] arr,int min,int i){
        if(i==arr.length){
            return min;
        }

        if(arr[i]<min){
            min = arr[i];
            return minInAnArray(arr,min,i+1);
        }

        return minInAnArray(arr,min,i+1);
    }



}
