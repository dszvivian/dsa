package com.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] a = {-1,1,-6,4,5,-6,1,4,1};

        System.out.println(Arrays.toString(bubbleSort(a)));
    }

    //after every pass largest element gets sorted from last
    static int[] bubbleSort(int[] nums){

        //At each pass if no elements are swapped then its already sorted

        boolean swapped = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length-i; j++) {
                if(nums[j-1]>nums[j]){
                    swap(nums,j-1,j);
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }


        return nums;
    }

    //you select an element and place it at right position
    static int[] selectionSort(int[] arr){

        int max = Integer.MIN_VALUE;
        int maxIndex  =-1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j]>max){
                    max=arr[j];
                    maxIndex=j;
                }
            }
            swap(arr,maxIndex, arr.length-i-1);
            max=Integer.MIN_VALUE;


        }


        return arr;
    }

    static void swap(int[] arr,int n1,int n2){
        //n1,n2 ---> indexes
        int temp=arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=temp;
    }



    static int majorityElement(int[] nums) {
        //https://leetcode.com/problems/majority-element/

        bubbleSort(nums);

        int maj = 0;
        int element = nums[0];
        for(int i=1;i<nums.length;i++){
            if(element==nums[i]){
                maj++;
            }else{
                if(maj>(nums.length/2)){
                    return nums[i-1];
                }else{
                    maj=0;
                }
            }
        }

        return 0;
    }


    /*
    Condition:
    Elements should range from 1-N
    All the elements from 1-N should be present in the array
    */
    static int[] cyclicSort(int[] nums){
        int i=0;
        while(i< nums.length) {
            int correctIndex = nums[i]-1;
            if(nums[i]==nums[correctIndex]){
                i++;
            }else{
                swap(nums,i,nums[i]-1);
            }
        }
        return nums;
    }


    //find the missing elements
    //range: 1-N
    static List<Integer> missingNumbers(int[] nums){
        // Google interview Question

        List<Integer> ans = new ArrayList<>() ;

        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));

        for (int j = 0; j < nums.length; j++) {
            int correctIndex = nums[j]-1;
            //comparing index to the current index
            if(j!=correctIndex){
                ans.add(j+1);
            }
        }

        return ans;
    }



    static int[] insertionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                int p = j-1;
                if(!(arr[j]>arr[p])){
                    swap(arr,j,p);
                }else{
                    break;
                }
            }
        }
        return arr;
    }



}
