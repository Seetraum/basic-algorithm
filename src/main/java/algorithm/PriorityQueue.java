package java.algorithm;

import java.util.Arrays;

/**
 * 优先队列
 * 二叉堆上浮下沉
 * 与二叉堆一样，插入删除（入队出队）时间复杂度O(logn)
 * */
public class PriorityQueue {
    private int[] array;
    private int size;
    public PriorityQueue(){
        //队列初始长度为32
        array = new int[32];
    }

    /**
     * 入队
     * @param key 入队元素
     * */
    public void enQueue(int key){
        //队列长度超出范围 扩容
        if (size >= array.length){
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队
     * */
    public int deQueue() throws Exception {
        if (size <= 0){
            throw new Exception("the queue is empty!");
        }
        //获取堆顶元素
        int head = array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[size--];
        downAdjust();
        return head;
    }

    /**
     * 最小堆
     * '上浮'调整
     * 若二叉堆父节点下标为： parentIndex 则子节点下标：childIndex = parentIndex * 2 + 1
     * */
    public void upAdjust(){
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1)/2;
        //temp保存插入叶子节点的值，用于最后赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]){
            //无需真正交换 单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex /2;
        }
        array[childIndex] = temp;
    }

    /**
     * '下沉'调整
     * */
    public void downAdjust(){
        //temp保存父节点的值  用于最后赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size){
            //如果有右节点  且右节点的值小于左节点 则定位到右节点
            if (childIndex + 1 < size && array[childIndex + 1] < array[childIndex]){
                childIndex++;
            }
            //如果父节点小于任何一个节点（左右节点）的值 则直接跳出
            if (temp >= array[childIndex]){
                break;
            }
            //无需交换  单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 队列扩容
     * */
    private void resize(){
        //队列容量翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array,newSize);
    }

    public static strictfp void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println(2.0 - 1.1);
        System.out.println("8的平方根:" + Math.sqrt(8));
    }
}
