package com.bjpowernode.ibatis.test;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import junit.framework.TestCase;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class IbatisTest extends TestCase {

	// Ibatis访问对象
	private SqlMapClient sqlMapper;
	protected void setUp() throws Exception {
	    try {
	    	// 读取Ibatis的配置文件,从classpath下查找
	        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	        // 创建Ibatis访问对象
	        sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
	        reader.close(); 
	      } catch (IOException e) {
	    	  e.printStackTrace();
	      }
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDBOper() {
		try {
			// 使用Ibatis对象访问数据库
			
			// 查询数据
			//  queryForList的参数为SQL文的映射ID
			List<User> list = sqlMapper.queryForList("selectUsers");
			
			for ( User u : list ) {
				System.out.println("usercode:" + u.getUsercode() + ",username:" + u.getUsername() + ".password:" + u.getPassword());
			}
			//assertEquals(3, list.size());
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}
}
