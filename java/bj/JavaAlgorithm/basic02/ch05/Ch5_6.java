package bj.JavaAlgorithm.basic02.ch05;

public class Ch5_6
{

	static int age(int n)
	{
		int c;
		if(n==1) 
			c=10;
		else 
			c=age(n-1)+2;
		return c;
	}

	public static void main(String[] args) 
	{
		System.out.print("第5个人的年龄："+age(5));
	}

}
