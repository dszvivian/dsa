package com.dsa.recursionAssignments;

public class BSRecursion {

    public static void main(String[] args) {

        int[] arr = {-1,0,3,5,9,12};
        System.out.println(bs(arr,-1,0, arr.length-1));
    }

    //return the index of the target element if exists else return -1
    static int bs(int[] arr,int target,int start,int end){

        if(start>end){
            return -1;
        }

        int mid = start+(end-start);

        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
           return bs(arr,target,start,mid-1);
        }
        return bs(arr, target, mid+1, end);
    }


}
