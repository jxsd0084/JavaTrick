package bj.JavaAlgorithm.basic02.ch03;

/*
  图解java数据结构
*/
public class Ch3_1
{

	public static void main(String[] args) 
	{
		int i,a,b,c;
		int count = 0;
		for(i=100;i<=999;i++)
		{
			a = i/100;
			b = i/10%10;
			c = i%10;
			if(a!=b && a!=c && b!=c)
			{ 
				System.out.print(i+" ");
	            count++; 
	            if(count%10==0)
				{
					System.out.print("\n");
				}
	                       
			}
		}
		System.out.println("\n一共有 "+count+" 个这样的数字");

	}

}
