package bj.bigData.HBase.ex03.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 提供一些操作文件文件夹的公共方法
 *
 * @author ranhualin
 * @date 2013-1-4
 */
public class FileUtils {

	@SuppressWarnings( "unused" )
	private static Logger logger = LoggerFactory.getLogger( FileUtils.class );
	private        String path   = null;

	private File file = null;

	private InputStreamReader read = null;

	private BufferedReader reader = null;

	private OutputStreamWriter write = null;

	private BufferedWriter writer = null;

	/**
	 * 构造函数
	 *
	 * @param path example:/opt/test
	 */
	public FileUtils( String path ) {

		this.path = path;

		init();
	}

	/**
	 * 构造函数
	 *
	 * @param file 文件或目录对像
	 */
	public FileUtils( File file ) {

		this.file = file;

		init();
	}

	private void init() {

		if ( file == null ) {
			file = new File( path );
		}
	}

	/**
	 * 获取文件实体
	 *
	 * @return
	 */
	public File getFile() {

		return this.file;
	}

	/**
	 * 获取文件路径
	 *
	 * @return
	 */
	public String getPath() {

		return file.getPath();
	}

	/**
	 * 获取文件名
	 *
	 * @return
	 */
	public String getFileName() {

		return file.getName();
	}

	/**
	 * 根据初始化的路径，创建文件
	 *
	 * @return
	 * @throws IOException
	 * @throws IOException
	 */
	public File createFile() throws IOException {

		if ( !file.exists() ) {
			if ( file.createNewFile() ) {
				return file;
			} else {
				return null;
			}
		} else {
			return file;
		}
	}

	/**
	 * 根据初始化的路径，创建目录
	 *
	 * @return
	 */
	public File createDir() {

		if ( !file.exists() ) {
			if ( file.mkdir() ) {
				return file;
			} else {
				return null;
			}
		} else {
			return file;
		}

	}

	/**
	 * 重命名文件或目录的名称，只能重命名名字，不能移动
	 *
	 * @param otherName 重命名的文件名
	 * @return
	 */
	public boolean rename( String otherName ) {

		String otherPath = null;
		File   otherFile = null;

		otherPath = file.getParent() + "/" + otherName;

		otherFile = new File( otherPath );

		if ( file.exists() ) {
			if ( file.renameTo( otherFile ) ) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 移动文件或目录,文件名不变
	 *
	 * @param destPath
	 */
	public boolean move( String destPath ) {

		File destFile = null;

		destFile = new File( destPath + file.getName() );
		if ( file.exists() ) {
			if ( file.renameTo( destFile ) ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 移动文件或目录，指定文件名
	 *
	 * @param destPath
	 * @param fileName
	 * @return
	 */
	public boolean move( String destPath, String fileName ) {

		File destFile = null;

		destFile = new File( destPath + fileName );
		if ( file.exists() ) {
			if ( file.renameTo( destFile ) ) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 开启文件读取器，只适用于文本文件
	 *
	 * @param file
	 * @throws IOException
	 */
	public void openFileReader() throws IOException {

		if ( file == null ) {
			file = new File( path );
		}

		if ( !file.isFile() ) {
			throw new IOException( "\"" + path + "\" is not a file path!" );
		}
		if ( !file.exists() ) {
			throw new IOException( "\"" + path + "\" haven't exists!" );
		}

		read = new InputStreamReader( new FileInputStream( file ) );
		reader = new BufferedReader( read );
	}

	/**
	 * 开启文件读取器，只适用于文本文件，指定编码方式
	 *
	 * @param file
	 * @throws IOException
	 */
	public void openFileReader( String encode ) throws IOException {

		if ( file == null ) {
			file = new File( path );
		}

		if ( !file.isFile() ) {
			throw new IOException( "\"" + path + "\" is not a file path!" );
		}
		if ( !file.exists() ) {
			throw new IOException( "\"" + path + "\" haven't exists!" );
		}

		read = new InputStreamReader( new FileInputStream( file ), encode );
		reader = new BufferedReader( read );
	}

	/**
	 * 必须在调用了openFileReader方法以后，才能使用，一次读出一行的数据，当数据读完没有时返回null
	 *
	 * @return
	 * @throws IOException
	 */
	public String readLine() throws IOException {

		return reader.readLine();
	}

	/**
	 * 关闭文件读取器，openFileReader后，当读完数据后，必须使用该方法，将文件的读取器关闭，不然做其他操作会出错
	 *
	 * @throws IOException
	 */
	public void closeFileReader() throws IOException {

		read.close();
		reader.close();

		read = null;
		reader = null;
	}

	/**
	 * 开启文件写入器，只适用于文本文件
	 *
	 * @param file
	 * @throws IOException
	 */
	public void openFileWriter() throws IOException {

		if ( file == null ) {
			file = new File( path );
		}

		if ( !file.isFile() ) {
			throw new IOException( "\"" + path + "\" is not a file path!" );
		}
		if ( !file.exists() ) {
			file.createNewFile();
		}

		write = new OutputStreamWriter( new FileOutputStream( file ) );
		writer = new BufferedWriter( write );
	}

	/**
	 * 开启文件写入器，只适用于文本文件，指定编码
	 *
	 * @param file
	 * @throws IOException
	 */
	public void openFileWriter( String encode ) throws IOException {

		if ( file == null ) {
			file = new File( path );
		}

		if ( !file.isFile() ) {
			throw new IOException( "\"" + path + "\" is not a file path!" );
		}
		if ( !file.exists() ) {
			file.createNewFile();
		}

		write = new OutputStreamWriter( new FileOutputStream( file ), encode );
		writer = new BufferedWriter( write );
	}

	/**
	 * 必须在调用了openFileWriter方法以后，才能使用，一次写入一个字符串
	 *
	 * @param str
	 * @throws IOException
	 */
	public void writeString( String str ) throws IOException {

		writer.write( str );
	}

	/**
	 * 关闭文件写入器，openFileWriter后，当写完数据后，必须使用该方法，将文件的写入器关闭，不然做其他操作会出错
	 *
	 * @throws IOException
	 */
	public void closeFileWriter() throws IOException {

		writer.flush();

		write.close();
		writer.close();

		write = null;
		writer = null;
	}

	/**
	 * 获取目录下的所有文件(包括目录),初始化时必须指定的是目录路径
	 *
	 * @return
	 * @throws IOException
	 */
	public File[] getAllFiles() {

		File[] value = null;

		if ( file.exists() ) {

			value = file.listFiles();

			/**
			 * 根据文件名进行排序
			 */
			Arrays.sort( value );
		}

		return value;
	}

	/**
	 * 获取目录下的所有文件(不包括目录),初始化时必须指定的是目录路径
	 *
	 * @param fileName   指定的文件名，模糊匹配，没有指定可以用null或""代替
	 * @param extendName 指定的扩展名，模糊匹配，没有指定可以用null或""代替
	 * @return
	 */
	public File[] getFiles( String fileName, String extendName ) {

		File[] files  = null;
		Filter filter = null;

		filter = new Filter( fileName, extendName );
		files = file.listFiles( filter );// 取得所有文件信息

		/**
		 * 根据文件名进行排序
		 */
		if ( files != null ) {
			Arrays.sort( files );
		}

		return files;
	}

	/**
	 * 递归获取目录以及该目录子目录下的所有文件
	 *
	 * @param fileName
	 * @param extendName
	 * @return
	 */
	public File[] getAllFiles( String fileName, String extendName ) {

		List< File > files  = getAllIncludeFiles( file, null );
		List< File > nfiles = new ArrayList< File >();
		if ( files != null && files.size() > 0 ) {
			for ( File f : files ) {
				if ( fileName != null && !fileName.equals( "" )
				     && !checkFileName( f, fileName ) ) {
					continue;
				}
				if ( extendName != null && !extendName.equals( "" )
				     && !checkFileExtendName( f, extendName ) ) {
					continue;
				}
				nfiles.add( f );
			}
		}
		File[] rs = nfiles.toArray( new File[]{} );
		Arrays.sort( rs );
		return rs;
	}

	/**
	 * 递归获取目录以及该目录子目录下的所有文件
	 *
	 * @param fileName
	 * @param extendName
	 * @return
	 */
	public File[] getAllFileByPartName( String checkName, String checkTail ) {

		List< File > files  = getAllIncludeFiles( file, null );
		List< File > nfiles = new ArrayList< File >();
		if ( files != null && files.size() > 0 ) {
			for ( File f : files ) {
				if ( checkName != null && !checkName.equals( "" )
				     && !checkContains( f, checkName ) ) {
					continue;
				}
//				if (checkTail != null && !checkTail.equals("")
//						&& !checkFileExtendName(f, checkTail)) {
//					continue;
//				}
				nfiles.add( f );
			}
		}
		File[] rs = nfiles.toArray( new File[]{} );
		Arrays.sort( rs );
		return rs;
	}

	private boolean checkFileName( File file, String fileName ) {

		String name = file.getName();
		if ( name.lastIndexOf( "." ) == -1 ) {
			return fileName.equals( name );
		} else {
			String idxname = name.substring( 0, name.lastIndexOf( "." ) );
			return fileName.equals( idxname );
		}
	}

	private boolean checkStartWith( File file, String checkName ) {

		String name = file.getName();
		return name.startsWith( checkName );
	}

	private boolean checkContains( File file, String checkName ) {

		String name = file.getName();
		return name.indexOf( checkName ) != -1;
	}

	private boolean checkFileExtendName( File file, String extendName ) {

		String name = file.getName();
		int    di   = name.lastIndexOf( "." );
		if ( di != -1 && di < name.length() - 1 ) {
			String extname = name.substring( di + 1 );
			return extendName.equals( extname );
		} else {
			return false;
		}
	}

	private List< File > getAllIncludeFiles( File tfile, List< File > rsf ) {

		if ( rsf == null ) {
			rsf = new ArrayList< File >();
		}
		File[] files = tfile.listFiles();
		if ( files != null ) {
			for ( File f : files ) {
				if ( f.isDirectory() ) {
					getAllIncludeFiles( f, rsf );
				} else {
					rsf.add( f );
				}
			}
		}
		return rsf;
	}

	/**
	 * 删除文件
	 *
	 * @param file
	 */
	public boolean deleteFile() {

		boolean result = true;

		result = file.delete();

		return result;
	}
}

class Filter implements FileFilter {

	private String fileName = null;

	private String extendName = null;

	/**
	 * 构造函数
	 *
	 * @param filePrefix
	 * @param filePostfix
	 */
	public Filter( String fileName, String extendName ) {

		this.fileName = fileName;
		this.extendName = extendName;
	}

	@Override
	public boolean accept( File file ) {

		String   allName   = null;
		String[] names     = null;
		String   inName    = "";
		String   extName   = "";
		boolean  nameCheck = false;
		boolean  extCheck  = false;

		if ( file.isFile() ) {
			allName = file.getName();
			names = allName.split( "\\.", -1 );

			if ( names.length == 1 ) {
				inName = names[ 0 ];
			} else {
				for ( int i = 0; i < names.length - 1; i++ ) {
					inName = inName + names[ i ];
				}

				extName = names[ names.length - 1 ];
			}

			if ( fileName != null ) {
				if ( !fileName.equals( "" ) ) {
					if ( inName.indexOf( fileName ) >= 0 ) {
						nameCheck = true;
					}
				} else {
					nameCheck = true;
				}
			} else {
				nameCheck = true;
			}

			if ( extendName != null ) {
				if ( !extendName.equals( "" ) ) {
					if ( extName.indexOf( extendName ) >= 0 ) {
						extCheck = true;
					}
				} else {
					extCheck = true;
				}
			} else {
				extCheck = true;
			}
		}

		return nameCheck && extCheck;
	}
}
