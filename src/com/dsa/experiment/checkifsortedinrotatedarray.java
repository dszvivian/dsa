package com.dsa.experiment;

public class checkifsortedinrotatedarray {

    public static void main(String[] args) {
        int[] nums = {6,7,7,5};
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {4,5,1,2,3};
        int[] arr3 = {10,1,2,3,10};
        System.out.println(check(nums));

        System.out.println(isSorted(arr,0,arr.length));


        System.out.println(findPivot(nums));
        System.out.println(findPivot(arr));
        System.out.println(findPivot(arr2));
        System.out.println(findPivot(arr3));
    }

    static public boolean check(int[] nums) {
        int pivotIndex = findlargestelementIndex(nums);

        if(pivotIndex==nums.length){
            return isSorted(nums,0,nums.length);
        }else{
            return isSorted(nums,0,pivotIndex) && isSorted(nums,pivotIndex+1,nums.length);
        }
    }


    static boolean isSorted(int[] nums,int first,int last){
        int index = first+1;
        while(index<last){
            if(nums[index]<nums[index-1]){
                return false;
            }
            index++;
        }
        return true;
    }

    static int findlargestelementIndex(int[] nums){
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=max){
                max=nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    static int findPivot(int[] nums){
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                return i-1;
            }
        }

        return nums.length-1;
    }


}
