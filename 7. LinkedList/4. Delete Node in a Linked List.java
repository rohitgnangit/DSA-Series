// Leetcode-237: Delete Node in a Linked List
// Level-Medium

// Input: head = [4,5,1,9], node = 5
// Output: [4,1,9]
// Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Just change the current node value with next node value and delete last node.
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while(curr.next != null) {
            curr.val = curr.next.val;
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }
}