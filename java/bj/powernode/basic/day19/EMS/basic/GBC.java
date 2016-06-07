package bj.powernode.basic.day19.EMS.basic;

import java.awt.*;

public class GBC extends GridBagConstraints {

	private static final long serialVersionUID = -431128636591623671L;

	public GBC() {

		super();
	}

	public GBC( int gridx, int gridy, int gridwidth, int gridheight ) {

		super();
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}

	public GBC setWeight( int weightx, int weighty ) {

		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}

	public GBC setInsets( int top, int bottom, int left, int right ) {

		this.insets = new java.awt.Insets( top, left, bottom, right );
		return this;
	}

	public GBC setInsets( int distance ) {

		this.insets = new java.awt.Insets( distance, distance, distance, distance );
		return this;
	}

	public GBC setIpad( int ipadx, int ipady ) {

		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}

	public GBC setAnchor( int anchor ) {

		this.anchor = anchor;
		return this;
	}

	public GBC setFill( int fill ) {

		this.fill = fill;
		return this;
	}

	public GBC setInsetsOfX( int distance, Insets x ) {

		if ( x == Insets.TOP ) {
			this.insets.top = distance;
		} else if ( x == Insets.BOTTOM ) {
			this.insets.bottom = distance;
		} else if ( x == Insets.LEFT ) {
			this.insets.left = distance;
		} else if ( x == Insets.RIGHT ) {
			this.insets.right = distance;
		}
		return this;
	}
}

