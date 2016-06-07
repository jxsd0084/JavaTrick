package bj.powernode.basic.day26.EMS.common;

import java.awt.*;

public class GBC extends GridBagConstraints {

	public GBC( int gridx, int gridy, int gridwidth, int gridheight,
	            int weightx, int weighty ) {

		super();
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
		this.weightx = weightx;
		this.weighty = weighty;
	}


	public GBC setInsets( int dis, Orientation o ) {

		if ( o == Orientation.BOTTOM ) {

			this.insets.bottom = dis;

		} else if ( o == Orientation.TOP ) {

			this.insets.top = dis;

		} else if ( o == Orientation.LEFT ) {

			this.insets.left = dis;

		} else if ( o == Orientation.RIGHT ) {

			this.insets.right = dis;

		}

		return this;
	}


	public GBC setFill( int fill ) {

		this.fill = fill;
		return this;
	}

	public GBC setAnchor( int anchor ) {

		this.anchor = anchor;
		return this;
	}


}
