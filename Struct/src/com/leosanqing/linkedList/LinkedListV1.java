package com.leosanqing.linkedList;


/**
 *  LinkedListV1 1.0 version
 *
 *  只实现最最基础的功能,能进行增删改查操作
 */

public class LinkedListV1 {
    private Node first;
    private Node last;
    // 临时变量
    private Node p;
    private int size;

    public LinkedListV1(){
        first = new Node();
        last = first;
        size = 0;
    }

    public class Node{
        private Object data;
        private Node next;

        public Object getData() {
            return data;
        }

        public Node() {

        }
        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 增加节点操作
     * @param object
     */
    public void add(Object object){
        p.data = object;
        last.next = p;
        //将链表的尾指针指向链表的最后
        last = p;
        size++;
    }


    /**
     * 根据索引删除节点，并返回值
     * @param index
     * @return
     */
    public Object remove(int index){
        checkElemIndex(index);

         Node node = first;

        for (int i = 0; i < index; i++) {
            node  =node.next;
        }
        Object elem = node.next.data;

        node.next = node.next.next;
        return elem;

    }

    /**
     * 根据索引获取节点
     * @param index
     * @return
     */
    Node node (int index){
        int i = 0;
        Node p = first;
        while(i !=index){
            p = p.next;
        }
        return p;

    }

    /**
     * 检查是否为正确的索引，如果是，返回true；否则返回false
     * @param index
     * @return
     */
    private boolean isElemIndex(int index){
        return (index >=0 && index < size);
    }

    /**
     * 检查传入的参数是否为有效的索引，是，返回true；否则返回false
     * 在add操作时使用
     * @param index
     * @return
     */
    private boolean isPositionIndex(int index){
        return index >=0 && index < size;
    }

    /**
     * 如果索引越界，输入索引值和LinkedList的大小
     * @param index
     * @return
     */
    private String outOfBoundMsg(int index){
        return "index: " + index +",but size: " +size;
    }
    private void checkElemIndex(int index){
        if(!isElemIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
    }


}
