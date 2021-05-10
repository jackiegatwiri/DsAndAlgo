package com.company;

import java.util.Arrays;

public class Strings {
    public String reverseString(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        int length;
        if (s.length() % 2 == 0) {
            length = s.length() / 2;
        } else {
            length = (s.length() - 1) / 2;
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < length; i++) {
            char temp = c[i];
            c[i] = c[c.length - (i + 1)];
            c[c.length - (i + 1)] = temp;
        }
        return new String(c);
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
