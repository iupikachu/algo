package Tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName TreeTravesl.java
 * @Description 树的遍历
 * @createTime 2021年09月09日 10:24:00
 *
 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   6
 *
 * 层次遍历顺序：[1 2 3 4 5 6]
 * 前序遍历顺序：[1 2 4 5 3 6]
 * 中序遍历顺序：[4 2 5 1 3 6]
 * 后序遍历顺序：[4 5 2 6 3 1]
 *
 */
public class TreeTravesl {

    public static void visit(TreeNode node){
        System.out.println(node.val);
    }
    // 递归实现前序遍历 解法1：递归
    public static void preorder(TreeNode head){
        if(head == null){ return;}
        visit(head);
        preorder(head.left);
        preorder(head.right);
    }

    //非递归实现前序遍历 解法2：栈
    public static void preorderWithStack(TreeNode head){
        Stack stack = new Stack<TreeNode>();
        if(head == null){ return;}
        stack.push(head);
        while(!stack.isEmpty()){
            TreeNode node = (TreeNode) stack.pop();
            visit(node);
            if(node.right != null){ stack.push(node.right); }
            if(node.left != null){ stack.push(node.left); }
        }
    }

    // morris
    public void MorrisTravesl(TreeNode head){
        if(head == null){ return; }
        TreeNode cur1 = head;
        TreeNode cur2;
        while(cur1 != null){
            cur2 = cur1.left;
            // 先连接。再左移
            if(cur2 != null){
                while(cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                // 建立连接
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{
                    // 斩断连接
                    cur2.right = null;
                }
            }
            cur1 = cur1.right;
        }
    }

    // 前序遍历 解法3: morris
    public static void preOrderMorris(TreeNode head){
        if(head == null){ return; }
        TreeNode cur1 = head;
        TreeNode cur2;
        while(cur1 != null){
            cur2 = cur1.left;
            // 先连接。再左移
            if(cur2 != null){
                while(cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                // 建立连接
                if(cur2.right == null){
                    visit(cur1);
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{
                    // 斩断连接
                    cur2.right = null;
                }
            }else{
                visit(cur1);
            }
            // 斩断连接 or cur2==null(cur1到了左边叶子节点) ，cur1就往右移
            cur1 = cur1.right;
        }
    }


    // 中序遍历  解法1:递归
    public static void inOrder(TreeNode head){
        if(head == null){return;}
        inOrder(head.left);
        visit(head);
        inOrder(head.right);
    }

    // 中序遍历 解法2：栈
    public static void inOrderWithStack(TreeNode head){
        if(head == null){ return; }
        Stack stack = new Stack<TreeNode>();
        TreeNode cur = head;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node=(TreeNode)stack.pop();
            visit(node);
            cur = node.right;
        }
    }

    // 中序遍历 解法3：morris
    public static void inOrderMorris(TreeNode head) {
        if(head == null){ return; }
        TreeNode cur1 = head;
        TreeNode cur2;
        while(cur1 != null){
            cur2 = cur1.left;
            // 先连接。再左移
            if(cur2 != null){
                while(cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                // 建立连接
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{
                    // 斩断连接
                    cur2.right = null;
                }
            }
            visit(cur1);
            cur1 = cur1.right;
        }
    }

    // 后序遍历 解法1:递归
    public static void postOrder(TreeNode head){
        if(head == null){ return;}
        postOrder(head.left);
        postOrder(head.right);
        visit(head);
    }

    // 后序遍历 解法2:栈
    public static void postOrderWithStack(TreeNode head){
        List<Integer> ret = new ArrayList<>();
        if(head == null){ return;}
        Stack stack = new Stack<TreeNode>();
        stack.push(head);
        while (!stack.isEmpty()){
            TreeNode node = (TreeNode) stack.pop();
            ret.add(node.val);
            if(node.left != null){ stack.push(node.left);}
            if(node.right != null){  stack.push(node.right);}
            }
        Collections.reverse(ret);
        printList(ret);
        }

        public static void printList(List list){
            if(list == null){return;}
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }








    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;

        // preorder(treeNode1);
        System.out.println("前序遍历 递归");
        preorder(treeNode1);
        System.out.println("=========");


        System.out.println("前序遍历 栈");
        preorderWithStack(treeNode1);
        System.out.println("=========");


        System.out.println("中序遍历 递归");
        inOrder(treeNode1);
        System.out.println("=========");

        System.out.println("中序遍历 栈");
        inOrderWithStack(treeNode1);
        System.out.println("=========");

        System.out.println("中序遍历 morris");
        preOrderMorris(treeNode1);
        System.out.println("=========");

        System.out.println("后序遍历 递归");
        postOrder(treeNode1);
        System.out.println("=========");

        System.out.println("后序遍历 栈");
        postOrderWithStack(treeNode1);
        System.out.println("=========");
    }
}
