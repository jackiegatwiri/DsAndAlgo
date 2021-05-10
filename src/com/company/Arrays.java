package com.company;

public class Arrays {
    //return index of k in an infinite array
    //either move constantly or exponentially
    /*1. left = 0
     * 2. right = 1 --> multiply this by 2*/


    public int infiniteArray(int[] x, int k) {
        int left = 0;
        int right = 1;

        while (x[right] < k) {
            left = right;
            right = 2 * right;
        }
        int index = binarySearch(x, left, right, k);
        return index;

    }

    public int binarySearch(int[] x, int left, int right, int k) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (x[mid] == k) return mid;

            if (x[mid] > k)
                return binarySearch(x, left, mid - 1, k);
            return binarySearch(x, mid + 1, right, k);
        }
        return -1;
    }
}
