package Tree;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName TreeNode.java
 * @Description TODO
 * @createTime 2021年09月09日 10:32:00
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
