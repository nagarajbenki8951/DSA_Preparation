package com.nagaraj.dsa.basic.LinkedList;

public class LinkedListDemoIncludingTail {
    public static void main(String args[]){
        LinkedListDemoIncludingTail ll = new LinkedListDemoIncludingTail();
        ll.insertFirst(10);
        ll.insertFirst(20);
        ll.insertFirst(30);
        ll.insertFirst(40);
        ll.insertLast(50);
        ll.insert(2,60);
        ll.display();
    }
    private Node head;
    private Node tail;
    private int size;

    public LinkedListDemoIncludingTail(){
        this.size =0;
    }

    // To insert first data  time complexity O(1);
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
             tail = head;  // as no data available so pointing head and tail will be same for 1st data
        }
        size+=1;
    }
    // To insert last data  time complexity O(1);
    public void insertLast(int val){
        if(tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size+=1;
    }

    //Time complexity will b O(n)
    public void insert(int index, int value){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index >= size){
            insertLast(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while(index>0){
            temp = temp.next;
            index--;
        }
        Node nextData = temp.next;
        temp.next = node;
        node.next = nextData;
        size+=1;
    }
// To Delete first node
    public int deleteFirst(){
        int val = head.val;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size -=1;
        return val;
    }
    // to get any index node
    public Node get(int index){
         Node node = head;
         for(int i=0; i<index; i++){
             node = node.next;
         }
         return node;
    }
// To delete last node
    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.val;
        tail = secondLast;
        tail.next = null;
        return val;
    }


    // To display all data iterate till we found head as null dont use head only it will change the structure of
    // linkedlist take temp and modify
    // using while loop as we dont know exact count
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" ->");
            temp = temp.next;
        }
    }

    class Node{
        private int val;
        private Node next;

        public Node(int val, Node node) {
            this.val = val;
            this.next = node;
        }

        public Node(int val) {
            this.val = val;
        }
    }

}


