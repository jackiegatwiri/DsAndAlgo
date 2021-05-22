package com.company;

import java.util.Stack;
import java.util.regex.Pattern;

public class Stacky {
    int[] array;
    int top;
    int capacity;

    Stacky(int capacity){
        this.array = new int[capacity];
        this.capacity = capacity;
        this.top = 0;
    }

    public void push(int item){
        if(isFull()){
            throw new RuntimeException("Stack is full");
        }
        array[top] = item;
        top++;
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        int data;
        top--;
        data = array[top];
        array[top] = 0;
        return data;
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return array[top-1];
    }

    public boolean isFull(){
       return top == capacity-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public static void main(String[] args) {


    }





}
