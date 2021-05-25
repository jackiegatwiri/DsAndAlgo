package com.company;

import java.util.*;

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

    public int minimumDeletions(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> frequencies = new PriorityQueue<>(Collections.reverseOrder());

        if(s.length() <= 1 || s==null){
            return 0;
        }
        char[] chars = s.toCharArray();
        for (char c : chars){
            int count = map.getOrDefault(c,0);
            map.put(c,count+1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            frequencies.add(entry.getValue());
        }
        int deletionCount = 0;
        while (!frequencies.isEmpty()){
            int polled = frequencies.poll();
            if(frequencies.size() == 0){
                return deletionCount;
            }
            if(polled == frequencies.peek()){
                if(polled-1 > 0){
                    frequencies.add(polled-1);
                }
                deletionCount++;
            }
        }

        return deletionCount;
    }

//    public String adjacentSwap(String s){
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (char c : s.toCharArray()){
//            int count = map.getOrDefault(c, 0);
//            map.put(c, count+1);
//        }
//
//
//    }

    public static void main(String[] args) {
        Strings strings = new Strings();
        System.out.println(strings.minimumDeletions("bbcebab"));
    }
}
