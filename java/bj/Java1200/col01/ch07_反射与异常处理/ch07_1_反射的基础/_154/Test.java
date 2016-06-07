package bj.Java1200.col01.ch07_反射与异常处理.ch07_1_反射的基础._154;

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;

/**
 * 按继承层次对类进行排序
 */
public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		TreeSet< Class< ? > > treeSet = new TreeSet< Class< ? > >( new ClassComparator() );
		System.out.println( "向树集中添加JPanel.class" );
		treeSet.add( JPanel.class );// 向树集中添加JPanel.class

		System.out.println( "向树集中添加JComponent.class" );
		treeSet.add( JComponent.class );// 向树集中添加JComponent.class

		System.out.println( "向树集中添加Container.class" );
		treeSet.add( Container.class );// 向树集中添加Container.class

		System.out.print( "获得树集的最后一个元素：" );
		System.out.println( treeSet.last() );// 获得树集的最后一个元素

	}

}
