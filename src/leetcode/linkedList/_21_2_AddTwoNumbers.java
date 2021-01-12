package leetcode.linkedList;

//Input: l1 = [2,4,3], l2 = [5,6,4]
//        Output: [7,0,8]
//        Explanation: 342 + 465 = 807.
public class _21_2_AddTwoNumbers {
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
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = addTwoNumbers(l1, l2);
        while(l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
    public static ListNode addTwoNumbersLecture(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;
        int carry = 0;

        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
        if(carry == 1){
            p3.next = new ListNode(1);
        }
        return newHead.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode node = answer;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode(sum % 10);
            node = node.next;

        }
        if (sum / 10 == 1) {
            node.next = new ListNode(sum / 10);
        }
        return answer.next;
    }
}


