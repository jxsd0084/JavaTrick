package bj.JavaAlgorithm.basic02.ch07;

import java.util.Scanner;

public class Ch7_5 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int i,j,h,k,m,u;
		int c[]=new int[100];//保存每行的项数
		double d,n,t;
		double f[]=new double[1000];//保存数列项
		
		System.out.printf("计算小于n的项数，请指定n: ");
		n=in.nextDouble();
		System.out.printf("输出序列的第m项，请指定m: ");
		m=in.nextInt();
		
		k=1;
		t=1.0;
		i=1;
		c[0]=1;//下标代表x+y的值，保存当前行的项数
		f[1]=1.0;
		
		while(true)
		{
			u=0;//是否继续递推标志，为1，继续，为0，退出
			
			//第i行各项为前一行各项乘2
		    for(j=0;j<=i-1;j++)
		    {
		    	h=c[i-1]+j;				//h，代表第i行第j个元素在f[]数组中的索引
		    	if(f[h]*2<n && f[h]>0)   //条件满足，加入数组
		        {
		    		k++;				//计数器加1
		    		f[k]=f[h]*2;		//第i行项为前一行项乘2
		    		u=1;
		    		if(j==0)
		    			c[i]=k;    		// 该行项数赋给c(i)
		        }
		    	else break;
		    }
		    t=t*3;                 		// 最后一项为3的幂
		    if(t<n && t>0)				//条件满足，加入数组	
		    {
		    	k++;
		    	f[k]=t;					//该行的最后一项单独添加
		    }        
		    if(u==0)
		    	break;
		    i++;
		}
		
		for(i=1;i<k;i++)        		// 冒泡排序
			for(j=i+1;j<=k;j++)
				if(f[i]>f[j])
		        {
					d=f[i];
					f[i]=f[j];
					f[j]=d;
				}
		
		System.out.printf("幂序列中小于%.0f的项数为：%d\n",n,k);
		if(m<=k)
			System.out.printf("从小到大排序的第%d项为：%.0f\n",m,f[m]);
		else
		   	System.out.printf("所输入的m大于序列的项数！\n");
	}
}
