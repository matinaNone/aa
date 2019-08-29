package suanfa;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wangnan01 on 2019/8/28.
 */
public class ListHasCycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    // hash集合，每次循环先判断集合中是否已有链表节点，如果有则为true，否则将当前节点放入集合
    public static boolean hasCycle(ListNode node){
        Set<ListNode> nodeSet = new HashSet<>();
        while (node != null){
            if (nodeSet.contains(node)){
                return true;
            }
            nodeSet.add(node);
            node = node.next;
        }
        return false;
    }

    // 快慢指针法
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while(slow != null && quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){
                return true;
            }
        }
        return false;
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
//        node6.next = node2;

        boolean b = hasCycle(node1);
        System.out.println(b);
    }
}
