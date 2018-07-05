package com.zwt.sort.OtherSort;

import com.zwt.sort.ArrayHelper;

/**
 * @Author: zwt
 * @Description: 计数排序
 * @Name: CountingSort
 * @Date: 2018/5/28 下午7:38
 * @Version: 1.0
 */
public class CountingSort {

    public static int[] countSort(int[]a){
        int b[] = new int[a.length];
        int max = a[0],min = a[0];
        for(int i:a){
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }//这里k的大小是要排序的数组中，元素大小的极值差+1
        int k=max-min+1;
        int c[]=new int[k];
        for(int i=0;i<a.length;++i){
            c[a[i]-min]+=1;//优化过的地方，减小了数组c的大小
        }
        for(int i=1;i<c.length;++i){
            c[i]=c[i]+c[i-1];
        }
        for(int i=a.length-1;i>=0;--i){
            b[--c[a[i]-min]]=a[i];//按存取的方式取出c的元素
        }
        return b;
    }

    public static void main(String[] args) {
        int a[]=new int[]{10,11,18,33,5,7};
        a=CountingSort.countSort(a);
        ArrayHelper.printLine(a);
    }
}
