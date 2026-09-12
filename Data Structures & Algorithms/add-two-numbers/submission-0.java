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
            if (l1 == null && l2 == null) {
                current.next = new ListNode(carry);
                carry = 0;
            }

            if (l1 != null && l2 == null) {
                int sum = l1.val + carry;
                int digit = sum % 10;
                carry = sum / 10;
                current.next = new ListNode(digit);
                l1 = l1.next;
            }

            if (l1 == null && l2 != null) {
                int sum = l2.val + carry;
                int digit = sum % 10;
                carry = sum / 10;
                current.next = new ListNode(digit);
                l2 = l2.next;
            }

            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                int digit = sum % 10;
                carry = sum / 10;
                current.next = new ListNode(digit);
                l1 = l1.next;
                l2 = l2.next;
            }

            current = current.next;
        }
        return dummyNode.next;
    }
}
