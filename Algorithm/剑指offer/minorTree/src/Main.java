/**
 * 题目：镜像树
 *
 *
 */


public class Main {
    public static void main(String[] args) {

    }


    public static void minorTree(TreeNode root){
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
            return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        if(root.left!=null)
            minorTree(root.left);
        if(root.right!=null)
            minorTree(root.right);
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
}
