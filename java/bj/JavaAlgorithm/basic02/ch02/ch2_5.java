package bj.JavaAlgorithm.basic02.ch02;

public class ch2_5
{
	public static void main(String[] args) 
	{
		int t;
		//i代表最高位上的数字
		for (int i = 1; i <= 9; i++) 
		{
			//j代表最低位上的数字
			for (int j = 0; j <= 9; j++) 
			{
				if(i!=j)
				{
					//i、j组成的四位数
					t=i*1000+i*100+j*10+j;
					//k的取值根据四位数字开平方得到的大概范围
					for (int k = 30; k < 100; k++) 
					{
						if (k == Math.sqrt(t)) 
						{
							System.out.println("车牌号码："+k * k);
						}
					}
				}
			}

		}
	}
}
