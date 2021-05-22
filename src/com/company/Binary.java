package com.company;

public class Binary {
    public int solution(int N) {
        int store = 0;
        int start = 0;
        String binary = Integer.toBinaryString(N);
        char[] b = new char[binary.length()];
        for (int i=0; i<b.length; i++){
            b[i] = binary.charAt(i);
        }
        if (N == 0) {
            return store;
        }
        for (int i = 1; i < b.length; i++) {
            int a = b[i] - '0';
            if (a == 1) {
                int diff = i - start  - 1;
                if (diff > store) {
                    store = diff;
                }
                start = i;
            }

        }
        return store;
    }
}
