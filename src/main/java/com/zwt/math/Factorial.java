package com.zwt.math;

/**
 * @Author: zwt
 * @Description: 求一个正整数的阶乘
 * @Name: Factorial
 * @Date: 2018/6/5 下午4:40
 * @Version: 1.0
 */
public class Factorial {
    //阶乘回调
    private static int factCallback(int num){
        if(num<0){
           System.out.println("输入错误");
           return -1;
        }
        if(num==0){
           return 1;
        }else{
            return num*factCallback(num-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("6的阶乘为："+factCallback(6));
    }
}
