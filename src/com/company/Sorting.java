package com.company;

import java.util.Arrays;

public class Sorting {
    //bubble sort - sorts the array by switching two elements and it does this until the array is sorted
    /* 1. Create a boolean that will check if array is sorted or not
    2. Create a while loop and compare against your boolean. If it's false, then enter your for loop
     */

    public int[] bubbleSort(int[] nums) { //(n2)
        boolean check = false;
        while (check == false) {
            check = true;
            for (int i = 0; i < nums.length - 1; i++) {
                int temp = nums[i];
                if (nums[i] > nums[i + 1]) {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    check = false;
                }
            }
        }
        return nums;
    }

    //merge sort - divide and conquer (nlogn)
    public int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];

        for (int i = 0; i < mid - 1; i++) {
            left[i] = nums[i];
        }
        for (int i = mid; i < nums.length - 1; i++) {
            right[i-mid] = nums[i];
        }
        mergeSort(left);
        mergeSort(right);
        return merge(left, right, nums);
    }

    private int[] merge(int[] left, int[] right, int[] nums) {
        int nl = left.length;
        int nr = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nl && j < nr) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nl) {
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < nr) {
            nums[k] = right[j];
            j++;
            k++;
        }

        return nums;

    }

    //quicksort - partitioning
    //select pivot
    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        System.out.println(Arrays.toString(sorting.mergeSort(new int[]{9, 3, 2, 5, 1, 4, 7})));

    }

}

