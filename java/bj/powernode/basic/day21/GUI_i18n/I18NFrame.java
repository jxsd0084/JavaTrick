package bj.powernode.basic.day21.GUI_i18n;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Properties;

public class I18NFrame extends JFrame {

	private JButton b1, b2;

	private int version = 0; //0是中文版,1是英文版

	public I18NFrame() {

		setLayout( new FlowLayout( FlowLayout.LEFT ) );

		b1 = new JButton( getValue( "buttonView", version ) );

		b2 = new JButton( "change version of language to English" );

		b2.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed( ActionEvent e ) {

				if ( version == 0 ) {
					version = 1;
					b2.setText( "切换到中文" );
				} else if ( version == 1 ) {
					version = 0;
					b2.setText( "change version of language to English" );
				}

				b1.setText( getValue( "buttonView", version ) );
			}
		} );

		setBounds( 420, 160, 500, 100 );

		add( b1 );
		add( b2 );

	}


	//通过读取配置文件,通过key来获取value
	public static String getValue( String key, int version ) {  //通过key获取value
		Properties p = new Properties();
		try {
			if ( version == 0 ) {
				p.load( new FileInputStream( "src/i18n_zh_CN.properties" ) );
			} else if ( version == 1 ) {
				p.load( new FileInputStream( "src/i18n_en_US.properties" ) );
			}

		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return p.getProperty( key );
	}


	//主方法
	public static void main( String[] args ) {

		I18NFrame i18n = new I18NFrame();
		i18n.setVisible( true );
		i18n.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}

