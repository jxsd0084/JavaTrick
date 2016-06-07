package bj.JavaAlgorithm.basic02.ch09;

import java.util.Scanner;

public class Ch9_6 
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.print("请输入一个数：");
		int num=in.nextInt();
//		KaBuLieKe83(num,0);
		
		kaBuLieKe(num);	//调用方法验证卡布列克运算
	}
	         
	private static void kaBuLieKe(int n)
	{
	 	int count=0;
	 	int cha=0;
	 	
	 	/*循环相减，直至差为卡布列克常数*/
	 	do
	 	{
	 		/*四位数组成的最大数、最小数方法
	 		 *参数1，代表组成最大数 
	 		 *参数0，代表组成最小数
	 		 */
	 		cha = getTheMaxOrMin(n, 1) - getTheMaxOrMin(n, 0); 
	 		System.out.println(count + ":" + getTheMaxOrMin(n, 1) + "-"  
	                + getTheMaxOrMin(n, 0) + " = " + cha);  
	 		 count++;   
	 		 n=cha;
	 	}while(cha!=6174);
	 	System.out.println("验证通过");   
		
	}

		/**  
	     * 83。卡布列克常数，挺好玩，实现一下  
	     */  
	public static void KaBuLieKe83(int n, int count) 
	{   
		int cha = getTheMaxOrMin(n, 1) - getTheMaxOrMin(n, 0);   
	    System.out.println(count + ":" + getTheMaxOrMin(n, 1) + "-"  
	                + getTheMaxOrMin(n, 0) + " = " + cha);   
	    count++;   
	    if (n == 6174) {   
	    	System.out.println("I did it 6174");   
	    } else {   
	    	KaBuLieKe83(cha, count);   
	    }   
	}   
	  
	/**  
	  * 获取重新排列后最大的数，如2310,得到3210，暂时只要四位  
	  */  
	public static int getTheMaxOrMin(int n, int maxOrMin) 
	{   
		if (n < 1000 || n > 9999)   
			return -1;  
		
		/*分解出数字的每位，a为最高位*/
		int a = getThe(n, 4);   
		int b = getThe(n, 3);   
		int c = getThe(n, 2);   
		int d = getThe(n, 1);   
	  
		int temp = 0;   
	     
		//把分解出的数字放到数组里
		int[] list = new int[] {a,b,c,d};   
		
		/*冒泡法对数组排序
		 * maxOrMin == 1：降序排列
		 * maxOrMin == 0：升序排列
		 */
		for (int i = 0; i < 4; i++) 
		{   
			for (int j = i; j < 4; j++) 
			{   
				if (maxOrMin == 1 ? (list[i]<list[j]) : (list[i]>list[j])) 
				{   
					temp =list[i];   
					list[i]= list[j];   
					list[j] = temp;   
				}   
			}   
		}   
	    return list[0] * 1000 + list[1] * 100 + list[2] * 10 + list[3];   
	}
	
	/**  
	  * 获取N从后往前数第i位  
	  */  
	public static int  getThe(int num, int i) 
	{   
		if (i > getBitCount(num) || i < 1)   
			return -1;   
	    return (num % ((int) Math.pow(10, i))) / (int) Math.pow(10, i - 1);   
	}   
	  
	/**  
	  * 获取一个数的位数  
	  */  
	public static int getBitCount(int n) 
	{   
		int i = 1;   
	    while (n / 10 > 0) 
	    {   
	    	i++;   
	        n /= 10;   
	    }   
	    return i;   
	}   
} 
