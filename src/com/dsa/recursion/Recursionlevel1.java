package com.dsa.recursion;

public class Recursionlevel1 {

    public static void main(String[] args) {

        reverse2(12345);
        System.out.println(sum);

    }

    //Only For positive numbers-- reverse way
    static void printNto1(int n){
        if (n==1) System.out.println(1);;
        System.out.println(n);
        printNto1(n-1);
    }

    static void print(int n){
        if(n==1) {System.out.println(1);}
        else{
            print(n-1);
            System.out.println(n);
        }
   }

    static void printNto1toN(int n){
        if(n==1) {System.out.print(1+" ");}
        else{
            System.out.print(n+" ");
            printNto1toN(n-1);
            System.out.print(n+" ");
        }
    }

    static int fact(int n){
        if(n==1){ return 1;}
        else{
            return n * fact(n-1);
        }
    }

    static int sum(int n){
        if(n==1) return 1;
        else{
            return n + sum(n-1);
        }
    }

    static int sumOfDigits(int n){
        if(n/10==0) return n;
        else{
            return (n%10)+sumOfDigits(n/10);
        }
    }

    static int productOfDigits(int n){
        if(n/10==0) return n;
        else{
            return (n%10)*productOfDigits(n/10);
        }
    }

    static int reverse(int n){
        int digits =((int)(Math.log(n)/Math.log(10)))+1;

        if(digits==1) return n;
        else{
            return ((int)((n%10)*Math.pow(10,digits-1)))+reverse(n/10);
        }
    }

    static int sum = 0;
    static void reverse2(int n){
        if(n==0) return;
        else{
            sum = (sum*10) + (n%10);
            reverse2(n/10);
        }
    }
}
