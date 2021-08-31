package Queue;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName CircularQueue.java
 * @Description 循环队列
 * @createTime 2021年04月18日 14:43:00
 */
public class CircularQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue ( int capacity ){
        items = new String[capacity];
        this.n = capacity;

    }

    // 入队
    public boolean enQueue(String item){
        if( (tail+1)%n == head ){
            // 队满
            return false;
        }
        items[tail] = item;
        tail = (tail+1)%n;
        return  true;
    }

    // 出队
    public String deQueue(){
        if( head == tail ){
            // 队空
            return null;
        }
        String ret = items[head];
        head = (head+1)%n;
        return ret;
    }

    public void printAll(){
        if( n == 0){
            return;
        }
        for(int i =head ; i%n!= tail ; i=(i+1)%n){
            System.out.println(items[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);

        circularQueue.enQueue("a");
        circularQueue.enQueue("b");
        circularQueue.enQueue("c");
        circularQueue.printAll();
        circularQueue.deQueue();
        circularQueue.printAll();
    }
}

