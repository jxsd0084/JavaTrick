package bj.JavaAlgorithm.basic02.ch10;

import java.util.Random;

/*扑克牌类*/
class Card
{
   int Suit;				//花色 
   char Number;				//牌面数字
}

public class Ch10_2 
{
	static Card[] OneCard=new Card[52];	//保存每张扑克的花色、数字
	
	/*显示扑克牌*/ 
	static void showCard() 				
	{
	   int i, j;
	   String s="";

	   for (i = 0, j = 0; i < 52; i++, j++)
	   {
		  if (j % 13==0)
		  {
			 System.out.print("\n");
		  }
		  switch(OneCard[i].Suit)				//显示花色符号
		  {
		  case 1:
			  s="黑桃";
			  break;
		  case 2:
			  s="红桃";
			  break;
		  case 3:
			  s="梅花";
			  break;
		  case 4:
			  s="方块";
			  break;
		  default:
			  ;
		  }
		  System.out.printf("  "+s+OneCard[i].Number);//输出显示
	   }
	   System.out.print("\n");
	}
	
	/*洗牌*/
	static void shuffle()								
	{
		int i,j;
		
	    Card tempcard=new Card();

	   Random r=new Random();					//随机种子
	   for (i = 0; i < 52; i++)
	   {
		  j = r.nextInt(52);					//随机换牌
		  tempcard = OneCard[j];
		  OneCard[j] = OneCard[i];
		  OneCard[i] = tempcard;
	   }
	}
	
	public static void main(String[] args) 
	{
		initial();              //生成一副新牌
		
		System.out.printf("一副新牌的初始排列如下:\n"); 		
		showCard();				//显示新牌的排列
		
		shuffle();				//洗牌
		
		System.out.print("\n洗牌后的排列如下:\n");
		showCard();				//显示洗牌后的排列
	}

	/*生成一副新牌*/
	private static void initial() 
	{
		int i,temp;
		int suit;
		
	   suit=0;
	   for (i = 0; i < 52; i++)				//生成52张牌 
	   {
		  if (i % 13 == 0)
		  {
			 suit++;						//改变花色 
		  }
		  Card t=new Card();
		  t.Suit = suit;					//保存花色 
		  temp = i % 13;
		  switch(temp)						//特殊值处理
		  {
		  case 0:
			  t.Number = 'A';
			  break;
		  case 9:
			  t.Number = '0';			//代表10
			  break;
		  case 10:
			  t.Number = 'J';
			  break;
		  case 11:
			  t.Number = 'Q';
			  break;
		  case 12:
			  t.Number = 'K';
			  break;
		  default:
			  t.Number =(char)(temp + '1');
		  }
		  OneCard[i]=t;

	   }
		
	}
}
