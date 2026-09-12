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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode();
        ListNode current = dummyNode;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int val1 = 0;
            int val2 = 0;

            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            current.next = new ListNode(digit);
            current = current.next;
        }
        return dummyNode.next;
    }
}
