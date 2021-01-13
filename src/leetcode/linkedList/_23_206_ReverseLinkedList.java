package leetcode.linkedList;

import java.util.HashMap;
import java.util.Stack;

public class _23_206_ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    public static void main(String[] args) {
        ListNode ln = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        ListNode answer = reverseList2(ln);
        while(answer != null){
            System.out.println(answer.val);
            answer = answer.next;
        }
    }

    }
    /*
    Runtime: 1 ms, faster than 6.03% of Java online submissions for Reverse Linked List.
    Memory Usage: 38.5 MB, less than 93.66% of Java online submissions for Reverse Linked List.
     */
    public static ListNode reverseList1(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while(head != null){
            s.push(head.val);
            head = head.next;
        }

        ListNode answer = new ListNode(0);
        ListNode node = answer;
        while (!s.isEmpty()){
            node.next = new ListNode(s.pop());
            node = node.next;
        }

        return answer.next;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
