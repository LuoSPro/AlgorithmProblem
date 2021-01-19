package com.test.test1;

import java.util.Scanner;//获取用户的输入

public class Test01 {
	private int[] data;
	
	public Test01() {
	}

	public Test01(int[] data){
		this.data = data;
	}
	
	//求最大值
	public int getMax() {//传入三个数到这个方法中
		int max = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max){
				max = data[i];
			}
		}
		return max;
	}
	//求最小值
	public int gatMin() {
		int min = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i] < min){
				min = data[i];
			}
		}
		return min;
	}
	//求平均值
	public float getAvg() {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum = sum + data[i];
		}
		return (float) (1.0*sum/data.length);
	}

	public static void main(String[] args) {
		//system.in作为参数传递给Scanner的构造函数，使Scanner用键盘作为输入
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一组数据，并用逗号分隔，系统将为您计算最大最小值及平均值：");
		//用字符串接收
		String input = sc.next();
		//划分数据
		String[] arr = input.split(",");
		int[] data = new int[arr.length];
		//转化
		for (int i = 0; i < arr.length; i++) {
			//将String转化为int类型的数据
			data[i] = Integer.parseInt(arr[i]);
		}
		//数组
		Test01 x = new Test01(data);
		int max = x.getMax();
		int min = x.gatMin();
		float avg = x.getAvg();
		
		System.out.printf("这组数据中最大值为：%d，最小值为：%d，平均值为：%f",max,min,avg);
	}
}
