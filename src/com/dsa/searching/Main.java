package com.dsa.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] a = {1,1,2};

//        System.out.println(Arrays.toString(twoSum(a,6)));
        System.out.println(singleNonDuplicate(a));


    }


    static int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];

        int start=0,end=numbers.length-1;

        while((numbers[start]+numbers[end]!=target)){

            if(numbers[start]+numbers[end]>target){
                start++;
            }else{
                end--;
            }

        }

        ans[0] = start;
        ans[1] = end;

        return ans;
    }


    static int findKthPositive(int[] arr, int k) {
        //https://leetcode.com/problems/kth-missing-positive-number/
        List<Integer> ans = new ArrayList<Integer>();

        int index=0;
        for(int i=1;i<arr[arr.length-1];i++){
            if(!(i==arr[index])){
                ans.add(i);
            }else{
                index++;
            }
        }

        for (Integer i :
             ans) {
            System.out.println(i);

        }

        return ans.get(k-1);
    }

    static int findKthPositive2(int[] arr, int k) {
        //https://leetcode.com/problems/kth-missing-positive-number/
        int start=0;

        int end=arr.length-1;

        while(start<=end){

            int mid=start+(end-start)/2;

            if(arr[mid]-mid-1<k)start=mid+1;

            else end=mid-1;

        }

        return k+start;
    }


    static int singleNonDuplicate(int[] nums) {
        //https://leetcode.com/problems/single-element-in-a-sorted-array/

        int i1=0,i2=i1+1;



        if(nums.length==1){
            return nums[0];
        }

        while(i1<nums.length-1){

            if(i2==nums.length){
                return nums[nums.length-1];
            }

            if(nums[i1]==nums[i2]){
                i1=i2+1;
                i2=i1+1;
            }else{
                return nums[i1];
            }

        }

        return -1;
    }


}
