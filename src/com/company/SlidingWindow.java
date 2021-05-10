package com.company;

import java.util.HashMap;

public class SlidingWindow {
    /*
    Find the max subarray of a fixed size k
    Example
    size = 3
    2,14,6,3,0,17,5,2
    */

    public int findMaxSumSubArray(int[] num, int k) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < num.length; i++) {
            currentSum += num[i];
            if (i >= k - 1) {
                max = Math.max(max, currentSum);
                currentSum -= num[i - (k - 1)];
            }
        }
        return max;
    }

    /* Find minimum window size*/
    public int findMinWindowSize(int[] num, int k) {
        int minWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int currentWindowSum = 0;
        for (int windowEnd = 0; windowEnd < num.length; windowEnd++) {
            currentWindowSum += num[windowEnd];
            while (currentWindowSum >= k) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= num[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;

    }

    /*Longest substring with distinct characters
    AAAHHIBC*/

    public int longestSubstring(String s, int k) {
        int maxSub = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (end<s.length()){
           int count = hashMap.getOrDefault(s.charAt(end), 0) + 1;
           hashMap.put(s.charAt(end), count);
           while (hashMap.size() > k){
               char d = s.charAt(start);
               if (hashMap.get(d) == 1){
                   hashMap.remove(d);
               } else {
                   hashMap.put(d, hashMap.get(d)-1);
               }
               start++;
           }
           maxSub = Math.max(maxSub, end-start + 1);
           end++;

        }


        return maxSub;
    }
}
