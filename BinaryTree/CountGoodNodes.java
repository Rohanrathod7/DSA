package BinaryTree;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class CountGoodNodes {
    public static int goodNodes(TreeNode root) {
        return dfsRecursive(root, Integer.MIN_VALUE);
    }

    private static int dfsRecursive(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1; // This node is a good node
        }

        maxSoFar = Math.max(maxSoFar, node.val); // Update the max value
        count += dfsRecursive(node.left, maxSoFar);
        count += dfsRecursive(node.right, maxSoFar);

        return count;
    }

    static class Pair{
        TreeNode node;
        Integer max;

        Pair(TreeNode node, Integer max) {
            this.node = node;
            this.max = max;
        }
    }

    public static int dfsIterative(TreeNode node){
        if(node == null) return 0;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(node, Integer.MIN_VALUE));

        int count = 0;
        while(!stack.isEmpty()){
            Pair c = stack.pop();
            TreeNode root = c.node;
            Integer max = c.max;

            if(root.val >= max){
                count += 1;
            }

            max = Math.max(root.val, max);

            if(root.right != null) stack.push(new Pair(root.right, max));
            if(root.left != null) stack.push(new Pair(root.left, max));

        }

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(goodNodes(root)); // Output: 4
        System.out.println(dfsIterative(root)); // Output: 4

    }
}
