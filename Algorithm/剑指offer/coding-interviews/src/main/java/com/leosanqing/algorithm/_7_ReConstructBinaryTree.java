package com.leosanqing.algorithm;

import java.util.Arrays;

/**
 * @Author: leosanqing
 * @Date: 2019-11-09 11:44
 *
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回头结点。
 *
 */
public class _7_ReConstructBinaryTree {
    public static void main(String[] args) {

        int[] pre={1,2,4,7,3,5,6,8};
        int[] in ={4,7,2,1,5,3,8,6};

        System.out.println(method(pre,in).value);
    }

    /**
     * ！！！！！注意：题目中说，数组中的数字是不会重复的。不然用不了下面的方法
     *
     * 这道题主要运用 二叉树先序遍历和中序遍历的特点
     *
     * 1.先序遍历中，第一个就是根节点。按照上面的例子，也就是 1
     * 2.然后我们再去中序遍历的 数组中找到这个 1 。
     *     在1前面的那部分就是 这个根节点的左子树{4,7,2}。右边的为右子树{5,3,8,6}
     * 3.然后我们再在左子树中找到第一个数 4,再重复上述步骤
     *
     * 这样我们就能找到树的结构，然后一直递归。再在这个过程中添加上左右子节点。就能完成重构了
     *
     * @param pre 左子树
     * @param in 右子树
     * @return 根节点
     */
    private static TreeNode method(int[] pre,int[] in){
        if(null == pre||null == in){
            return null;
        }
        if(pre.length <=0||in.length<=0) {
            return null;
        }
        if(pre.length!=in.length){
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            // 找到中序遍历的根节点
            if(pre[0] == in[i]){

                root.left = method(Arrays.copyOfRange(pre,i,i+1),Arrays.copyOfRange(in,0,i));
                root.right = method(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));

//                root.left = reConstructBinaryTree(
//                        Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
//                root.right = reConstructBinaryTree(
//                        Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }


    /**
     * 树结构
     */
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
