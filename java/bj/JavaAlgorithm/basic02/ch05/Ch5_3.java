package bj.JavaAlgorithm.basic02.ch05;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Ch5_3 
{
	public static void main(String[] args) 
	{
		int count=0;
		int w[]=new int[5];
		int s[]=new int[5];
		Scanner in=new Scanner(System.in);
		System.out.print("请输入硬币种类：");
		int n=in.nextInt();
		
		for(int i=0;i<n;i++)
		{
			System.out.print("请输入面值：");
			w[i]=in.nextInt();
			System.out.print("请输入数量：");
			s[i]=in.nextInt();
		}
		
		//把已有的硬币按照从大到小的顺序存入a1中
		List a1=new ArrayList();
		for(int i=0;i<n;i++)
			for(int j=0;j<s[i];j++)
				a1.add(w[i]+"");
		
		System.out.print("\n请输入钱数：");
		int money=in.nextInt();
		
		//a2负责存储找的钱
		List a2=new ArrayList();
		for(int i=0;i<a1.size();i++)
		{
			if(money>=Integer.parseInt((String)a1.get(i)))
			{
				a2.add(a1.get(i));
				money=money-Integer.parseInt((String)a1.get(i));
				count++;
			}
				
		}
		
		System.out.println("至少要用："+count+"枚，用法如下：");
		
		int c[]=new int[n];
		for(int i=0;i<n;i++)
		{
			c[i]=Collections.frequency(a2, w[i]+"");
			System.out.println("面值 "+w[i]+"："+c[i]+"枚");
		}
	}
}
