package bj.mldn.javase01.no69.persondemo;

import java.io.*;

public class FileOperate {

	private File file = null;

	public FileOperate( String path ) {

		this.file = new File( path ); // 从外部指定操作的文件路径
	}

	public void save( Object obj ) throws Exception {

		ObjectOutputStream oos = null;
		oos = new ObjectOutputStream( new FileOutputStream( file ) );
		oos.writeObject( obj );
		oos.close();
	}

	public Object load() throws Exception {

		Object            temp = null;
		ObjectInputStream ois  = null;
		ois = new ObjectInputStream( new FileInputStream( file ) );
		temp = ois.readObject();
		return temp;
	}
}
