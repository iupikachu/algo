package LeetCode.Tree;


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
    public void 











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
        preorderWithStack(treeNode1);
    }
}
