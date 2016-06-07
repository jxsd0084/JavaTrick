package bj.JavaAlgorithm.basic02.ch02;

import java.util.Scanner;

public class ch2_2_2 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int s;
		int sum=0;
		
		//salary存放分级标准
		int salary[]={0,500,2000,5000,20000,40000,60000,80000,100000};
		//rate存放分级税率
		int rate[]={5,10,15,20,25,30,35,40,45};
		
		System.out.print("请输入月收入：");
		s=in.nextInt();
		s=s-3500; //扣除基数
		
		int index=0;//记录级数
		//循环查找，属于哪一级，index记录下标
		for(int i=0;i<salary.length;i++)
		{
			if(s<salary[i])
			{
				index=i;
				break;
			}
		}
		
		System.out.println("级别："+index);
		//循环计算扣除累计数
		for(int i=0;i<index-1;i++)
		{
			sum=sum+(int)((salary[i+1]-salary[i])*rate[i]*0.01);
		}
		//计算最终税款
		sum=sum+(int)((s-salary[index-1])*rate[index-1]*0.01);
		System.out.print("交税总额："+sum);

	}

}
