package bj.JavaAlgorithm.basic02.ch06;

public class Ch6_8
{
	public static void main(String[] args) 
	{
		// 穷举法
		for (int i = 0;i<10000; i++) 
		{    
			int count = i;      // count记住的数是0, 1, 2, 3, 4......
			int j;
			for (j = 0; j < 5; j++) 
			{  // 每个数循环判断5次
				if ((count - 1) % 5 == 0)  // 如果这个数能满足吃掉1个再分成5份
					count = (count - 1) / 5 * 4; // 那么就将桃子吃掉一个分成5份, 留下4份
				else
					break;     // 如果不满足吃掉1个再分成5份, 那么直接外层循环进入下一次
			}
			if(j==5)
			{
				System.out.println("原来可能有桃子："+i);    // 循环5次之后, 代表可以被5个猴子来分
//				break;
			}
		}
		System.out.print("程序结束。");
	}
 
}
