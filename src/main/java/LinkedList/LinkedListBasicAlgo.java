package LinkedList;

import org.w3c.dom.Node;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName LinkedListBasicAlgo.java
 * @Description
 *
 *  * 1) 单链表反转
 *  * 2) 链表中环的检测
 *  * 3) 两个有序的链表合并
 *  * 4) 删除链表倒数第n个结点
 *  * 5) 求链表的中间结点
 *
 *
 *   练习题LeetCode对应编号：206，141，21，19，876
 *   默认头结点也存储数据
 * @createTime 2021年04月17日 14:14:00
 */
public class LinkedListBasicAlgo {

    public static class Node {
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
    public static Node createNode(int value) {
        return new Node(value, null);
    }

    // 1.翻转单链表
    public static Node reverse (Node list){
         Node curr = list;
         Node prev = null;
         Node next = null;

         while ( curr != null ){
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }

         return prev;
    }

    // 2.检测环
    public static boolean  checkCircle(Node list){
        Node slow = list;
        Node fast = list;
        while( fast != null && fast.next != null ){

            // 注意这个 fast.next != null 考虑到极端情况下 fast为最后一个元素时
            // .next是null 所以.next.next会报NullPointerException

            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    // 3.两个有序的链表合并
    public static Node mergeTwoLists (Node l1,Node l2){
        Node solider = new Node(0,null);   // 引入哨兵
        Node p = solider;

        while( l1 != null && l2 != null){
            if( l1.data <= l2.data ){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if( l1 != null){
            p.next = l1;
        }else {
            p.next = l2;
        }

        return solider.next ;
    }

    // 4.删除链表倒数第n个结点
    // 解题思路： 快指针先移动n个距离，然后快慢一起移动，两个指针一直相距n距离，快指针到尾的时候，慢指针就在要删除的节点

    public static Node delNthFromEnd(Node list , int n){
        Node fast = list;
        Node slow = list;

        while( n>0 ){
            fast = fast.next;
            n--;
        }
        while( fast.next != null ){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return list;
    }

    //  5.求链表的中间结点
    // 解题思路: 快慢指针。快指针走两步，慢指针走一步，快指针到尾时，慢指针到中点
     public static Node findMiddleNode (Node list){

        if (list == null) {
            return null;
        }

        Node fast = list;
        Node slow = list;

        while ( fast != null && fast.next != null){
              fast = fast.next.next;
              slow = slow.next;
        }
        return slow;
     }





    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {


        // 测试 reverse
        Node node1 = createNode(1);
        Node node2 = createNode(2);
        Node node3 = createNode(3);
        Node node4 = createNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node reverse = reverse(node1);
        while(reverse != null ){
            System.out.println(reverse.data);
            reverse = reverse.next;
        }

        System.out.println("*******");
        // 检测环
        node4.next = node1;
        boolean b = checkCircle(node1);
        System.out.println(b);


        System.out.println("*******");
        // 检测两链表合并
        Node node_a = createNode(1);
        Node node_b = createNode(3);
        Node node_c = createNode(5);
        node_a.next = node_b;
        node_b.next = node_c;
        
        Node node_1 = createNode(2);
        Node node_2 = createNode(4);
        node_1.next = node_2;

        Node node = mergeTwoLists(node_a, node_1);
        printAll(node);


        // 测试删除倒数第n个数
//        System.out.println("******");
//        Node node_delNthFromEnd = delNthFromEnd(node, 2);
//        printAll(node_delNthFromEnd);

        // 测试求中间节点
        System.out.println("******");
        Node middleNode = findMiddleNode(node);
        System.out.println(middleNode.data);
    }


}
