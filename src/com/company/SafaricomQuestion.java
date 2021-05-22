package com.company;

import java.util.Stack;
import java.util.regex.Pattern;

public class SafaricomQuestion {
    final Stack<Integer> stack = new Stack<>();


    public int solution(String S) {
        try {
            for(String s : S.split(" ")){
                runOps(s);
            }
            return pop();
        } catch (IllegalArgumentException exception) {
            return -1;
        }
    }

    private void runOps(String str) {
        if (Pattern.compile("\\d+").matcher(str).matches()) { //find a digit using regex
            push(Integer.valueOf(str));
        } else {
            if(str.equals("POP")){
                pop();
            } else if(str.equals("+")){
                add();
            } else if(str.equals("DUP")){
                duplicate();
            } else{
                subtract();
            }
        }
    }

    private int pop() {
        return stack.pop();
    }

    private void push(int x) {
        checkRange(x); //check range to make sure that number is valid.. for each array, each space is given only 8bytes
        stack.push(x);
    }

    private void add() {
        containElements(2);
        push(stack.pop() + stack.pop());
    }

    private void duplicate() {
        containElements(1);
        push(stack.peek());
    }

    private void subtract() {
        containElements(2);
        push(stack.pop() - stack.pop());
    }

    private int checkRange(int x){
        if(x < 0 || x > Integer.MAX_VALUE){
            throw new IllegalArgumentException("overflow");
        }
        return x;
    }

    private int containElements(int x) {
        if(stack.size() < x){
            throw new IllegalArgumentException("elements in the stack are less");
        }
        return x;
    }

}
