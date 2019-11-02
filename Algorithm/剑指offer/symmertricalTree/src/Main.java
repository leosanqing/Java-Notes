/**
 * 题目：判断一个树是否对称
 * 思路：一个正常前根序，一个也是前根序，不过要先遍历右子树。
 */

public class Main {
    public static void main(String[] args) {

    }

    public static boolean isSymmetricalTree(TreeNode root){
        return isSymmetricalTree(root,root);
    }


    public static boolean isSymmetricalTree(TreeNode root1, TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        if(root1.value!=root2.value)
            return false;

        //递归

        return isSymmetricalTree(root1.left,root2.right)
                &&isSymmetricalTree(root1.right,root2.left);
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}

