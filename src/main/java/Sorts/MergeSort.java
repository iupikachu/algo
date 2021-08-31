package Sorts;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName MergeSort.java
 * @Description 归并排序 (MergeSort) O(nlogn)
 * @createTime 2021年04月27日 19:54:00
 */
public class MergeSort {


    public static void  MergeSort_start(int[] a ){
        MergeSort_divide_merge(a,0,a.length-1);
    }


    public static void MergeSort_divide_merge(int[] a, int p , int r){
        // 递归终止条件
        if( p == r){
            return;
        }
        // 开始递归
        int q = (r + p)/2;
        MergeSort_divide_merge(a,p,q);
        MergeSort_divide_merge(a,q+1,r);

        // 合并
        Merge(a,p,q,r);
    }

    public static void Merge(int a[],int p,int q,int r){
        int [] temp = new int[r-p+1]; // 临时存放数组
        int i = p;
        int j = q+1;
        int k = 0;
        while( i <= q && j<=r ){
            if( a[i] <= a[j]){
                temp[k] = a[i];
                k++;
                i++;
            }else{
                temp[k] = a[j];
                k++;
                j++;
            }
        }
            while (i<=q){
                temp[k++] = a[i++];
            }
            while(j<=r){
                temp[k++] = a[j++];
            }
       // 把temp复制给a数组
        for(int z=0;z<=r-p;z++){
            a[z+p] = temp[z];
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
        MergeSort_start(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
