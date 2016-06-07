package bj.JavaAlgorithm.basic02.ch10;

import java.util.Scanner;

public class Ch10_4 
{
	public static void main(String[] args) 
	{
		int computer,user;
		int last=21;
	
		System.out.printf("常胜将军问题求解！\n");
		while(true)
		{
			System.out.printf("----------  目前还有火柴 %d 根 ----------\n",last);
		    System.out.printf("用户取火柴数量:") ;
		    Scanner input=new Scanner(System.in);
		    user=input.nextInt();					//用户取火柴数量
		    if(user<1 || user>4 || user>last)
		    {
		    	System.out.printf("你违规了，你取的火柴数有问题!\n\n");
				continue;
		    }
		    last = last - user;						//剩余火柴数量
		    if(last == 0)
			{
		       	System.out.printf("\n用户取了最后一个火柴,因此计算机赢了!\n"); 
				break;
			}
			else
			{
				computer =  5 - user;			//计算机取火柴数量
				last = last - computer;
				System.out.printf("计算机取火柴数量:%d  \n",computer);
				if(last == 0)
				{
					System.out.printf("\n计算机取了最后一根火柴,因此用户赢了!\n"); 
					break;
				}
			}
		}
	}
}
