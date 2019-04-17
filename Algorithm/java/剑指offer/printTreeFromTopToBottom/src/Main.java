import sun.misc.Queue;

/**
 * 题目：按照广度优先打印树
 * 思路：使用队列，每次出队时，将子节点插入队尾
 */

public class Main {
    public static void main(String[] args) {

    }


    public static void printTree(TreeNode root) throws InterruptedException {
        if (root == null) {
            return;
        }

        Queue queue=new Queue();
        queue.enqueue(root);

        while(!queue.isEmpty()){
            root=(TreeNode) queue.dequeue();
            System.out.print(root.value+"\t");
            if(root.left!=null){
                queue.enqueue(root.left);
            }
            if(root.right!=null)
                queue.enqueue(root.right);
        }
    }

    /**
     * 打印树，按照层打印
     *
     * 设置两个变量，一个记录一层总共需要打印多少个，一个记录一层是否打印完
     * @param root
     * @throws InterruptedException
     */

    public static void printTreeInLayer(TreeNode root) throws InterruptedException {
        if (root == null) {
            return;
        }

        Queue queue=new Queue();
        queue.enqueue(root);

        int count=1;
        int layCount=0;

        while (!queue.isEmpty()){
            TreeNode node=(TreeNode)queue.dequeue();
            System.out.print(node+"\t");

            if(node.left!=null) {
                queue.enqueue(node.left);
                layCount++;
            }
            if(node.right!=null) {
                queue.enqueue(node.right);
                layCount++;
            }
            count--;
            if(count==0){
                System.out.println();
                count=layCount;
                layCount=0;
            }
        }
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
}
