/**
 * @jdk版本:1.6
 * @编码时间:2010-7-20
 */
package bj.Java1200.col02.ch07_JFreeChart基本操作._154;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.*;

/**
 * 隐藏图标边框
 */
public class ChartDemo11 {

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
		piePlot.setLabelGenerator( new StandardPieSectionLabelGenerator( "{1}" ) );

		// 标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont( new Font( "宋体", Font.BOLD, 20 ) );

		// 图例
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont( new Font( "宋体", Font.PLAIN, 12 ) );

	}

	/**
	 * 设置边框
	 *
	 * @param chart
	 */
	public void setOutline( JFreeChart chart ) {

		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setBackgroundPaint( Color.white );
		piePlot.setOutlineVisible( false );

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

	public static void main( String[] args ) {

		ChartDemo11 pieChartDemo1 = new ChartDemo11();
		JFreeChart  chart         = pieChartDemo1.getJFreeChart();
		pieChartDemo1.setPiePoltFont( chart );
		pieChartDemo1.setOutline( chart );
		ChartFrame chartFrame = new ChartFrame( "JFreeChart的例子", chart );
		chartFrame.pack();
		chartFrame.setVisible( true );

	}
}
