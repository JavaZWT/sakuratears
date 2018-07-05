package com.zwt.math;

/**
 * @Author: zwt
 * @Description: 质数
 * @Name: PrimeNumber
 * @Date: 2018/6/5 上午11:24
 * @Version: 1.0
 */
//求1-10000内的所有质数
public class PrimeNumber {

    //判断一个数是不是素数
    private static boolean assertNum(int num){
        if(num<=1){
            return false;
        }
        if(num==2){
            return true;
        }
        for(int i=2;i<num;i++){
            if(num%i==0){
              return false;
            }
        }
        return true;
    }

    //Test
    public static void main(String[] args) {
        for(int i=1;i<10000;i++){
            if(assertNum(i)){
                System.out.println(i+"是素数");
            }
        }
    }
}
