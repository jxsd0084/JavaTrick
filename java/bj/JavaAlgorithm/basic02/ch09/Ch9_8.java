package bj.JavaAlgorithm.basic02.ch09;

import java.util.Scanner;

public class Ch9_8 
{
	public static void main(String[] args) 
	{
		int a,b,c,d;
		Scanner in=new Scanner(System.in);
		System.out.print("请输入验证范围，即多少以内的数：");
		int max=in.nextInt(); /*输入整数*/
		
		for(a=1;a<=max;a++)
		{
			b=a*a*a; /*求整数的三次方*/
			System.out.printf("%d的三次方 = %d = ",a,b);
		
			/*输出数列，首项为a*a-a+1,等差值为2*/
			for(d=0,c=0;c<a;c++) 
			{
				/*求数列的前a项的和*/
				d+=a*a-a+1+c*2; 
				/*如果是第一项，不用+号*/
				System.out.printf(c==0?"%d":"+%d",a*a-a+1+c*2);
			}
			if(d==b)
				System.out.print(" 验证通过\n"); //若条件满足则验证通过
			else 
				System.out.printf(" 验证失败\n"); //否则失败
		}
	}


}
