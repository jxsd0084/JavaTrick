package bj.JavaAlgorithm.basic02.ch06;

import java.util.Scanner;


/*
  图解java数据结构
*/
public class Ch6_1 
{
	static int gcd2(int a,int b)
	{
		if(a%b==0)
			return b;
		else
			return gcd2(b,a%b);
	}
	
	
	/*自定义函数求两数的最大公约数*/
	static int gcd(int a,int b)   
	{
		int  temp;         
		
		/*设置中间变量进行两数交换，大数放到a里，小数放到b里*/
		if(a<b)             
		{
			temp=a;
			a=b;
			b=temp;
		} 
		while(b!=0)           /*通过循环求两数的余数，直到余数为0*/
	    {
			temp=a%b;
			a=b;              /*变量数值交换*/
			b=temp;
	    }
		return a;            /*返回最大公约数到调用函数处*/ 
	}

	public static void main(String[] args) 
	{	
		Scanner in=new Scanner(System.in);
		int m,n,t1;  
		 
		System.out.print("请输入第一个整数：");
		m=in.nextInt();		 /*通过终端输入两个数*/
		System.out.print("请输入第二个整数："); 
		n=in.nextInt();
		
		//调用最大公约数方法
//		t1=gcd(m,n);                    
		t1=gcd2(m,n);  
		
		System.out.print("最大公约数： "+t1);  /*输出最大公约数*/
		
	}

}
