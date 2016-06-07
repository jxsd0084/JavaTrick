package bj.JavaAlgorithm.basic02.ch06;

import java.util.Scanner;

public class Ch6_5 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int  a,b,c;
		String go;
		do
		{
			System.out.printf("请输入一个分数(a/b)：");
			String s=in.next();
			int index=s.indexOf('/');
			a=Integer.parseInt(s.substring(0, index));
			b=Integer.parseInt(s.substring(index+1)); /*输入分子a和分母b*/
			System.out.printf("它可被分解为：");
			while(true)
			{
				if(b%a!=0) /*若分子不能整除分母*/
					c=b/a+1; /*则分解出一个分母为b/a+1的埃及分数*/
				else
				{
					c=b/a;
					a=1;
				} /*否则，输出化简后的真分数(埃及分数)*/
				if(a==1)
				{
					System.out.printf("1/%d\n",c);
					break; /*a为1标志结束*/
				}
				else
					System.out.printf("1/%d + ",c);
				
				a=a*c-b; /*求出余数的分子*/
				b=b*c; /*求出余数的分母*/

			}
			System.out.print("\n继续吗（y/n）？");
			go=in.next();
		}while(go.equals("y"));
		System.out.print("\n程序结束。");
	}
}
