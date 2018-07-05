package com.zwt.sort.ExchangeSort;

import com.zwt.sort.ArrayHelper;

/**
 * @Author: zwt
 * @Description: 交换排序-----冒泡排序算法
 * @Name: BubbleSort
 * @Date: 2018/5/23 下午5:08
 * @Version: 1.0
 */
public class BubbleSort {
    /**
     * @Author: zwt
     * @Description: 冒泡排序算法
     * @Name: bubbleSort
     * @Date: 2018/5/23 下午5:08
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     */
    public static int[] bubbleSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int a[]=new int[]{10,11,18,33,5,7};
        BubbleSort.bubbleSort(a);
        ArrayHelper.printLine(a);
    }
}
