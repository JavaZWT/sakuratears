package sort;

import com.zwt.sort.ArrayHelper;
import com.zwt.sort.ExchangeSort.BubbleSort;
import com.zwt.sort.ExchangeSort.QuickSort;
import com.zwt.sort.InsertSort.ShellsSort;
import com.zwt.sort.InsertSort.StraightInsertionSort;
import com.zwt.sort.MergeSort.MergeSort;
import com.zwt.sort.OtherSort.BucketSort;
import com.zwt.sort.OtherSort.CountingSort;
import com.zwt.sort.OtherSort.RadixSort;
import com.zwt.sort.SelectionSort.HeapSort;
import com.zwt.sort.SelectionSort.SimpleSelectionSort;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: MyExecutorsTest
 * @Date: 2018/5/23 下午5:11
 * @Version: 1.0
 */
public class SortTest {
    public static void main(String[] args) {
//        int arrayLength=10;
//        int range=100;
        int arrayLength=100000;
        int range=100000;
        //生成一个指定长度数据的int数组
        int[] a=new int[arrayLength];
        for (int i=0;i<arrayLength;i++){
            a[i]=(int)(Math.random()*range);
        }

        //创建十个数组用于测试，否则会冲突
        int[] a1= a.clone();
        int[] a2= a.clone();
        int[] a3= a.clone();
        int[] a4= a.clone();
        int[] a5= a.clone();
        int[] a6= a.clone();
        int[] a7= a.clone();
        int[] a8= a.clone();
        int[] a9= a.clone();
        int[] a10= a.clone();
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
        System.out.println(a4.toString());
        System.out.println(a5.toString());
        System.out.println(a6.toString());
        System.out.println(a7.toString());
        System.out.println(a8.toString());
        System.out.println(a9.toString());
        System.out.println(a10.toString());

        System.gc();


        //直接插入排序法
        long starta1=System.currentTimeMillis();
        a1= StraightInsertionSort.straightInsertionSort(a1);
        long enda1=System.currentTimeMillis();
        System.out.println("插入排序法耗时："+(enda1-starta1)+"ms");

        //冒泡排序法
        long starta2=System.currentTimeMillis();
        a2= BubbleSort.bubbleSort(a2);
        long enda2=System.currentTimeMillis();
        System.out.println("冒泡排序法耗时："+(enda2-starta2)+"ms");

        //直接(简单)选择排序法
        long starta3=System.currentTimeMillis();
        a3= SimpleSelectionSort.simpleSelectSort(a3);
        long enda3=System.currentTimeMillis();
        System.out.println("直接选择排序法耗时："+(enda3-starta3)+"ms");

        //堆排序
        long starta4=System.currentTimeMillis();
        a4= HeapSort.heapSort(a4);
        long enda4=System.currentTimeMillis();
        System.out.println("堆排序法耗时："+(enda4-starta4)+"ms");

        //归并排序
        long starta5=System.currentTimeMillis();
        a5= MergeSort.mergeSort(a5);
        long enda5=System.currentTimeMillis();
        System.out.println("归并排序法耗时："+(enda5-starta5)+"ms");

        //快速排序算法
        long starta6=System.currentTimeMillis();
        a6= QuickSort.quickSort(a6,0,a6.length-1);
        long enda6=System.currentTimeMillis();
        System.out.println("快速排序耗时："+(enda6-starta6)+"ms");

        //计数排序算法
        long starta7=System.currentTimeMillis();
        a7= CountingSort.countSort(a7);
        long enda7=System.currentTimeMillis();
        System.out.println("计数排序耗时："+(enda7-starta7)+"ms");

        //希尔排序算法
        long starta8=System.currentTimeMillis();
        a8= ShellsSort.shellsSort(a8);
        long enda8=System.currentTimeMillis();
        System.out.println("希尔排序耗时："+(enda8-starta8)+"ms");

        //桶排序算法
        long starta9=System.currentTimeMillis();
        a9= BucketSort.basket(a9);
        long enda9=System.currentTimeMillis();
        System.out.println("桶排序耗时："+(enda9-starta9)+"ms");

        //基数排序算法
        long starta10=System.currentTimeMillis();
        a10= RadixSort.sort(a10,6);
        long enda10=System.currentTimeMillis();
        System.out.println("基数排序耗时："+(enda10-starta10)+"ms");

//        ArrayHelper.printLine(a1);
//        System.out.println();
//        ArrayHelper.printLine(a2);
//        System.out.println();
//        ArrayHelper.printLine(a3);
//        System.out.println();
//        ArrayHelper.printLine(a4);
//        System.out.println();
//        ArrayHelper.printLine(a5);
//        System.out.println();
//        ArrayHelper.printLine(a6);
//        System.out.println();
//        ArrayHelper.printLine(a7);
//        System.out.println();
//        ArrayHelper.printLine(a8);
//        System.out.println();
//        ArrayHelper.printLine(a9);
//        System.out.println();
//        ArrayHelper.printLine(a10);

        System.gc();

    }
}
