package bj.JavaAlgorithm.basic02.ch05;

public class Ch5_7
{
	/*
	 * len[0]，存储井深
	 * len[1],甲家井绳长度
	 * len[2],乙家井绳长度
	 * ....
	 */
	static void WJGJ(int[] len)	//五家共井算法
	{
		for(len[5]=4; ;len[5]+=4)                     //len5为4的倍数 
			
			for(len[1]=5; ;len[1]+=5)                 //len1为5的倍数 
			{ 
				len[4]=len[5]+len[1]/5; 
				len[3]=len[4]+len[5]/4; 
				
				if(len[3]%2!=0||len[4]%3!=0)
					continue;                //如果不能被2整除或若不能被3整除，进行下一次循环 
				
				len[2]=len[3]+len[4]/3; 
				
				if(len[2]+len[3]/2<len[1])
					break;                             //切回len5[0]循环(因为len1太大了) 
				
				if(len[2]+len[3]/2==len[1])
				{ 
					len[0]=2*(len[1])+(len[2]);     //计算井深 
					return;
				} 
			} 
	   								

	}
	
	public static void main(String[] args)
	{
		//len数组存放井深及每家井绳长度
		int[] len={0,0,0,0,0,0};
			
		WJGJ(len);				//求解算法
		
	    System.out.printf("五家共井问题求解结果如下:\n");					//输出结果
	    System.out.printf("甲家井绳长度为:%d\n",len[1]);
	    System.out.printf("乙家井绳长度为:%d\n",len[2]);
	    System.out.printf("丙家井绳长度为:%d\n",len[3]);
	    System.out.printf("丁家井绳长度为:%d\n",len[4]);
	    System.out.printf("戌家井绳长度为:%d\n",len[5]);
	    System.out.printf("井深:%d\n",len[0]);

	}
}
