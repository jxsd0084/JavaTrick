package bj.JavaAlgorithm.basic02.ch10;

import java.util.*;

public class Ch10_7 
{
	/*把整数里的每一位提出来，放到Set集合里，过滤重复数字*/
	public static Set intToSet(int num,int n)
	{
		Set s=new HashSet();
		//循环处理数字每一位，加入到Set集合里
		for(int i=0;i<4;i++)
		{
			s.add(num%10);//重复的数字被过滤掉
			num=num/10;
		}
		
		return s;
	}
	
	public static void main(String[] args) 
	{
		Set s1;//存放计算机生成的数字各位
		Set s2;//存放人输入的数字各位
		Scanner in=new Scanner(System.in);
		int c,g;
		int w=0;//记录数字位置相同的数字位个数
		int n;//记录数字位相同的个数
		
		Random r=new Random(); 
		int z=1000+9*r.nextInt(1000); /*计算机想一个4位随机数*/
		
		int zb=z;//保存，备用

		s1=intToSet(z,4);//把数字每一位放到集合中
	  
		System.out.printf("我已经想好了一个4位数字，请猜 \n");
		
		/*c: 猜数次数计数器*/
		for(c=1;;c++) 
		{
			System.out.printf("请输入一个4位数：");
			g = in.nextInt(); /*请人猜*/ 
			
			s2=intToSet(g,4);//把数字每一位放到集合中
			
			Iterator ite2 = s2.iterator();//生成迭代器

			n=0;
			/*循环判断集合中重复元素*/
			while (ite2.hasNext()) 
			{
				if (s1.contains(ite2.next())) 
				{
					n++;//如果集合中找到一个重复元素，计数器就加1
				}
			}
			System.out.println("猜中数字个数："+n);   
			
			z=zb;
			w=0;
			/*循环判断数字的每一位是否相等*/
			for(int i=0;i<4;i++)
			{
				if(g%10==z%10)
					w++;//如果相等，计数器加1
				g/=10;
				z/=10;
			}
			
			System.out.println("猜中数字位置个数："+w+"\n"); 
			
			if(w==4)
			{
				System.out.println("猜中总共用的次数："+c); 
				break;
			}
		}
	}
}
