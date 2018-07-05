package com.zwt.math;

/**
 * @Author: zwt
 * @Description: 求1-999999内的所有对称数  （12321，123321）
 * @Name: SymmetryNumber
 * @Date: 2018/6/5 下午6:52
 * @Version: 1.0
 */
public class SymmetryNumber {
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

    //判断是不是对称数
    private static boolean assertNum(int num){
        int length=getNumDigit(num);
        int array[]=getNumArray(num,length);
        for(int i=0;i<length/2;i++){
            if(array[i]!=array[length-1-i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for(int i=1;i<=999999;i++){
            if(assertNum(i)){
                System.out.println(i+"是对称数");
            }
        }
    }
}
