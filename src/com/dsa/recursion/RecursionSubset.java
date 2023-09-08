package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionSubset {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        for(List<Integer> list:subsetIterativeDuplicates(arr)){
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    //region Subset String Question


    //Add all the elements to external ArrayList
    static ArrayList<String> ans = new ArrayList<>();
    static void subsetString(String p,String up){

        if(up.isEmpty()){
            ans.add(p);
            return;
        }

        char c = up.charAt(0);

        subsetString(p+c,up.substring(1));
        subsetString(p,up.substring(1));
    }

    //Return the ArrayList elements at base condition
    static ArrayList<String> subsetString2(String p,String up){

        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<String>();
            ans.add(p);
            return ans;
        }

        char a = up.charAt(0);

        ArrayList<String> left = subsetString2(p+a,up.substring(1));
        ArrayList<String> right = subsetString2(p,up.substring(1));

        left.addAll(right);

        return left;

    }


    //get all the subset including their ascii values
    static void subsetStringAscii(String p,String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char a = up.charAt(0);

        subsetStringAscii(p+a,up.substring(1));
        subsetStringAscii(p,up.substring(1));
        subsetStringAscii(p+(a+0),up.substring(1));
    }

    //get all the subset including their ascii values and return ans in a ArrayList
    static ArrayList<String> subsetStringAsciiRet(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<String>();
            ans.add(p);
            return ans;
        }

        char a = up.charAt(0);

        ArrayList<String> first = subsetStringAsciiRet(p+a,up.substring(1));
        ArrayList<String> second = subsetStringAsciiRet(p,up.substring(1));
        ArrayList<String> third = subsetStringAsciiRet(p+(a+0),up.substring(1));

        first.addAll(second);
        first.addAll(third);

        return first;
    }


    //endregion Subset String Question

    //subset using iterative method
    static List<List<Integer>> subsetIterative(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num:arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

    /*subset using iterative method for duplicate elements

        - Sort the array cuz --> duplicate elements need to be adjacent
        - find the indexes of duplicate array
        - at that level --> only add element to newly created list of previous step

     */
    static List<List<Integer>> subsetIterativeDuplicates(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        Arrays.sort(arr);

        ArrayList<Integer> list = findDuplicates(arr);

        for (int i = 0; i < arr.length; i++){
            int num = arr[i];
            int n = outer.size();

            int start = 0;

            if(list.contains(i)){
                start = i;
            }

            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(num);
                outer.add(internal);
            }

        }

        return outer;
    }

    private static ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==arr[i-1]){
                ans.add(i);
            }
        }
        return ans;
    }


}
