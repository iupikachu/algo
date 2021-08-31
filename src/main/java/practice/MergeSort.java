package practice;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName MergeSort.java
 * @Description TODO
 * @createTime 2021年08月30日 15:12:00
 */

/*
    11 8 3 9 7 1 2 5
    11 8 3 9    |      7 1 2 5
    11 8 |  3 9       7 1 |  2 5
    11|8  3|9         7|1    2|5
分解

合并 8 11 | 3 9        1 7 |  2 5
    3 8 9 11           1 2 5 7
    1 2 3 5 7 8 9 11

    分治思想
    递归                       (start+end)/2
   start                        middle                          end
    1    2   3   4   5   6   7   8   9   10  11   12  13   14   15

    if(start == end) return
    divide(start,middle)
    divide(middle+1,end)
    merge(start,middle,end)
 */


public class MergeSort {

    public static void MergeSortStart(int[] a){
        divide(a,0,a.length-1);
    }

    public static void divide(int[] a,int start,int end){
       int middle = (start + end)/2;
       if(start == end){ return;}
       divide(a,start,middle);
       divide(a,middle+1,end);
       // 合并
       merge(a,start,middle,end);
    }

    public static void merge(int[] a,int start,int middle,int end){
        // 定义临时数组存放拍好序的数据
        int[] tmp = new int[end - start +1];
        int i = start;       // 左半段数组的第一位
        int j = middle+1;    // 右半段数组的第一位
        int k = 0;           // 临时数组的第一位


        while(i <= middle && j <= end){
           if(a[i] <= a[j]){
              tmp[k] = a[i];
              k++;
              i++;
           }else{
               tmp[k] = a[j];
               k++;
               j++;
           }
        }
        while (i <= middle){
            tmp[k++] = a[i++];
        }
        while (j <= end){
            tmp[k++] = a[j++];
        }

        // 把临时数组复制回给 a[]
        for(int z = 0;z <= end - start;z++){
            a[z+start] = tmp[z];
        }

    }

    public static void main(String[] args) {
        int[] a = new int[8];

        a[0] = 11;
        a[1] = 8;
        a[2] = 3;
        a[3] = 9;
        a[4] = 7;
        a[5] = 1;
        a[6] = 2;
        a[7] = 5;
        MergeSortStart(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
