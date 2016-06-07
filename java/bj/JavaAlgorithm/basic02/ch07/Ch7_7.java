package bj.JavaAlgorithm.basic02.ch07;

public class Ch7_7
{
	public static void main(String[] args) 
	{
		/*用二维数组存放三家孩子的得分 */
		int score[][]=new int[3][3];
		int i,j,k,who;
		
		/*
		 * 按已知条件进行初始化：
		 * score[0]：存储张家三个孩子的得分
		 * score[1]：存储张家三个孩子的得分
		 * score[2]：存储张家三个孩子的得分
		 */
		score[0][0]=7;
		score[1][0]=8;
		score[2][0]=9;
		
		for(i=4;i<6;i++)                /*i：张家孩子在4到6分数段之间可能的分数*/
			for(j=4;j<7;j++)            /*j：王家孩子在4到6分数段之间可能的分数*/
				for(k=4;i!=j&&k<7;k++)  /*k：李家孩子在4到6分数段之间可能的分数*/
					/*分数不能并列*/
					if(k!=i&&k!=j
					&&15-i-score[0][0]!=15-j-score[1][0]
					&&15-i-score[0][0]!=15-k-score[2][0]
					&&15-j-score[1][0]!=15-k-score[2][0])
					{
						/*将满足条件的结果存储到数组里*/
						score[0][1]=i;
						score[0][2]=15-i-7;
						score[1][1]=j;
						score[1][2]=15-j-8;
						score[2][1]=k;
						score[2][2]=15-k-9;
					}
		
		System.out.print("每家孩子的得分如下：\n");
		for(who=0,i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				System.out.print(score[i][j]+" ");//输出三家孩子的得分情况
				if(score[i][j]==1)   
					who=i;     //记录最后一名的家庭索引下标
			}
			System.out.print("\n");
		}
		
		/*输出最后判断的结果*/
		switch (who)
		{
			case 0:
				System.out.print("最后一名的孩子来自张家");
				break;
			case 1:
				System.out.print("最后一名的孩子来自王家");
				break;
			case 2:
				System.out.print("最后一名的孩子来自李家");
				break;
		}

	}

}
