package LeetCode;


import java.util.*;

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






    // 队列解决
    public static int findSecondMinimumValueByQueue(TreeNode root) {
        Queue queue = new LinkedList<TreeNode>();
        int min = root.val; int res = Integer.MAX_VALUE;
        Boolean isChanged = false;
        queue.add(root);
        while (queue.size() > 0){
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = (TreeNode) queue.poll();

                if(node.val > min && node.val <= res){
                    res = node.val;
                    isChanged = true;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return isChanged ? res : -1;
    }




    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(7);
        head.left = treeNode1;
        head.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

//        TreeNode head = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(1);
//        head.left = treeNode1;
//        head.right = treeNode2;
//        treeNode2.right = treeNode3;


//        int secondMinimumValue = findSecondMinimumValue(head);
//        System.out.println("第二小的数是:"+secondMinimumValue);

        System.out.println("第二小的数是:"+findSecondMinimumValueByQueue(head));

        double a =215;
        int b =2;
        System.out.println("a/b:"+a/b);
        ArrayList arrayList = new ArrayList<String>();
        LinkedList linkedList = new LinkedList<String>();
        long l1=2147483647;//取值大小在int类型取值范围内，将采取类型自动转换
        //long l2=2147483648;//大于int类型取值范围时将需要需要加L，否则报错
        long l3=2147483648L;//大于int类型取值范围时将需要需要加L，否则报错

        Stack stack = new Stack();
    }



        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> averages = new ArrayList<Double>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                double sum = 0;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    TreeNode left = node.left, right = node.right;
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                }
                averages.add(sum / size);
            }
            return averages;
        }

    }



