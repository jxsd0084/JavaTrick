package com.bjpowernode.hibernate.test;

import com.bjpowernode.hibernate.bean.User;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testHibernate() {
		
		// 加载Hibernate配置信息

		// 配置信息所在的文件名默认为 hibernate.cfg.xml

		// new Configuration()在加载hibernate.properties,

		// new Configuration().configure() 在加载hibernate.cfg.xml

		// 这么写为了兼容性
		Configuration config = new Configuration().configure();
		
		// SessionFactory可以理解为对应数据库的一个镜像，这个对象原则上只创建一份，这个对象是线程安全的。
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = null;

		try {

			// 获取数据库连接
			session = sf.openSession();
			
			// Hibernate默认数据库操作的事务为不是自动提交。
			
			// 所以要想使用Hibernate，必须启用事务
			session.beginTransaction();
			
			// 创建对象
			User user = new User();
			user.setName("lisi");
			user.setAge(20);
			user.setRegdate( new Date() );
			
			// 保存数据
			//session.save(user);
			//session.save(user);
			
			// 提交事务
			session.getTransaction().commit();
			
		} catch ( Exception e ) {

			e.printStackTrace();

			// 回滚事务
			session.getTransaction().rollback();

		} finally {

			// 关闭资源
			if ( session != null ) {
				if ( session.isOpen() ) {
					session.close();
				}
			}
		}

	}
}
