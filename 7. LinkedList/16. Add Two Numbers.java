// Leetcode-2: Add Two Numbers
// Level-Medium

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example 1:
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.

// Example 2:
// Input: l1 = [0], l2 = [0]
// Output: [0]

// Example 3:
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int carry = 0;
        while(curr1 != null && curr2 != null) {
            int num = curr1.val + curr2.val + carry;
            if(num > 9) {
                int n = num % 10;
                curr.next = new ListNode(n);
                curr = curr.next;
                carry = num / 10;
            } else {
                curr.next = new ListNode(num);
                curr = curr.next;
                carry = 0;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1 != null || curr2 != null) {
            if(curr1 != null) {
                int num = curr1.val + carry;
                if(num > 9) {
                    int n = num % 10;
                    curr.next = new ListNode(n);
                    curr = curr.next;
                    carry = num / 10;
                } else {
                    curr.next = new ListNode(num);
                    curr = curr.next;
                    carry = 0;
                }
                curr1 = curr1.next;
            } 
            if(curr2 != null) {
                int num = curr2.val + carry;
                if(num > 9) {
                    int n = num % 10;
                    curr.next = new ListNode(n);
                    curr = curr.next;
                    carry = num / 10;
                } else {
                    curr.next = new ListNode(num);
                    curr = curr.next;
                    carry = 0;
                }
                curr2 = curr2.next;
            }
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return res.next;
    }
}