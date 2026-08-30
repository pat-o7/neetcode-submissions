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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;

        // if only list1 is populated
        if (list1 != null && list2 == null) {
            return list1;
        }

        // if only list2 is populated
        if (list2 != null && list1 == null) {
            return list2;
        }

        // if both are empty
        if (list1 == null && list2 == null) {
            return null;
        }

        // if both are populated
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head = list1;
                list1 = list1.next;
            } else {
                head = list2;
                list2 = list2.next;
            }
        }

        ListNode current = head;
        // while one of the lists still have values:
        while (list1 != null || list2 != null) {
            // if only list1 has values
            if (list1 != null && list2 == null) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }

            // if only list2 has values
            if (list2 != null && list1 == null) {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }

            // if both list1 and list2 have values
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    current.next = list1;
                    current = current.next;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    current = current.next;
                    list2 = list2.next;
                }
            }
        }
        return head;        
    }
}