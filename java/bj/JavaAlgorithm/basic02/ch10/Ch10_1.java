package bj.JavaAlgorithm.basic02.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
  图解java数据结构
*/
public class Ch10_1
{
	/*游戏三种状态*/
	public static enum Status 
	{
		CONTINUE, WON, LOST
	};

	/*生成随机数对象*/
	public static Random random = new Random();

    /*游戏规则中的几个常量*/
	private final static int SNAKE_EYES = 2;
    private final static int TREY = 3;
    private final static int SEVEN = 7;
    private final static int YO_LEVEN = 11;
    private final static int BOX_CARS = 12;
	
	private  List<String> results;//存放游戏的整个输赢状态
	private  int w;//赢
	private  int l;//输
	    
	public Ch10_1() 
	{
		results = new ArrayList<String>();
	    w = 0;
	    l = 0;
	}
	    
	public  void play() 
	{
		int myPoint = 0;
	    Status gameStatus = Status.CONTINUE;
	    int sumOfDice = rollDice(); //掷骰子

	    /*根据骰子的点数和修改游戏状态*/
	    switch (sumOfDice) 
	    {
	    	case SEVEN:
	        case YO_LEVEN:
	        	gameStatus = Status.WON;
	         	break;
	        case SNAKE_EYES:
	        case TREY:
	        case BOX_CARS:
	        	gameStatus = Status.LOST;
	        	break;
	    }
	        
	    if(gameStatus == Status.CONTINUE) 
	    {
	    	myPoint = sumOfDice;
	        System.out.printf("点数是  %d\n", myPoint);
	    }

	    /*如果游戏状态为继续，继续掷骰子*/
	    while (gameStatus == Status.CONTINUE) 
	    {
	    	sumOfDice = rollDice(); 

	        if (sumOfDice == myPoint)
	        	gameStatus = Status.WON;
	        else if (sumOfDice == SEVEN)
	        	gameStatus = Status.LOST;
	    } 

	    /*输出本次游戏的结果，并记录到最终的游戏状态中*/
	    if (gameStatus == Status.WON) 
		{
	    	System.out.println("玩家赢");
	        results.add("赢");
	        w++;
	    } 
	    else 
	    {
	    	System.out.println("玩家输");
	        results.add("输");
	        l++;
	    }
	} 

	/*掷骰子*/
	public int rollDice() 
	{
		/*随机生成点数*/
		int die1 = 1 + random.nextInt(6);
	    int die2 = 1 + random.nextInt(6);

	    int sum = die1 + die2;

	    System.out.printf("玩家掷的点数  %d + %d = %d\n", die1, die2, sum);

	    return sum;
	}
	 
	/*打印最终结果*/
	public  void print() 
	{
		System.out.println("游戏结果统计：");
	    System.out.println("赢的次数： " + w);
	    System.out.println("输的次数： " + l);
	    int i = 0;
	    for(String rs: results)
	    {
	    	System.out.println("第  "+(++i)+"次: " +rs);
	    }
	}
	
	public static void main(String[] args) 
	{
		
		String answer;
		Ch10_1 game=new Ch10_1();
           
        do{
        	game.play();
        
        	System.out.println("继续游戏吗(y/n)?");
        	Scanner input = new Scanner(System.in);
        	answer = input.next();
        }while("Y".equalsIgnoreCase(answer));
       
        game.print();
    }
}
