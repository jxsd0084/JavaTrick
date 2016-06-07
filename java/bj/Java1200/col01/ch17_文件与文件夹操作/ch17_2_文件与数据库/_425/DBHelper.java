package bj.Java1200.col01.ch17_文件与文件夹操作.ch17_2_文件与数据库._425;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper implements DBConfig {

	public static void saveImage( String name, String type, File image ) {

		Connection        conn = null;
		PreparedStatement ps   = null;
		try {
			Class.forName( DRIVER );// 加载驱动
			conn = DriverManager.getConnection( URL, USERNAME, PASSWORD );// 建立连接
			ps = conn.prepareStatement( "insert into picture values (?, ?, ?);" );
			ps.setString( 1, name );// 保存图片名称
			ps.setString( 2, type );// 保存图片类型
			ps.setString( 3, image.getAbsolutePath() );// 保存图片的绝对路径
			ps.executeUpdate();// 执行保存
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			if ( ps != null ) {
				try {
					ps.close();
				} catch ( SQLException e ) {
					e.printStackTrace();
				}
			}
			if ( conn != null ) {
				try {
					conn.close();
				} catch ( SQLException e ) {
					e.printStackTrace();
				}
			}
		}
	}
}
