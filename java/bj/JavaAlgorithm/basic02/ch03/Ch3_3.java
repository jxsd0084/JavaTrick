package bj.JavaAlgorithm.basic02.ch03;

public class Ch3_3
{
	public static void main(String[] args) 
	{
		int i,j,sum;
		for(i=2;i<10000;i++)
		{
			sum=0;
			for(j=1;j<=i/2;j++)
			{
				if(i%j==0)
					sum=sum+j;
			}
			if(sum==i)
				printwanshu(i);
		}

	}
	
	public static void printwanshu(int n)
	{
	    int j ;
	    System.out.print(n+"的约数（自身除外）为：");
//	    while(i!=1)
//	    {
//	        i=n/2 ;
//	        if(n%2!=0)
//	        i++;
//	        System.out.print(i+" ");
//	        n=i ;
//	    }
	    for(j=1;j<=n/2;j++)                          //再次找出这个完数的因子
        {
            if(n%j==0)                                    //输出各个因子
            System.out.print(j+" ");
        }           
	    System.out.print("\n");
	}

}
