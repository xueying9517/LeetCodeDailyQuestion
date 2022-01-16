/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-16
 * 执行用时：
 * 2 ms
 * , 在所有 Java 提交中击败了
 * 99.42%
 * 的用户
 * 内存消耗：
 * 63.6 MB
 * , 在所有 Java 提交中击败了
 * 55.76%
 * 的用户
 */
public class SolutionWangCong1721 {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode kNode =head,lastKNode = head;
        ListNode tmp = head;
        int i = 0;
        while(tmp != null  ) {
            i++;
            // System.out.println("i="+ i +",k="+k);
            if( i == k) {
                kNode = tmp;
            }
            if(i > k) {
                lastKNode = lastKNode.next;
            }
            tmp = tmp.next;

        }
        // System.out.println("kNode="+ kNode.val +",lastKNode="+ lastKNode.val);
        int tmpValue = kNode.val;
        kNode.val = lastKNode.val;
        lastKNode.val = tmpValue;
        return head;
    }
}
