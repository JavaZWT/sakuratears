package com.zwt.sort;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: ArrayHelper
 * @Date: 2018/5/23 下午4:30
 * @Version: 1.0
 */
public class ArrayHelper {
    //打印每次的排序结果
    public static void printLine(int[] arr) {
        int Arrlength = arr.length;
        for (int j = 0; j < Arrlength; j++) {
            System.out.print(arr[j] + "  ");
        }
    }
}
