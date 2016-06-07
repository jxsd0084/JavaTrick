package bj.powernode.advance.Charpter18.src.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 在这里老吴准备了一个专门记录异常信息的文件
 * <p>
 * 在有些情况下,是服务器端出现的问题,不方便让用户知道,
 * <p>
 * 输出到一个专门的记录异常的日志文件中,方面后续进行跟踪
 */

public class Logger {

	// 准备好一个log文件的路径,在C盘的根目录下面
	private static String fileName = "c:\\log.txt";

	// 打印异常信息的方法,静态方法,参数:Throwable t
	public static void printException( Throwable t ) {

		// 准备一个文件输出流
		FileOutputStream fout = null;

		try {

			fout = new FileOutputStream( fileName, true );
			PrintStream ps = new PrintStream( fout );

			// 调用静态方法getDateInfo,获取返回值赋给String类型的dateInfo
			String dateInfo = getDateInfo();
			// 将日期输出
			ps.println( dateInfo );
			// 包装成异常信息输出到文件中去
			t.printStackTrace( ps );

			// 如果发生了"FileNotFoundException"异常时
		} catch ( FileNotFoundException e ) {
			// 打印异常堆栈信息
			e.printStackTrace();

			// 最后将流给关闭掉
		} finally {
			if ( fout != null ) {
				try {
					fout.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}

	// 获得日期的静态方法,返回String类型,无参数
	private static String getDateInfo() {

		// 先导入java.util.*,创建Date对象
		Date date = new Date();

		// 导入java.text.SimpleDateFormat包,创建后设置日期格式

		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS" );

		// 将得到的日期返回
		return format.format( date );
	}
}
