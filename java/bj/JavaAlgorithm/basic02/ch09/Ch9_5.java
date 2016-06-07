package bj.JavaAlgorithm.basic02.ch09;

import java.util.Scanner;

public class Ch9_5 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.print("请输入一个数（至少2位）：");
		int num=in.nextInt();
		
		int length=getLength(num);//求数的长度
		
		int reverse=getReverse(num,length);//求数的反序数
		
		if(num==reverse)//判断本身与反序数是否相等，
			System.out.print(num+"是回文数");
		else
			System.out.print(num+"不是回文数");
			

	}

	/*求反序数*/
	private static int getReverse(int num, int length) 
	{
		int i;
		int tmp;
		int sum=0;
		
		/*根据数字长度，从后往前循环处理每一位*/
		for(i=1;i<=length;i++)
		{
			tmp=num%10;//取当前数的最后一位数字
			//调用10的次方方法，求反序数的权重，累加
			sum=sum+tmp*pow(length-i);
			num=num/10;//删除最后一位
		}
		return sum;
	}

	/*求10的次方*/
	private static int pow(int n) 
	{
		int i;
		int s=1;
		for(i=0;i<n;i++)
		{
			s=s*10;//不停的乘以10
		}
		return s;
	}

	/*求数字num的长度*/
	private static int getLength(int num) 
	{
		int count=0;
		/*每次从数字尾部取出一个数，进行判断*/
		while(num!=0)
		{
			count++;
			num=num/10;//截断尾部最后一位
		}
		return count;
	}

}
