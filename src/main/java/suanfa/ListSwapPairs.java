package suanfa;

/**
 * Created by wangnan01 on 2019/8/28.
 */
public class ListSwapPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static ListNode swapTraversal(ListNode head){
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next!= null && cur.next.next != null){ //cur=0
            ListNode start = cur.next; // start=1
            ListNode end = cur.next.next;// end=2

            cur.next = end; //0,2
            start.next = end.next; //1,3
            end.next = start;//2,1

            cur = start;

        }
        return pre.next;
    }

    static ListNode swapRecursion(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapRecursion(next.next);
        next.next = head;
        return next;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode out = swapRecursion(node1);
        while (out != null) {
            System.out.print(out.val);
            out = out.next;
        }

    }

}
