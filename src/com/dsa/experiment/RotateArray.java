package com.dsa.experiment;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {-1,-200};

        reverse(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    static void rotate(int[] nums, int k) {

        for(int i=0;i<k;i++){
            int j=nums.length-1;
            while(j>0){
                swap(nums,j,j-1);
                j--;
            }
        }
    }

    static void swap(int[] arr,int i1,int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }


    static void rotate2(int[] arr, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = arr.length-k; i <arr.length; i++) {
            ans.add(arr[i]);
        }
        for (int i = 0; i < arr.length - k; i++) {
            ans.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(i);
        }

    }




    static void rotate3(int[] arr,int k){
        int largest = arr.length-1;

        if(arr.length>k){
            for(int i=k-1;i>=0;i--){
                swap(arr,i,largest);
                largest--;
            }
            Arrays.sort(arr,k,arr.length);
        }






    }


    static void reverse(int[] arr,int start,int end){
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }





}
