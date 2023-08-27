package com.dsa.patterns;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pattern 1");
        p1(4);

        System.out.println("Pattern 2");
        p2(4);

        System.out.println("Pattern 3");
        p3(4);

        System.out.println("Pattern 4");
        p4(4);

        System.out.println("Pattern 5");
        p5(4);

    }


    static void p1(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void p2(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void p3(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void p4(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j+1);
            }
            System.out.println();
        }
    }

    static void p5(int n){
        for (int i = 0; i < 2*n; i++) {
            int nCols = i>n?2*n-i:i;

            for (int j = 0; j < nCols; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}
