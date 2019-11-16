package com.leosanqing.algorithm;

import java.util.Stack;

/**
 * @Author: leosanqing
 * @Date: 2019-11-16 12:47
 *
 * 面试题9,使用两个栈实现队列
 *
 *
 * 我们先将一个元素入队列，在内部，其实是我们选取一个栈，叫他stack1
 *
 * 我们将元素a，b,c,d 依次入stack1，这个时候，我们要出栈了。
 * 栈是FILO，先入后出。我们将它再依次出栈并入到 stack2。然后stack2再出栈，顺序就对了
 * 这个时候,d 出栈了。然后再入 e， e入哪里呢？
 *
 * 我们把它入到 stack1中，(没入前stack1是空的)。因为如果入到 stack2就出问题了
 * 我们把它放到stack1中并不影响 我们出队列的顺序。
 *
 * 如果再来 f 呢？ 我们还是把它入到 stack1.所以不管怎么样，我们总是只入stack1
 *
 * 出栈的时候就讲究了。如果 stack2有值，那就出栈，没值。要把stack1中所有的元素入到stack2
 *
 */
public class _9_ImplementQueueWithStack {


    public static void main(String[] args) throws Exception {
        MyQueue<String> queue = new MyQueue<String>();

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        System.out.println(queue.dequeue());
        queue.enqueue("e");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }


}

class MyQueue<T>{
    private  Stack<T> stack1 = new Stack<T>();
    private  Stack<T> stack2 = new Stack<T>();

    public void enqueue(T e){
        stack1.push(e);
    }
    public T dequeue() throws Exception {
        if(stack1.empty()&&stack2.empty()) {
            throw new Exception("队列为空");
        }else {
            if(stack2.empty()){
                while (!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}