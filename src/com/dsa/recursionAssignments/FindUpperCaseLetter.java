package com.dsa.recursionAssignments;

public class FindUpperCaseLetter {

    public static void main(String[] args) {

        findUpperCaseLetter("ViViaN");

    }


    static void findUpperCaseLetter(String p){

        if(p.isEmpty()){
            return;
        }

        char c = p.charAt(0);

        if(Character.isUpperCase(c)){
            System.out.println(c);
        }

        findUpperCaseLetter(p.substring(1));
    }


}
