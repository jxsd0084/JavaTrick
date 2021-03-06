package bj.crazy.ch11.u09;

import java.awt.datatransfer.*;
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
public class SerialSelection implements Transferable {

	private Serializable obj;

	public SerialSelection( Serializable obj ) {
		this.obj = obj;
	}

	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor[] flavors = new DataFlavor[ 2 ];
		//获取被封装对象的类型
		Class  clazz    = obj.getClass();
		String mimeType = "application/x-java-serialized-object;class=" + clazz.getName();
		try {
			flavors[ 0 ] = new DataFlavor( mimeType );
			flavors[ 1 ] = DataFlavor.stringFlavor;
			return flavors;
		} catch ( ClassNotFoundException e ) {
			return null;
		}

	}

	public Object getTransferData( DataFlavor flavor )
			throws UnsupportedFlavorException {
		if ( !isDataFlavorSupported( flavor ) ) {
			throw new UnsupportedFlavorException( flavor );
		}
		if ( flavor.equals( DataFlavor.stringFlavor ) ) {
			return obj.toString();
		}
		return obj;
	}

	public boolean isDataFlavorSupported( DataFlavor flavor ) {
		return flavor.equals( DataFlavor.stringFlavor ) ||
		       flavor.getPrimaryType().equals( "application" )
		       && flavor.getSubType().equals( "x-java-serialized-object" )
		       && flavor.getRepresentationClass().isAssignableFrom( obj.getClass() );
	}
}
