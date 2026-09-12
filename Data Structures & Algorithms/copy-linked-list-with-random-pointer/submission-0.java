/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // map of original, copy
        Map<Node, Node> map = new HashMap<>();

        // iterate through original, create copy without random
        Node current = head;
        while (current != null) {
            Node temp = new Node(current.val);
            map.put(current, temp);
            current = current.next;            
        }

        // map of original, copy created
        // point all of them
        current = head;
        while (current != null) {
            // next pointer
            map.get(current).next = map.get(current.next);

            // random pointer
            map.get(current).random = map.get(current.random);

            current = current.next;
        }



        return map.get(head);        
    }
}
