package bj.JavaAlgorithm.basic02.ch09;

public class Ch9_7
{
	public static void main(String[] args) 
	{
		int b[]={2,3,2},m[]={3,5,7};
		int a[]=new int[3];
		
		int s=shengyu(b,m);//返回通解的前半部分
		
		int t=1;
		//计算通解的后半部分
		for(int i=0;i<m.length;i++)
		{
			t=t*m[i];
		}
		System.out.print("解为："+s+"+"+t+"x(x∈Z)");
	
	}

	private static int shengyu(int[] b, int[] m) 
	{
		int s[]=new int[b.length];//存放解的每一项
		int t[]=new int[b.length];//存放另外两个数的最小公倍数
		int sum=0;
		
		/*求另外两个数的最小公倍数*/
		for(int i=0;i<b.length;i++)
		{
			//求数组中另外两个数的最小公倍数，下标循环处理
			t[i]=lcd(m[(i%b.length+1)%b.length],m[(i%b.length+2)%b.length]);
		}
//		print(t);
		/*求出解的每个独立项*/
		for(int i=0;i<b.length;i++)
		{
			s[i]=item(b[i],m[i],t[i]);
		}
//		print(s);
		for(int i=0;i<b.length;i++)
		{
			sum=sum+s[i];
		}
		
		return sum;
	}
	
	
	 /*自定义函数求两数的最小公倍数*/
	static int lcd(int a,int b)   
	{
		int as,bs;
		int  temp;   
		
		as=a;
		bs=b;
			
		/*设置中间变量进行两数交换，大数放到a里，小数放到b里*/
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
		return as*bs/a;            /*返回最小公倍数到调用函数处*/ 
	}
	
	/**返回解的一部分
	 * 参数a：余数
	 * 参数b：除数
	 * 参数c：另外两项的最小公倍数
	 */
	static int item(int a,int b,int c)
	{
		int i=1;
		int t=c;
		while(t%b!=a)
		{
			i++;
			t=c*i;
		}
		return t;
	}
	
	//测试用
	static void print(int[] s)
	{
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]+" ");
	}

}
