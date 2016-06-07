package bj.JavaAlgorithm.basic02.ch02;

import java.util.Scanner;


public class ch2_4 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,max,min,sum;
		int x[]=new int[10];
//		max=-32768;
//		min=32767;
		max=0;
		min=100;
		sum=0;
		for(i=0;i<10;i++){
			System.out.print("请输入第"+(i+1)+"分数：");
			Scanner input=new Scanner(System.in);
			x[i]=input.nextInt();
			sum=sum+x[i];
			if(x[i]>max)max=x[i];
			if(x[i]<min)min=x[i];
		}
		System.out.println("去掉一个最高分和一个最低分："+max+"、"+min);
		System.out.println("平均分："+(sum-max-min)/8);
	}

}
