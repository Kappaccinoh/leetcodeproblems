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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head;
        }
        ListNode curr = head.next.next;
        ListNode oddLast = head;
        ListNode evenStart = head.next;
        ListNode evenLast = head.next;

        int count = 3;

        while (curr != null) {
            // System.out.println("val: " + curr.val);
            // System.out.println("count: " + count);
            // if count is odd
            if (count % 2 == 1) {
                oddLast.next = curr;
                oddLast = curr;
            } else { // count is even
                evenLast.next = curr;
                evenLast = curr;
            }

            curr = curr.next;
            count++;
        }

        // last node is odd
        if (count % 2 == 0) {
            evenLast.next = null;
        }
        oddLast.next = evenStart;
        return head;
    }
}