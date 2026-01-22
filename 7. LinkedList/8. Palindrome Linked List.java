// Leetcode-234: Palindrome Linked List
// Level-Easy

// Input: head = [1,2,2,1]
// Output: true

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
    // Store all nodes in array list and compare the actual linked list with array list from last index
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            list.add(temp);
            temp = temp.next;
        }
        
        ListNode curr = head;
        int i = length-1;
        while(curr != null) {
            if(curr.val != list.get(i).val) {
                return false;
            }
            curr = curr.next;
            i--;
        }
        return true;
    }
}