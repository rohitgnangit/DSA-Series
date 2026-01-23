// Leetcode-2181: Merge Nodes in Between Zeros
// Level-Medium

// Example 1:
// Input: head = [0,3,1,0,4,5,2,0]
// Output: [4,11]
// Explanation: 
// The above figure represents the given linked list. The modified list contains
// - The sum of the nodes marked in green: 3 + 1 = 4.
// - The sum of the nodes marked in red: 4 + 5 + 2 = 11.

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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head;
        ListNode temp = head.next;
        int sum = 0;
        while(temp != null) {
            if(temp.val == 0) {
                curr.val = sum;
                sum = 0;
                curr.next = temp.next;
                curr = temp.next;
            }
            sum += temp.val;
            temp = temp.next;
        }
        return head;
    }
}