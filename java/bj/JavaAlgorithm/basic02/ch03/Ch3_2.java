package bj.JavaAlgorithm.basic02.ch03;

public class Ch3_2
{
	public static int scf(int n)
	{
		int m=1;
		for(int i=0;i<3;i++)
		{
			m=m*n;
		}
		return m;
	}

	public static void main(String[] args) 
	{
		int i,a,b,c;
		int count = 0;

		for(i=100;i<=999;i++)
		{
			a = i/100;
			b = i%100/10;
			c = i%10;
			
//			if(a*a*a+b*b*b+c*c*c==i)
			
			if(scf(a)+scf(b)+scf(c)==i)
			{ 
				System.out.println(i+"是水仙花数。");
	        	                       
			}
		}

	}

}
