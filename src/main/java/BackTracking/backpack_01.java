package BackTracking;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName backpack_01.java
 * @Description 01背包问题 （回溯求解）
 * @createTime 2021年09月06日 10:03:00
 */

/**
 *  一个背包可以装 W kg的物品  总共有 10 个物品   4 3 2 6 7 8 9 1 3 2  如何装入不超过背包容量又尽可能大的重量
 *  每一个物品（不可分割）对应 2种情况： 装 不装   n 个物品总共有 2^n 种排列方式 去掉总质量 > 背包容量 的情况
 *  对这些穷举出的情况进行比较得到一个最大值
 *
 *  回溯过程解析:
 *  先递归到最后，再往前，根据当前物品放和不放两种情况，再往后递归
 *
 */
public class backpack_01 {
    public static int maxW = Integer.MIN_VALUE;  // 全局变量，存储装入背包物品质量的最大值

    // i:考察到第i个物品  cw:当前装入背包的质量 items[i]:第i个物品的重量 n:物品的个数 w:背包最大重量
    public static void f(int i, int cw, int []items, int n, int w){
        // 退出条件: 当前质量已经 == 背包最大质量   或      所有物品都递归完了
        if(cw == w || i == n){
            if(cw > maxW){ maxW = cw; }
            return;
        }
        // 不放入背包
        f(i+1,cw,items,n,w);

        // 不超过背包容量就放入背包
        if(cw + items[i] <= w){
            f(i+1,cw + items[i],items,n,w);
        }
    }

    public static void main(String[] args) {
        int[] items = new int[10];
        items[0] = 6;
        items[1] = 6;
        items[2] = 4;
        items[3] = 7;
        items[4] = 9;
        items[5] = 8;
        items[6] = 2;
        items[7] = 6;
        items[8] = 4;
        items[9] = 6;
        f(0,0,items,10,53);
        System.out.println(maxW);
    }
}
