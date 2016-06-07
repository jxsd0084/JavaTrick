package bj.JavaAlgorithm.basic02.ch01;

import java.util.*;

public class Ch1_5_2 
{ 
   public static void main(String[] args) 
   {
	   Scanner in = new Scanner(System.in);
	   System.out.print("请输入行号： ");
	   int m = in.nextInt();
	   int n=2*m-1;

	   int arr[][]=new int[m][n];
	   for(int i=0;i<m;i++)
	   {
		   for(int j=0;j<n;j++)
		   {
			   if(j<(m-i-1)||(j>=(m+i)))
				   System.out.print("   ");
			   else if((j==(m-i-1))||(j==(m+i-1)))
			   {
				   arr[i][j]=1;
				   System.out.printf("%-3d",arr[i][j]);
			   }
//			   else if((i+j)%2==0&&m%2==0||(i+j)%2==1&&m%2==1)
//				   System.out.print("   ");
			   else
			   {
				   arr[i][j]=arr[i-1][j-1]+arr[i-1][j+1];
				   System.out.printf("%-3d",arr[i][j]);
			   }
		   }
           System.out.println();
	   }
   }
}

