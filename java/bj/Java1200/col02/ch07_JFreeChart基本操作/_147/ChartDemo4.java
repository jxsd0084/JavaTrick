/**
 * @jdk版本:1.6
 * @编码时间:2010-7-20
 */
package bj.Java1200.col02.ch07_JFreeChart基本操作._147;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;

/**
 * 乱码问题
 */
public class ChartDemo4 {

	/**
	 * 生成JFreeChart
	 *
	 * @return
	 */
	public JFreeChart getJFreeChart() {

		PieDataset dataset = getPieDataset();
		// locale.getISO3Language()
		JFreeChart chart = ChartFactory.createPieChart( "2010.8月份销售排行", dataset,
		                                                true, true, false );

		return chart;
	}

	/**
	 * 设置饼图使用的字体
	 *
	 * @param chart
	 */
	public void setPiePoltFont( JFreeChart chart ) {

		// 图表(饼图)
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont( new Font( "宋体", Font.PLAIN, 14 ) );

		// 标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont( new Font( "宋体", Font.BOLD, 20 ) );

		// 图例
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont( new Font( "宋体", Font.PLAIN, 12 ) );

	}

	/**
	 * 创建一个饼图表的数据集
	 *
	 * @return
	 */
	private PieDataset getPieDataset() {

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue( "JAVA从入门到精通（第2版）", 500 );
		dataset.setValue( "视频学JAVA", 800 );
		dataset.setValue( "JAVA全能速查宝典", 1000 );
		return dataset;
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		ChartDemo4 demo  = new ChartDemo4();
		JFreeChart chart = demo.getJFreeChart();
		demo.setPiePoltFont( chart );
		ChartFrame chartFrame = new ChartFrame( "JFreeChart的例子", chart );
		chartFrame.pack();
		chartFrame.setVisible( true );

	}

}
