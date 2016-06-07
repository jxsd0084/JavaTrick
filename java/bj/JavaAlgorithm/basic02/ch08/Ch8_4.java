package bj.JavaAlgorithm.basic02.ch08;

public class Ch8_4
{
	public static void main(String[] args) 
	{
		int j = 3;
		int a[][] = new int[j][j];
		
		/*矩阵初始化*/
		for (int b = 0; b < j; b++) 
		{
			for (int d = 0; d < j; d++) 
			{
				a[b][d] = 0;
			}
		}
		
		int r;//代表行
		int c;//代表列
		r=0;
		c=j/2;
		a[r][c]=1;//1位置一般位于第一行中间
		//罗伯特法，填充数字
		for (int i = 2; i <= j*j; i++) 
		{
			/*1.默认在前一个数的右上方*/
			r=r-1;
			c=c+1;
			
			/*2.如果这个数所要放的格已经超出了顶行那么就把它放在底行，仍然要放在右一列*/
			if(r<0&&c<=j-1)
			{
				r=j-1;
			}
			
			/*3.如果这个数所要放的格已经超出了最右列那么就把它放在最左列，仍然要放在上一行*/
			if(c>j-1&&r>=0)
			{	
				c=0;
			}
			
			/*4.如果这个数所要放的格已经超出了顶行且超出了最右列，那么就把它放在前一个数的下一行同一列的格内；*/
			if(r<0&&c>j-1)
			{	
				r=r+2;
				c=c-1;
			}
			
			/*5.如果这个数所要放的格已经有数填入，那么就把它放在前一个数的下一行同一列的格内；*/
			if(a[r][c]!=0)
			{	
				r=r+2;
				c=c-1;
			}
			
			a[r][c]=i;//填充数字
		}
		
		/*输出结果*/
		for (int e = 0; e < j; e++) 
		{
			for (int f = 0; f < j; f++) 
			{
				if (a[e][f] < 10)
					System.out.print(a[e][f] + "  ");
				else
					System.out.print(a[e][f] + " ");
				if (f == j - 1)
					System.out.println("\n");
			}
		}

	}

}
