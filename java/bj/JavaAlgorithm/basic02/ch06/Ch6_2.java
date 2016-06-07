package bj.JavaAlgorithm.basic02.ch06;

import java.util.Scanner;


public class Ch6_2 
{
	//求数组最小元素的下标
	public static int minIndex(int[] num)
	{
		int min,index;
		index=0;
		min=num[0];
		for(int i=1;i<3;i++)
			if(num[i]<min)
				{
					min=num[i];
					index=i;
				}
		return index;
	}
	
	//判断数组元素是否全部相等
	public static boolean allSame(int[] num)
	{
		boolean flag=false;
		int count=0;
		for(int i=0;i<2;i++)
		{
			if(num[i]==num[i+1])
				count++;
		}
		if(count==2)
			flag=true;
		return flag;
		
	}
	
	//求最小公倍数
	public static int lcd(int[] num)
	{
		int t1;
		int t2;
		int t3;
		int index;
		
		//保存数组元素初始值
		t1=num[0];
		t2=num[1];
		t3=num[2];
		
		while(!allSame(num))
		{
			for(int i=0;i<3;i++)
				System.out.print(num[i]+" ");
			System.out.print("\n");
			
			index=minIndex(num);//找出数组中最小元素的下标
			switch(index)//根据小标，加初始值
			{
				case 0:
					num[0]=num[0]+t1;
					break;
				case 1:
					num[1]=num[1]+t2;
					break;
				case 2:
					num[2]=num[2]+t3;
					break;
			}
		}
		
		for(int i=0;i<3;i++)
			System.out.print(num[i]+" ");
		System.out.print("\n");
		
		return num[0];
	}
	
	
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int num[]=new int[3];
		System.out.println("请输入数");
		for(int i=0;i<3;i++)
		{
			System.out.print("请输入第"+(i+1)+"个数：");
			num[i]=in.nextInt();
		}
		
		//调用最小公倍数方法
		int lcd=lcd(num);
		
		System.out.print("最小公倍数："+lcd);


	}
}
