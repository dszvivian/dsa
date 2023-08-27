package com.dsa.searching;

import java.util.Arrays;

public class BS2D {

    public static void main(String[] args) {
        int[][] a = {
                {10,20,30,37},
                {22,28,38,45},
                {38,48,57,65},
                {45,50,60,70}
        };

        System.out.println(Arrays.toString(search2d(a,57)));
    }

    //Given that matrix is sorted Both in column and row wise
    //In increasing order
    static int[] search2d(int[][] matrix,int target){

        int r=0,c= matrix.length-1;

        while(r< matrix.length && c>=0){
            if(matrix[r][c]==target) return new int[]{r,c};
            else if(matrix[r][c]>target) c--;
            else r++;
        }
        return new int[]{-1,-1};
    }





}
