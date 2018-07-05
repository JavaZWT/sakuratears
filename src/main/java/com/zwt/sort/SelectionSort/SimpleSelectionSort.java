package com.zwt.sort.SelectionSort;

import com.zwt.sort.ArrayHelper;

/**
 * @Author: zwt
 * @Description: 选择排序----简单选择排序，又称直接选择排序
 * @Name: SimpleSelectionSort
 * @Date: 2018/5/23 下午5:02
 * @Version: 1.0
 */
public class SimpleSelectionSort {
    /**
     * @Author: zwt
     * @Description: 简单选择排序
     * @Name: selectSort
     * @Date: 2018/5/23 下午5:03
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     */
    public static int[] simpleSelectSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            int min=i;
            for(int j=i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=a[i];
                a[i]=a[min];
                a[min]=temp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int a[]=new int[]{10,11,18,33,5,7};
        SimpleSelectionSort.simpleSelectSort(a);
        ArrayHelper.printLine(a);
    }
}
