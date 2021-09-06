package Queue;

import java.util.*;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName ArrayQueue.java
 * @Description 用数组实现--顺序队列
 * @createTime 2021年04月18日 13:56:00
 *  tail 始终指向队列最后一个数据的下一个位置
 */
public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue (int capacity){
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue (String item){
        if(tail == n){
            if(head == 0){
                // tail == n 且 head == 0 队列是真的满了
                return false;
            }
            // 队列头部还有空间，数据搬移
            for (int i = head; i < tail ; i++) {
                items[i-head] = items[i];
            }
            // 搬移结束 更新 head tail;
            tail = tail - head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    // 出队
    public String dequeue(){
        // 如果 head == tail 表示队列为空
        if(head == tail){
            return null;
        }
        String ret = items[head];
        head++;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        boolean c = arrayQueue.enqueue("c");
        boolean d = arrayQueue.enqueue("d");
        String dequeue = arrayQueue.dequeue();
        arrayQueue.enqueue("e");



    }
}

