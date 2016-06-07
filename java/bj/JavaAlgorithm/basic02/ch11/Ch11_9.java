package bj.JavaAlgorithm.basic02.ch11;

import java.util.Scanner;


public class Ch11_9 
{
	static final int MAXNUM=30;
	static int FalseCoin(int coin[],int low,int high)	//算法
	{
	    int i,sum1,sum2;
		int re=0;
		sum1=sum2=0;
	    if(low+1==high)//仅剩下两个硬币
	    {
	        if(coin[low]<coin[high]) //左边轻
			{
				re=low+1;//下标从0开始，加1
				return re;
			}
	        else 
			{
				re=high+1;
				return re;
			}
	    }
	    if((high-low+1)%2 == 0)				//n是偶数
	    {
	        for(i=low;i<=low+(high-low)/2;i++)
			{
	            sum1= sum1 + coin[i];       	//前半段和
			}
	        for(i=low+(high-low)/2+1;i<=high;i++)
			{
	            sum2 = sum2 + coin[i];       	//后半段和
			}
	        if(sum1>sum2) //前半段重，假币在后半段
			{
				re=FalseCoin(coin,low+(high-low)/2+1,high);//递归，在后半段中查询
				return re;
			}
	        else if(sum1<sum2)//后半段重，假币在前半段
			{
				re=FalseCoin(coin,low,low+(high-low)/2);//递归，在前半段中查询
				return re;
			}
			else
			{
			}
	    }
	    else   //n是奇数
	    {
	        for(i=low;i<=low+(high-low)/2-1;i++)
			{
	            sum1= sum1 + coin[i];       	//前半段和
			}
	        for(i=low+(high-low)/2+1;i<=high;i++)
			{
	            sum2 = sum2 + coin[i];       	//后半段和
			}
	        
	        if(sum1>sum2)   //前半段重，假币在后半段
			{
				re=FalseCoin(coin,low+(high-low)/2+1,high);//递归，在后半段中查询
	            return re;
			}
	        else if(sum1<sum2)//后半段重，假币在前半段
			{
				re=FalseCoin(coin,low,low+(high-low)/2-1);//递归，在前半段中查询
	            return re;
			}
			else	//前后一样重，假币在中间
			{
				re=low+(high-low)/2+1;//计算中间位置
				return re;
			}
	    }
		return re;
	}
	public static void main(String[] args) 
	{
		int[] coin=new int[MAXNUM];
		int i,n;
		int weizhi;
	    System.out.println("分治算法求解假银币问题！");
		System.out.print("请输入银币总的个数：");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();						//银币总的个数
		System.out.print("请输入银币的真假：");
		for(i=0;i<n;i++)
		{
			coin[i]=input.nextInt();			//输入银币的真假，1代表假币，2代表真币
		}
		weizhi=FalseCoin(coin,0,n-1);			//调用求假币方法，求解
	    System.out.println("在上述"+n+"个银币中，第"+weizhi+"个银币是假的！");
	}
}
