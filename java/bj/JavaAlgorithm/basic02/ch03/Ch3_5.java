package bj.JavaAlgorithm.basic02.ch03;

import java.util.Arrays;


public class Ch3_5 
{

	public static void main(String[] args) 
	{
		for(int input=1000;input<=9999;input++)
		{
			System.out.println("\n"+input+" 验证如下：");
//			
//			if(input==10000)
//				break;
//			else if(input%1111==0)
			if(input%1111==0)
			{
			   System.out.println("数字全部相同!");
			   continue;
			}
			else
		   	{
			   int flag=0; //计算次数
			   int input2=input;
			   do
			   {
				   input2=he(fen(input2));   //调用he()与fen()函数
				   flag++;
			   }while(input2!=6174);
		    
			   if(input2==6174)
			   {
				   System.out.println("计算了"+flag+"次，"+"命题为真!");
		     
			   }
			   else
				   System.out.println("命题为假!");
		   }
		}   
		System.out.println("程序结束!");
	}
		 
	public static int[] fen(int input)  // 拆分4位数
	{
		int a[]=new int [4];
		a[0]=input/1000; //千位数
		input=input%1000;
		a[1]=input/100;  //百位数
		input=input%100;
		a[2]=input/10;   //十位数
		input=input%10;
		a[3]=input;   // 个位数
		Arrays.sort(a);  //从小到大排序
		return a;  
	}
		 
	public static int he(int a[])  //合并4位数，重新组成最大和最小的四位数
	{
		Arrays.sort(a);
		int max=a[3]*1000+a[2]*100+a[1]*10+a[0];   //最大的四位数
		int min=a[0]*1000+a[1]*100+a[2]*10+a[3];  //最小四位数
		System.out.println(max+"-"+min+"="+(max-min));
		return max-min;
	}
}
