package bj.JavaAlgorithm.basic02.ch07;

public class Ch7_8
{
	public static void main(String[] args) 
	{
		double way[]=new double[52];
			 
		//初始值计算
		way[1] = 0;
		way[2] = 1;
		way[3] = 1;
		way[4] = 2;

		//根据递推关系求解
		for (int i=5; i<=50; i++)
		{
			way[i] = way[i-2]+way[i-3]+way[i-4];
		}
			 
		System.out.printf("上山的跳法：%.0f\n", way[50]);

		//初始化
		way[0] = 0;
		way[1] = 1;
		way[2] = 2;
		way[3] = 4;
		
		//根据递推关系求解
		for (int i=4; i<=50; i++)
		{
			way[i] = way[i-1]+way[i-2]+way[i-3];
		}
		
		System.out.printf("下山的跳法：%.0f\n", way[50]);
	}
}
