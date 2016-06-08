package bj.DesignPattern.JavaPattern._06_开闭原则.section1;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 *         书店销售书籍
 */
public class BookStore {

	private final static ArrayList< IBook > bookList = new ArrayList< IBook >();

	// 静态模块初始化，项目中一般是从持久层初始化产生
	static {
		bookList.add( new NovelBook( "天龙八部", 3200, "金庸" ) );
		bookList.add( new NovelBook( "巴黎圣母院", 5600, "雨果" ) );
		bookList.add( new NovelBook( "悲惨世界", 3500, "雨果" ) );
		bookList.add( new NovelBook( "金瓶梅", 4300, "兰陵笑笑生" ) );
	}

	// 模拟书店买书
	public static void main( String[] args ) {

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		formatter.setMaximumFractionDigits( 2 );

		System.out.println( "------------书店买出去的书籍记录如下：---------------------" );
		for ( IBook book : bookList ) {

			System.out.println( "书籍名称：" +
			                    book.getName() + "\t书籍作者：" +
			                    book.getAuthor() + "\t书籍价格：" +
			                    formatter.format( book.getPrice() / 100.0 ) + "元" );
		}
	}

}

/*

对已经投产的项目来说，这就是一个变化，我们应该如何应对这样一个需求变化？
有如下三种方法可以解决这个问题：

● 修改接口

	在IBook上新增加一个方法getOffPrice()，专门用于进行打折处理，所有的实现类实现该
方法。但是这样修改的后果就是，实现类NovelBook要修改，BookStore中的main方法也修
改，同时IBook作为接口应该是稳定且可靠的，不应该经常发生变化，否则接口作为契约的
作用就失去了效能。因此，该方案否定。



● 修改实现类

    修改NovelBook类中的方法，直接在getPrice()中实现打折处理，好办法，我相信大家在
项目中经常使用的就是这样的办法，通过class文件替换的方式可以完成部分业务变化（或是
缺陷修复）。该方法在项目有明确的章程（团队内约束）或优良的架构设计时，是一个非常
优秀的方法，但是该方法还是有缺陷的。例如采购书籍人员也是要看价格的，由于该方法已
经实现了打折处理价格，因此采购人员看到的也是打折后的价格，会因信息不对称而出现决
策失误的情况。因此，该方案也不是一个最优的方案。



● 通过扩展实现变化

    增加一个子类OffNovelBook，覆写getPrice方法，高层次的模块（也就是static静态模块
区）通过OffNovelBook类产生新的对象，完成业务变化对系统的最小化开发。好办法，修改
也少，风险也小。



注意　开闭原则对扩展开放，对修改关闭，并不意味着不做任何修改，低层模块的变
更，必然要有高层模块进行耦合，否则就是一个孤立无意义的代码片段。




 */
