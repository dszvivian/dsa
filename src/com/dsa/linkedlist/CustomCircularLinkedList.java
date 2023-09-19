package com.dsa.linkedlist;

public class CustomCircularLinkedList {

    private Node head,tail;
    private int size;


    //insert Last same as insertFirst
    public void insertFirst(int val){

        Node n = new Node(val);

        if(head==null){
            head = n;
            tail = n;
            return;
        }

        tail.next = n;
        n.next = head;
        head = n;//since we insert it from the first

        size++;
    }


    public void display(){
        Node node = head;
        if(head != null){
            do{
                System.out.print(node.val + "-->");
                node = node.next;
            }while(node != head);
        }
        System.out.println(head.val);

    }


    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
