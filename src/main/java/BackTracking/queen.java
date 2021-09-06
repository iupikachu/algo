package BackTracking;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName queen.java
 * @Description 八皇后
 * @createTime 2021年09月03日 10:28:00
 */
public class queen {
    public static int[] result = new int[8];
    public static boolean isOne = false;
    public static void cal_8queens(int row){
        if(row == 8){
            // 打印
            printQueens(result);
            return;// 8个皇后排完毕了 直接返回
        }
        for(int column=0; column < 8; column++){
            if(isOk(row,column)){ // 满足八皇后的排列规律,继续往下摆放旗子，继续往下递归
                result[row] = column;    // 放皇后
                cal_8queens(row+1);
            }
            // 不满足条件，直接for循环到下一步，column++，查看右边的位置是否满足
        }
        return;
    }

    private static boolean isOk(int row,int column){
        // 判断是否符合摆放规律 1.水平线以上不能有同一列的 result[row--] != column row >0
        // 判断左上对角线不能有皇后 int leftup = column-1; for(i = row-1; i >=0; i--){ leftup >=0   if(result[i] == leftup) leftup-- }
        // 判断右下对角线不能有皇后 int rightup = column+1; for(i = row-1; i >=0; i--){ rightup <8  if(result[i] == rightup) rightup++ }
        int leftup = column - 1;
        int rightup = column + 1;

        for(int i = row-1; i >= 0; i--){
            if(result[i] == column){
                return false;
            }
            if(leftup >= 0){
                if(result[i] == leftup){
                    return false;
                }
            }

            if(rightup < 8){
                if(result[i] == rightup){
                    return false;
                }
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    public static void printQueens(int[] result){
        for (int row =0; row < 8; row++){
            for(int column =0; column <8; column++){
                if(result[row] == column){
                    System.out.print("Q");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        cal_8queens(0);
    }
}
