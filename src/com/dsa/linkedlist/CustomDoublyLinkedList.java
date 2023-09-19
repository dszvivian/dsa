package com.dsa.linkedlist;

public class CustomDoublyLinkedList {

    private Node head,tail;
    private int size=0;


    public void insertFirst(int val){
        Node n = new Node(val);

        if(head==null){
            head = n;
            tail = n;
        }else{
            n.next = head;
            head.prev = n;
            head = n;
        }

        size++;
    }

    public void insertLast(int val){
        Node n = new Node(val);

        if(tail == null){
            insertFirst(val);
        }

        tail.next = n;
        n.prev = tail;
        tail = n;

        size++;
    }

    public void insertAt(int val,int index){
        Node n = new Node(val);

        if(index==1){
            insertFirst(val);
        }
        if(index==size){
            insertLast(val);
        }

        Node prev = getNode(index-1);
        Node temp = prev.next;
        prev.next = n;
        n.next = temp;
        temp.prev = n;
        n.prev = prev;


        size++;

    }


    public void deleteFirst(){
        if(head!=null){
            head=head.next;
        }
        size--;
    }

    public void deleteLast(){
        if(tail!=null){
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }


    public void deleteAt(int index){

        if(index<=1){
            deleteFirst();
        }
        if(index==size){
            deleteLast();
        }

        Node prev = getNode(index-1);
        Node current = prev.next;
        prev.next = prev.next.next;
        prev.next.prev = prev;

        size--;

    }


    private Node getNode(int index){
        Node node = head;

        for (int i = 1; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    public void display(){
        Node element = head;
        while(element != null){
            System.out.print(element.value+"-->");
            element = element.next;
        }
        System.out.println("END");

    }

    public void displayReverse(){
        Node element = tail;

        while(element != null){
            System.out.print(element.value + "-->");
            element = element.prev;
        }
        System.out.print("START");

    }


    private class Node{
        int value;
        Node prev;
        Node next;

        private Node(int value,Node next){
            this.value = value;
            this.next = next;
        }

        private Node(int value){
            this.value = value;
        }


        private Node(int value,Node prev,Node next){
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

    }



}
