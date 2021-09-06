package LeetCode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName Leetcode671.java
 * @Description 二叉树中第二小的节点
 * @createTime 2021年09月06日 16:50:00
 */


public class Leetcode671 {
    // 遍历树放入set中，对set排序，取第二个数
   static LinkedHashSet hashSet = new LinkedHashSet<Integer>();

    public static int findSecondMinimumValue(TreeNode root) {
        bfs(root);
        Integer i = sort(hashSet);
        return i;
    }


    public static void bfs(TreeNode root){
        if(root != null){
            hashSet.add(root.val);
        }else{
            return;
        }
        bfs(root.left);
        bfs(root.right);
    }

    public static Integer sort(LinkedHashSet hashSet){
        ArrayList<Integer> list = new ArrayList<Integer>(Leetcode671.hashSet);
        Collections.sort(list);
        for(Integer integer:list){
            System.out.println(integer);
        }

        return list.size() >= 2 ? list.get(1) : -1;
    }

    public static void main(String[] args) {
//        TreeNode head = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(5);
//        TreeNode treeNode3 = new TreeNode(5);
//        TreeNode treeNode4 = new TreeNode(7);
//        head.left = treeNode1;
//        head.right = treeNode2;
//        treeNode2.left = treeNode3;
//        treeNode2.right = treeNode4;

        TreeNode head = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(1);
        head.left = treeNode1;
        head.right = treeNode2;
        treeNode2.right = treeNode3;
        int secondMinimumValue = findSecondMinimumValue(head);
        System.out.println("第二小的数是:"+secondMinimumValue);
    }


}
