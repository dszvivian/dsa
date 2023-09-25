package com.dsa.linkedlist;

public class Main {

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        list.insertFirst(6);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        list.insertRec(5,5);
        list.insertRec(-1,1);


        list.display();

    }

}
