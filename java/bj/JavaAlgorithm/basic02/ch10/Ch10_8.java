package bj.JavaAlgorithm.basic02.ch10;

public class Ch10_8
{
	static String name[]={"小明","弟弟","爸爸","妈妈","爷爷"};//过桥人
	static int time[] = {2,5,6,9,13};      //每个人过桥所需要的时间;
	
	//方案一 最快者将最慢的2个送过桥
	static void step1(int a,int b,int y,int z)
	{
		String pA=name[a];
		String pY=name[y];
		String pZ=name[z];
		int tY=time[y];
		int tA=time[a];
		int tZ=time[z];
		System.out.println(pA+"和"+pZ+"过桥，花费"+tZ+"分钟");
		System.out.println(pA+"回来，花费"+tA+"分钟");
		System.out.println(pA+"和"+pY+"过桥，花费"+tY+"分钟");
		System.out.println(pA+"回来，花费"+tA+"分钟");
	}
	//方案二 最快的2个将最慢的2个送过桥
	static void step2(int a,int b,int y,int z)
	{
		String pA=name[a];
		String pB=name[b];
		String pY=name[y];
		String pZ=name[z];
		int tB=time[b];
		int tA=time[a];
		int tZ=time[z];
		System.out.println(pA+"和"+pB+"过桥，花费"+tB+"分钟");
		System.out.println(pA+"回来，花费"+tA+"分钟");
		System.out.println(pY+"和"+pZ+"过桥，花费"+tZ+"分钟");
		System.out.println(pB+"回来，花费"+tB+"分钟");
	}
	
	//方案三  有3个人过桥
		static void step3(int a,int b,int c)
		{
			System.out.println(name[a]+"和"+name[b]+"过桥，花费"+time[b]+"分钟");
			System.out.println(name[a]+"回来，花费"+time[a]+"分钟");
			System.out.println(name[a]+"和"+name[c]+"过桥，花费"+time[c]+"分钟");
		}
	
		//方案四  有2个人过桥
		static void step4(int a)
		{
			System.out.println(name[0]+"和"+name[a]+"过桥，花费"+time[a]+"分钟");
		}
	
	public static void main(String[] args) 
	{
		int n=5;//人数
		int sum=0;
		int i;
		for(i=n-1;i>2;i=i-2)
		{
			//最快的2个将最慢的2个送过桥
			if(time[0]+time[1]+time[1]+time[i]<time[0]+time[0]+time[i-1]+time[i])
			{
				sum=sum+time[0]+time[1]+time[1]+time[i];
				step2(0,1,i-1,i);//输出详细过程
			}
			else//最快者将最慢的2个送过桥
			{
				sum=sum+time[0]+time[0]+time[i-1]+time[i];
				step1(0,1,i-1,i);//输出详细过程
			}
			
		}
		if(i==2)//三个人过桥
		{
			sum=sum+time[0]+time[1]+time[2];
			step3(0,1,2);//输出详细过程
		}
		else if(i==1)//二个人过桥
		{
			sum=sum+time[1];
			step4(1);//输出详细过程
		}
		else//一个人过桥，其实不存在
			sum=time[0];
		System.out.print("最短过桥时间为："+sum);
	}
}
