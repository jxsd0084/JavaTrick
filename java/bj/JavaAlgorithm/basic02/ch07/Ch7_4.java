package bj.JavaAlgorithm.basic02.ch07;

public class Ch7_4
{
	public static void main(String[] args) 
	{
		int a,b,c;
		//穷举各种情况
		for(a=0;a<=1;a++)
			for(b=0;b<=1;b++)
				for(c=0;c<=1;c++)
				{
					//约束条件
					if((a==1&&b==0||a==0&&b==1)&&(b==1&&c==0||b==1&&c==1)&&(c==1&&a+b==0||c==0&&a+b!=0))
					{
						System.out.println("张三说的是"+(a==1?"真话":"假话"));
						System.out.println("李四说的是"+(b==1?"真话":"假话"));
						System.out.println("王二说的是"+(c==1?"真话":"假话"));
					}
				} 
	}
}
