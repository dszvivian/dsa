package com.dsa.mathsfordsa;



public class BitwiseOperations {

    public static void main(String[] args) {
        System.out.println(xorFromAtoB(5,9));
    }

    /*
    Approach:
    a = LeftShift 1 i times
    n Or a
     1-->1
     0-->1
    */
    private static int changeIthBitTo1(int n, int i) {
        int a = 1<<i;
        return (n|a);
    }

    /*
    Approach:
    a = LeftShift 1 i times
    n Or a
     1-->0
     0-->1
    */
    private static int changeIthBit1(int n, int i) {
        int a = 1<<i;
        return (n^a);
    }

    private static int changeIthBit2(int n, int i) {
        int a = 1<<i;
        a =  a^1;
        return (n&a);
    }

    //find nth bit of a binary number

    /*
    Approach 1:
        RightShift the binary no until the given index
        Return the last digit
    */

    private static int findNthBit(int n, int index) {
        n = n>>index;
        return (n&1);
    }
    /*
    Approach 2:
        a = LeftShift 1 index times
        Multiply the given no with a
        n&a
        if we get positive number bit is 1 else 0
    */
    private static int findNthBit2(int n, int index) {
        int a = 1 << index;
        if((n & a)>0) return 1;
        else return 0;
    }

    private static int nonRepeatedNumber(int[] nums) {
        /*
        Intuition: a^a = 0
        So if we xor all the numbers in the array
        We will get the non repeating element
        Cuz, Other elements will cancel out
        */
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

    private static boolean isOdd(int n) {
        return (n & 1)==1;
    }

    static int nthMagicalNo(int n){
        int ans = 0;
        int base = 5;
        while(n>0){
            int lastDigit = (n&1);
            ans += lastDigit*base;
            n = n>>1;
            base = base*5;
        }
        return ans;
    }
    //Approach 1 : Brute Forced value
    static int noOfBits(int n){
        int ans = 0;
        while(n>0){
            ans++;
            n = n>>1;
        }

        return ans;
    }

    //Approach 2 : Formula based
    static int noOfBits(int n,int base){
        return (int)(Math.log(n)/Math.log(base))+1;
    }



    static double binaryToInt(String a){
        double base = 1;
        double ans = 0;

        int i=a.length()-1;
        while(i>=0){
            int digit = Character.getNumericValue(a.charAt(i));
            ans += digit*base;
            base = base*2;
            i--;
        }
        return ans;
    }

    static String intToBinary(int n){
        StringBuilder ans = new StringBuilder();
        if(n==0) return "0";

        while(n>0){
            if((n%2)==0){
                ans.append(0);
            }else{
                ans.append(1);
            }
            n=n/2;
        }
        return ans.reverse().toString();
    }

    //brute Force method
    // two's power wil always will be in the form of: 10,100,1000,......
    static boolean isPowTwo(int n){
        int counter = 0;
        while(n>0){
            int digit = (n&1);
            if(digit==1) counter++;
            n = n>>1;
        }

        if(counter==1) return true;

        return false;
    }

    /*
    Formula based:
    So : 1000=0111+1
    -->  1000
    -> & 0111
    ans->  0
    */
    static boolean isPowTwoFormula(int n){
        int a = (n&(n-1));

        if(a==0)return true;

        return false;
    }

    //find ato the power b (a^b)
    static int findPower(int a,int b){
        int ans = 1;
        int base = a;
        while(b>0){
            int digit = (b&1);
            if(digit==1){
                ans *= base;
            }
            b = b>>1;
            base = base*base;

        }
        return ans;
    }

    static int noOfSetBits1(int n){
        int count=0;
        while(n>0){
            count++;
            n -= (n&(-n));
        }
        return count;
    }

    //Method 2
    static int noOfSetBits2(int n){
        int count=0;
        while(n>0){
            count++;
            n = (n&(n-1));
        }
        return count;
    }

    static int xorFrom1ton(int n){
        if(n%4==0) return n;
        if(n%4==1) return 1;
        if(n%4==2) return n+1;
        if(n%4==3) return 0;

        return -1;
    }

    static int xorFromAtoB(int a,int b){
        return xorFrom1ton(b) ^ xorFrom1ton(a-1);
    }


}
