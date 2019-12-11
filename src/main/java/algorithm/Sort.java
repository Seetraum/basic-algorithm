package test;


import org.junit.Test;

import java.util.Arrays;

public class Sort {
    private int[] arr = {5,6,11,3,65,89,41,33,1,5,6};
    private int count = 0;

    @Test
    public void dubbleSort(){
        for (int i = 0; i < arr.length - 1;i++){
            for (int j = 0; j < arr.length - i - 1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                count ++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("一共比较" + count + "次");
    }

    /**
     *基于冒泡排序优化（鸡尾酒排序）
     * */
    @Test
    public void dubbleSort1(){
        int tmp = 0;
        for (int i = 0; i < arr.length / 2;i++){
            //有序标记，每一轮初始值都是true
            boolean isSorted = true;
            //奇数轮。从左向右比较交换
            for (int j = i; j < arr.length - i - 1;j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    //有元素交换 所以数组不是有序的
                    isSorted = false;
                }
                count ++;
            }
            if (isSorted){
                break;
            }

            //在偶数轮之前 将isSorted重新标记为true
            isSorted = true;

            //偶数轮从右向左比较 交换
            for (int j = arr.length - i - 1;j > i; j --){
                if (arr[j] < arr[j - 1]){
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1 ] = tmp;
                    //有元素交换 所以数组不是有序的
                    isSorted = false;
                }
                count ++;
            }
            if (isSorted){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("一共比较" + count + "次");
    }

    @Test
    public void selectionSort(){
        for (int i = 0; i < arr.length - 1;i++){
            int index = i;
            for (int j = i + 1; j < arr.length;j++){
                if(arr[j] < arr[index]){
                    //获取最小元素的下标
                    index = j;
                }
            }
            //将最小值与前面值交换
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    //插入排序时间复杂度为O(n^2)
    public void insertSort(){
        for (int i = 1; i < arr.length;i++){
           int insertValue = arr[i];
           int insertIndex = i - 1;
           while (insertIndex >= 0 && insertValue < arr[insertIndex]){
               arr[insertIndex+1] = arr[insertIndex];
               insertIndex --;
           }
           arr[insertIndex+1] = insertValue;
        }
        System.out.println(Arrays.toString(arr));
    }

}
