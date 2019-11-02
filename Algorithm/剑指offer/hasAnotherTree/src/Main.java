/**
 * 题目：判断一个树是否包含另一个树
 *
 */

public class Main {
    public static void main(String[] args) {

    }

    /**
     * 遍历树
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubtree(TreeNode root1,TreeNode root2){
        boolean result=false;
        if(root1!=null&&root2!=null){
            if(root1.value==root2.value)
                result=hasTree2(root1,root2);
            if(!result)
                result=hasTree2(root1.left,root2);
            if(!result)
                result=hasTree2(root1.right,root2);
        }
        return false;
    }


    /**
     * 判断是否包含 第二棵树
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasTree2(TreeNode root1,TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.value!=root2.value)
            return false;
        return hasTree2(root1.left,root2.left)&&hasTree2(root1.right,root2.right);
    }
}
 class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

 }