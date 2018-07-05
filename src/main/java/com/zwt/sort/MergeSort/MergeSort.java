package com.zwt.sort.MergeSort;


import com.zwt.sort.ArrayHelper;

/**
 * @Author: zwt
 * @Description: 归并排序
 * @Name: MergeSort
 * @Date: 2018/5/24 下午4:09
 * @Version: 1.0
 */
public class MergeSort {


    /**
     * @Author: zwt
     * @Description: 归并排序
     * @Name: mergeSort
     * @Date: 2018/5/24 下午4:25
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     */
    public static int[] mergeSort(int a[]){
        sort(a,0,1);
        return a;
    }
    
    /**
     * @Author: zwt
     * @Description: 排序
     * @Name: mergeSort
     * @Date: 2018/5/24 下午4:22
     * @Params: [a, s, len]
     * @Return: void
     * @Version: 1.0
     */
    private static void sort(int[] a, int s, int len) {
        int size = a.length;
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);
        //　-------归并到只剩一个有序集合的时候结束算法-------//
        if (mid == 0)
            return;
        //　------进行一趟归并排序-------//
        for (int i = 0; i < mid; ++i) {
            s = i * 2 * len;
            merge(a, s, s + len, (len << 1) + s - 1);
        }
        //　-------将剩下的数和倒数一个有序集合归并-------//
        if (c != 0)
            merge(a, size - c - 2 * len, size - c, size - 1);
        //　-------递归执行下一趟归并排序------//
        sort(a, 0, 2 * len);
    }


    /**
     * @Author: zwt
     * @Description: 将两个有序列表合成一个有序列表
     * @Name: merge
     * @Date: 2018/5/24 下午4:21
     * @Params: [a, s, m, t]
     * @Return: void
     * @Version: 1.0
     */
    private static void merge(int[] a, int s, int m, int t) {
        int[] tmp = new int[t - s + 1];
        int i = s, j = m, k = 0;
        while (i < m && j <= t) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            tmp[k] = a[i];
            i++;
            k++;
        }
        while (j <= t) {
            tmp[k] = a[j];
            j++;
            k++;
        }
        System.arraycopy(tmp, 0, a, s, tmp.length);
    }



    public static void main(String[] args) {
        int a[]=new int[]{10,11,18,33,5,7};
        MergeSort.mergeSort(a);
        ArrayHelper.printLine(a);
    }
}
