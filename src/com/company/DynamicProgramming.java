package com.company;

//0,1,1,2,3,5,8,13
public class DynamicProgramming {

    public int fib(int n) {  //o(2^n)
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + (n - 2);
    }

    public int fibo(int n) {   //o(n)
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

    public int bottomUp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] memo = new int[n];

        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < memo.length; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n - 1] + memo[n - 2];
    }

    public int memoization(int n) {
        return memoization(n, new int[n + 1]);
    }

    public int memoization(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        int result = memoization(n - 1) + memoization(n - 2);
        memo[n] = result;

        return result;

    }

    public int recursiveStairCase(int n, int[] x) {
        //given a stair case, and you can climb it either with one or two steps, then solve this as recurssion
        //if x(1,3,5) then
        if (n == 0) return 1;
        int total = 0;
        for (int i : x) {
            if ((n - i) >= 0) {
                total += recursiveStairCase(n - i, x);
            }
        }
        return total;
    }

    public int recursiveStairCaseBottomUp(int n, int[] x){
        if (n == 0) return 1;
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i=1;i<=n;i++){
            int total = 0;
            for (int j: x) {
                if (i-j>=0){
                    total += nums[i-j];
                }
                nums[i] = total;
            }
        }
        return nums[n];
    }

}
