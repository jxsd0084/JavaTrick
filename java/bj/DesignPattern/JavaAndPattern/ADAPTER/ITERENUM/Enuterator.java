package bj.DesignPattern.JavaAndPattern.ADAPTER.ITERENUM;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Enuterator implements Iterator {

	Enumeration _enum;

	public Enuterator( Enumeration _enum ) {
		this._enum = _enum;
	}

	public boolean hasNext() {
		return _enum.hasMoreElements();
	}

	public Object next() throws NoSuchElementException {
		return _enum.nextElement();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
