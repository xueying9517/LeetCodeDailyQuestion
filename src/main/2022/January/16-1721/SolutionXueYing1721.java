public class SolutionXueYing1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head;
        ListNode p1 = head, p2 = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
            p1 = fast;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        p2 = slow;
        int tmp = p1.val;
        p1.val = p2.val;
        p2.val = tmp;
        return head;
    }
}
