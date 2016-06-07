package bj.mldn.DAO.org.lxh.oracle.dbc;

import java.sql.* ;
public class DataBaseConnection{
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	public static final String DBUSER = "scott" ;
	public static final String DBPASS = "tiger" ;
	private Connection conn = null ;
	public DataBaseConnection(){
		try{
			Class.forName(DBDRIVER) ;
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS) ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
	}
	public Connection getConnection(){
		return this.conn ;
	}
	public void close(){
		if(this.conn!=null){
			try{
				this.conn.close() ;
			}catch(Exception e){}
		}
	}
};
