/**
 * @jdk版本:1.6
 * @编码时间:2010-7-20
 */
package bj.Java1200.col02.ch07_JFreeChart基本操作._180;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

import java.awt.*;

public class PieDemo14 extends ApplicationFrame {

	public PieDemo14( final String title ) {

		super( title );

	}

	/**
	 * 创建数据集
	 *
	 * @return
	 */
	private CategoryDataset createDataset() {

		double[][] data = new double[][]{
				{ 620, 410, 310 },
				{ 300, 390, 500 }
		};
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"部门",//行名称 
				"月份",//列名称
				data );
		return dataset;
	}

	/**
	 * 获取数据集，生成JFreeChart，
	 *
	 * @return
	 */
	private JFreeChart getJFreeChart() {

		CategoryDataset dataset = createDataset();
		JFreeChart chart = ChartFactory.createMultiplePieChart3D(
				"4-6月销售排行", // 饼图标题
				dataset, // 数据集
				TableOrder.BY_COLUMN, // 排序方式
				true, true, false );
		return chart;
	}

	/**
	 * 创建饼图
	 */
	public void createPiePlot() {

		JFreeChart chart = getJFreeChart();
		// 窗体标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont( new Font( "宋体", Font.BOLD, 20 ) );

		// 图例
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont( new Font( "宋体", Font.PLAIN, 14 ) );


		MultiplePiePlot multiplePiePlot = (MultiplePiePlot) chart.getPlot();
		JFreeChart      jFreeChart      = multiplePiePlot.getPieChart();

		// 图表标签
		PiePlot3D piePlot = (PiePlot3D) jFreeChart.getPlot();

		piePlot.setLabelFont( new Font( "宋体", Font.PLAIN, 14 ) );
		piePlot.setLabelGenerator( new StandardPieSectionLabelGenerator(
				"{0}:{1}" ) );
		// 图表标题
		TextTitle textTitle2 = jFreeChart.getTitle();
		textTitle2.setFont( new Font( "宋体", Font.BOLD, 20 ) );


		setContentPane( new ChartPanel( chart ) );
	}

	public static void main( final String[] args ) {

		final PieDemo14 demo = new PieDemo14( "饼图实例" );
		demo.createPiePlot();
		demo.pack();
		RefineryUtilities.centerFrameOnScreen( demo );
		demo.setVisible( true );

	}

}
