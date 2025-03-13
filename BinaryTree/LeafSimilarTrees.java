package BinaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class LeafSimilarTrees {

    // Method to check if two trees are leaf-similar using recursion
    public static boolean leafSimilarRecursive(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Get leaf values for both trees
        getLeafValues(root1, leaves1);
        getLeafValues(root2, leaves2);

        // Compare the leaf values
        return leaves1.equals(leaves2);
    }

    // Helper method to get leaf values recursively
    private static void getLeafValues(TreeNode node, List<Integer> leafList) {
        if (node == null) return;
        if (node.left == null && node.right == null) { // It's a leaf
            leafList.add(node.val); // Add leaf value to the list
        }
        getLeafValues(node.left, leafList);
        getLeafValues(node.right, leafList);
    }

    // Method to check if two trees are leaf-similar using iteration
    public static boolean leafSimilarIterative(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new LinkedList<>();
        List<Integer> r2 = new LinkedList<>();
        
        // Get leaf values for both trees
        r1 = getList(root1);
        r2 = getList(root2);

        // Print leaf values for debugging
        System.out.println(r1);
        System.out.println(r2);
        
        // Compare the leaf values
        return (r1.equals(r2));
    }

    // Helper method to get leaf values iteratively
    public static List<Integer> getList(TreeNode r) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode root = r;
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
            if (root.left == null && root.right == null) {
                res.add(root.val); // Add leaf value to the list
            }
        }

        return res;
    }

    // Main method to test the leaf-similar trees implementation
    public static void main(String[] args) {
        // Construct first tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        // Construct second tree
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        // Check if trees are leaf-similar
        System.out.println(leafSimilarRecursive(root1, root2)); // true
        System.out.println(leafSimilarIterative(root1, root2)); // true
    }
}

