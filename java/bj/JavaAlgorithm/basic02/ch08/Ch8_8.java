package bj.JavaAlgorithm.basic02.ch08;

import java.util.Scanner;

public class Ch8_8 
{
	/*将数n拆分成不大于m的划分个数*/
	static int q(int n,int m)
	{
	    /*无效数字*/
		if(n<1 || m<1)
			return 0;
		
		 /*1、当数n不大于1时，任何正整数n只有一种划分方式，即 n = 1+1+1+..+1 (n个1相加)。*/
	    if(n==1 || m==1)
	        return 1;
	    
	    /*2、数m大于n，没有意义，最大只能到自身，拆分不允许出现减号。*/
	    if(m>n)
	        return q(n,n);
	    
	    /*3、数n的划分由自身和q(n,n-1)划分组成。*/
	    if(n==m)
	        return q(n,m-1) + 1;
	    
	    /*4、数n的划分由 q(n,m-1)划分和q(n-m,m)划分组成*/
	    return q(n,m-1) + q(n-m,m);
	}
	
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
	    int a,b;
	    System.out.print("请输入待拆的数：");
	    a=in.nextInt();
    
	    System.out.print("请输入能拆出的最大值：");
	    b=in.nextInt();
	    System.out.printf("拆分方法：%d\n",q(a,b));
	}
}
