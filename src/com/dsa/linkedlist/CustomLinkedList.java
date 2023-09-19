package com.dsa.linkedlist;

public class CustomLinkedList {

    private Node head,tail;
    public int size;

    public CustomLinkedList(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node n = new Node(val,head);
        this.head = n;

        if(tail==null){
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val){


        if(tail==null){
            insertFirst(val);
        }else{
            Node n = new Node(val);
            tail.next = n;
            tail = n;
            size += 1;
        }

    }

    public void insertAt(int val,int index){


        if(index==0){
            insertFirst(val);
            return;
        }else if(index==size){
            insertLast(val);
            return;
        }else{
            int i=1;
            Node element = head;
            while(i<index){
                element = element.next;
                i++;
            }

            Node n = new Node(val,element.next);
            element.next = n;
            size++;
        }


    }



    public int deleteFirst(){
        int val = head.value;
        head = head.next;

        if(head==null){
           tail = null;//since the head and tail were pointing to same node (ie: when we have only one element)
        }
        size--;


        return val;
    }



    public int deleteLast(){

        if(size<=1){
            return deleteFirst();
        }

        Node n = getNode(size-1);
        int val = tail.value;
        tail = n;
        tail.next = null;
        size--;

        return val;
    }

    public int deleteAt(int index){
        if(index<=1){
            return deleteFirst();
        }
        if(index==size){
            return deleteLast();
        }

        Node prev = getNode(index-1);

        Node temp = prev.next;

        int val = temp.value;

        prev.next = temp.next;

        size--;

        return val;

    }




    public void display(){
        Node element = head;
        while(element != null){
            System.out.print(element.value+"-->");
            element = element.next;
        }
        System.out.println("END");

    }

    public Node findNode(int value){

        Node element = head;
        while(element != null) {
            if(element.value == value){
                return element;
            }

            element = element.next;
        }
        return null;
    }

    public Node getNode(int index){

        Node element = head;
        for (int i = 1; i < index; i++) {
            element = element.next;
        }
        return element;
    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value =value;
        }

        public Node(int value,Node next){
            this.value =value;
            this.next = next;
        }
    }

}



