package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName leetcode_653.java
 * @Description 两数之和
 *              给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true
 * @createTime 2021年09月20日 10:39:00
 */
public class leetcode_653 {
    // 解法1：hashset
    public boolean findTarget(TreeNode root, int k) {
        Set set = new HashSet<Integer>();
        return find(root,k,set);
    }
    public boolean find(TreeNode root, int k, Set set){
        if(root == null){ return false;}
        if(set.contains(k - root.val)){
            return true;
        }
        set.add(root.val);

        return find(root.left,k,set) || find(root.right,k,set) ;
    }

    // 解法2：利用搜索二叉树的性质


    public void inorder(TreeNode root,List list){
        if(root == null){ return;}
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
 
    }
}
