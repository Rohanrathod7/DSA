package BinaryTree;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Binarytree {
    // Node class representing each node in the binary tree
    class node {
        int data;
        node left;
        node right;
        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Root of the binary tree
    node root;

    // Constructor to initialize the binary tree
    Binarytree() {
        root = null;
    }

    // Method to insert a new node with given data
    void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive method to insert a new node
    node insertRec(node root, int data) {
        if (root == null) {
            root = new node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Method to perform inorder traversal
    void inorder() {
        inorderRec(root);
    }

    // Recursive method for inorder traversal
    void inorderRec(node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data); // Output: 20 30 40 50 60 70 80
            inorderRec(root.right);
        }
    }

    // Method to perform preorder traversal
    void preorder() {
        preorderRec(root);
    }

    // Recursive method for preorder traversal
    void preorderRec(node root) {
        if (root != null) {
            System.out.println(root.data); // Output: 50 30 20 40 70 60 80
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Method to perform postorder traversal
    void postorder() {
        postorderRec(root);
    }

    // Recursive method for postorder traversal
    void postorderRec(node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.data); // Output: 20 40 30 60 80 70 50
        }
    }

    // Method for iterative preorder traversal
    List<Integer> preorderIterative() {
        Stack<node> st = new Stack<>();
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            res.add(root.data); // Output: [50, 30, 20, 40, 70, 60, 80]
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return res;
    }

    // Method for iterative inorder traversal
    List<Integer> inorderIterative() {
        Stack<node> st = new Stack<>();
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }
        node curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            res.add(curr.data); // Output: [20, 30, 40, 50, 60, 70, 80]
            curr = curr.right;
        }
        return res;
    }

    // Method for iterative postorder traversal
    List<Integer> postorderIteration() {
        Stack<node> st1 = new Stack<>();
        Stack<node> st2 = new Stack<>();
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        st1.push(root);
        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);
            if (root.left != null) {
                st1.push(root.left);
            }
            if (root.right != null) {
                st1.push(root.right);
            }
        }
        while (!st2.isEmpty()) {
            res.add(st2.pop().data); // Output: [20, 40, 30, 60, 80, 70, 50]
        }
        return res;
    }

    // Main method to test the binary tree implementation
    public static void main(String[] args) {
        List<Integer> res = new LinkedList<>();
        Binarytree tree = new Binarytree();
        tree.insert(50); // Insert root
        tree.insert(30); // Insert left child of root
        tree.insert(20); // Insert left child of node 30
        tree.insert(40); // Insert right child of node 30
        tree.insert(70); // Insert right child of root
        tree.insert(60); // Insert left child of node 70
        tree.insert(80); // Insert right child of node 70

        // Uncomment to print traversals
        // tree.inorder();                  // Output: 20 30 40 50 60 70 80
        // tree.preorder();                // Output: 50 30 20 40 70 60 80
        tree.postorder();                 // Output: 20 40 30 60 80 70 50

        // Uncomment to test iterative traversals
        // res = tree.preorderIterative();
        // System.out.println(res);                      // Output: [50, 30, 20, 40, 70, 60, 80]
        // res = tree.inorderIterative();
        // System.out.println(res);                      // Output: [20, 30, 40, 50, 60, 70, 80]
        res = tree.postorderIteration();
        System.out.println(res);                         // Output: [20, 40, 30, 60, 80, 70, 50]
    }
}