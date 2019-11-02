public class Main {
    public static void main(String[] args) {

    }

    public void deleteDuplication(Node head){
        if(head==null)
            return;
        Node preNode=null;
        Node node=head;


        while (node != null) {
            Node nextNode=node.next;
            boolean needDelete=false;
            if(nextNode!=null&&node.value==nextNode.value)
                needDelete=true;

            if(!needDelete){
                node=nextNode;
                nextNode=nextNode.next;
            }
            else {
                int value=node.value;
                Node toBeDel=node;

                while (toBeDel != null && toBeDel.value == value) {
                    nextNode=toBeDel.next;
                    toBeDel=nextNode;
                }
                if(preNode==null)
                    head=nextNode;
                else {
                    preNode.next=nextNode;
                }
                node=nextNode;
            }
        }
    }
}
