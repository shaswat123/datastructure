import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class BinaryTree {

    private TreeNode root;

    private static class TreeNode{

        private Integer data;
        private TreeNode left;
        private TreeNode right;


        public TreeNode(Integer data){
            this.data = data;
            this.left=null;
            this.right=null;

        }

    }

    public void createBinaryTree(){

        TreeNode first = new TreeNode(10);
        TreeNode second = new TreeNode(20);
        TreeNode third = new TreeNode(30);
        TreeNode fourth = new TreeNode(40);
        TreeNode fifth = new TreeNode(50);
        TreeNode sixth = new TreeNode(60);
        TreeNode seventh = new TreeNode(70);

        root = first;

        first.left=second;
        first.right=third; // second <--- first -----> third


        second.left=fourth;
        second.right=fifth;  //      fourth<--second--->fifth

        third.left=sixth;
        third.right=seventh;   //  sixth<---third---->seventh
 }

 //PreOrder traversal recursively
 public void preOrderRecursive(TreeNode root){

        if(root==null){

            return;
        }

        System.out.println(root.data);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);

 }

    //PreOrder traversal iterative
    public void preOrderIterative(TreeNode root){

        Stack<TreeNode>stack= new Stack();

        if(root==null){

            return;
        }

        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode tempRoot=stack.pop();
            System.out.println(tempRoot.data);

            if(tempRoot.right!=null){
                stack.push(tempRoot.right);
            }

            if(tempRoot.left!=null){
                stack.push(tempRoot.left);
            }


        }
    }

    public void InOrderTraversalRecursive(TreeNode root){

        if(root==null){//base case
            return;
        }

        InOrderTraversalRecursive(root.left);
        System.out.println(root.data+"");
        InOrderTraversalRecursive(root.right);
    }

    public void InOrderTraversalIterative(TreeNode root){

        Stack<TreeNode> stack = new Stack();

        if(root==null){
            return;
        }

        TreeNode temp=root;

        while(!stack.isEmpty() || temp!=null ){

            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            else{
                temp=stack.pop();
                System.out.println(temp.data+"");
                temp=temp.right;
            }
        }
    }

    public void postOrderTraversalRecursive(TreeNode root){

        if(root==null){ //base case
            return ;
        }

        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        System.out.println(root.data+"");
    }

    public void levelOrderTraversalBinaryTree(TreeNode root){

        if(root==null){
            return ;
        }

        Queue<TreeNode> queue = new LinkedList();

        TreeNode temp=null;
        queue.offer(root);

        while(!queue.isEmpty()){

            temp= queue.poll();
            System.out.println(temp.data+"");

            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }


        }

    }




    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.createBinaryTree();

        System.out.println("Pre Order traversal");
        binaryTree.preOrderRecursive(binaryTree.root);
        System.out.println("Iterative");
        binaryTree.preOrderIterative(binaryTree.root);

        System.out.println("In Order traversal");
        binaryTree.InOrderTraversalRecursive(binaryTree.root);

        System.out.println("Iterative");
        binaryTree.InOrderTraversalIterative(binaryTree.root);

        System.out.println("Post Order traversal");
        binaryTree.postOrderTraversalRecursive(binaryTree.root);

        System.out.println("Level Order traversal");
        binaryTree.levelOrderTraversalBinaryTree(binaryTree.root);


    }
}
