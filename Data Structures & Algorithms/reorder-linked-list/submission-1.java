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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null;

        if (head == null) {
            return;
        }

        if (head.next == null) {
            return;
        }

        // find middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        // slow now points at the last half of the list
        prevSlow.next = null;
        // reverse the last half of the list

        ListNode current = slow;
        ListNode last = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = last;
            last = current;
            current = temp;
        }

        // last now points at the last node
        ListNode forwardHead = head;
        ListNode reverseHead = last;
        ListNode reorderedcurrent = new ListNode();

        while (forwardHead != null || reverseHead != null) {
            if (forwardHead != null) {
                reorderedcurrent.next = forwardHead;
                reorderedcurrent = reorderedcurrent.next;
                forwardHead = forwardHead.next;
            }
            if (reverseHead != null) {
                reorderedcurrent.next = reverseHead;
                reorderedcurrent = reorderedcurrent.next;
                reverseHead = reverseHead.next;
            }
        }        
    }
}
