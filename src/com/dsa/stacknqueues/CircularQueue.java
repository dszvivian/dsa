package com.dsa.stacknqueues;

public class CircularQueue {

    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    //first index
    protected int start = 0;
    protected int end = 0;
    protected int size = 0;


    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }


    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;

    }


    public int remove() throws Exception {
        if(isEmpty()){
            throw  new Exception("Queue Empty!!");
        }

        int removed = data[start++];
        start = start % data.length;
        size--;
        return removed;
    }


    public void display(){
        for (int i = start; i < end; i++) {
            System.out.print(data[i]+ " ");
        }
        System.out.println();
    }





    protected boolean isFull() {
        return size == data.length;
    }

    protected boolean isEmpty() {
        return size == -1;
    }


    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue(4);
        cq.insert(12);
        cq.insert(13);
        cq.insert(14);
        cq.insert(21);
        cq.insert(45);

        cq.display();
    }


}
