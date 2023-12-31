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

    public void insertRec(int val,int index){
        head = insertRec(val,index,head);
    }


    //insert using recursion --- 1-based indexing
    //every recursion call should return the same node
    private Node insertRec(int val,int index,Node n){

        if(index==1){
            Node node= new Node(val,n);
            size++;
            return node;
        }

        insertRec(val,index-1,n.next);
        return n;
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

    public void displayCustom(Node head){
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


    static class Node{
        private int value;
        private Node next;

        public Node(){

        }

        public Node(int value){
            this.value =value;
        }

        public Node(int value,Node next){
            this.value =value;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        CustomLinkedList list = new CustomLinkedList();


        list.insertLast(4);
        list.insertLast(22);
        list.insertLast(1);
        list.insertLast(61);
        list.insertLast(18);
        list.insertLast(12);

        list.display();

        list.bubbleSort();

        list.display();


    }

    //region MergeSort

    static Node mergeSort(Node head){

        CustomLinkedList ll = new CustomLinkedList();


        if(head==null || head.next==null){
            return head;
        }

        Node mid = splitMid(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);


        return merge(left,right);
    }

    static Node merge(Node list1, Node list2){
        Node dummyHead = new Node();
        Node tail = dummyHead;
        while(list1!= null && list2!=null){
            if(list1.value < list2.value){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        if(list1 != null){
            tail.next = list1;
        }

        if(list2 != null){
            tail.next = list2;
        }

        return dummyHead.next;
    }

    static Node middleNode(Node head) {

        Node fast = head;
        Node slow = head;

        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        Node next = slow.next;
        slow.next = null;

        return next;
    }

    //breaking of the middle element
    static Node splitMid(Node head) {

        int mid = (lengthOfLL(head))/2;
        Node midPrev = null;
        while(head.next!=null && mid>0){
            midPrev = head;
            head = head.next;
            mid--;
        }

        System.out.println(midPrev.value);
        Node midNode = midPrev.next;
        midPrev.next = null;

        return midNode;
    }


    static int lengthOfLL(Node head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }

    //endregion MergeSort

    //region Bubble Sort

    void bubbleSort(){

        bubbleSort(size,0);

    }

    private void bubbleSort(int row, int col) {

        CustomLinkedList ll = new CustomLinkedList();

        if(row==1){
            return;
        }

        if(col<row){
            Node first = getNode(col);
            Node second = getNode(col+1);

            if(first.value > second.value){
                //swap
                if(first==head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }else if(second==tail){
                    Node prev = getNode(col-1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }else{
                    Node prev = getNode(col-1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col+1);
        }


        bubbleSort(row-1,0);
    }

    //endregion bubbleSort


    //region Recursion Reverse LinkedList

    void reverse(Node head){

        //move until you reach tail
        if(head.next == null){
            tail = head;
        }

        reverse(head.next);
        tail.next = head;
        tail = head;
        tail.next = null;
    }


}



