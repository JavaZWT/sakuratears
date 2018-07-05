package com.zwt.sort.ExchangeSort;

/**
 * @Author: zwt
 * @Description: 交换排序----快速排序算法
 * @Name: QuickSort
 * @Date: 2018/6/23 下午2:32
 * @Version: 1.0
 */
public class QuickSort {
    public static int[] quickSort(int a[],int low,int high){
        if(low<high){
            int privotLoc=partition(a,low,high);//将表一分为二
            quickSort(a,low,privotLoc-1);
            quickSort(a,privotLoc+1,high);
        }

        return a;
    }

    private static int partition(int a[],int low,int high){
        int privotKey=a[low];//基准元素
        while(low<high){     //从表的两端交替向中间扫描
            while(low<high&&a[high]>=privotKey){   //从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端
                --high;                             //从右找比基准元素少的
            }
            a[low]=a[high];                         //如果比基准元素小，交换位置
            a[high]=privotKey;

            while(low<high&&a[low]<=privotKey){
                ++low;                              //从右找比基准元素大的
            }
            a[high]=a[low];                          //如果比基准元素大，交换位置
            a[low]=privotKey;

        }
        return low;
    }
}
