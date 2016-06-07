package bj.JavaAlgorithm.basic02.ch04;

public class Ch4_8
{
	public static void main(String[] args)
	{
        int count=0;
        int s=0;
        int n;
        int num=1000;
        for(int i=4;i<=num;i=i+2)
        {
        	for(n=2;n<=i/2;n++)
        	{
        		if((suShu(n))&&(suShu(i-n))) 
        		{
//        			System.out.print(i+"="+n+"+"+(i-n)+"  ");
        			System.out.printf("%3d=%2d+%3d   ",i,n,(i-n));
        			count++;
        			s++;
        			break;
        		}
        	}
        	if(n==i/2+1)
        		System.out.print("error "+i);
        	if(count%5==0)
        	{
        		System.out.println();
        		count=0;
        	}
        }

        System.out.print("\n表达式个数："+s);
	} 
    
	public static boolean suShu(int n)
	{
		for(int i=2;i<=(int)(Math.sqrt((double)n));i++)
        {
			if(n%i==0)
				return false;
        }
		return true;
	}

}
