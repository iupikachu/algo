package practice;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName MergeSortCounting.java
 * @Description TODO
 * @createTime 2021年08月31日 19:11:00
 *
 *
 * 分治算法: 处理问题的思想
 * 递归实现: 编程技巧
 * 分治算法的递归实现:
 * 1. 将原问题分解成一系列子问题
 * 2. 递归地求解各个子问题，若子问题足够小，直接求解
 * 3. 将子问题的结果合并成原问题
 *
 * 用分治算法符合的条件:
 * 1. 原问题与分解成的小问题有相同的模式
 * 2. 子问题可以独立求解，子问题之间无相关性（与动态规划的明显区别）
 * 3. 终止条件
 * 4. 子问题合并成原问题
 *
 *
 *
 * *  2 4 3 1 5 6 逆序对个数
 *  * (2,1) (4,3) (4,1) (5,6)
 *  * 给定一个数组，如何计算逆序对个数
 *
 *  思路:
 *  借助归并排序 mergesort，在merge时，由于两边都是有序的，需要对两边进行比较，这时可以顺便计算逆序数
 *
 *  1 4 5 |  3 6 7
 *  i        j                            num: 0      tmp：
 *
 *  1 4 5 |  3 6 7
 *  i        j      a[i]:1 < a[j]:3       num: 0     tmp：1
 *
 *  1 4 5 |  3 6 7
 *    i      j      a[i]:4 > a[j]:3       num: 2      tmp：1 3           逆序对<4,3> <5,3>  num = j-i
 *
 * 1 4 5 |  3 6 7
 *   i        j      a[i]:4 < a[j]:6       num: 2      tmp：1 3 4
 *
 * 1 4 5 | 3 6 7
 *     i     j        a[i]:5 < a[j]:6      num: 2     tmp 1 3 4 5
 *     i 到边界了退出循环
 *
 */
public class MergeSortCounting {
    private static int num = 0;

    public static int mergeSortCounting(int[]a){
        divide(a,0,a.length-1);
        return num;
    }

    public static void divide(int[]a,int start,int end){
        if(start == end){ return;}
        int middle = (start + end)/2;
        divide(a,start,middle);
        divide(a,middle+1,end);
        merge(a,start,middle,end);
    }

    public static void merge(int[]a,int start,int middle,int end){
        int i = start;
        int j = middle+1;
        int k = 0;
        int []tmp = new int[end-start+1];
        while (i <= middle && j<= end){
            if(a[i] <= a[j]){
                tmp[k++] = a[i++];
            }else{
                num = num + middle - i+1;
                tmp[k++] = a[j++];
            }
        }
        while(i <= middle){
            tmp[k++] = a[i++];
        }
        while(j <= end){
            tmp[k++] = a[j++];
        }

        for(int z=0;z<end-start+1;z++){
            a[z+start] = tmp[z];
        }

    }

    public static void main(String[] args) {
        int[] a = new int[6];

//        a[0] = 11;
//        a[1] = 8;
//        a[2] = 3;
//        a[3] = 9;
//        a[4] = 7;
//        a[5] = 1;
//        a[6] = 2;
//        a[7] = 5;
        a[0] = 2;
        a[1] = 4;
        a[2] = 3;
        a[3] = 1;
        a[4] = 5;
        a[5] = 6;
        int num = mergeSortCounting(a);
        System.out.println("逆序对个数："+num);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }



}
