package bj.JavaAlgorithm.basic02.ch11;

public class Ch11_5
{
	public static void main(String[] args) 
	{	
		int n = 0;//代表6的前面部分，“n6”
		int N;//6移动前，即N=n6
		int M;//6移动到数字首部后，即M=6n
		
		int buf;
		int i = 0;//代表数字的长度
		while(true)//穷举
		{
			//移动前
			N = n * 10 + 6;
		    buf = n;
		    //计算数字的长度，确定6移到首部的权重
		    while(buf!=0)
		    {
		    	i++;
		        buf = buf/10;
		    }
		    //移动后
		    M = (int)(6 * Math.pow(10,i)) + n;
		    //条件满足，输出，退出循环
		    if(M == (4*N))
		    {
		    	System.out.print("要找的数为："+N);
		        break;
		    }
		    n++;//穷举变量修改
		    i = 0;//长度值复位
		}
	}
}
