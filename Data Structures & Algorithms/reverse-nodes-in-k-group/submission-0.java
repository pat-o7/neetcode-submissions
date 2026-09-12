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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyNode = new ListNode(0, head);
        ListNode groupPrev = dummyNode;
        ListNode current = head;

        while (true) {

            // check if kth node exists
            int i = k;
            current = groupPrev.next;
            while (i > 0 && current != null) {
                current = current.next;
                i--;
            }

            // fewer than k nodes remain
            if (i > 0) {
                return dummyNode.next;
            }

            // current is now at kth.next
            ListNode groupNext = current;

            // old first node becomes tail
            ListNode oldStart = groupPrev.next;

            // reverse current group
            current = oldStart;
            ListNode last = groupNext;
            while (current != groupNext) {
                ListNode temp = current.next;
                current.next = last;
                last = current;
                current = temp;
            }

            // last is now head of new group
            groupPrev.next = last;

            // oldStart is now tail of new group
            groupPrev = oldStart;


        }
        
    }
}
