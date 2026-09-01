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
        ListNode current = head;
        ListNode last = null;

        while (current != null) {
            length++;
            current = current.next;
        }

        if (n == length) {
            return head.next;
        }
        current = head;

        int remove = length - n + 1; // 1 based
        int currentCounter = 1;
        while (current != null) {
            System.out.println("remove: " + remove + " | current counter: " + currentCounter);
            if (currentCounter == remove) {
                last.next = current.next;
                return head;
            }
            last = current;
            current = current.next;
            currentCounter++;
        }
        return head;
    }
}
