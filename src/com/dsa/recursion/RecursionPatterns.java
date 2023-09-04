package com.dsa.recursion;

public class RecursionPatterns {

    public static void main(String[] args) {
        p2(4,0);
    }

    /*
    Pattern 1:

     ****
     ***
     **
     *

    */

    static void p1(int r,int c){
        if(r==0) return;
        else{
            if(c<r){
                System.out.print("*");
                p1(r,c+1);
            }
            else{
                System.out.println();
                p1(r-1,0);
            }
        }
    }

    static void p2(int r,int c){
        if(r==0) return;
        else{
            if(c<r){
                p2(r,c+1);
                System.out.print("*");
            }
            else{
                p2(r-1,0);
                System.out.println();
            }
        }
    }

}
