package com.dsa.arrays;

import java.util.*;

public class problems {

    public static void main(String[] args) {

        int[] a = {3,2,4};

//        int[][] b = new int[][];

//        System.out.println(luckyNumbers(b));

    }


    static int[] p1(int[] nums){
        //https://leetcode.com/problems/concatenation-of-array/description/

        int[] ans = new int[2*nums.length];
        System.arraycopy(nums,0,ans,0,nums.length);
        System.arraycopy(nums,0,ans,nums.length,nums.length);

        return ans;
    }


    static int[] runningSum(int[] nums) {

        //https://leetcode.com/problems/running-sum-of-1d-array/



        /*
            - modifying the i/p array itself
            - we start from 1st element
            - we add current element and previous element

        * */

        for(int i=1;i<nums.length;i++){

            nums[i] += nums[i-1];

        }

        return nums;

    }


    static int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];

        //Using Brute Force
        for(int i=0;i<nums.length;i++){
            if(!(nums[i]>target)){
                for(int j=0;j<nums.length;j++){
                        if((nums[i]+nums[j])==target && (j!=i)){
                            ans[0]=i;
                            ans[1]=j;
                        }
                }
            }
        }

        return ans;


    }



    //2d Arrays

    static int[][] flipAndInvertImage(int[][] image) {

        //https://leetcode.com/problems/flipping-an-image/

        for(int i=0;i<image.length;i++){
                int start = 0;
                int end = image[i].length-1;

                while (start<end){
                    swap(image[i],start,end);
                    start++;
                    end--;
                }
        }

        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length;j++){
                if(image[i][j]==0){
                    image[i][j]=1;
                }else{
                    image[i][j]=0;
                }
            }
        }

        return image;

    }



    static  void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }


    // LuckyNumber(lowest in row && highest in column)
/*    static List<Integer> luckyNumbers (int[][] matrix) {

        List<Integer> ans=new ArrayList<Integer>();


        int index = -1;

        for(int i=0;i<matrix.length;i++){
            int lr = -1;
            int lc = -1;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]<lr){
                    lr = matrix[i][j];
                }else{
                    break;
                }
            }
            for(int k=0;k<matrix.length;k++){
                if(matrix[k][i]>lc){
                    lc=matrix[k][i];
                }else{
                    break;
                }
            }

            if(lr==lc){
                ans.add(lr);
            }
        }



        return ans;
    }*/










}



