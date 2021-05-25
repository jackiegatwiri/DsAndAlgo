package com.company;

import java.util.*;
import java.util.List;

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
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (res.indexOf(ch) < 0) {
                    res = res + s.charAt(i);
                }
            }
            return res;
        }

        //Create a function to reverse a word and use that function to reverse a string(Kenya return aynek for a word or “I am” return “ma I”

        public String reverseAWord(String s) {
            char[] arr = new char[s.length()];
            int start = 0;
            int end = s.length() - 1;

            while (start < end) {
                char temp = s.charAt(start);
                arr[start] = s.charAt(end);
                arr[end] = temp;
                start++;
                end--;

            }
            System.out.println(new String(arr));
            return Arrays.toString(arr);
        }

        public String reverseWords(String s) {
            if (s == null) return null;

            char[] a = s.toCharArray();
            int n = a.length;

            // step 1. reverse the whole string
            reverse(a, 0, n - 1);
            // step 2. reverse each word
            reverseWords(a, n);
            // step 3. clean up spaces
            return cleanSpaces(a, n);
        }

        void reverseWords(char[] a, int n) {
            int i = 0, j = 0;

            while (i < n) {
                while (i < j || i < n && a[i] == ' ') i++; // skip spaces
                while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
                reverse(a, i, j - 1);                      // reverse the word
            }
        }

        // trim leading, trailing and multiple spaces
        String cleanSpaces(char[] a, int n) {
            int i = 0, j = 0;

            while (j < n) {
                while (j < n && a[j] == ' ') j++;             // skip spaces
                while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
                while (j < n && a[j] == ' ') j++;             // skip spaces
                if (j < n) a[i++] = ' ';                      // keep only one space
            }

            return new String(a).substring(0, i);
        }

        // reverse a[] from a[i] to a[j]
        private void reverse(char[] a, int i, int j) {
            while (i < j) {
                char t = a[i];
                a[i++] = a[j];
                a[j--] = t;
            }
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

                    A = A + (char) (D1 + '0');
                    B = B + (char) (D2 + '0');
                } else {
                    A = A + (char) (D + '0');
                    B = B + '0';
                }
            }
            A = removeLeadingZero(A);
            B = removeLeadingZero(B);


            System.out.println(A);
            System.out.println(B);
        }

        private String removeLeadingZero(String a) {
            int i = 0;
            int n = a.length();

            while (a.charAt(i) == '0' && i < n) {
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

        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;

            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) sum += a.charAt(i) - '0';
                if (j >= 0) sum += b.charAt(j) - '0';
                sb.append(sum % 2);
                carry = sum / 2;
                i--;
                j--;
            }
            if (carry != 0) sb.append(carry);
            return sb.reverse().toString();

        }

        public int addTwoNumbers(int a, int b) {
            StringBuilder sb = new StringBuilder();
            int i = String.valueOf(a).length() - 1;
            int j = String.valueOf(b).length() - 1;
            int carry = 0;
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) sum += s1.charAt(i) - '0';
                if (j >= 0) sum += s2.charAt(j) - '0';

                sb.append(sum % 10);
                carry = sum / 10;
                i--;
                j--;

            }
            if (carry != 0) sb.append(carry);
            return Integer.parseInt(sb.reverse().toString());

        }

        public int reverseNumber(int x) {
            int result = 0;
//321
            while (x != 0) {
                int lastDigit = x % 10;
                int newResult = result * 10 + lastDigit;
                if ((newResult - lastDigit) / 10 != result) {
                    return 0;
                }
                x = x / 10;
                result = newResult;
            }
            return result;
        }

        public int searchInRotatedSortedArray(int[] nums, int target) {
            //find the smallest index using reversed binary seacrh
            //[4,5,6,7,0,1,2]
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int start = left;
            left = 0;
            right = nums.length - 1;

            if (target >= nums[start] && target <= nums[right]) {
                left = start;
            } else {
                right = start;
            }

            while (left <= right) {
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            return -1;
        }

        //(2->4->3) + (5->6->4)
        public Node sumOfLinkedList(Node l1, Node l2) {
            Node dummy_head = new Node(0);
            Node l3 = dummy_head;
            int carry = 0;

            while (l1 != null || l2 != null) {
                int val1 = l1 != null ? l1.data : 0;
                int val2 = l2 != null ? l2.data : 0;
                int sum = val1 + val2 + carry;
                carry = sum / 10;
                int lastDigit = carry % 10;

                Node node = new Node(lastDigit);
                l3.next = node;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
                l3 = l3.next;
            }

            if (carry > 0) {
                Node node = new Node(carry);
                l3.next = node;
                l3 = l3.next;
            }
            return dummy_head.next;
        }

        public java.util.List<java.util.List<Integer>> subSet(int[] nums) {
            java.util.List<java.util.List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            for (int n : nums) {
                int s = result.size();
                for (int i = 0; i < s; i++) {
                    ArrayList<Integer> r = new ArrayList<>(result.get(i));
                    r.add(n);
                    result.add(r);
                }
            }
            return result;
        }

        public int nonDuplicate(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int res = 0;

            for (int i : nums) {
                int val = 0;
                if (map.containsKey(i)) {
                    val = map.get(i);
                    val++;
                    map.put(i, val);
                } else {
                    map.put(i, 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    res = entry.getKey();
                }
            }
            return res;
        }
        //1,3,5,5,8   //4,5,5,7,8   //5,5,8,9

        public java.util.List<Integer> commonElementsInSortedArray(int[] nums1, int[] nums2, int[] nums3) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int n3 = nums3.length;
            int i = 0, j = 0, k = 0;
            List<Integer> res = new ArrayList<>();

            while (i < n1 && j < n2 && k < n3) {
                if (nums1[i] == nums2[j] && nums2[j] == nums3[k]) {
                    res.add(nums1[i]);
                    i++;
                    j++;
                    k++;
                } else if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums2[j] < nums3[k]) {
                    j++;
                } else {
                    k++;
                }

            }
            return res;
        }

        // missing element in a sorted array
        //4
        //1,2,4,5
        public void missingElement(){

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseAWord("i am");
//        solution.isPalindrome("nice");
//        solution.findPairs(33673, 3);
//        System.out.println(solution.addTwoNumbers(999, 1));
//        System.out.println(solution.reverseNumber(-321));
//        System.out.println(solution.removeDuplicatesFromString("geeksofgeeks"));
//        System.out.println(solution.reverseWords("Hello!  you"));
        System.out.println(solution.subSet(new int[]{1,2,3}));
//        ArrayList<Integer> r = new ArrayList<>(0);

        System.out.println(solution.nonDuplicate(new int[]{1, 5, 3, 1, 2, 4, 3}));
    }


}



