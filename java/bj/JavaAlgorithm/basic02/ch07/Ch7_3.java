package bj.JavaAlgorithm.basic02.ch07;

public class Ch7_3
{
	public static void main(String[] args) 
	{
		int n,d=0,i;
		int flag=1;
		
		for(n=1;n<=7;n++)  //首项n取值范围为1~6
		{
			for(d=1;d<=4;d++) //公差a取值范围1~4
				/*约束条件：和为26，积为880*/
				if(4*n+6*d==28&&n*(n+d)*(n+d+d)*(n+d+d+d)==585)
				{
					System.out.println("首项："+n+"，公差："+d);
					flag=0;
					break;
				}
			if(flag==0)
				break;
		}
		
		System.out.print("等差序列前15项：");
		/*输出前20项*/
		for(i=0;i<15;i++)
			System.out.print(" "+(n+i*d));
	}
}
