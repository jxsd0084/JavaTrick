package bj.JavaAlgorithm.basic02.ch07;

/*
  图解java数据结构
*/
public class Ch7_1
{
	
	public static int fibonacci2(int n)
	{
		if(n==1||n==2)
			return 1;
		if(n>2)
		   return fibonacci2(n-2)+fibonacci2(n-1);
		return -1;
	}
	
	//求fibonacci数列的第n项
	public static int fibonacci(int n)
	{
		int f1=1;
		int f2=1;
		int f3=0;
		if(n==1)
			f3=f1;
		if(n==2)
			f3=f2;
		if(n>2)
			for(int i=3;i<=n;i++)
			{
				f3=f1+f2;
				f1=f2;
				f2=f3;
			}
		return f3;
	}

	public static void main(String[] args) 
	{
		int m=25,n;
		int fib[]=new int[m];
		for(n=1;n<m;n++)
			fib[n]=fibonacci(n);
		
		System.out.print("fibonacci数列前24项如下：\n");
		for(n=1;n<fib.length;n++)
			System.out.print(fib[n]+" ");
		System.out.println();

	}

}
