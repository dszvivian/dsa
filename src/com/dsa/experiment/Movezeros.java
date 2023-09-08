package com.dsa.experiment;

import java.util.Arrays;

public class Movezeros {

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,3,0,4,5};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void moveZeroes(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int k = i-1;
            if(arr[k]==0 && arr[i]!=0){
                swap(arr,k,i);
            }
            if(arr[k]==0 && arr[i]==0){
                int j = i;
                while(arr[j]==0){
                    if(j== arr.length-1){
                        break;
                    }
                    j++;
                }
                swap(arr,i,j);
                swap(arr,i,k);
            }
        }
    }

    static void swap(int[] arr,int i1,int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }









}
