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
    public ListNode mergeKLists(ListNode[] lists) {
        // create minheap
        Queue<ListNode> heap = new PriorityQueue<>((a, b) -> {
            if (a.val < b.val) {
                return -1;
            } else if (a.val > b.val) {
                return +1;
            } else {
                return 0;
            }
        });

        // add all list heads to min heap
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }

        // create merged list
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        while (heap.size() > 0) {
            current.next = heap.poll();
            if (current.next.next != null) {
                heap.add(current.next.next);
            }
            current = current.next;
        }

        return dummyHead.next;
    }
}
