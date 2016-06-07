package bj.crazy.ch15.u08.externalizable;

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
public class Person implements Externalizable {

	private String name;
	private int    age;

	public Person( String name, int age ) {

		System.out.println( "有参数的构造器" );
		this.name = name;
		this.age = age;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public int getAge() {

		return this.age;
	}

	public void writeExternal( ObjectOutput out )
			throws IOException {

		out.writeObject( new StringBuffer( name ).reverse() );
		out.writeInt( age );
	}

	public void readExternal( ObjectInput in )
			throws IOException, ClassNotFoundException {

		this.name = ( (StringBuffer) in.readObject() ).reverse().toString();
		this.age = in.readInt();
	}
}
