package bj.bigData.HBase.ex03.writer.bean;

import java.io.File;

public class FileInfo {

	private File file;
	boolean isFinished = false;

	public FileInfo() {

	}

	public FileInfo( File file ) {

		super();
		this.file = file;
	}

	public File getFile() {

		return file;
	}

	public void setFile( File file ) {

		this.file = file;
	}

	public boolean isFinished() {

		return isFinished;
	}

	public void setFinished( boolean isFinished ) {

		this.isFinished = isFinished;
	}
}
