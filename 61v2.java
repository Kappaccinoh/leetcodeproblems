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
    public ListNode rotateRight(ListNode head, int k) {
        int len = getLength(head);

        if (len == 0) {
            return head;
        }

        if (k >= len) {
            k = k % len;
        }

        ListNode marker = traverse(head, len - k);
        ListNode first = erase(head, len - k);
        return join(marker, first);
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        return 1 + getLength(head.next);
    }

    public ListNode traverse(ListNode head, int k) {
        if (k == 0) {
            return head;
        }

        return traverse(head.next, k - 1);
    }

    public ListNode erase(ListNode head, int k) {
        if (k == 0) {
            return null;
        }

        return new ListNode(head.val, erase(head.next, k - 1));
    }

    public ListNode join(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

        return new ListNode(a.val, join(a.next, b));
    }
}