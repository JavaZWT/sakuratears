package com.zwt.search;

/**
 * @Author: Little Fish
 * @Description: 二分查找法，查找数组必须是有序的。
 * @Name: BinarySearch.java
 * @Date: 2018年7月31日 下午5:47:26
 * @Version: 1.0
 */
public class BinarySearch {
	public static int binarySearch(int[] srcArray,int des) {
		//定义最小、最大索引
		int low=0;
		int high=srcArray.length-1;
		while(low<=high) {
			//计算中间值
			int middle=(high+low)>>>1;
			//值相等返回结果
			if(des==srcArray[middle]) {
				return middle;
			//比中间值小，在左边，把high值重新赋值为middle-1
			}else if(des<srcArray[middle]) {
				high=middle-1;
			//比中间值大，在右边，把low值重新赋值为middle-1
			}else {
				low=middle+1;
			}
		}
		//查不到返回-1
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a=new int[]{1,2,3,4,7,9,10};
		int index=binarySearch(a,9);
		System.out.println(index);
	}
}
