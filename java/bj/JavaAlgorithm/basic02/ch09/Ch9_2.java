package bj.JavaAlgorithm.basic02.ch09;

import java.util.Scanner;

public class Ch9_2 
{
	/*对n进行角谷猜想验证*/
	static void proveJiaoGu(int n)
	{
	    int count=1;
	    while(n!=1 && count<=1000)
	    {
	    	/*上限设为1000*/
	    	if(n%2==0)   /*n为偶数*/
	    	{
	    		System.out.printf("%d/2=%d\n",n,n/2);
	    		n = n/2;
	    	}
	    	else
	    	{
	    		System.out.printf("%d*3+1=%d\n",n,n*3+1); /*n为奇数*/
	    		n=n*3+1;
	    	}
	    	count++;
	    }
	    
	    if(count<1000 && n==1)
	        System.out.print("这个数满足角谷猜想\n");
	}

	public static void main(String[] args) 
	{
		int n;
		Scanner in=new Scanner(System.in);
	    System.out.print("请输入一个数:");
	    n=in.nextInt();
	    System.out.print("验证过程如下：\n");
	    
	    proveJiaoGu(n);//调用角谷猜想方法进行验证
	    

	}

}
