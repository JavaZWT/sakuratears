package com.zwt.sort.OtherSort;

import com.zwt.sort.ArrayHelper;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: RadixSort
 * @Date: 2018/5/28 下午11:23
 * @Version: 1.0
 */
public class RadixSort {
    public static int[] sort(int[] number, int d) //d表示最大的数有多少位
    {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while (m <= d) {
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0)
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
        return number;
    }

    public static void main(String[] args) {
        int a[]=new int[]{10,11,18,33,5,7};
        a=RadixSort.sort(a,2);
        ArrayHelper.printLine(a);
    }
}
