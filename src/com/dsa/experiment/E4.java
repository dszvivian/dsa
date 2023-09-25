package com.dsa.experiment;

public class E4 {

    public static void main(String[] args) {

        System.out.println(5/2);

    }


    //region Evaluate the expression and give the answer

    static int evaluateExpression(String exp){

        if(isInteger(exp)){
            return Integer.parseInt(exp);
        }


        String operator;

        int i=0;
        String firstS =  "";
        while(i<exp.length() && isInteger(String.valueOf(exp.charAt(i)))){
            char a = exp.charAt(i);
            firstS += a;
            i++;
        }
        operator = String.valueOf(exp.charAt(i));
        i++;

        String secondS =  "";
        while(i<exp.length() && isInteger(String.valueOf(exp.charAt(i)))){
            char a = exp.charAt(i);
            secondS += a;
            i++;
        }

        int ans =  evaluate(firstS,secondS,operator);

        return evaluateExpression(ans + exp.substring(i));
    }
    static int evaluate(String first,String second,String operator){
        int f = Integer.parseInt(first);
        int s = Integer.parseInt(second);
        return switch (operator) {
            case "+" -> f + s;
            case "-" -> f - s;
            case "*" -> f * s;
            case "/" -> f / s;
            default -> Integer.MIN_VALUE;
        };

    }
    static boolean isInteger(String s){

        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/'){
                return false;
            }
            i++;
        }

        return true;
    }

    //endregion Evaluate the expression and give the answer


    //region return all the non repeating chars in a String
    static String nonRepeatingString(String s){
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            boolean isPresent = true;
            for (int j = 0; j < s.length(); j++) {
                if(j!=i && a==s.charAt(j)){
                    isPresent = false;
                }
            }
            if(isPresent){
                ans.append(a);
            }
        }

        return ans.toString();
    }

    //endregion return all the non repeating chars in a String






}
