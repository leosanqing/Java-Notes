/**
 * 题目：搜索树转化为排序双向链表
 *
 * 思路：搜索树根据中序遍历是一个排序好的序列，然后只要将其链接好就行，使用递归操作
 */

public class Main {
    public static void main(String[] args) {

    }


    public static TreeNode convertTree(TreeNode root){
        if(root==null)
            return null;


        TreeNode lastNode=null;


        convert(root,lastNode);

        TreeNode headNode=lastNode;

        while(headNode!=null&&headNode.left!=null)
            headNode=headNode.left;



        return headNode ;

    }

    public static void convert(TreeNode node,TreeNode lastNode){
        if(node==null)
            return;

        TreeNode current=node;
        if(current.left!=null)
            convert(current.left,lastNode);

        current.left=lastNode;

        if(lastNode!=null)
            lastNode.right=current;

        lastNode=current;

        if(current.right!=null)
            convert(current.right,lastNode);

    }
}
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
}
