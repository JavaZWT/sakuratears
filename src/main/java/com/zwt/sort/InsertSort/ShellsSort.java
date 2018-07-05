package com.zwt.sort.InsertSort;

import com.zwt.sort.ArrayHelper;

/**
 * @Author: zwt
 * @Description: 插入排序----希尔排序
 * @Name: ShellsSort
 * @Date: 2018/5/23 下午7:42
 * @Version: 1.0
 */
public class ShellsSort {
    /**
     * @Author: zwt
     * @Description: 希尔排序
     * @Name: shellSort
     * @Date: 2018/5/23 下午7:45
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     */
    public static int[] shellsSort(int a[]) {
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i = i + d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
        return a;
    }


    public static void main(String[] args) {
        int a[]=new int[]{10,11,18,33,5,7};
        ShellsSort.shellsSort(a);
        ArrayHelper.printLine(a);
    }
}
