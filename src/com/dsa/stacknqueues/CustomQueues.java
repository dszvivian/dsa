package com.dsa.stacknqueues;

public class CustomQueues {

    int[] data;

    private static final int DEFAULT_SIZE = 10;
    int end = -1;


    public CustomQueues() {
        this(DEFAULT_SIZE);
    }

    public CustomQueues(int size) {
        this.data = new int[size];
    }


    //insertion happens from the end
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[++end] = item;
        return true;
    }


    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is Empty!!1");
        }

        /*
        * shift all the elements to one by left side
        * so that we can remove the first element of the queue*/
        int element = data[0];
        for (int i = 1; i < data.length; i++) {
            data[i-1] = data[i];
        }
        end--;

        return element;
    }


    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+ " ");
        }
        System.out.println();
    }





    protected boolean isFull() {
        return end == data.length-1;
    }

    protected boolean isEmpty() {
        return end == -1;
    }

    public static void main(String[] args) throws Exception {

        CustomQueues q = new CustomQueues(6);
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);

        q.display();
        q.remove();
        q.display();

    }


}
