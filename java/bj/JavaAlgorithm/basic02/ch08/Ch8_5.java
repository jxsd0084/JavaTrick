package bj.JavaAlgorithm.basic02.ch08;

public class Ch8_5
{

	static final int A=12;//大瓶容量
	static final int B=8; //中瓶容量
	static final int C=5; //小瓶容量
	
	static int a = A;//大瓶里实际酒量
	static int b = 0;//中瓶里实际酒量
	static int c = 0;//小瓶里实际酒量
	
	public static void main(String[] args) 
	{
		while(a != A/2)
		{
			if(b==0)A_To_B();     //大瓶往中瓶倒酒
            if(c==C)C_To_A();     //小瓶往大瓶倒酒
            else if(b!=0)B_To_C();//中瓶往小瓶倒酒
		} 
	}

	/*大瓶往中瓶倒酒*/
	static void A_To_B()
	{
		if(a>B)
			b=B;
		else
			b=a;
		a=a-b;
		System.out.printf("\na->b:\t a=%d\tb=%d\tc=%d\t",a,b,c);
	} 
	
	/*中瓶往小瓶倒酒*/
	static void B_To_C()
	{
		int n = c;
		if(b+c>C)
		{	
			c=C;
			b=b-(C-n);
		}
		else 
		{	
			c=b+c;
			b=0;
		}
		System.out.printf("\nb->c:\t a=%d\tb=%d\tc=%d\t",a,b,c);
	}
	
	/*小瓶往大瓶倒酒*/
	static void C_To_A()
	{
		a =a+c;
		c = 0;
		System.out.printf("\nc->a:\t a=%d\tb=%d\tc=%d\t",a,b,c);
	}
     
}  


