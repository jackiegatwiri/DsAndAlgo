package com.company;

import java.util.*;

public class NewMicrosoftQuestions {
    //Remove duplicates from an array in-place(without using extra space)

    public static class Solution {
        public int removeDuplicates(int[] nums) {
            int start = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[start] != nums[i]) {
                    nums[start + 1] = nums[i];
                    start++;
                }
            }
            return start + 1;
        }

        public String removeDuplicatesFromString(String s) {
            String res = new String();
            for (int i = 0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if(res.indexOf(ch) < 0){
                    res = res+s.charAt(i);
                }
            }
            return res;
        }

        //Create a function to reverse a word and use that function to reverse a string(Kenya return aynek for a word or “I am” return “ma I”

        public String reverseAWord(String s) {
            char[] arr = new char[s.length()];
            int start = 0;
            int end = s.length()-1;

            while(start<end){
                char temp = s.charAt(start);
                arr[start] = s.charAt(end);
                arr[end] = temp;
                start++;
                end--;

            }
//            for (int i = 0; i < s.length(); i++) {
//                char temp = s.charAt(i);
//                arr[i] = s.charAt(s.length() - (i + 1));
//                arr[arr.length - (i + 1)] = temp;
//            }
            System.out.println(new String(arr));
            return Arrays.toString(arr);
        }

        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder();

            for (char ch : s.toCharArray()) {
                if (Character.isLetterOrDigit(ch)) {
                    sb.append(Character.toLowerCase(ch));
                }
            }
            s = sb.toString();
            int start = 0;
            int end = s.length() - 1;

            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {

                    return false;
                }
                start++;
                end--;
            }

            return true;
        }


        //Given an integer N, split it into two numbers A and B such that A+B= N and that A and B doesn’t contain any 5 in it
        public void findPairs(int sum, int k) {
            String A, B;
            A = "";
            B = "";

            String s = String.valueOf(sum);
            int length = s.length();

            for (int i = 0; i < length; i++) {
                int D = s.charAt(i) - '0';
                int D1, D2;
                if (D == k) {
                    D1 = D / 2;
                    D2 = D / 2 + D % 2;

                    A = A + (char)(D1 + '0');
                    B = B + (char)(D2 + '0');
                } else{
                    A = A + (char)(D+'0');
                    B = B + '0';
                }
            }
            A = removeLeadingZero(A);
            B = removeLeadingZero(B);


            System.out.println(A);
            System.out.println(B);
        }

        private String removeLeadingZero(String a) {
            int i=0;
            int n=a.length();

            while (a.charAt(i) == '0' && i<n){
                i++;
                a.substring(i);
            }
            return a;
        }

//        public String getTwoNumbersFromOneNumber(int sum, int K){
//            String s = String.valueOf(sum);
//            HashMap<Integer, Integer> map = new HashMap<>();
//
//
//            String a = "";
//            String b = "";
//            for (int i=s.length()-1; i>=0; i++){
//                if(s.charAt(i)-'0' == K){
//
//                }
//            }
//        }

        public String addBinary(String a, String b){
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;

            while(i>=0 || j>=0){
                int sum = carry;
                if(i>=0) sum += a.charAt(i) - '0';
                if(j>=0) sum += b.charAt(j) - '0';
                sb.append(sum%2);
                carry = sum/2;
                i--;
                j--;
            }
            if (carry!=0) sb.append(carry);
            return sb.reverse().toString();

        }

        public int addTwoNumbers(int a, int b){
            StringBuilder sb = new StringBuilder();
            int i = String.valueOf(a).length()-1;
            int j = String.valueOf(b).length()-1;
            int carry = 0;
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            while (i>=0 || j>=0){
                int sum = carry;
                if (i>= 0) sum += s1.charAt(i) -'0';
                if (j>=0) sum += s2.charAt(j) - '0';

                sb.append(sum%10);
                carry = sum/10;
                i--;
                j--;

            }
            if (carry!=0) sb.append(carry);
            return Integer.parseInt(sb.reverse().toString());

        }

        public int reverseNumber(int x){
            int result = 0;
//321
            while (x != 0){
                int lastDigit = x%10;
                int newResult = result * 10 + lastDigit;
                if((newResult-lastDigit)/10 != result){
                    return 0;
                }
                x = x/10;
                result = newResult;
            }
            return result;
        }

        public int searchInRotatedSortedArray(int[] nums, int target){
            //find the smallest index using reversed binary seacrh
            //[4,5,6,7,0,1,2]
            int left = 0;
            int right = nums.length-1;

            while (left<right){
                int mid = left+(right-left)/2;
                if(nums[mid] > nums[right]){
                    left = mid+1;
                } else{
                    right = mid;
                }
            }
            int start = left;
            left = 0;
            right = nums.length-1;

            if(target>=nums[start] && target<=nums[right]){
                left = start;
            } else {
                right = start;
            }

            while (left <= right){}
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                right = mid-1;
            } else {
                left = mid+1;
            }

            return -1;
        }





    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseAWord("i am");
//        solution.isPalindrome("nice");
//        solution.findPairs(33673, 3);
        System.out.println(solution.addTwoNumbers(999, 1));
        System.out.println(solution.reverseNumber(-321));
        System.out.println(solution.removeDuplicatesFromString("geeksofgeeks"));
    }


}



