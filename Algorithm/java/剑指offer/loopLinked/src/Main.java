/**
 * 题目：假如一个链表有环，如何找到环的入口
 * 思路： 分为两步
 *       1.判断是否有环，
 *       2.找到环的节点个数，让其循环直到两个节点相等
 *          之后，假设环的节点a个，设置两个指针，第一个走a步，之后第二个节点和第一个节点一起走，当两个相同，则为入口节点
 */


public class Main {
    public static void main(String[] args) {

    }



    public static Node meetNode(Node head){
        if (head == null) {
            return null;
        }
        Node slow=head.next;
        if (slow == null) {
            return null;
        }
        Node fast=slow.next;

        while (fast != null && slow != null) {
            if(fast==slow)
                return fast;
            slow=slow.next;
            fast=fast.next;
            if (fast!=null)
                fast=fast.next;
        }


        return null;
    }



    public static Node entryNodeOfLoop(Node head){
        Node meetNode=meetNode(head);
        int count=1;
        if(meetNode==null)
            return null;

        Node node1=meetNode;
        while(node1.next!=meetNode){
            count++;
            node1=node1.next;
        }

         node1= head;
        for (int i = 0; i < count; i++) {
            node1=node1.next;
        }
        Node node2=head;

        while(node1!=node2){
            node1=node1.next;
            node2=node2.next;
        }


        return node2;
    }
}
