package bj.JavaAlgorithm.basic02.ch10;

import java.util.Random;
import java.util.Scanner;

public class Ch10_5 
{
	static Random r=new Random(); 
	static Scanner in=new Scanner(System.in);

	static int people(int t)
	{
		int a;
		do
		{
			System.out.printf("请报数：");
			a=in.nextInt();
			if(a>2||a<1||t+a>30)
				System.out.printf("报数错误，重报！\n");
			else
				System.out.printf("你的报数：%d \n",t+a);
		}while(a>2||a<1||t+a>30);
		return t+a; /*返回当前的已经取走的数累加和*/
	}
	
	static int computer(int s)
	{
		int c;
		System.out.printf("计算机的报数：");
		if((s+1)%3==0) /*若剩余的数的模为1，则取1*/
		{	
			s++;
			System.out.printf(" %d \n",s);
		}
		else if((s+2)%3==0)/*若剩余的数的模为2，则取2*/
		{
			s+=2; 
			System.out.printf(" %d \n",s);
		}
		else              /*否则随机取1或2*/
		{
			c=r.nextInt(2)+1; 
			s+=c;
			System.out.printf(" %d \n",s);
		}
		return s;
	}
	
	public static void main(String[] args) 
	{
		Random r=new Random(); 
		int tol=0;//报数初始值为0
		System.out.printf(" * * * * * * * *抢30* * * * * * * \n");
		System.out.printf("游戏开始\n");
		
		/*取随机数决定机器和人谁先走第一步*/
		if(r.nextInt(2)==1) 
			tol=people(tol); //若为1，则人走第一步
		
		while(tol!=30) /*游戏结束条件*/
		{
			tol=computer(tol);
			if(tol==30) /*计算机取一个数，若为30则机器胜利*/
			{
				System.out.printf("\n我输了! ");
				break;
			}
			
			tol=people(tol);
			if(tol==30) /*人取一个数，若为30则人胜利*/
			{
				System.out.printf("\n我赢了! ");
				break;
			}
		}
		System.out.printf("\n * * * * * * * *游戏结束 * * * * * * * * ");
	}
}


