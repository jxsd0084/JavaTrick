package bj.JavaAlgorithm.basic02.ch08;

public class Ch8_2
{
	public static void main(String[] args) 
	{
		long i,j,k;//被乘数的每一位
		long l,m,n;//乘数的每一位
		long term,mul;//被乘数、乘数
		long t1=0,t2=0,t3=0;//乘式过程的部分积
	    int flag;//条件标志
	    
	    for(i=0;i<=4;++i) /*被乘数的第一位*/
	    	for(j=5;j<=9;++j) /*被乘数的第二位*/
	    		for(k=0;k<=4;++k) /*被乘数的第三位*/
	    		{
	    			term=100*i+10*j+k; /*被乘数*/
	    			for(flag=0,n=0;n<=4&&flag==0;) /*乘数的第一位*/
	    			{
	    				t3=n*term*100;
	    				flag=jud(t3/100,"001"); /*判断第三个部分积*/
	    				n++;
	    			}
	    			if(flag==1)
	    			{
	    				for(flag=0,m=0;m<=4&&flag==0;) /*乘数的第二位*/
	    				{
	    					t2=m*term*10;
	    					flag=jud(t2/10,"1100"); /*判断第二个部分积*/
	    					m++;
	    				}
	    				if(flag==1)
	    				{
	    					for(flag=0,l=5;l<=9&&flag==0;) /*乘数的第三位*/
	    					{
	    						t1=l*term;
	    						flag=jud(t1,"0000"); /*判断第一个部分积*/
	    						l++;
	    						
	    					}
	    					if(flag==1&&jud(t1+t2+t3,"00101")==1) /*判断乘式的积*/
	    					{
	    						mul=(n-1)*100+(m-1)*10+(l-1);//乘数
	    						print(term,mul,t1,t2,t3);//输出结果
	    					}
	    				}
	    			}
	    		}
	}
	
	/* a：被乘数
	 * b:乘数
	 * s1、s2、s3：中间过程的积 */
	static void print(long a,long b,long s1,long s2,long s3) /*打印结果*/
	{
		System.out.print("   "+a+"\n");
	    System.out.print("*) "+b+"\n");
	    System.out.printf("......................\n");
	    System.out.printf("  "+s1+"\n "+s2/10+"\n "+s3/100+"\n");
	    System.out.printf("......................\n");
	    System.out.printf(" "+a*b+"\n");
	}
	  
	/*判断一个数的每一位是否满足要求的判断函数
    *q:需要判断的数。
    *pflag:标志字符串，A用0表示，Z用1表示。
    *标志串排列顺序：个十百...*/
	static int jud(long q,String pflag) 
	{
		int i=0;
	    while(q!=0&&i<=pflag.length()-1) /*循环判断对应位的取值范围是否正确*/
	    	if(pflag.charAt(i)-'0'!=(q%10>=5?1:0)) /*标志位与对应的位不符，返回0*/
	    		return 0;
	    	else	
	    	{
	    		q/=10;
	    		++i; /*若相符则取下一位进行判断*/
	    	}
	    	if(q==0&&i==pflag.length()) /*q的位数与标志字符串的长度相同时，返回1*/
	    		return 1;
	    	else 
	    		return 0;
	}
}
