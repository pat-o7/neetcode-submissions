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
    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        ListNode current = head;

        while (current != null) {
            set.add(current);

            if (set.contains(current.next)) {
                return true;
            }

            current = current.next;
        }

        return false;        
    }
}
