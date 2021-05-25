package com.company;

/*Adv of arrays
Arrays are contigous
Easy to access an element at any index  o(1)
       Dis
Memory unused i we remove elements o(n)
insertions and deletion is costly o(n)
     Linked LisT
Not contigous
Store date and address of the next item
address of the head node gives us access of the complete list
Dis
Takes time to access an item o(n)
Adv
easy insertion coz of the use of the address o(n)
easy to remove too
  */

import java.util.LinkedList;

public class List {
    Node head;

    public void insert(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }

    }

    public void show() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);
    }

    public void insertAtStart(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void insertAt(int index, int data) {
        Node node = new Node(data);
        Node n = head;
        if (index == 0) {
            insertAtStart(data);
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }
        node.next = n.next;
        n.next = node;

    }

    public void delete(int index) {
        if (index == 0) {
            head = head.next;
        }

        Node n = head;
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }
        Node temp = n.next;
        n.next = temp.next;
        temp = null;

    }

    public Node reverse(Node head) {
        Node current, prev, next;
        current = head;
        prev = null;


        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;

    }

    public Node reverseRecursively(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node head = reverseRecursively(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    public boolean singlyLinkedList(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


}


