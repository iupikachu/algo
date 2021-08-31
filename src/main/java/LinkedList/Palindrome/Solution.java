package LinkedList.Palindrome;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2021年04月17日 10:41:00
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 给一个单链表，判断是否是回文
 * Follow up:
 *
 * Could you do it in O(n) time and O(1) space?
 *
 * 思路
 * 使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
 */
public class Solution {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {

            ListNode mid = slow;
            slow = slow.next;
            mid.next = prev;
            prev = mid;

        }

        if (fast == null) {

            slow = slow.next;

        }

        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);

//        ListNode head = new ListNode(0);
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(1);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        boolean b =(isPalindrome(head));
//        System.out.println(b);

    }

}
