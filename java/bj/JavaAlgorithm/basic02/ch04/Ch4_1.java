package bj.JavaAlgorithm.basic02.ch04;

/*
  图解java数据结构
*/
public class Ch4_1
{
	public static void main(String[] args) 
	{
		Ch4_1 test=new Ch4_1();
//		long time1=new Date().getTime();
		System.out.println("100以内素数如下：");
		int count=0;
		for(int i=2;i<100;i++) //循环判断每个数是不是素数
		{
			if(test.isPrimeNumber(i)==true)
			{
				System.out.print(i+" ");
				count++;
				if(count%10==0)
					System.out.print("\n");
			}
		}
//		long time=new Date().getTime()-time1;
//		System.out.println("\n"+time+"毫秒");
	}
	
	/**判断一个正整数是否为素数
	 * @param number 传入需要判断的正整数
	 */
	public boolean isPrimeNumber(int number)
	{
		boolean flag=true;
		if(number<=0)
			throw new IllegalArgumentException("number是不合法的参数！");
		for(int i=2;i<=Math.sqrt(number);i++)//用这个数循环除以2、3……一直到这个数的平方根数
		{
			if(number%i==0)//如果有一个数被整除，说明不是素数
			{
				flag=false;
				break;//如果不是素数退出
			}
		}
		return flag;
	} 
}
