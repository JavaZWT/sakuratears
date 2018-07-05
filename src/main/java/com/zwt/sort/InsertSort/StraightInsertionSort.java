package com.zwt.sort.InsertSort;

import com.zwt.sort.ArrayHelper;

/**
 * @Author: zwt
 * @Description: 插入排序----直接插入排序算法
 * @Name: StraightInsertionSort
 * @Date: 2018/5/23 下午4:06
 * @Version: 1.0
 *
 */
public class StraightInsertionSort {
    /**
     * @Author: zwt
     * @Description: 直接插入排序算法
     * @Name: straightInsertionSort
     * @Date: 2018/5/23 下午4:08
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     */
    public static int[] straightInsertionSort(int[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    int temp=a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                }else{
                    break;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int a[]=new int[]{10,11,18,33,5,7};
        StraightInsertionSort.straightInsertionSort(a);
        ArrayHelper.printLine(a);
    }
}
