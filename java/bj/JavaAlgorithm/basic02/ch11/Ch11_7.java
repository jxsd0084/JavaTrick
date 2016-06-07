package bj.JavaAlgorithm.basic02.ch11;

import java.util.Scanner;

public class Ch11_7 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int num,i,max,min,sum,avg;
		max=0; /*先假设当前的最大值max为0*/
		min=100; /*先假设当前的最小值min为100*/
		sum=0; /*将求累加和变量的初值置为0*/
		for(i=1;i<=10;i++)
		{
			System.out.print("请第"+i+"评委输入分数： ");
			num=in.nextInt(); /*输入评委的评分*/
			sum+=num; /*计算总分*/
			if(num>max)max=num; /*通过比较筛选出其中的最高分*/
			if(num<min)min=num; /*通过比较筛选出其中的最低分*/
		}
		System.out.printf("去掉一个最高分:%d \n去掉一个最低分:%d ",max,min);
		avg=(sum-max-min)/8;
		System.out.printf("\n平均得分:%d ",avg); /*输出结果*/
		}

}
