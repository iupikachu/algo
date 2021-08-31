package Stack;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName StackBasedOnLinkedList.java
 * @Description 基于链表实现的栈--链式栈
 * @createTime 2021年04月18日 11:15:00
 */
public class StackBasedOnLinkedList {
    private Node top = null;

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    // 入栈
    public void push (int value){
        Node newNode = new Node(value, null);

        // 判断栈是否为空
        if( top == null ){
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
    }

    // 出栈
    public int pop(){
        if( top == null ){
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

}
