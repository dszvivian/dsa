package com.dsa.stacknqueues;

public class CustomStack {
    int[] data;

    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int n) throws Exception {
        if(isFull()){
            throw new Exception("StackOverFlow");
        }
        ptr++;
        data[ptr] = n;
        return true;
    }

    public int pop() throws Exception {
        if(isEmpty()){
          throw new Exception("StackUnderFlow");
        }
        return data[ptr--];
    }

    //Returns the Top Element
    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("StackUnderFlow");
        }
        return data[ptr];
    }

    protected boolean isFull() {
        return ptr == data.length-1;
    }

    protected boolean isEmpty() {
        return ptr == -1;
    }


    public static void main(String[] args) throws Exception {

    }


}
