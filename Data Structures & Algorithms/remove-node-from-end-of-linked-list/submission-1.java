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
        int length = 0;
        ListNode currentNode = head;

        // find length of linked list
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }

        // base case
        if (length == n) {
            return head.next;
        }

        // other cases
        // find n from start instead of end
        int remove = length - n + 1;
        int current = 0;
        currentNode = head;
        ListNode lastNode = null;
        while (currentNode != null) {
            current++;
            if (current == remove) {
                lastNode.next = currentNode.next;
                return head;
            }
            lastNode = currentNode;
            currentNode = currentNode.next;
        }
        throw new IllegalArgumentException("invalid removal");
    }
}
