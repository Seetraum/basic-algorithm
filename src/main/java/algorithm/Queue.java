package java.algorithm;

public class Queue {
    private int[] array;
    private int front;//最前下标
    private int rear;//最后下标
    public Queue(int capacity){
        this.array = new int[capacity];
    }
    /**
     * 入队
     * @param element 入队元素
     * */
    public void enQueue(int element) throws Exception{
        if((rear + 1)%array.length == front){
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear + 1)%array.length;
    }

    /**
     * 出队
     * */
    public int deQueue() throws Exception{
        if (rear == front){
            new Exception("队列已空");
        }
        int deQueueElement = array[front];
        front = (front + 1)%array.length;
        return deQueueElement;
    }

    /**
     * 输出队列
     * */
    public void output(){
        for (int i = front; i != rear;i = (i + 1)%array.length){
            System.out.println(array[i]);
        }

    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(6);
        queue.enQueue(0);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(6);
        queue.enQueue(7);
        queue.enQueue(8);
        queue.output();
    }
}
