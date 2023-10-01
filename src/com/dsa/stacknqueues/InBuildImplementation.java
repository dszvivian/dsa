package com.dsa.stacknqueues;

import java.util.*;

public class InBuildImplementation {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
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


        Queue<Integer> queue = new LinkedList<>();
        queue.add(12);
        queue.add(123);
        queue.add(1234);

        System.out.println(queue.remove());


        Deque<Integer> deque = new ArrayDeque<>();
    }
}
