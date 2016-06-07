package com.bjpowernode.hibernate.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportTableTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 将POJO对象生成表

		Configuration config = new Configuration().configure();

		SchemaExport export = new SchemaExport( config );

		export.create( true, true );

	}

}
