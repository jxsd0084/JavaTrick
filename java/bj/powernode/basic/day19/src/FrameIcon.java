package bj.powernode.basic.day19.src;

import javax.swing.*;
import java.awt.*;

public class FrameIcon extends JFrame {

	public FrameIcon() {
	}

	public FrameIcon( String title ) {
		super( title );

		Toolkit kit = Toolkit.getDefaultToolkit();

		// 获取图片
		Image image = kit.getImage( "src/image/1.jpg" );

		// 设置图标
		setIconImage( image );

		// 设置窗口的大小和显示位置
		setBounds( 420, 160, 300, 300 );
	}

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {
		FrameIcon fi = new FrameIcon( "窗口上添加图标" );
		fi.setVisible( true );
		fi.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}
