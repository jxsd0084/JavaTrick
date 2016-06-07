package bj.DesignPattern.JavaAndPattern.ITERATOR.badexample;

import java.awt.*;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Display extends Panel {

	public List itemList = new LinkedList();

	public Display() {
		//write your code here
	}

	public void initList( Vector opts ) {
		Enumeration enu = opts.elements();

		while ( enu.hasMoreElements() ) {
			String item = (String) enu.nextElement();
			itemList.add( item );
		}
	}

}
