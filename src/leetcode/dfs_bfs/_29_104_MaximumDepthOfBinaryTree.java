package leetcode.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _29_104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(1, new TreeNode(5, new TreeNode(7), null), new TreeNode(8)),
                new TreeNode(4));
        System.out.println(maxDepth_DFS(root));
    }

    private static int maxDepth_DFS(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        stack.push(root);
        valueStack.push(1);
        int max = 0;

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int level = valueStack.pop();
            max = Math.max(max, level);

            if(node.left != null){
                stack.add(node.left);
                valueStack.push(level+1);
            }
            if(node.right != null){
                stack.add(node.left);
                valueStack.push(level+1);
            }
        }
        return max;
    }



    private static int maxDepth_Recursive(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(maxDepth_Recursive(root.left), maxDepth_Recursive(root.right));
    }

    /*
    Runtime: 1 ms, faster than 12.23% of Java online submissions for Maximum Depth of Binary Tree.
    Memory Usage: 38.7 MB, less than 87.23% of Java online submissions for Maximum Depth of Binary Tree.
     */
    private static int maxDepth_BFS(TreeNode root) {

        if(root == null){
            return 0;
        }
        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            /*
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            */
            depth++;
        }
        return depth;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}