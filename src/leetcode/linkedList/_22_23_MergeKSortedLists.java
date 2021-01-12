package leetcode.linkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _22_23_MergeKSortedLists {
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
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4,new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3,new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        ListNode answer = mergeKList(lists);
        while(answer != null){
            System.out.println(answer.val);
            answer = answer.next;
        }
    }

    /*
    Runtime: 5 ms, faster than 44.05% of Java online submissions for Merge k Sorted Lists.
    Memory Usage: 40.6 MB, less than 59.40% of Java online submissions for Merge k Sorted Lists.
     */
    private static ListNode mergeKList(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for(int i=0; i<lists.length; i++){
            ListNode ln = lists[i];
            while(ln != null){
                pq.offer(ln.val);
                ln = ln.next;
            }
        }
        ListNode answer = new ListNode(0);
        ListNode node = answer;
        while(!pq.isEmpty()){
            node.next = new ListNode(pq.poll());
            node = node.next;
        }

        return answer.next;
    }

    /*
    Runtime: 4 ms, faster than 78.69% of Java online submissions for Merge k Sorted Lists.
    Memory Usage: 41.2 MB, less than 19.90% of Java online submissions for Merge k Sorted Lists.
     */
    private static ListNode mergeKListLecture(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        for(ListNode node : lists){
            if(node != null){
                pq.offer(node);
            }
        }

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if(node.next != null){//안들어간 것 다시 queue에 넣으면 조정해서 최소값으로 나오므로 추가
                pq.offer(node.next);
            }
        }
        return newHead.next;
    }
}
