package bj.JavaAlgorithm.basic02.ch06;

import java.util.Scanner;

public class Ch6_6 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		
		int remainder[]=new int[101]; //remainder:存放余数对应的商的位数
		int quotient[]=new int[101]; // quotient:依次存放商的每一位
		int m,n,i,j;
		
		System.out.printf("请输入一个分数(A/B)(0<A<B<=100)：");
		String s=in.next();
		
		/*解析出被除数和除数*/
		int index=s.indexOf('/');
		m=Integer.parseInt(s.substring(0, index));
		n=Integer.parseInt(s.substring(index+1)); 
		 
		System.out.printf("%d/%d 的精确值：0.",m,n);
		for(i=1;i<=100;i++) /*i: 商的位数*/
		{
			/*m:除的余数， remainder[m]:该余数对应的商的位数*/
			remainder[m]=i; 
			m*=10; //余数扩大10位
			quotient[i]=m/n; //商保存下来
			m=m%n; //求余数
			
			/*余数为0 则表示是有限小数*/
			if(m==0) 
			{
				for(j=1;j<=1;j++)
					System.out.printf("%d",quotient[j]); /*输出商*/
				break; /*退出循环*/
			}
			
			/*若该余数对应的位在前面已经出现过*/
			if(remainder[m]!=0) 
			{
				for(j=1;j<=i;j++)
					System.out.printf("%d",quotient[j]); //则输出循环小数
				
				/*输出循环节的位置*/
				System.out.printf("\n是一个无限循环数，循环从 小数点后第 %d 位开始，到 %d 位。\n",remainder[m],i);
				
				break; //退出
			}
		}
	}
}
