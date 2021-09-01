package BackTracking;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName queens_8.java
 * @Description 八皇后  （广度遍历所有八皇后的摆法）
 * @createTime 2021年09月01日 20:39:00
 *
 *
 *
 *
 *          column
 *           0 1 2 3 4 5 6 7
 *   row  0  q * * * * * * *
 *        1  * * * * q * * *
 *        2  * * * * * * * q
 *        3  * * * * * q * *
 *        4  * * q * * * * *
 *        5  * * * * * * q *
 *        6  * q * * * * * *
 *        7  * * * q * * * *
 *
 * result[]             [0] [4] [7] [5] [2] [6] [1] [3]
 *       row             0   1   2   3   4   5   6  7
 *
 */

public class queens_8{

    private static int[] result = new int[8];
    private static void cal8queens(int row){
        if(row == 8){ // 8个皇后放置完毕
            printQueens(result);
            return;
        }
        for(int column = 0; column < 8; column++){
            if(isOk(row,column)){
                result[row] = column;   // 第row行的皇后放到第column列
                cal8queens(row+1);  // 考察下一行
            }
        }
    }

    private static boolean isOk(int row,int column){
        int leftup = column-1;
        int rightup = column+1;
        for(int i = row-1; i >= 0; i--){
            if(result[i] == column){  // 第i行的column列有皇后
                return false;
            }
            if(leftup >= 0){
                if(result[i] == leftup){ // 第i行column-1列 左上角有皇后
                    return false;
                }
            }
            if(rightup <= 8){
                if(result[i] == rightup){
                    return false;
                }
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    private static void printQueens(int[] result){
        for(int row=0; row < 8; row++){
            for(int column=0; column < 8; column++){
                if(result[row] == column){
                    System.out.print('Q');
                }else{
                    System.out.print('*');
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        cal8queens(0);
    }
}
