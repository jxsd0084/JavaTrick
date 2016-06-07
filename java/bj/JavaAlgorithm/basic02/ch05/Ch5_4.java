package bj.JavaAlgorithm.basic02.ch05;

import java.util.Scanner;


public class Ch5_4 
{

	/*
	 * 参数a，每位上的数字
	 * 参数length，数的长度
	 * 返回由length个a组成的数
	 */
	public static int getNum(int a,int length)
	{
		int v=0;
		int s=1;
		for(int i=0;i<length;i++)
		{
			v=v+a*s;
			s=s*10;
		}
		
		return v;
	}
	
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.print("请输入a的值：");
		int a=in.nextInt();
//		int w=a;//记录个位数，个位数一直保持不变
		System.out.print("请输入n的值：");
		int n=in.nextInt();
		int sum=0;
		
		for(int i=1;i<=n;i++)
		{
//			sum=sum+a;
//			a=a*10+w;
			sum=sum+getNum(a,i);
		}
		
		System.out.print("表达式的值："+sum);

	}

}
