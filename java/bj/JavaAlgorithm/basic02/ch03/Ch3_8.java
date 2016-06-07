package bj.JavaAlgorithm.basic02.ch03;

public class Ch3_8
{
	
	public static void fanXu(int n)
	{
		int i,j,k;
		i=n/100;
		j=n/10%10;
		k=n%10;
		
		int fx=k*100+j*10+i;
		
		if(n*fx==280021)
		{
			System.out.println(i+""+j+""+k);
		}
	}

	public static void main(String[] args) 
	{
//		for(int i=1;i<10;i++)//方法二
//	        for(int j=i+1;j<10;j++)
//	        	for(int k=j+1;k<10;k++)
//	        		if((i*100+j*10+k)*(k*100+10*j+i)==280021)
//	        			System.out.println(i+""+j+""+k);
		int i;
		System.out.println("要找的数如下：");
		for(i=101;i<=999;i++)
		{
			fanXu(i);
		}

	}

}
