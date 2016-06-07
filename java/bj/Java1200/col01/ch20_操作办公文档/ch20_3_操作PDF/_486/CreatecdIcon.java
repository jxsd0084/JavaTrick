package bj.Java1200.col01.ch20_操作办公文档.ch20_3_操作PDF._486;

import javax.swing.*;
import java.net.URL;


public class CreatecdIcon {

	public static ImageIcon add( String ImageName ) {

		URL       IconUrl = MainFrame.class.getResource( "/res/" + ImageName );
		ImageIcon icon    = new ImageIcon( IconUrl );
		return icon;
	}
}
