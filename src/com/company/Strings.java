package com.company;

import java.util.Arrays;

public class Strings {
    public String reverseString(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        char[] ar = new char[s.length()];
        for (int i = 0; i<ar.length; i++){
            ar[i] = s.charAt(i);
        }
        int start = 0;
        int end = s.length()-1;
        while (start<end){
           char temp =  ar[start];
           ar[start] = ar[end];
           ar[end] = temp;
           start++;
           end--;

        }
        System.out.println(Arrays.toString(ar));
        return Arrays.toString(ar);
    }

    public boolean palindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        int length;
        if (s.length() % 2 == 0) {
            length = s.length() / 2;
        } else {
            length = (s.length() - 1) / 2;
        }
        char[] c = s.toCharArray();
        for (int i=0; i<length; i++) {
            if (c[i] == c[c.length - (i+1)]){
                return true;
            }
        }
        return false;
    }
}
