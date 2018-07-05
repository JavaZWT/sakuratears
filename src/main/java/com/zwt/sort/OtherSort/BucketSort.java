package com.zwt.sort.OtherSort;

import com.zwt.sort.ArrayHelper;

/**
 * @Author: zwt
 * @Description: 桶排序
 * @Name: BucketSort
 * @Date: 2018/5/28 下午11:16
 * @Version: 1.0
 */
public class BucketSort {
    public static int[] basket(int data[])//data为待排序数组
    {
        int n = data.length;
        int bask[][] = new int[10][n];
        int index[] = new int[10];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = max > (Integer.toString(data[i]).length()) ? max : (Integer.toString(data[i]).length());
        }
        String str;
        for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                str = "";
                if (Integer.toString(data[j]).length() < max) {
                    for (int k = 0; k < max - Integer.toString(data[j]).length(); k++)
                        str += "0";
                }
                str += Integer.toString(data[j]);
                bask[str.charAt(i) - '0'][index[str.charAt(i) - '0']++] = data[j];
            }
            int pos = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < index[j]; k++) {
                    data[pos++] = bask[j][k];
                }
            }
            for (int x = 0; x < 10; x++) index[x] = 0;
        }

        return data;
    }

    public static void main(String[] args) {
        int a[]=new int[]{10,11,18,33,5,7};
        BucketSort.basket(a);
        ArrayHelper.printLine(a);
    }
}
