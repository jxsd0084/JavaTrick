package bj.JavaAlgorithm.basic02.ch04;

public class Ch4_7
{
	public static void main(String[] args) 
	{
		double t,m; 
		int j,n;
		int x;//x为0，代表是素数，为1，代表不是素数
		int count;//计数器
		count=0;
		t=2;
		
		for(n=2;n<=50;n++)
		{
			t=t*2; /* 累乘量 t 为 2^n */
			m=t-1;
			x=0;
			for(j=3;j<Math.sqrt(m)+1;j+=2) /* 试商法判别 m是否素数 */
				if(m%j==0)
				{
					x=1;
					break;
				}
			if(x==0) /* 输出所求得的素数 */
			{
				count=count+1;
				System.out.printf(" 2^%d-1=%.0f \n",n,m);
			}
		}
		
		System.out.printf(" 指数 n 于[2,50]中梅森尼数共有%d 个。",count);
	}
}
