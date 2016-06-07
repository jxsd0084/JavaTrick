package bj.JavaAlgorithm.basic02.ch05;

/*
  图解java数据结构
*/
public class Ch5_1
{
	static void BQBJ(int m,int n)				//m钱买n鸡算法
	{
	    int x,y,z;
	    for(x=0;x<=n;x++)				//公鸡数量
	    {
	        for(y=0;y<=n;y++)			//母鸡数量
	        {
	            z=n-x-y;				//小鸡数量
	            if (z>0 && z%3==0 && x*5+y*3+z/3==m)
				{
	                System.out.printf("公鸡：%d只,母鸡：%d只,小鸡：%d只\n",x,y,z);
				}
				else					//无法求解!
				{
					;
				}
	        }
	    }  
	}
	
	public static void main(String[] args) 
	{
		int m,n;

		m=100;						//百钱
		n=100;						//百鸡
		System.out.print(m+"钱买"+n+"鸡问题的求解结果为：\n");
		BQBJ(m,n);
	}
}
