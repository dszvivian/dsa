package com.dsa.linkedlistquestions;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(10));
    }

    static boolean isHappy(int n) {

        int fast = n;
        int slow = n;

        do{

            slow = findSquareOfDigits(slow);
            fast = findSquareOfDigits(findSquareOfDigits(fast));

        }while(fast != slow);

        if(slow==1){
            return true;
        }

        return false;
    }


    static int findSquareOfDigits(int n){
        int ans = 0;
        while(n>0){
            int rem = n%10;
            ans += (rem*rem);
            n=n/10;
        }
        return ans;
    }
}
