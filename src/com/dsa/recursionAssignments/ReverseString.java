package com.dsa.recursionAssignments;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {

        print(5);
    }

    //print no from 1--n
    static void print(int N){
        if(N==0){
            return;
        }
        print(N-1);
        System.out.println(N);

    }


    //reverse char array
    static void revereCharArray(char[] s,int start,int end){

        if(start>=end){
            return;
        }
        swap(s,start,end);
        start++;end--;
        revereCharArray(s,start,end);
    }

    static void swap(char[] s,int i1,int i2){
        char temp = s[i1];
        s[i1] = s[i2];
        s[i2] = temp;
    }

}
