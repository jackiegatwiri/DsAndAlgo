package com.company;
import java.util.Arrays;
public class Arrayss {
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
        System.out.println(index);
        return index;

    }

    public int binarySearch(int[] x, int left, int right, int k) {
        if (right >= left) {
            System.out.println();
            int mid = left + (right - left) / 2;
            System.out.println("jacky" + mid + "-" + left + "-" + right);


            if (x[mid] == k) return mid;

            if (x[mid] > k)
                return binarySearch(x, left, mid - 1, k);
            return binarySearch(x, mid + 1, right, k);
        }
        return -1;
    }

    public int[] cyclicRotation(int[] A, int k) {
        if (k == 0) {
            return A;
        }
        while (k != 0) {
            for (int i = A.length - 1; i != 0; i--) {
                int temp = A[i];
                A[i] = A[i - 1];
                A[i - 1] = temp;
            }
            k--;
        }
        System.out.println(Arrays.toString(A));
        return A;

    }

    public int[] rotateByK(int[] A, int k){
        k = k%A.length;
        reverse(A,0, (A.length) - k - 1);
        reverse(A, (A.length) - k, A.length - 1);
        reverse(A, 0, A.length-1);

        System.out.println(Arrays.toString(A));

        return A;
    }

    public int[] reverse(int[] A, int start, int end){
        while (start<end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;

            start++;
            end--;
        }

        return A;
    }


}
