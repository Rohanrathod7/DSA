package BinaryTree;


import java.util.*;

// Definition of TreeNode
class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class MaximumDepth {
    
    // 1️⃣ Recursive DFS (Postorder: Left -> Right -> Root)
    public int maxDepthDFSRecursive(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepthDFSRecursive(root.left);
        int rightDepth = maxDepthDFSRecursive(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
    
    // 2️⃣ Iterative DFS (Using Stack)
    public int maxDepthDFSIterative(TreeNode root) {
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.push(root);
        depths.push(1);

        int maxDepth = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = depths.pop();
            maxDepth = Math.max(maxDepth, depth);

            if (node.right != null) {
                stack.push(node.right);
                depths.push(depth + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                depths.push(depth + 1);
            }
        }
        return maxDepth;
    }
    
    // 3️⃣ BFS (Level Order Traversal)
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    // Test cases
    public static void main(String[] args) {
        MaximumDepth tree = new MaximumDepth();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.println("DFS Recursive Depth: " + tree.maxDepthDFSRecursive(root));
        System.out.println("DFS Iterative Depth: " + tree.maxDepthDFSIterative(root));
        System.out.println("BFS Level Order Depth: " + tree.maxDepthBFS(root));
    }
}
