package com.leosanqing.algorithm;

/**
 * @Author: leosanqing
 * @Date: 2019-11-13 22:20
 * <p>
 * 第八题：二叉树的下一个节点
 * <p>
 * 给定一颗二叉树的一个节点，如何找到该二叉树中序遍历的下一个节点。
 * 树中的节点除了两个指向左右子节点的指针，还有一个指向父节点的指针
 *
 *
 *                         a
 *                       /   \
 *                     b      c
 *                   /  \    / \
 *                 d    e   f   g
 *                    /  \
 *                   h    i
 */
public class _8_FindNextNode {

    public static void main(String[] args) {

        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");
        TreeNode h = new TreeNode("h");
        TreeNode i = new TreeNode("i");

        h.parent = e;
        i.parent = e;

        e.left = h;
        e.right = i;
        e.parent = b;
        d.parent = b;
        b.left = d;
        b.right = e;
        b.parent = a;

        a.left = b;
        a.right = c;
        c.parent = a;
        c.left = f;
        c.right = g;
        f.parent = c;
        g.parent = c;


        System.out.println(method(b));
        System.out.println(method(a));
        System.out.println(method(d));
        System.out.println(method(f));
        System.out.println(method(i));
        System.out.println(method(g));
    }

    /**
     * 1.如果当前节点有右节点。那下一个节点就是这个节点右子树的最左边的那个节点
     * 2.如果当前节点没有右节点，并且还是父节点的左节点
     *      那他的下一个节点就是父节点
     * 3.如果当前节点没有右节点，并且还是父节点的右节点 比如i
     *       那我们就一直往上遍历父节点，直到找到 他是父节点的左子节点的那个节点 b
     *       那么他的父节点 a 就是 我们要找的 i 的下一个节点
     * @param node
     * @return
     */
    private static TreeNode method(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode next = null;

        // 如果他是右边的最后一个
        // 如果右子节点不为空，那就是右子树的最左节点
        if (node.right != null) {
            TreeNode right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;

        } else if (node.parent != null) {
            TreeNode current = node;
            TreeNode parent = node.parent;
            // 如果他是父节点的右子节点，并且他还没有右子节点
            while (parent.right == current && parent !=null){
                current = parent;
                if(null == current.parent){
                    return null;
                }
                parent = current.parent;
            }

            next = parent;
        }

        return next;
    }


    public static class TreeNode {
        String value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
