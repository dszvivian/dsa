package com.dsa.mathsfordsa;

import java.util.ArrayList;

public class Maths {
    public static void main(String[] args) {

        System.out.println(lcm(60,13));
        System.out.println(lcm2(60,13));
    }

    //compare until sqrt(n)
    //ie: c<=sqrt(n) ---> c*c<=n
    static boolean isPrime(int n){
        if(n<=0) return false;
        int c=2;
        while(c*c<=n){
            if(n%c==0) return false;
            c++;
        }
        return true;
    }

    static void countOfPrimeNos(int n,boolean[] isPrime){

        for (int i = 2; i*i <= n; i++) {
            if(!isPrime[i]){
                for (int j = 2*i; j <=n; j+=i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = 2; i <=n; i++) {
            if(!isPrime[i]){
                System.out.print(i+" ");
            }
        }

    }

    //Brute Forced Method
    static double squareRoot(int n,int p){
        //p--> Precision--get the precision value
        double root = getPerfectSquare(n);

        float increment = 0.1f;
        for (int i = 0; i <= p; i++) {
            while(root*root<n){ // chek when we increment the 0.1 value its square is grater than n or not
                root += increment;
            }
            root -= increment;
            increment /= 10;
        }

        return root;
    }

    static int getPerfectSquare(int n){
        int start = 0,end=n,mid=-1;
        int perfectSquare = -1;

        while(start<=end){
            mid = start+(end-start)/2;

            int element = mid;

            if(element*element == n){
                return element;
            }else if(element*element > n){
                end=mid-1;
            }else{
                start=mid+1;
            }


        }

        return mid-1;
    }


    /*//Optimized Solution( Newton Raphson Method)
    static double getSquareRoot(int n,int p) {

    }*/


    static void factors(int n) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                if(i==(n/i)){
                    System.out.print(i);
                }else{
                    System.out.print(" "+i+" ");
                    list.add(n/i);
                }
            }
        }

        for (int i = list.size()-1; i >=0  ; i--) {
            System.out.print(" "+list.get(i)+" ");
        }

    }


    static int gcd(int a,int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }

    /*
      d=hcf
      f=a/d g=b/d
      lcm = f*g*d
     a*b = fd*gd = d*fgd = hcf * lcm
     lcm = a*b/hcf
    */
    static int lcm(int a,int b){
        int hcf = gcd(a,b);
        return (a*b)/hcf;
    }

    static int lcm2(int a, int b){
        int d = gcd(a,b);
        int f = a/d,g=b/d;

        return d*f*g;

    }


}
