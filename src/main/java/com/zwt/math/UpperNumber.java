package com.zwt.math;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: UpperNumber
 * @Date: 2018/5/31 下午4:21
 * @Version: 1.0
 * 请问1到1000之前，有多少升数字？
    升数字就是从左向右读，数值是依次上升的即可，比如123，1256，1389，但是1123，165就不是。请提供明确的实现思路，或者提供写好的代码
 */
public class UpperNumber {

    /**
     * @Author: zwt
     * @Description: 获取一个int数的位数
     * @Name: getNumDigit
     * @Date: 2018/5/31 下午4:39
     * @Params: [num]
     * @Return: int
     * @Version: 1.0
     */
    private static int getNumDigit(int num){
        int count = 1;
        while ((num = num / 10) != 0) {
            count++;
        }
        return count;
    }

    /**
     * @Author: zwt
     * @Description: 将num拆分成int数组
     * @Name: getNumArray
     * @Date: 2018/5/31 下午4:42
     * @Params: [num, count]
     * @Return: int[]
     * @Version: 1.0
     */
    private static int[] getNumArray(int num,int count){
        int[] numArray=new int[count];
        for(int i=count-1;i>=0;i--) {
            numArray[i]=(int) (num/(Math.pow(10,i))%10);
        }
        return numArray;
    }

    /**
     * @Author: zwt
     * @Description: 判断是不是有序数组，从小到大
     * @Name: isRightArray
     * @Date: 2018/5/31 下午4:57
     * @Params: []
     * @Return: boolean
     * @Version: 1.0
     */
    private static boolean isRightArray(int[] array){
        boolean flag=true;
        for(int i=0;i<array.length-1;i++) {
            if(array[i]>array[i+1]) {
            }else {
                flag=false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        for(int i=0;i<100000;i++){
            if(i>=10){
                boolean flag=isRightArray(getNumArray(i,getNumDigit(i)));
                if(flag){
                    System.out.println(i+"为升数字");
                }
            }
        }
    }

}
