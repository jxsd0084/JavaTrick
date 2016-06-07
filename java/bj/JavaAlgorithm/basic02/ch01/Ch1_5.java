package bj.JavaAlgorithm.basic02.ch01;

import java.util.Scanner;

public class Ch1_5 
{
	public static void main(String[] args) 
	{
  		System.out.print("请输入行数：");
  		Scanner scanner = new Scanner(System.in);
   		int num = scanner.nextInt();
  		
  		int[][] ary = getTriangle(num);//得到杨辉三角
  		
  		print(ary);//打印杨辉三角
	}

	//得到杨辉三角
	private static int[][] getTriangle(int num) 
	{
		int[][] ary = new int[num][num];//用二维数组存储
  
		for(int i = 0; i < ary.length; i++)//竖边、斜边置1
		{
			ary[i][0] = 1;
			ary[i][i] = 1;
		}
  
		for(int i = 1; i < ary.length; i++)
		{
			for(int j = 1; j <= i; j++)
			{
				//里面部分，等于当前位置的上方和左上角之和
				ary[i][j] = ary[i-1][j-1] + ary[i-1][j];
			}
		}
		return ary;
	}
	
	private static void print(int[][] ary)
	{
		for(int i=0;i<ary.length;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.printf(" %-3d", ary[i][j]);
			}
			System.out.println();
		}
	}
			
}
