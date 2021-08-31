package Sorts;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName MergeSort.java
 * @Description TODO
 * @createTime 2021年04月28日 20:34:00
 */
public class MergeSort {

    // 开始递归
    public static void Merge_start(int a[]){
        divide_merge(a,0,a.length-1);
    }

    public static void divide_merge( int a[],int p, int r){

        // 递归终止
        if( p == r){
            return;
        }
        int q = (p + r)/2;
        divide_merge(a,p,q);
        divide_merge(a,q+1,r);
        // 合并两个数组
        // Merge()
        merge(a,p,q,r);
    }

    public static void merge(int a[],int p ,int q, int r){
        int i = p;
        int j = q+1;
        int[] tmp = new int[r-p+1];
        int k = 0;

        // 比较 排序 放入tmp中
        while( i <= q && j<=r ){
            if ( a[i] < a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        // 把剩下的放入tmp中
        int start = i;
        int end = q;
        if( j <= r){   // 注意这里是 <=
            start = j;
            end = r;
        }
        while (start <= end){
            tmp[k++] = a[start++];
        }

        // 把tmp[] 拷贝到 a[]中

        for (int z = 0;z < r-p+1 ;z++){
            a[p+z] = tmp[z];
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
        Merge_start(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
