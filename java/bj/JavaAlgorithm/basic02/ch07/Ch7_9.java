package bj.JavaAlgorithm.basic02.ch07;

import java.util.Scanner;

public class Ch7_9 
{
	final static int N=30;
	static long f[] = new long[N]; 
	
	/*斐波那契数组*/   
    public static void fibonacciArray(int n)
    {    
         
        f[0]=1;    
        f[1]=1;    
        for(int i =2;i < n;i++)
        {  
            f[i]=f[i-2]+f[i-1]; //数组的第三个数开始为前两个数的和   
        }    
       //        System.out.println(java.util.Arrays.toString(f)); //把数组转化成String输出   
    }    
   
    public static void print(long[] array)
    {
    	for(int i=0;i<array.length;i++)
    	{
    		if(array[i]==0)
    			break;
    		System.out.print(array[i]+" ");
    		
    	}
    		
    }
    
    
    public static void main(String[] args) 
    {
    	Scanner in=new Scanner(System.in);
    	System.out.print("请输入月份：");
    	int n=in.nextInt();
    	fibonacciArray(n);
    	System.out.print("前"+n+"月份个数如下：\n");
    	print(f);
    }    
   
}   
                        
