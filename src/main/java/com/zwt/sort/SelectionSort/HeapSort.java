package com.zwt.sort.SelectionSort;

import com.zwt.sort.ArrayHelper;

/**
 * @Author: zwt
 * @Description: 选择排序-----堆排序
 * @Name: HeapSort
 * @Date: 2018/5/24 下午1:52
 * @Version: 1.0
 */
public class HeapSort {


    /**
     * @Author: zwt
     * @Description: 堆排序
     * @Name: heapSort
     * @Date: 2018/5/24 下午2:06
     * @Params: []
     * @Return: int[]
     * @Version: 1.0
     */
    public static int[] heapSort(int a[]){
        buildMaxHeapTree(a);
        sort(a);
        return a;
    }

    /**
     * @Author: zwt
     * @Description: 构建最大堆树
     * @Name: buildMaxHeapTree
     * @Date: 2018/5/24 下午1:59
     * @Params: [a]
     * @Return: void
     * @Version: 1.0
     */
    private static void buildMaxHeapTree(int a[]){
        //没有子节点的才需要创建最大堆，从最后一个的父节点开始
        int startIndex=getParentIndex(a.length-1);
        //从尾端开始创建最大堆，每次都是正确的堆
        for(int i=startIndex;i>=0;i--){
            maxHeap(a,a.length,i);
        }
    }

    /**
     * @Author: zwt
     * @Description: 最大堆
     * @Name: maxHeap
     * @Date: 2018/5/24 下午2:01
     * @Params: [data, heapSize, index]
     * @Return: void
     * @Version: 1.0
     */
    private static void maxHeap(int[] data, int heapSize, int index) {
        //当前点与左右子节点比较
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        int largest = index;
        if (left < heapSize && data[index] < data[left]) {
            largest = left;
        }
        if (right < heapSize && data[largest] < data[right]) {
            largest = right;
        }
        //得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
        if (largest != index) {
            int temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeap(data, heapSize, largest);
        }
    }


    /**
     * @Author: zwt
     * @Description: 获取父节点位置
     * @Name: getParentIndex
     * @Date: 2018/5/24 下午1:56
     * @Params: [current]
     * @Return: int
     * @Version: 1.0
     */
    private static int getParentIndex(int current){
        return (current-1)>>2;
    }

    /**
     * @Author: zwt
     * @Description: 获取元素左节点位置
     * @Name: getChildLeftIndex
     * @Date: 2018/5/24 下午2:03
     * @Params: [current]
     * @Return: int
     * @Version: 1.0
     */
    private static int getChildLeftIndex(int current){
        return(current<<1)+1;
    }

    /**
     * @Author: zwt
     * @Description: 获取元素右节点位置
     * @Name: getChildRightIndex
     * @Date: 2018/5/24 下午2:03
     * @Params: [current]
     * @Return: int
     * @Version: 1.0
     */
    private static int getChildRightIndex(int current){
        return(current<<1)+2;
    }

    /**
     * @Author: zwt
     * @Description: 排序
     * @Name: sort
     * @Date: 2018/5/24 下午2:05
     * @Params: [data]
     * @Return: void
     * @Version: 1.0
     */
    private static void sort(int[] data){
        //末尾与头交换，交换后调整最大堆
        for(int i=data.length-1;i>0;i--){
            int temp=data[0];
            data[0]=data[i];
            data[i]=temp;
            maxHeap(data,i,0);
        }
    }


    public static void main(String[] args) {
        int a[]=new int[]{10,11,18,33,5,7};
        HeapSort.heapSort(a);
        ArrayHelper.printLine(a);
    }
}
