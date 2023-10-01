package com.dsa.stacknqueues;

public class Main {

    public static void main(String[] args) throws Exception {

        DynamicStack stack = new DynamicStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());





    }

}
