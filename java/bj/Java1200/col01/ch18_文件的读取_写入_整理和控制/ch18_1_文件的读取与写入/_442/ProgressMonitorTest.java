package bj.Java1200.col01.ch18_文件的读取_写入_整理和控制.ch18_1_文件的读取与写入._442;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ProgressMonitorTest {

	public void useProgressMonitor( JFrame frame, String copyPath, String newPath ) {

		try {
			File             file    = new File( copyPath ); // 根据要复制的文件创建File对象
			File             newFile = new File( newPath ); // 根据复制后文件的保存地址创建File对象
			FileOutputStream fop     = new FileOutputStream( newFile ); // 创建FileOutputStream对象
			InputStream      in      = new FileInputStream( file );
			// 读取文件，如果总耗时超过2秒，将会自动弹出一个进度监视窗口。
			ProgressMonitorInputStream pm = new ProgressMonitorInputStream(
					frame, "文件读取中，请稍后...", in );
			int    c     = 0;
			byte[] bytes = new byte[ 1024 ]; // 定义byte数组
			while ( ( c = pm.read( bytes ) ) != - 1 ) { // 循环读取文件
				fop.write( bytes, 0, c ); // 通过流写数据
			}
			fop.close(); // 关闭输出流
			pm.close(); // 关闭输入流
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
