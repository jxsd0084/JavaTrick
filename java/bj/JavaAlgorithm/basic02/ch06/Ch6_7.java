package bj.JavaAlgorithm.basic02.ch06;

public class Ch6_7
{
	public static void main(String[] args) 
	{
		int n,number=20;
		float a=2,b=1,t,s=0;
		for(n=1;n<=number;n++)
		{
			s=s+a/b;
			t=a;
			a=a+b;
			b=t;
		}
		System.out.printf("和是： %9.6f\n",s);
	}
}
