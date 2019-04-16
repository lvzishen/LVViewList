package u.com.linklistdemo;

import java.util.ArrayDeque;
import java.util.Queue;

import sun.rmi.runtime.Log;

public class MyClass {
    public static void main(String args[]) {
//        ListNode listNode = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        listNode.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = null;
//        ListNode x = listNode;
//        while (x != null) {
//            System.out.println("listNode val:" + x.val);
//            x = x.next;
//        }
//        System.out.println("listNode val:" + listNode.toString());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
//        int size=queue.size();
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll() + "");
        }
    }
}
