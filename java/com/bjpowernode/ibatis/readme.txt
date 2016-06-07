1. 创建普通JAVA项目

2. 引入依赖包
	ibatis-2.3.4.726.jar （Ibatis类库）
	junit-3.8.2.jar （单体测试）
	log4j-1.2.8.jar （日志类库）
	mysql-connector-java-5.0.6-bin.jar （MYSQL数据库驱动）

3. 创建表
create table t_user (
    user_code varchar(30) not null,
    user_name varchar(30),
    password  varchar(10),
    primary key (user_code)
);

create table t_emp (
    emp_code varchar(30) not null,
    emp_name varchar(30),
    age  int,
    primary key (emp_code)
);

4. 拷贝log4j的配置文件到项目的src下(运行时生成到classpath下)
5. 拷贝IBatis配置文件到项目的src下
6. 增加javabean User
7. 增加映射文件
8. 在IBatis的配置文件中引入映射文件
9. 创建Ibatis操作类SqlMapClient
10. 使用SqlMapClient访问SQL文

IBatis 实际是对SQL的映射 SQL Mapper,
ORM (  Object Relation Mapping )