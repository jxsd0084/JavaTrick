package bj.JavaAlgorithm.basic02.ch02;//import java.io.Console;


public class ch2_8 
{
	 public static void main(String[] args)
	 {
		 int[][] fishermen = new int[3][3];
	 
		 System.out.println("可能存在的分配方案：");
	     for (int m = 1; m <= 3; m++)    //A
	     {
	    	 fishermen[0][0] = m;
	         fishermen[0][1] = (int)((3.5 - m) / 0.5);
	         fishermen[0][2] = 7 - fishermen[0][1] - fishermen[0][0];
	 
	         for (int n = 1; n <= 3; n++)    //B
	         {
	        	 if (n < m)
	        		 continue;
	             fishermen[1][0] = n;
	             fishermen[1][1] = (int)((3.5 - n) / 0.5);
	 
	             if (fishermen[1][1] < 0)
	            	 break;
	 
	             fishermen[1][2] = 7 - fishermen[1][1] - fishermen[1][0];
	 
	             for (int j = 1; j <= 3; j++)    //C
	             {
	            	 if (j < n || j + n + m != 7)
	            		 continue;
	 
	                 fishermen[2][0] = j;
	                 fishermen[2][1] = (int)((3.5 - j) / 0.5);
	                 if (fishermen[2][1] < 0)
	                	 break;
	                 fishermen[2][2] = 7 - fishermen[2][1] - fishermen[2][0];
	 
	                 if (fishermen[2][1] + fishermen[1][1] + fishermen[0][1] == 7 &&
	                		 fishermen[2][0] + fishermen[1][0] + fishermen[0][0] == 7)
	                 {	
	                	 System.out.println("       满筐数     半筐数    空筐数");
	                	 for (int i = 0; i < 3; i++)
	                     {
	                		 
	                		 System.out.println(i + "：   " + fishermen[i][0] + "       " + fishermen[i][1] + "      " + fishermen[i][2]);
	                     }
	                     System.out.println("-----------------------");
	                     break;
	                 }
	             }
	         }
	     }
	 }
}
