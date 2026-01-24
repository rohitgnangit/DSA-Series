// Leetcode-1669: Merge In Between Linked Lists
// Level-Medium

// You are given two linked lists: list1 and list2 of sizes n and m respectively.
// Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
// The blue edges and nodes in the following figure indicate the result:
// Build the result list and return its head.

// Example 1:
// Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
// Output: [10,1,13,1000000,1000001,1000002,5]
// Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        ListNode removed = null;
        int index = -1;
        int removedIndex = 0;
        while(curr.next != null) {
            index++;
            if(index == a-1) {
                removed = curr.next;
                curr.next = list2;
                removedIndex = index;
            }
            curr = curr.next;
        }

        while(removed.next != null) {
            removedIndex++;
            if(removedIndex == b) {
                removed = removed.next;
                break;
            }
            removed = removed.next;
        }
        curr.next = removed;
        return list1;
    }
}