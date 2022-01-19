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
    public ListNode swapNodes(ListNode head, int k) {
        int cnt = 1;
        ListNode h = head;
        ListNode t = head;
        while(cnt < k) {
            t = t.next;
            cnt++;
        }
        
        ListNode kNode = t;
        
        while(t.next != null) {
            t = t.next;
            h = h.next;
        }
        
        int tmp = kNode.val;
        kNode.val = h.val;
        h.val = tmp;
        return head;
    }
}