package Stack;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName StackBasedOnArray.java
 * @Description 数组实现栈--顺序栈
 * @createTime 2021年04月18日 11:15:00
 */
public class StackBasedOnArray {
    private String[] items;
    private int count;
    private int n;

    // 初始化数组，申请大小为n的数组空间
    public StackBasedOnArray (int n){
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    // 入栈
    public boolean push (String item){
        // 数组空间不够，直接返回false，入栈失败
        if (count == n){
            return false;
        }

        // 将item放到下标为count的位置
        items[count] = item;
        ++count;
        return true;
    }

    // 出栈
    public String pop(){
        // 栈为空 返回null
        if(count == 0){
            return null;
        }

        // 返回下标为count-1的元素
        String tmp = items[count-1];
        --count;
        return tmp;
    }

}
