-- 数据库定义语句  DDL


DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    ID        NUMBER(4),
    NAME      VARCHAR2(20),
    SEX       CHAR(2) DEFAULT  '男',
    BIRTHDAY  DATE ,
    EMAIL     VARCHAR2(20)
);


INSERT INTO DEPT_BAK VALUES(20,'生产部',1001)



DROP TABLE DEPT_BAK;
CREATE TABLE DEPT_BAK 
AS
SELECT DEPTNO "部门编号", DNAME "部门名称", LOC_ID "位置编号" FROM DEPT WHERE DEPTNO < 30;


DROP TABLE DEPT_BAK;
CREATE TABLE DEPT_BAK (
  部门编号, 部门名称, 位置
)
AS
SELECT DEPTNO  ,DNAME ,LOC_ID  FROM DEPT WHERE DEPTNO < 30;


SELECT * FROM DEPT_BAK;



DROP TABLE STUDENT;
CREATE TABLE STUDENT(
    ID        NUMBER(4),
    NAME      VARCHAR2(20),
    SEX       CHAR(2) DEFAULT '男',
    BIRTHDAY  DATE,
    EMAIL     VARCHAR2(20)
);



INSERT INTO STUDENT(ID,NAME,BIRTHDAY) VALUES (1000,'张一','23-12月-1987');


-- 添加字段
ALTER TABLE STUDENT
   ADD  ADDR    VARCHAR2(20)  DEFAULT   '北苑路金苑大厦';
   
   
-- 修改字段,修改字段的类型,和长度,和缺省值
-- 在没有数据的情况下,字段类型总是可以修改成功的
ALTER TABLE STUDENT
   MODIFY  EMAIL  VARCHAR2(30);

-- 在有数据的情况下,字段类型是不能修改的
ALTER TABLE STUDENT
   MODIFY  ADDR  NUMBER(4);   


-- 在有数据的情况下,增大数据的长度总是可以的
ALTER TABLE STUDENT  
   MODIFY  ADDR   VARCHAR2(50)
   
-- 在有数据的情况下,减小数据的长度有可能成功   
-- 要以原来的数据作为减小的标准
ALTER TABLE STUDENT  
   MODIFY  ADDR   VARCHAR2(14)


-- 对缺省值的修改,对已有的数据没有影响,之后影响以后插入的数据
ALTER TABLE STUDENT
   modify  ADDR    VARCHAR2(40)  DEFAULT   '北京市朝阳区北苑路金苑大厦';
   
INSERT INTO STUDENT(ID,NAME,BIRTHDAY) VALUES (1001,'张二','23-12月-1987');   


ALTER TABLE STUDENT 
   DROP COLUMN  EMAIL;



TRUNCATE TABLE STUDENT;


RENAME STUDENT TO STUDENTS;

SELECT * FROM STUDENTS;



-- 在建表的时候创建约束
DROP TABLE USERS;
CREATE TABLE USERS(
     ID      NUMBER(4),
     NAME    VARCHAR2(20) NOT NULL,
     SEX     CHAR(2),
     ADDR    VARCHAR2(20) ,
     SAL     NUMBER(7,2)  NOT NULL ,
     CONSTRAINTS PK_USERS  PRIMARY KEY  (ID)
);





DROP TABLE USERS;
CREATE TABLE USERS(
     ID      NUMBER(4),
     NAME    VARCHAR2(20) NOT NULL,
     SEX     CHAR(2),
     ADDR    VARCHAR2(20) ,
     SAL     NUMBER(7,2)  NOT NULL ,
     EMAIL   VARCHAR(40),
     CONSTRAINTS PK_USERS  PRIMARY KEY  (ID),
     CONSTRAINTS EMAIL_UNI   UNIQUE  (EMAIL)
);


-- UNIQUE 不能重复,但是可以为null
-- UNIQUE可以同时作用在多个字段上
INSERT INTO USERS (ID,NAME,SEX,ADDR ,SAL,EMAIL) VALUES (2,'张二','男','北京朝阳区',2000 ,'zhanger@163.com');
INSERT INTO USERS (ID,NAME,SEX,ADDR ,SAL,EMAIL) VALUES (3,'张三','女','北京朝阳区',2000 ,null);



-- UNIQUE可以同时作用在多个字段上
DROP TABLE USERS;
CREATE TABLE USERS(
     ID      NUMBER(4),
     NAME    VARCHAR2(20) ,    
     EMAIL   VARCHAR(40),
     CONSTRAINTS PK_USERS  PRIMARY KEY  (ID),
     CONSTRAINTS EMAIL_NAME_UNI   UNIQUE  (NAME,EMAIL)
);

INSERT INTO USERS (ID,NAME,EMAIL) VALUES (4,'张1','zhangyi@163.com');
INSERT INTO USERS (ID,NAME,EMAIL) VALUES (2,'张1','zhangyi1@163.com');
INSERT INTO USERS (ID,NAME,EMAIL) VALUES (3,'zhangyi@163.com','张1');

INSERT INTO USERS (ID,NAME,EMAIL) VALUES (9,null,null);


-- 主键约束,非空且唯一
DROP TABLE USERS;
CREATE TABLE USERS(
     ID      NUMBER(4)  PRIMARY KEY ,
     NAME    VARCHAR2(20) ,    
     EMAIL   VARCHAR(40)
   --  CONSTRAINTS PK_USERS  PRIMARY KEY  (ID)
);


INSERT INTO USERS (ID,NAME,EMAIL) VALUES (2,'张二','zhangyi@163.com');


-- 在一个表中,只能有唯一的一个主键约束,而其他的约束没有数量限制
-- 主键可以唯一的确定一条记录
-- 主键约束可以同时作用在多个字段上

DROP TABLE USERS;
CREATE TABLE USERS(
     FIRST_NAME         VARCHAR2(20),
     LAST_NAME          VARCHAR2(20),
     AGE                NUMBER(3),
     CONSTRAINTS PK_USERS   PRIMARY KEY (FIRST_NAME,LAST_NAME)
);


INSERT INTO USERS  VALUES('张','一' ,23);
INSERT INTO USERS VALUES('张','二' ,23);
INSERT INTO USERS VALUES('二','张' ,23);
INSERT INTO USERS VALUES('张','一' ,23);


INSERT INTO USERS VALUES(NULL,'三' ,23);

-- 应该选用什么样的数据作为表的主键?应该选用和业务无关的流水号来当做表的主键


-- 外键约束 ,可以重复,可以为NULL




-- 在删除表的时候 ,先删除子表,后删除父表
DROP TABLE EMPLS;
DROP TABLE DEPTS;


-- 在建表的时候, 先建父表,后建子表
CREATE TABLE DEPTS(
    DNO         NUMBER(4) PRIMARY KEY ,
    DNAME       VARCHAR2(20) ,
    LOC         VARCHAR2(20),
    CONSTRAINTS  NAME_NUI  UNIQUE (DNAME)
);

CREATE TABLE EMPLS(
    EID           NUMBER(4)  PRIMARY KEY,
    ENAME         VARCHAR2(20),
    JOB           VARCHAR2(20),
    D_NO          NUMBER(4)
   -- CONSTRAINTS FK_EMP_DEPT  FOREIGN KEY  (D_NO) REFERENCES DEPTS (DNO)
);


-- 在添加数据的时候
INSERT INTO DEPTS VALUES (10,'开发部');
INSERT INTO DEPTS VALUES (20,'技术部');
INSERT INTO DEPTS VALUES (30,'销售部');
INSERT INTO DEPTS VALUES (40,'生产部');
commit;

SELECT * FROM DEPTS;
SELECT * FROM EMPLS;

INSERT INTO EMPLS VALUES (1001,'张一','产品经理',20);
INSERT INTO EMPLS VALUES (1002,'张二','产品副经理',20);
INSERT INTO EMPLS VALUES (1003,'张三','工程师',10);
INSERT INTO EMPLS VALUES (1004,'张四','高级工程师',10);
COMMIT;

-- 在删除数据的时候 
--TRUNCATE TABLE EMPLS;
DELETE FROM EMPLS;
DELETE FROM DEPTS;

-- 一个表的什么样的数据可以被其他表引为外键?一个表的主键或唯一键可以被其他表引为外键


DROP TABLE USERS;
CREATE TABLE USERS(
   ID        NUMBER(4) PRIMARY KEY,
   NAME      VARCHAR2(20),
   SEX       CHAR(2),
   SAL       NUMBER(7,2)
   --CONSTRAINTS AVAL_SEX  CHECK  (SEX  IN ('男','女')),
   --CONSTRAINTS MIN_SAL   CHECK  (SAL > 0)     
);


ALTER TABLE USERS
  ADD  CONSTRAINT  MIN_SAL   CHECK  (SAL > 0);

-- 删除DEPTS表的主键约束,并且把引用该主键作为外键的约束也删除掉
ALTER TABLE DEPTS
  DROP PRIMARY KEY CASCADE;


SELECT * FROM EMPLS;
INSERT INTO EMPLS  VALUES (1000,'张一','工程师',9000);

ALTER TABLE USERS
   DROP CONSTRAINT MIN_SAL;


SELECT * FROM EMP;


CREATE INDEX   EMP_NAME_INDEX  
   ON EMP (ENAME);

INSERT INTO USERS  VALUES (1000,'张一' ,'女',0);




-- 创建视图
CREATE OR REPLACE  VIEW V_EMP  
AS
SELECT * FROM EMP WHERE DEPTNO = 10;



CREATE OR REPLACE  VIEW V_EMP  
AS
SELECT E.EMPNO  "员工编号",E.ENAME "员工姓名",E.JOB "职位"  ,E.MGR "经理", E.HIREDATE "雇佣日期",   E.SAL "月薪" ,  (E.SAL * 12 + NVL(E.COMM ,0)) "年薪"  ,E.DEPTNO "部门编号",D.DNAME "部门名称",D.LOC_ID 位置
FROM EMP E ,DEPT D
WHERE E.DEPTNO = 10  AND E.DEPTNO = D.DEPTNO;



CREATE OR REPLACE  VIEW V_EMP  
AS
SELECT E.EMPNO  "员工编号",E.ENAME "员工姓名",E.JOB "职位"  ,E.MGR "经理", E.HIREDATE "雇佣日期",   E.SAL "月薪" 
FROM EMP E 
WHERE E.DEPTNO = 10  
WITH READ ONLY;



SELECT EE.部门编号 ,MAX(EE.月薪)
  FROM (SELECT E.EMPNO    "员工编号",
               E.ENAME    "员工姓名",
               E.JOB      "职位",
               E.MGR      "经理",
               E.HIREDATE "雇佣日期",
               E.SAL      "月薪",
               E.DEPTNO   "部门编号"
          FROM EMP E
         WHERE E.DEPTNO = 10) EE
GROUP BY     "部门编号"     
        


INSERT INTO V_EMP VALUES(9000,'张一','工程师',7839,'12-3月-1987',4000)


DROP VIEW V_EMP;

SELECT * FROM EMP;



-- TOP分析法

SELECT  ROWNUM NO , EE.ENAME,EE.SAL
FROM (SELECT E.ENAME, E.SAL FROM EMP E ORDER BY SAL ) EE
WHERE ROWNUM <= 3


SELECT *
  FROM (SELECT ROWNUM NO, EE.ENAME, EE.SAL
          FROM (SELECT E.ENAME, E.SAL FROM EMP E ORDER BY SAL) EE)
 WHERE NO >= 12



-- 同义词
SELECT  SYSDATE
FROM SYS.DUAL;


SELECT  SYSDATE
FROM DUAL;




SELECT MAX(EMPNO) FROM EMP;


CREATE TABLE USERS(
   ID          NUMBER(4) PRIMARY KEY,
   NAME        VARCHAR2(20) 
)

INSERT INTO USERS values(USERS_PK.NEXTVAL ,'张一');

SELECT * FROM USERS;

DELETE FROM USERS WHERE ID > 5;


SELECT USERS_PK.CURRVAL FROM SYS.DUAL;
