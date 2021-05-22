package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Stack;

//a node must have a maximum of 2 nodes
class Node1 {
    int data;
    Node1 left;
    Node1 right;
}

class BST {

    public Node1 createNewNode(int k) {
        Node1 a = new Node1();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }

    public Node1 insert(Node1 node1, int val) {
        if (node1 == null) {
            return createNewNode(val);
        }
        if (val < node1.data) {
            node1.left = insert(node1.left, val);
        } else if (val > node1.data) {
            node1.right = insert(node1.right, val);
        }
        return node1;
    }

    public Node1 delete(Node1 node1, int val) {
        if (node1 == null) {
            return null;
        }
        if (val < node1.data) {
            node1.left = delete(node1.left, val);
        } else if (val > node1.data) {
            node1.right = delete(node1.right, val);
        } else {
            if (node1.left == null || node1.right == null) {
                Node1 temp = null;
                temp = node1.left == null ? node1.right : node1.left;

                if (temp == null) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                Node1 successor = getSuccessor(node1);
                node1.data = successor.data;
                node1.right = delete(node1.right, successor.data);
                return node1;
            }
        }
        return node1;
    }

    private Node1 getSuccessor(Node1 node1) {
        if (node1 == null) {
            return null;
        }
        Node1 temp = node1.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public void inOrder(Node1 node1) {
        if (node1 == null) {
            return;
        }
        inOrder(node1. left);
        System.out.println(node1.data);
        inOrder(node1.right);
    }

    public void preOrder(Node1 node1) {
        if (node1 == null) {
            return;
        }
        System.out.println(node1.data);
        preOrder(node1.left);
        preOrder(node1.right);

    }

    public void postOrder(Node1 node1) {
        if (node1 == null) {
            return;
        }
        postOrder(node1.left);
        postOrder(node1.right);
        System.out.println(node1.data);


    }

    public boolean checkIfItsBst(Node1 node){
        //left max = node;
        //right min = node
        if(node == null){
            return true;
        }
        return check(node, 0, 0);
    }

    public Boolean check(Node1 node1, int min, int max){
        if(node1 == null){
            return true;
        }
        if((min != 0 && node1.data<=min) || (max != 0 && node1.data >= max)){
            return false;
        }
        return check(node1.right, node1.data, 0) && check(node1.left, min, node1.data);
    }

    public ArrayList<Integer> inOrderTraversal(Node1 node1){
        Stack<Node1> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        Node1 current = node1;
        while (node1 != null || !stack.isEmpty()){
            while(node1 != null){
                stack.push(node1);
                current = node1.left;
            }
            current = stack.pop();
            res.add(current.data);
            current = current.right;
        }
        return res;
    }

    public ArrayList<Integer> preOrderTraversal(Node1 node1){
        Stack<Node1> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        Node1 current = node1;
        while (node1 != null || !stack.isEmpty()){
            while(node1 != null){
                res.add(current.data);
                stack.push(node1);
                current = node1.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return res;
    }


}

public class BinarySearchTree {
    public static void main(String[] args) {
        BST a = new BST();
        Node1 root = null;
        //8,3,6,10,4,7,1,14,13
        root = a.insert(root, 8);
        root = a.insert(root, 3);
        root = a.insert(root, 2);
        root = a.insert(root, 10);

    }
}
