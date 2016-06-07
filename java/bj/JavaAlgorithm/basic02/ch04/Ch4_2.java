package bj.JavaAlgorithm.basic02.ch04;

public class Ch4_2
{
	public static void main(String[] args) 
	{
		int i,j;
		int flag,n=0;
		int a[]=new int[100];
		 
		for(i=2;i<=100;i++)
		{ 
			flag=1;
			for(j=2;j<i;j++)
			{
		      if(i%j==0) 
		      {	  
		    	  flag=0;//素数吧标准，赋值为0，不是素数
		    	  break;
		      }
		   }
		   if(flag==1)
		   {
			   a[n]=i;//素数存入数组中
			   n++;
		   }
		}
		
		System.out.println("100以内的孪生素数如下：");
		for(i=0;i<n-1;i++)
		{
//			for(j=i+1;j<n;j++)
//			{
				if(a[i+1]-a[i]==2)
				{   
					System.out.print(a[i]+" ");
					System.out.print(a[i+1]+" ");
//					if(a[j+1]-a[j]==2)
//					{
//						System.out.print(a[j+1]+" ");
////						i=3;//关键代码，解释
//					}
					System.out.print("\n");
				}
//			}
			
		}
	}
}
