package bj.JavaAlgorithm.basic02.ch04;

public class Ch4_6
{
	public static void main(String[] args) 
	{
		System.out.println("1000以内的平方回文素数如下：");
		for(int i = 2;i <= 1000;i++)
		{
			if(prime(i)==1&&pa(i*i)==1)
			{
				System.out.println(i+"*"+i+"="+i*i);
			}
		}
		System.out.printf("\n");
	}

	static int prime(int a)
	{
		for(int i = 2;i <= Math.sqrt(a) ;i++)
		{
			if(a%i==0)
				return 0;
		}
		return 1;
	}

	static String trans(int bk)//数字转换成字符串
	{
		int a = bk;
		String res = "";
		while(a!=0)
		{
			int b = a%10; 
			res = b + res;
			a = a/10;
		}
		return res;
	}
	
	static int pa(int a)
	{
		String str = trans(a);
		int ls = str.length();
		for(int i = 0;i < ls;i++)
		{
			if(str.codePointAt(i)!=str.codePointAt(ls - 1 - i))
			{
				return 0;
			}
		}
		return 1;
	}
}
