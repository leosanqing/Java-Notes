public class Main {
    public static void main(String[] args) {

    }



    public Node merge(Node head1,Node head2){
        if(head1==null)
            return head2;
        else if(head2==null)
            return head1;

        Node mergeHead =null;
        if(head1.value<head2.value){
            mergeHead=head1;
            mergeHead.next=merge(head1.next,head2);
        }
        else {
            mergeHead=head2;
            mergeHead.next=merge(head1,head2.next);
        }
        return mergeHead;
    }
}

class Node{
    int value;
    Node next;
}
