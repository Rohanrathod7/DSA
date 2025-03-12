import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Binarytree{
    class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    node root;
    Binarytree(){
        root = null;
    }
    void insert(int data){
        root = insertRec(root, data);
    }
    node insertRec(node root, int data){
        if(root == null){
            root = new node(data);
            return root;
        }
        if(data < root.data){
            root.left = insertRec(root.left, data);
        }else if(data > root.data){
            root.right = insertRec(root.right, data);
        }
        return root;
    }
    void inorder(){
        inorderRec(root);
    }
    void inorderRec(node root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }
    void preorder(){
        preorderRec(root);
    }
    void preorderRec(node root){
        if(root != null){
            System.out.println(root.data);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    void postorder(){
        postorderRec(root);
    }
    void postorderRec(node root){
        if(root != null){
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.data);
        }
    }

    List preorderIterative(){
        Stack<node> st = new Stack<>();
        List<Integer> res = new LinkedList<>();

        if(root == null){
            return res;
        }
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            res.add(root.data);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
            
        }
        return res;
        
    }

    List inorderIterative(){
        Stack<node> st = new Stack<>();
        List<Integer> res = new LinkedList<>();

        if(root == null){
            return res;
        }
        node curr = root;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            res.add(curr.data);
            curr = curr.right;
        }
        return res;
    }

    List postorderIteration(){
        Stack<node> st1 = new Stack<>();
        Stack<node> st2 = new Stack<>();
        List<Integer> res = new LinkedList<>();

        if(root == null){
            return res;
        }

        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null){
                st1.push(root.left);
            }
            if(root.right != null){
                st1.push(root.right);
            }
            
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().data);
        }
        return res;
    }

    
        
    public static void main(String[] args){
        List<Integer> res = new LinkedList<>();
        Binarytree tree = new Binarytree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        // tree.inorder();
        // tree.preorder();
        tree.postorder();

        // res = tree.preorderIterative();
        // System.out.println(res);
        // res = tree.inorderIterative();
        // System.out.println(res);
        res = tree.postorderIteration();
        System.out.println(res);
    }
}