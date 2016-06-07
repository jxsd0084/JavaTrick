package bj.Java1200.col01.ch21_SQL应用.ch21_2_聚集函数和日期查询._508_利用MAX函数求数据表中的最大值;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderFormUtil {

	Connection conn = null;

	// 获取数据库连接

	public Connection getConn() {

		try {
			Class.forName( "net.sourceforge.jtds.jdbc.Driver" ); // 加载数据库驱动
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		String url      = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // 连接数据库URL
		String userName = "sa"; // 连接数据库的用户名
		String passWord = ""; // 连接数据库密码
		try {
			conn = DriverManager.getConnection( url, userName, passWord ); // 获取数据库连接
			if ( conn != null ) {

			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return conn; // 返回Connection对象
	}
	// 定义按指定按指定条件降序查询数据方法

	public List getMAXOrder() {

		List list = new ArrayList(); // 定义用于保存返回值的List集合
		conn = getConn(); // 获取数据库连接
		try {
			Statement staement = conn.createStatement();
			String sql = "select clientName,clientArea,clientMoney,visePerson from tb_orderForm " +
					"where clientMoney = (select max(clientMoney) from tb_orderForm)"; // 定义查询签订的订单金额最大的信息
			ResultSet set = staement.executeQuery( sql ); // 执行查询语句返回查询结果集
			while ( set.next() ) { // 循环遍历查询结果集
				OrderForm orderForm = new OrderForm();
				orderForm.setClientArea( set.getString( "clientArea" ) );
				orderForm.setVisePerson( set.getString( "visePerson" ) );
				orderForm.setClientMoney( set.getFloat( "clientMoney" ) );
				orderForm.setClientName( set.getString( "clientName" ) );
				list.add( orderForm );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return list;        //返回List集合
	}

	public static void main( String[] args ) {

		OrderFormUtil util = new OrderFormUtil();
		List          list = util.getMAXOrder();
		System.out.println( "查询签订订单最多的客户信息：" );
		for ( int i = 0; i < list.size(); i++ ) {
			OrderForm orderForm = ( OrderForm ) list.get( i );
			System.out.println( "客户所在地区：" + orderForm.getClientArea() + " ,客户：" + orderForm.getClientName() + " ，金额：" + orderForm.getClientMoney()
					+ " ，签约人：" + orderForm.getVisePerson() );
		}
	}
}
