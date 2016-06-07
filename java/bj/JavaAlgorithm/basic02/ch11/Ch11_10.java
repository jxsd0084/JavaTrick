package bj.JavaAlgorithm.basic02.ch11;

public class Ch11_10
{
	//背包容量
	private int c;
	//物品重量数组
	private int[] w;
	//物品价值数组
	private int[] v;
	private int[][] m;//m(i, j)是背包容量为j,可选物品为0,1,...,i时0-1背包问题的最优值。
	//记录结果
	private int[] x;
	//最大价值
	private int maxV;

	//构造方法，数据初始化
	public Ch11_10(int[] w, int[] v, int c)
	{
		this.w = w;
		this.v = v;
		this.c = c;
		m = new int[w.length][c+1];
		x = new int[w.length];
	}

	/** 0-1背包问题  动态规划求解
	 *递归式
	 *  m(i, j) = 0										j=0
	 *  m(i, j) = 0										i=0 && j < wi
	 *  m(i, j) = vi									i=0 && j >= wi
	 *  m(i, j) = m(i-1, j)								j < wi
	 *  m(i, j) = max{m(i-1, j), m(i-1, j-wi) + vi}		j >= wi
	 */
	public void knapsack()
	{
		//初始化
		for (int i = 0; i < m.length; i++)
		{
			m[i][0] = 0;
		}
		for (int j = 0; j < m[0].length; j++)
		{
			if (w[0] <= j)
			{
				m[0][j] = v[0];
			}
			else
			{
				m[0][j] = 0;
			}
		}
		
		for (int i = 1; i < m.length; i++)
		{
			for (int j = 1; j < m[i].length; j++)
			{
				if (j < w[i])
				{
					m[i][j] = m[i-1][j];
				}
				else
				{
					m[i][j] = Math.max(m[i-1][j], m[i-1][j-w[i]] + v[i]);
				}
			}
		}
		maxV = m[m.length - 1][c];
		System.out.println("最大值为："+maxV );
	}

	//得到最优解
	public int[] getResult()
	{
		int tmp = c;
		int i;
		for (i = m.length - 1; i > 0; i--)
		{
			//根据二维数组最后一列，相邻两行是否相等，如果相等，没有加入，否则，加入
			if (m[i][tmp] == m[i-1][tmp])
			{
				x[i] = 0;
			}
			else
			{
				x[i] = 1;
				tmp = tmp - w[i];
			}
		}
		x[i] = (m[0][c] != 0) ? 1 : 0; //第一行，单独处理，如果非零，即加入
		return x;
	}

	//打印数组m
	public void printM()
	{
		for (int i = 0; i < m.length; i++)
		{
			
			for (int j = 0; j < m[i].length; j++)
			{
				System.out.printf("%2d  ",m[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) 
	{
		int[] w = {6, 5, 2, 1, 1};//物品重量
		int[] v = {48, 40, 12, 8, 7};//物品价格
		int c=8; //背包容量
		
		Ch11_10 k = new Ch11_10(w, v, c);//初始化数据
		
		k.knapsack();//调用背包方法，填充动态规划表
		
		int[] x = k.getResult();//得到最优解
		
		System.out.println("具体组合情况如下（1代表选中，0代表未选）：");
		for (int i = 0; i < x.length; i++)
		{
			System.out.print(x[i] + " ");
		}
		System.out.println("\n动态规划表如下：");
		
		
		k.printM();//打印动态规划表
	}
}
