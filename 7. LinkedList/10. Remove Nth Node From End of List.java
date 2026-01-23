// Leetcode-19: Remove Nth Node From End of List
// Level-Medium

// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        // Edgecase-1: if length of LL is equal to n then remove first node
        if(length == n) {
            head = head.next;
        }

        ListNode curr = head;
        int count = 0;
        int target = length - n;
        while(curr != null) {
            count++;
            if(count == target) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}