import java.util.Arrays;


/**
 * 题目：判断输入的后根序数组，是否为二叉搜索树
 *
 * 思路：二叉搜索树的左子树中的每一个值必定小于根节点，使用递归即可
 */

public class Main {
    public static void main(String[] args) {
        int a[]={7,4,6,5};
        System.out.println(verifySquenceOfBST(a));

    }



    public static boolean  verifySquenceOfBST(int nums[]){
        int length=nums.length;
        if (nums == null||length<=0) {
            return false;
        }

        int root=nums[length-1];

        int count=0;

        for (int i=0;i<length-1;i++){
            if(nums[i]<root)
                break;
            count++;
        }

        // 没有左子树
        if(count==0){
            verifySquenceOfBST(Arrays.copyOfRange(nums,0,length-1));
        }else {
            for(int j=count;j<length-1;j++){
                if(nums[j]<=root)
                    return false;
            }
            verifySquenceOfBST(Arrays.copyOfRange(nums,0,count));
            verifySquenceOfBST(Arrays.copyOfRange(nums,count,length-1));
        }

        return true;
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
}
