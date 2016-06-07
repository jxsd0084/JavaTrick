package bj.JavaAlgorithm.basic02.ch08;

public class Ch8_6
{
	static int a[]=new int[14];//存放牌，a[0]不用
	public static void main(String[] args) 
	{
		int i,n,j=1;/*j:数组(盒子)下标，初始时为1号元素*/
		System.out.printf("牌的原始顺序如下：\n");
		
		
		for(i=1;i<=13;i++)/*i:要放入盒子中的牌的序号*/
		{
			n=0;//空盒计数器
			while(n!=i)
			{
				if(a[j]==0)//如果位置空，n就计数
				{
					n++;
					if(n==i)/*若数到第i个空盒子，则将牌放入空盒中*/
					{	a[j]=i;
						break;
					}
				}

				if(j==13)/*由于盒子构成一个圈，j超过最后一个元素则指向1号元素*/
					j=1;
				else 
					j=j+1;
			}
		}
		/*输出结果*/
		for(i=1;i<=13;i++)
			System.out.printf("%d ",a[i]);
		System.out.printf("\n");
	}
}
