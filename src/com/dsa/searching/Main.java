package com.dsa.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] a = {1,2,5,7,11};

//        System.out.println(Arrays.toString(twoSum(a,6)));
        System.out.println(findKthPositive(a,3));


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


}
