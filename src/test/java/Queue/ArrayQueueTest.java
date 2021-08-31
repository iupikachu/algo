package Queue;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName ArrayQueueTest.java
 * @Description TODO
 * @createTime 2021年04月22日 20:44:00
 */
public class ArrayQueueTest {
    private String[] items;
    private int head = 0;
    private int tail = 0;
    int capacity = 0;

    public ArrayQueueTest(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }

    // 入栈
    public boolean enqueue(String item) {
        if (tail == capacity) {
            if (head == 0) {
                return false; // 栈满
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail = tail -head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    // 出栈
    public String dequeue() {
        if (head == tail) {
            return null; // 栈空
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
        ArrayQueueTest arrayQueue = new ArrayQueueTest(3);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        boolean c = arrayQueue.enqueue("c");
        boolean d = arrayQueue.enqueue("d");
        String dequeue = arrayQueue.dequeue();
        arrayQueue.enqueue("e");
        arrayQueue.printAll();
    }
}
