package bj.powernode.basic.day26.EMS.common;

import javax.swing.*;

public class OperationButton extends JButton {

	/**
	 * value
	 */
	private String value;

	public String getValue() {

		return value;
	}

	public void setValue( String value ) {

		this.value = value;
	}

	public OperationButton( String text ) {

		super( text );
	}

}
