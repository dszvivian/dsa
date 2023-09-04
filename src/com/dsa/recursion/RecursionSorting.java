package com.dsa.recursion;


import java.util.Arrays;

public class RecursionSorting {
    public static void main(String[] args) {
        int[] a = { 4,3,2,1};
        System.out.println(Arrays.toString(selectionSort(a,a.length,0,-1,Integer.MIN_VALUE)));
    }

    static int[] bubbleSort(int[] arr,int row,int column){
        if(row==0){
            return arr;
        }
        else{
            if(column <= row){
                if(arr[column-1]>arr[column]){
                    swap(arr,column-1,column);
                }
                return bubbleSort(arr,row,column+1);
            }else{
                return bubbleSort(arr,row-1,1);
            }
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    static int[] selectionSort(int[] arr,int row,int column,int maxIndex,int maxValue){
        if(row==0){
            return arr;
        }
        else{
            if(column < row){
                if(arr[column]>maxValue){
                    maxValue = arr[column];
                    maxIndex = column;
                }
                return selectionSort(arr,row,column+1,maxIndex,maxValue);
            }else{
                swap(arr,maxIndex,row-1);
                return selectionSort(arr,row-1,0,-1,Integer.MIN_VALUE);
            }
        }
    }


}
