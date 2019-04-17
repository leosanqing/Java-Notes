package LinkedList;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseList {

    LinkedList list=new LinkedList();

     static Stack stack1=new Stack();
     static Stack stack2=new Stack();




     public static void main(String[] args) throws Exception {
         for (int i = 1; i < 5; i++) {
             addTail(i);
         }

         System.out.println("deleteHead() = " + deleteHead());
         System.out.println("deleteHead() = " + deleteHead());

    }


      static void addTail(int elem ){
        stack1.push(elem);
    }
    public static int deleteHead() throws Exception {
         if(stack2.size()<=0){
             while(stack1.size()>0){
                 stack2.push(stack1.pop());
             }
         }
        if (stack2.size() == 0) {
             throw new Exception("队列为空");
        }
        return (int)stack2.pop();
    }
}
