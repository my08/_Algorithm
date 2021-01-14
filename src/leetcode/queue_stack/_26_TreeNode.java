package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _26_TreeNode {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(3);
        tn.left = new TreeNode(9);
        tn.right = new TreeNode(20);
        tn.right.left = new TreeNode(15);
        tn.right.right = new TreeNode(7);
        //tn.right = new TreeNode(5);

        List<List<Integer>> answer = solve(tn);
        for(int i=0; i<answer.size(); i++){
            for(Integer num : answer.get(i)){
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> solve(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        int level = 0;
        queue.add(new Node(level, root));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            TreeNode t0 = node.tn;

            if(list.size()-1 < node.level){
                List<Integer> l0 = new ArrayList<>();
                l0.add(t0.val);
                list.add(node.level, l0);
            }else{
                list.get(node.level).add(t0.val);
            }

            if(t0.left != null) queue.add(new Node(node.level+1, t0.left));
            if(t0.right != null) queue.add(new Node(node.level+1, t0.right));

        }

        return list;
    }

    static class Node{
        int level;
        TreeNode tn;
        Node(int level, TreeNode tn){
            this.level = level;
            this.tn = tn;
        }
    }

    public static List<List<Integer>> solveLecture(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(list);
        }
    return result;
    }
}
