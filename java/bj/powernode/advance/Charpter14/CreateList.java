package bj.powernode.advance.Charpter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.Socket;

public class CreateList extends Thread implements Serializable {

	private Socket socket;

	private JFrame f;

	private List list = new List();

	private TextArea  area;
	private TextField sayTo;

	public CreateList( Socket socket, JFrame f, TextArea area, TextField sayTo ) {

		this.socket = socket;
		this.f = f;
		this.area = area;
		this.sayTo = sayTo;
		this.start();
	}

	public void run() {

		BufferedReader reader = null;
		try {
			list.add( "大家" );
			reader = new BufferedReader( new InputStreamReader( socket
					                                                    .getInputStream() ) );
			while ( true ) {
				String info = reader.readLine();
				if ( info.endsWith( "进入了房间！" ) || info.contains( "说" ) ) {
					area.append( info + "\n" );

				} else if ( info.contains( "不要自言自语" ) ) {
					JOptionPane.showMessageDialog( f, info );
				} else {

					list.add( info );
					f.add( list, BorderLayout.EAST );
					f.setVisible( true );
				}
				list.addItemListener( new ItemListener() {

					public void itemStateChanged( ItemEvent e ) {

						int num = list.getItems().length;
						for ( int i = 0; i < num; i++ ) {
							if ( list.isIndexSelected( i ) ) {
								String to = list.getItem( i );
								sayTo.setText( to );
							}
						}
					}
				} );
			}

		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}
