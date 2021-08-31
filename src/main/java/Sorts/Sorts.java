package Sorts;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName Sorts.java
 * @Description 冒泡排序 插入排序 选择排序  时间复杂度都为 O(n^2)
 * @createTime 2021年04月23日 22:37:00
 */
public class Sorts {

    public static void BubbleSort( int[]a , int n){

        if( n<= 1) {
            return;
        }

        for(int i = 0; i<n; i++){
            Boolean flag = false;
            for(int j=0;j<n-i-1;j++){   // 最后一个数不需要比较所以为 n-i-1
                if(a[j] > a[j+1]){
                    int temp;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                return;  // 没有数据交换 排序提前退出
            }
        }
    }

    /**
     * 插入排序     4  6  7  5  2
     *                  j   i
     */
    public static void InsertionSort( int a[] , int n){
        if( n <= 1){
            return;
        }

        for(int i=1;i<n;i++){
            int value = a[i];
            int j=i-1;
            for(;j>=0;j--){
                if(a[j]>value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public static void SelectionSort( int a[] ,int n){

        if(n<1){
           return;
        }

        for(int i=0;i<n;i++){
            int min =i;
            for(int j=i+1;j<n;j++){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }



    public static void printAll(int[] a){
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
         int[] a = new int[6];
         a[0] = 3;
         a[1] = 5;
         a[2] = 4;
         a[3] = 1;
         a[4] = 2;
         a[5] = 6;
       // BubbleSort(a,6);
       // InsertionSort(a,6);
          SelectionSort(a,6);
        printAll(a);
    }

}
