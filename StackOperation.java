package test;

import java.util.Arrays;

/**
 * 二叉堆操作
 * @date 2019/11/17
 * */
public class StackOperation {
    /**
     * 最小堆
     * '上浮'调整
     * @param array 待调整的堆
     * 若二叉堆父节点下标为： parentIndex 则子节点下标：childIndex = parentIndex * 2 + 1
     * */
    public static void upAdjust(int[] array){
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1)/2;
        //temp保存插入叶子节点的值，用于最后赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]){
            //无需真正交换 单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     * '下沉'调整
     * @param array  待调整的堆
     * @param parentIndex 要下沉父节点
     * @param length 堆的有效大小
     * */
    public static void downAdjust(int[] array,int parentIndex,int length){
        //temp保存父节点的值  用于最后赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length){
            //如果有右节点  且右节点的值小于左节点 则定位到右节点
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]){
                childIndex++;
            }
            //如果父节点小于任何一个节点（左右节点）的值 则直接跳出
            if (temp <= array[childIndex]){
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
     * 构建堆
     * @param array 要调整的堆
     * */
    public static void  buildHeap(int[] array){
        //从最后一个非叶子节点开始，依次做'下沉'调整
        for (int i = (array.length - 2)/2; i >= 0; i--){
            downAdjust(array,i,array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        System.out.println(".............................................. ");
        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
