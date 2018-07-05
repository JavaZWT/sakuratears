package com.zwt.math;

/**
 * @Author: zwt
 * @Description:水仙花数
 * @Name: NarcissisticNumber
 * @Date: 2018/6/4 下午5:34
 * @Version: 1.0
 */
//水仙花数是指一个 n 位数（n≥3 ），它的每个位上的数字的 n 次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。
public class NarcissisticNumber {
    //获取传入数的位数
    private static int getNumDigit(int num){
        int count = 1;
        while ((num = num / 10) != 0) {
            count++;
        }
        return count;
    }
    //获取num位数数组
    private static int[] getNumArray(int num,int count){
        int[] numArray=new int[count];
        for(int i=count-1;i>=0;i--) {
            numArray[i]=(int) (num/(Math.pow(10,i))%10);
        }
        return numArray;
    }
    //判断数字是否符合要求
    private static boolean assertNum(int num){
        int digits=getNumDigit(num);
        if(digits<3){
            return false;
        }
        int[] array=getNumArray(num,digits);
        int testNum=0;
        for(int i=0;i<array.length;i++){
            testNum+=Math.pow(array[i],digits);
        }
        if(testNum==num){
            return true;
        }
        return false;
    }
    //Test
    public static void main(String[] args) {
        for(int i=0;i<9999999;i++) {
            if (assertNum(i)) {
                System.out.println(i + "是水仙花数");
            }
        }
    }
}
