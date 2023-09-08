package com.dsa.recursion;

import java.util.Arrays;


public class RecursiveSorting {

    public static void main(String[] args) {
        int[] a1 = {12,45,3,-2,56,-33};
        int[] a2 = {6,8,7,2,5,3,1};
        quickSort(a2,0, a2.length-1);
        System.out.println(Arrays.toString(a2));

    }


    // In Place Merge Sort
    static int[] mergeSort(int[] arr){
        int start = 0,end = arr.length-1;
        return helperMS(arr,start,end);
    }

    // Kunal's Solution
    static int[] mergeSort2(int[] arr){
        if(arr.length==1){
            return arr;
        }else{
            int mid = arr.length/2;
            int[] left = mergeSort2(Arrays.copyOfRange(arr,0,mid));
            int[] right = mergeSort2(Arrays.copyOfRange(arr,mid,arr.length));

            return merge(left,right);
        }
    }

    static int[] helperMS(int[] arr, int start, int end) {

        if(start==end) return new int[]{arr[start]};
        else{
            int mid = start+(end-start);
            return merge(helperMS(arr,start,mid-1), helperMS(arr,mid,end));
        }
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int i1 = 0 ;//index for arr1
        int i2 = 0;//index for arr2

        int[] ans = new int[arr1.length+ arr2.length];

        int counter = 0;//index counter for ans

        while(i1< arr1.length && i2< arr2.length){
            if(arr1[i1]<arr2[i2]){
                ans[counter] = arr1[i1];
                counter++;
                i1++;
            }else{
                ans[counter] = arr2[i2];
                counter++;
                i2++;
            }
        }

        if(i1< arr1.length){
            for (int i = i1; i < arr1.length; i++) {
                ans[counter] = arr1[i];
                counter++;
            }
        }

        if(i2< arr2.length){
            for (int i = i2; i < arr2.length; i++) {
                ans[counter] = arr2[i];
                counter++;
            }
        }

        return ans;
    }


    static void quickSort(int[] arr,int low,int high){

        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;
        int mid = s+(e-s)/2;
        int pivot = arr[mid];

        while(s<=e){

            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }

            if(s<=e){
                swap(arr,s,e);
                s++;
                e--;
            }
        }

        quickSort(arr,low,e);
        quickSort(arr,s,high);
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

}
