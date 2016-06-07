package bj.JavaAlgorithm.basic02.ch04;

public class Ch4_3
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int k,d=0,t,i,j,a[]=new int[6];
		System.out.println("金蝉素数为：");
		for(k=10001;k<99999;k+=2)
		{
			t=0;//素数标准，0代表是素数，1代表不是素数
			for(j=3;j<=Math.sqrt(k);j+=2)
				if(k%j==0) /* 试商求素数 */
				{
					t=1;
					break;
				}
			if(t==0) /* k 为 5 位素数 */
			{
//				a[1]=k%10; //存放k的个位数
//				a[5]=k/10000;//存放k的万位数
				d=(k/10)%1000;//取出k的中间3位数
				for(j=2;j<=Math.sqrt(d);j++)
					if(d%j==0) /* 试商求素数 */
					{
						t=1; 
						break;
					}
			}
			if(t==0) /* d 为 3 位素数 */
			{
				a[1]=k%10; //存放k的个位数
				a[5]=k/10000;//存放k的万位数
				a[2]=d%10;//存放d的个位数，也是k的十位数
				a[4]=d/100;//存放d的百位数，也是k的千位数
				a[3]=(d/10)%10;//存放d的十位数，也是k的百位数
				
				for(i=1;i<=4;i++) /* 比较确保没有相同数字 */
					for(j=i+1;j<=5;j++)
						if(a[i]==a[j])
						{
							t=1;
							break;
						}
			}
			if(t==0)
			{
				for(j=1;j<=5;j++) /* 排除偶数字与中间数字为 1，9 */
					if(a[j]%2==0 || a[3]==1 || a[3]==9)
					{
						t=1;
						break;
					}
			}
			if(t==0)
				System.out.printf("%d ",k); /* 输出金蝉素数 */
			}
	}
}
