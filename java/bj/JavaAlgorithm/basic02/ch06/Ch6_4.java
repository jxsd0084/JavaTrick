package bj.JavaAlgorithm.basic02.ch06;

public class Ch6_4
{
	public static void main(String[] args) 
	{
		int p,q,r,s,count=0;
		System.out.print("可能的结果如下： \n");
		
		/*穷举分母*/
		for(p=2;p<5;p++) 
			for(q=p;q<7;q++)
				for(r=q;r<13;r++)
					if(p*q*r-q*r-p*r-p*q!=0)
					{ 
						/*求出s的值*/
						s=(p*q*r)/(p*q*r-q*r-p*r-p*q);
						
						/*s为整数且大于r */
						if((p*q*r)%(p*q*r-q*r-p*r-p*q)==0&&s>=r)
							/*输出结果*/
							System.out.printf("[%2d] 1/%d+1/%d+1/%d+1/%d=1 \n",++count,p,q,r,s);
					}
		System.out.print("程序结束。");
	}
}
