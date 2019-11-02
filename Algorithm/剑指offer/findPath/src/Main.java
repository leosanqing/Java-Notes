import java.util.ArrayList;


/**
 * 题目：寻找路径，寻找数值加起来等于目标值的路径（从根到叶子节点）
 *
 * 使用递归，和链表
 */
public class Main {

     static ArrayList resultList=new ArrayList();
     static ArrayList list=new ArrayList();

    public static void main(String[] args) {
        TreeNode left1=new TreeNode(4,null,null);
        TreeNode right1=new TreeNode(7,null,null);


        TreeNode left=new TreeNode(5,left1,right1);
        TreeNode right=new TreeNode(12,null,null);
        TreeNode root=new TreeNode(10,left,right);



        System.out.println(findPath(root,22));
    }

    public static ArrayList findPath(TreeNode root, int target) {


        if(root == null)
            return resultList;
        list.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null){
            resultList.add(new ArrayList<>(list));
        }else {
            findPath(root.left,target);
            findPath(root.right,target);
        }
        //每返回上一层一次就要回退一个节点
        list.remove(list.size()-1);
        return resultList;
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
