package bj.JavaAlgorithm.basic02.ch06;

import java.util.Scanner;

public class Ch6_3 
{
	public static int divisor (int a,int b)    /*自定义函数求两数的最大公约数*/
	{
		int  temp;          
		if(a<b)             
		{ 
			temp=a;
			a=b;
			b=temp;
		} 
		while(b!=0)           /*通过循环求两数的余数，直到余数为0*/
	    {
			temp=a%b;
			a=b;              /*变量数值交换*/
			b=temp;
	    }
		return a;            
	}
	
	public static int multiple (int a,int b)  /*自定义函数求两数的最小公倍数*/
	{
		int temp;
		temp=divisor(a,b);  /*再次调用自定义函数，求出最大公约数*/
		return  (a*b/temp); 
	}
	
	public static char tongFen(int fz1,int fm1,int fz2,int fm2)
	{
		char flag=' ';
		//调用求最小公倍数方法
		int gbs=multiple(fm1,fm2);
		//通分后的新的分子
		int xfz1=gbs/fm1*fz1;
		int xfz2=gbs/fm2*fz2;
		
		//打印出通分表达式
		System.out.println(fz1+"/"+fm1+" = "+xfz1+"/"+gbs);
		System.out.println(fz2+"/"+fm2+" = "+xfz2+"/"+gbs);
		
		//同分母比较大小，只要比较分子即可
		if(xfz1>xfz2)
			flag='>';
		else if(xfz1<xfz2)
			flag='<';
		else
			flag='=';
		
		return flag;
	}
		
	public static void main(String[] args) 
	{
		char flag=' ';
		Scanner in=new Scanner(System.in);
		//输入两个分数，用字符串接收
		System.out.print("请输入第一个分数：");
		String s1=in.next();
		System.out.print("请输入第二个分数：");
		String s2=in.next();
		
		//对字符串解析，分解出分子、分母
		int index=s1.indexOf('/');
		int fz1=Integer.parseInt(s1.substring(0, index));
		int fm1=Integer.parseInt(s1.substring(index+1));
		
		int index2=s2.indexOf('/');
		int fz2=Integer.parseInt(s2.substring(0, index));
		int fm2=Integer.parseInt(s2.substring(index+1));
		
		if(fz1==fz2)
		{
			System.out.println("同分子比较大小");
			if(fm1>fm2)
				flag='<';
			else if(fm1<fm2)
				flag='>';
			else
				flag='=';
				
		}else if(fm1==fm2)
		{
			System.out.println("同分母比较大小");
			if(fz1>fz2)
				flag='>';
			else if(fz1<fz2)
				flag='<';
			else
				flag='=';
		}else 
		{
			System.out.println("异分子、分母比较大小");
			flag=tongFen(fz1,fm1,fz2,fm2);
		}
		
		System.out.print("结果如下：\n"+s1+" "+flag+" "+s2);

	}

}
