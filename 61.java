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
        // reducing k
        int len = getLength(head);
        System.out.println(len);
        if (len == 0) {
            return head;
        }

        if (k >= len) {
            k = k % len;
            System.out.println(k);
        }
        
        if (k == 0) {
            return head;
        }

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            ListNode second = head.next;
            ListNode first = head;
            first.next = null;
            ListNode newFirst = new ListNode(second.val, first);
            return rotateRight(newFirst, k - 1);    
        }

        ListNode last = getLast(head);
        ListNode remaining = removeLast(head);
        ListNode newList = new ListNode(last.val, remaining);
        return rotateRight(newList, k - 1);
    }

    public ListNode getLast(ListNode head) {
        if (head.next == null) {
            return head;
        }

        return getLast(head.next);
    }

    public ListNode removeLast(ListNode head) {
        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        ListNode ln = new ListNode(head.val);
        ln.next = removeLast(head.next);
        return ln;
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        return 1 + getLength(head.next);
    }
}