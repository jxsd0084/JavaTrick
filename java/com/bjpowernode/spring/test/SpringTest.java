package com.bjpowernode.spring.test;

import com.bjpowernode.spring.bean.User;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest extends TestCase {

	private ApplicationContext context;

	protected void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext( "applicationContext-*.xml" );
		System.out.println( " context finish" );
	}

	public void testUser() {

		System.out.println( " getBean before" );
		User user = (User) context.getBean( "user" );

		System.out.println( " getBean after" );
		System.out.println( user.getUsercode() );

//		System.out.println(user.getUsername());
//		System.out.println(user.getClasses().getCid());
//		System.out.println(user.getClasses().getCname());

//		System.out.println(user.getDate());
//		System.out.println(user.getMap());

	}
}
