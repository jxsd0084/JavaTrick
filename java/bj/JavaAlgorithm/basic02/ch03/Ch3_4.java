package bj.JavaAlgorithm.basic02.ch03;

public class Ch3_4
{

	private static int GetSum(int num)
	{
		int sum = 1;
		int limit = (int)Math.sqrt(num);
		for (int i = 2; i <= limit; i++)
		{
			if (num % i == 0) sum += i + num / i;
		}
		return sum;
	 }
	 
	 public static void Run(int from, int to)
	 {
		 int perfertCount = 0;
		 int amicablePairCount = 0;
		 for (int num = from; num <= to; num++)
		 {
			 int sum1 = GetSum(num);
//			 if (sum1 == num)
//			 {
//				 System.out.println(num+"是完全数");
//				 perfertCount++;
//			 }
			 if (sum1 > num)
			 {
				 int sum2 = GetSum(sum1);
				 if (sum2 == num)
				 {
					 System.out.printf("%5d和%-5d是一对相亲数\n",sum1,sum2);
					 amicablePairCount++;
				 }
			 }
		 }
		 System.out.println("在"+from+"到"+to+"中共有"+amicablePairCount+"对相亲数");
	 } 
	 
	public static void main(String[] args) 
	{
		Run(2,100000);
	}

}
