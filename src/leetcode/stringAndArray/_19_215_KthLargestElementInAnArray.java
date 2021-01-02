package leetcode.stringAndArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
3,2,1,5,6,4
1,2,3,4,5,6

3,2,3,1,2,4,5,5,6
1,2,2,3,3,4,5,5,6

 */
public class _19_215_KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
    /*
    Runtime: 1 ms, faster than 97.59% of Java online submissions for Kth Largest Element in an Array.
    Memory Usage: 39.4 MB, less than 55.61% of Java online submissions for Kth Largest Element in an Array.
     */
    public static int findKthLargestMine1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /*
    Runtime: 4 ms, faster than 62.64% of Java online submissions for Kth Largest Element in an Array.
    Memory Usage: 39.5 MB, less than 33.50% of Java online submissions for Kth Largest Element in an Array.
     */
    public static int findKthLargestMine2(int[] nums, int k){
        Queue<Integer> q = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(Integer i : nums){
            q.offer(i);
        }

        int idx = 0;
        int answer = 0;
        while(idx < k){
            answer = q.poll();
            idx++;
        }

        return answer;
    }

    /*
    Runtime: 4 ms, faster than 62.64% of Java online submissions for Kth Largest Element in an Array.
    Memory Usage: 39.4 MB, less than 43.31% of Java online submissions for Kth Largest Element in an Array.
     */
    public static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comp);

        for(int val : nums){
            pq.offer(val);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    static Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    };
}
