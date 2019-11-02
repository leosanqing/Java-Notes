/**
 * 反转链表
 *
 * 画图即可明白，需要设置preNode 用来存储之前的节点
 */

public class Main {
    public static void main(String[] args) {

    }


    public static Node reverseLinkedList(Node head){
        if(head==null)
            return null;
        Node node=head;
        Node preNode=null;
        Node reverseHead =null;
        while(node!=null){
            Node nextNode=node.next;
            if(nextNode==null)
                reverseHead=nextNode;
            node.next=preNode;
            preNode=node;
            node=nextNode;
        }
        return reverseHead;
    }
}



class Node{
    int data;
    Node next;
}
