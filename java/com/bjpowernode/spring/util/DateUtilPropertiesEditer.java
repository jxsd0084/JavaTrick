package com.bjpowernode.spring.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilPropertiesEditer extends PropertyEditorSupport {

	private String patter = null;

	public void setPatter( String patter ) {
		this.patter = patter;
	}

	@Override
	public void setAsText( String arg0 ) throws IllegalArgumentException {
		//System.out.println("---DateUtilPropertiesEditer setAsText---");

		SimpleDateFormat sdf = new SimpleDateFormat( this.patter );
		try {
			Date d = sdf.parse( arg0 );
			this.setValue( d );
		} catch ( ParseException e ) {
			e.printStackTrace();
		}
	}

}
