package com.dsa.linkedlist;

public class Main {

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        list.insertRec(22,2);


        list.display();

    }

}
