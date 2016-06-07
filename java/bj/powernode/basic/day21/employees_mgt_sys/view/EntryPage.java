package bj.powernode.basic.day21.employees_mgt_sys.view;

import bj.powernode.basic.day21.employees_mgt_sys.basic.GuiUtil;
import bj.powernode.basic.day21.employees_mgt_sys.basic.LanguageHandlerUtil;

import javax.swing.*;

public class EntryPage extends JFrame {

	private static final long serialVersionUID = 3278276216743468743L;

	public EntryPage() {

		this.setTitle( LanguageHandlerUtil.getContentByKey( "entryPage.title" ) );//设置窗体的标题栏
		this.setIconImage( GuiUtil.getImage( "src/image/1.jpg" ) );//处置窗体图标

		// 适合不同分辨率(设置窗体的大小)
		int width  = GuiUtil.getScreenWidth();
		int height = GuiUtil.getScreenHeight();
		this.setBounds( (int) ( width / 10 ), height / 10, (int) ( width / 1.2 ), (int) ( height / 1.2 ) );


		this.setVisible( true );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}
}
