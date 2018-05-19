package com.zwt.demo.sort;

import java.util.Arrays;

/**
 * @Author: zwt
 * @Description: 排序算法
 * @Name: Demo_Sort
 * @Date: 2018/4/22 上午1:15
 * @Version: 1.0
 */
public class Demo_Sort {
    /**
     * @Author: zwt
     * @Description: 插入排序法
     * @Name: insertSort
     * @Date: 2018/4/22 上午1:22
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     * @说明： 插入排序法最重要的机制就是从头开始循环比较，后面比前面大，位置不变，否则调换位置
     *        int [] a=[1,5,4,3,2]
     *        对于a数组，可以看出第一次i循环结果为[1,5,4,3,2],第一次i循环比较a[0],a[1]大小,j循环了一次；
     *        第二次i循环，j会循环两次，此时比较a[2],a[1]大小，a[2]<a[1],交换位置，
     *        新的a，继续比较新的a[1],a[0],a[1]>a[0],位置不变。结果应为[1,4,5,3,2];
     *        以此类推。
     *        由于类似于将后面的元素插入到前面，又称插入排序法。
     */
    public static int[] insertSort(int[] a){
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

    /**
     * @Author: zwt
     * @Description: 冒泡排序法
     * @Name: bubbleSort
     * @Date: 2018/4/22 下午5:03
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     * @说明： 冒泡排序法，很容易看出他是在拿循环第一个元素和后面的值依次比较。
     *      int [] a=[1,5,4,3,2]
     *      对于a数组，第一遍i循环，j循环4次，分别拿a[j]与a[0]比较，最终保留最小的a[j]值。结果为[1,5,4,3,2]
     *      第二次i循环时，j循环3次，留下最小值，数组变为[1,2,5,4,3]
     *      以此类推。
     *      可以看出像是把最小元素冒泡一样提出来，故称冒泡排序法。
     */
    public static int[] bubbleSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                   int temp=a[i];
                   a[i]=a[j];
                   a[j]=temp;
                }
            }
        }
        return a;
    }

    /**
     * @Author: zwt
     * @Description: 直接选择排序法
     * @Name: selectSort
     * @Date: 2018/4/22 下午5:22
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     * @说明： 直接选择排序法，就是遍历整个数组，选出最小值，放在第i位，依次类推
     *          int [] a=[1,5,4,3,2]
     *          第一次i循环，假定a[0]最小，循环一遍数组，拿到最小值，交换，结果位[1,5,4,3,2]
     *          第二次i循环,假定a[1]最小，循环一遍数组[5,4,3,2],拿到最小值，交换，结果为[1,2,4,3,5]
     *          以此类推。
     */
    public static int[] selectSort(int[] a){
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

    /**
     * @Author: zwt
     * @Description: jdk自带排序法排序
     * @Name: listSort
     * @Date: 2018/4/22 下午5:40
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     */
    public static int[] listSort(int[] a){
        Arrays.sort(a);
        return a;
    }

    /**
     * @Author: zwt
     * @Description: 并行排序
     * @Name: parallelSort
     * @Date: 2018/4/22 下午6:56
     * @Params: [a]
     * @Return: int[]
     * @Version: 1.0
     * @since jdk1.8
     */
    public static int[] parallelSort(int[] a){
        Arrays.parallelSort(a);
        return a;
    }

    //@Test
    public static void main(String[] args) {
        //生成一个100000个数据的int数组
        int[] a=new int[100000];
        for (int i=0;i<100000;i++){
            a[i]=(int)(Math.random()*100000);
        }

        //创建四个数组用于测试，否则会冲突，引用传递
        int[] a1= a.clone();
        int[] a2= a.clone();
        int[] a3= a.clone();
        int[] a4= a.clone();
        int[] a5= a.clone();

        //插入排序法
        long starta1=System.currentTimeMillis();
        a1= Demo_Sort.insertSort(a1);
        long enda1=System.currentTimeMillis();
        System.out.println("插入排序法耗时："+(enda1-starta1)+"ms");

        //冒泡排序法
        long starta2=System.currentTimeMillis();
        a2= Demo_Sort.bubbleSort(a2);
        long enda2=System.currentTimeMillis();
        System.out.println("冒泡排序法耗时："+(enda2-starta2)+"ms");

        //直接选择排序法
        long starta3=System.currentTimeMillis();
        a3= Demo_Sort.selectSort(a3);
        long enda3=System.currentTimeMillis();
        System.out.println("直接选择排序法耗时："+(enda3-starta3)+"ms");

        //jdk自带方法
        long starta4=System.currentTimeMillis();
        a4= Demo_Sort.listSort(a4);
        long enda4=System.currentTimeMillis();
        System.out.println("jdk自带排序法耗时："+(enda4-starta4)+"ms");

        //jdk自带并行方法
        long starta5=System.currentTimeMillis();
        a5= Demo_Sort.listSort(a5);
        long enda5=System.currentTimeMillis();
        System.out.println("jdk自带并行排序法耗时："+(enda5-starta5)+"ms");
    }
}
