// Leetcode-206: Reverse Linked List
// Level-Easy

// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

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
    // We don't need to change node positions, we just need to change the links to reverse.
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head = prev;
        return head;
    }
}