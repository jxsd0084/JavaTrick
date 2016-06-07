package bj.JavaAlgorithm.basic02.ch08;

import java.util.Scanner;

/*
  图解java数据结构
*/
public class Ch8_1 
{	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个数：");
		int n=sc.nextInt();
		
		//判断是不是质数，如果是，就不用分解了，否则，分解。
		if(PrimeNum(n))
		{
			System.out.println("这是一个素数不需要分解！");
		}
		else
		{
			System.out.println("这个数可以分解为： ");
		    for(int i=2;i<=n;)
		    {
		    	if(n%i==0)
		    	{
		    		if(n/i==1)//最后一个质因数判断
		    		{
		    			System.out.print(i);
		    			break;
		    		}
		    		else
		    		{	System.out.print(i+"*");
		            	n=n/i;
		    		}
		        }
		    	else
		    	{
		    		i++;
		        }
		    }    
		}
	}
	
	/*判断是不是质数*/
	public static  boolean PrimeNum(int a)
	{
		boolean flag=true;
		for(int j=2;j<=a/2;j++)
		{
			if(a%j==0)
			{
				flag=false;
		        break;
		    }
		}
		if(flag)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
