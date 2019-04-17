import java.util.Stack;


/**
 * 题目：判断输出序列是否为栈的压入顺序
 */
public class Main {
    public static void main(String[] args) {

        int a[]={1,2,3,4,5};
        int b[]={4,5,3,1,2};
        System.out.println(isPopOrder(a,b));

    }
    public static boolean isPopOrder(int pushA[],int popA[] ){
        if(pushA==null||popA==null)
            return false;

        int index=0;
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
