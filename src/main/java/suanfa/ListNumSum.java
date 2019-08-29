package suanfa;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangnan01 on 2019/8/26.
 */
public class ListNumSum {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //list-->数字--->相加--->转为list（）
    //[1,2,3] [2,4,6] ---> 321 + 642 = 963 ---> [3,6 9]
    // 问题：链表可能很长很长，长到我们不知道有多少位，这样计算一是容易溢出，而是消耗大量资源，增加空间复杂度
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int i1 = 0;
        int i2 = 0;
        int count1 = 1;
        int count2 = 1;
        while (l1 != null) {
            int i = l1.val * count1;
            i1 += i;
            count1 *= 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int i = l2.val * count2;
            i2 += i;
            count2 *= 10;
            l2 = l2.next;
        }

        int intRes = i1 + i2;
        String s = intRes + "";
        ListNode temp = result;
        for (int i = s.length() - 1; i >= 0; --i) {
            int num = Integer.parseInt(Character.toString(s.charAt(i)));
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return result.next;
    }


    //列表元素逐个相加法，
    // 如果节点为空，则补零
    // 如有进位，则带到下一个元素相加
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);

        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;

            int sum = i1 + i2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);

        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(9);
        ListNode node16 = new ListNode(9);
        ListNode node17 = new ListNode(9);
        ListNode node18 = new ListNode(9);
        ListNode node19 = new ListNode(9);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        node15.next = node16;
        node16.next = node17;
        node17.next = node18;
        node18.next = node19;

        ListNode out = addTwoNumbers2(node1, node11);
        while (out != null) {
            System.out.print(out.val);
            out = out.next;
        }
    }

}
