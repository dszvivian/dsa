package com.dsa.recursion;

public class Main {

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(222));


    }

    private static int binarySearch(int[] arr,int target,int start,int end){

        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid]==target) return mid;
            else if(arr[mid]>target){
                return binarySearch(arr,target,start,mid-1);
            }else{
                return binarySearch(arr,target,mid+1,end);
            }
        }

        return -1;
    }

    private static int fibonacci(int n) {
        if(n<2){
            return n;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    static boolean isPowerOfTwo(int n) {
        if(n==2||n==1
        ) return true;

        if(n%2!=0) return false;

        return (isPowerOfTwo(2) && isPowerOfTwo(n/2) );
    }


}
