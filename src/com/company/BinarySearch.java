package com.company;

public class BinarySearch {
    public int search(int[] array, int target){
        int left = 0;
        int right = array.length - 1;

        while (left<=right){
            int mid = left+right/2;
            if (target == array[mid]){
                return mid;

            } else if(target>array[mid]){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(-1);
        return -1;
    }
}
