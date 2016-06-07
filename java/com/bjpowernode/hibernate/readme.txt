Ver 1.0
	第一个Hibernate程序演示

1) 创建JAVA项目

2) 引入Hibernate相关的JAR包
	antlr-2.7.6.jar
	asm.jar
	c3p0-0.9.1.jar
	cglib-2.1.3.jar
	commons-collections-2.1.1.jar
	commons-logging-1.0.4.jar
	dom4j-1.6.1.jar
	ehcache-1.2.3.jar
	jta.jar
	log4j-1.2.11.jar
	hibernate3.jar
	
3) 引入数据库驱动
	mysql-connector-java-5.0.6-bin.jar
	
4) 引入Hibernate操作数据库的配置文件
	hibernate.cfg.xml,将文件放置到classpath下可以查找的地方
	文件内容如下：
	<hibernate-configuration>
		<session-factory>
		    <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
		    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/egov?useUnicode=true&amp;characterEncoding=gbk&amp;autoReconnect=true&amp;failOverReadOnly=false</property>
		    <property name="hibernate.connection.username">egov</property>
		    <property name="hibernate.connection.password">egov</property>
	        <!-- 方言 -->
	        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
		</session-factory>
	</hibernate-configuration>
	
5) 创建POJO（实体类）对象

6) 创建映射文件。和实体类对象放置同一个包中
将POJO对象和数据表进行关联
	<hibernate-mapping>
	
	    <!-- name属性表示对应的POJO对象 -->
		<class name="com.bjpowernode.hibernate.bean.User">
		    <!--
		    主键
		    
		    name属性为POJO对象的主键属性
		    -->
		    <id name="id">
		        <!-- 主键生成策略 -->
		        <generator class="uuid" />
		    </id>
		    <!-- 没有列名，默认将列名和属性名一致。 -->
		    <property name="name" />
		    <property name="age" />
		    <property name="regdate" />
		</class>
		
	</hibernate-mapping>
	
7）将映射文件引入到Hibernate的配置文件中, 在SessionFactory标签中增加
	<mapping resource="com/bjpowernode/hibernate/bean/User.hbm.xml"/>

8) 使用工具将POJO对象生成表
	Configuration config = new Configuration().configure();
	SchemaExport export = new SchemaExport( config );
	export.create(true, true);
	
9) 增加Log4j配置信息

10) 写保存数据的代码

Hibernate的优点：
	* 将数据库也看成对象，以对象的方式去操作更加容易。
	* 没有一句SQL语句，对SQL语句的完全封装，代码量变少，简化程序开发，提高开发效率
	* 测试更加容易
	* 没有侵入性，对数据模型没有侵入性，修改起来更加容易。
	* 透明持久化。
	
缺点：
	* 在工作中，业务往往非常复杂，SQL也会非常复杂，有时Hibernate并不能完全实现这些功能。
	  在系统中，存在很多的复杂SQL语句操作，就不要使用hibernate。
	  
	* 大数据量操作时，效率会非常的低.
	
IBatis和Hibernate，用哪一个？

	如果SQL语句掌握的比较好，系统中SQL操作比较复杂，推荐使用IBatis。
	
	如果SQL语句不行或系统中SQL操作很简单，那么就使用Hibernate.
	
	
	

Hibernate主键生成策略：

1) uuid
   根据当前的设备IP，当前时间，JVM启动时间，内部自增量4个 参数生成的16进制数值，转码为32位的字符串。
   重复的可能性比较小,Hibernates生成
   
2) assigned
   主键由业务逻辑生成，无需Hibernate干涉
   
3) hilo
   通过特定的算法实现主键生成，需要额外的表来保存主键的状态。
   
4) increment
   主键按照数值自增，实现的机制就是在当前的环境当中声明一个变量，保存自增的数值，
   可能会发生问题，不同的环境访问同一数据库，那么会发生主键重复。
   
5) identity
   采用数据库生成主键的机制。
   
6) sequence
   数据库提供支持sequence机制生成主键。
   
7) native
   由hibernate提供数据库适配器中的定义，自动采用其中的一种主键生成方式。
   
   
Hibernate查询也要使用事务，
使用数据库事务的隔离级别。

Hibernate事务提交之后，最好将session关闭，否则可能会出现问题。
	


