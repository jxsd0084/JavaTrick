package bj.crazy.ch11.u08;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ZoomImage {

	//下面两个常量设置缩小后图片的大小
	private final int WIDTH  = 80;
	private final int HEIGHT = 60;
	//定义个BuffedImage对象，用于保存缩小后的位图
	BufferedImage image = new BufferedImage( WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB );
	Graphics      g     = image.getGraphics();

	public void zoom() throws Exception {
		//读取原始位图
		Image srcImage = ImageIO.read( new File( "image/board.jpg" ) );
		//将原始位图缩小后绘制到image图象中
		g.drawImage( srcImage, 0, 0, WIDTH, HEIGHT, null );
		//将image图象文件输出到磁盘文件中。
		ImageIO.write( image, "jpeg",
				new File( System.currentTimeMillis() + ".jpg" ) );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {
		new ZoomImage().zoom();
	}
}
