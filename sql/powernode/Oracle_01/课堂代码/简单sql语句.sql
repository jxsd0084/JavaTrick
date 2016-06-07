-- 查询员工表的所有的记录
SELECT * FROM EMP;

SELECT SYSDATE FROM SYS.DUAL;


/*在Oracle中建表的时候,以那个用户登录
表就建在那个用户的方案之下
ORACLE中主要提供了三种数据类型
数值型
字符型
日期型

VARCHAR(50)   定长的字符串,就是50个字符
VARCHAR2(20)  变长的字符串,最大是20个
*/

CREATE TABLE USERS(
   ID          NUMBER(4) ,
   NAME        VARCHAR2(20),
   SEX         CHAR(2),
   BIRTHDAY    DATE,
   EMAIL       VARCHAR(50) ,
   SAL         NUMBER(7,2)
);


SELECT * FROM USERS;


-- oracle对大小写不敏感
Select * FrOm   eMp;




SELECT EMPNO  AS "员工编号" ,ENAME as "员工姓名",JOB  "工作" , MGR  经理, SAL 薪水
FROM EMP ;


-- 对NUMBER型数据可以使用算数操作符创建 表达式（+  -  *  /）
SELECT ENAME, SAL, (SAL * 12) AS "年薪"
FROM EMP ;

SELECT  ENAME, sal,comm, (SAL*12 + COMM) "年收入"
FROM EMP ;



-- 对于日期类型的数据,可以使用 + - 操作符

-- 日期类型的数据 + 数值类型  = 一个新的日期类型的数据
SELECT ENAME,HIREDATE  "雇佣日期"  ,(HIREDATE +90) "转正日期"
FROM EMP ;

-- 日期类型的数据 - 数值类型  =  一个新的日期类型的数据
SELECT ENAME,HIREDATE  "转正日期"  ,(HIREDATE - 90) "雇佣日期"
FROM EMP ;


-- 两个日期类型的数据 相减 得到一个 数值型的数据 (是两个日期直接的相差的天数)
SELECT  ENAME,   ((SYSDATE - HIREDATE)/365) as "年"
FROM EMP 


-- 两个日期类型的数据相加没有意义
-- 日期类型的数据不能进行乘除运算,没有意义




SELECT  EMPNO||ENAME
FROM EMP ;


-- 一个字符串拼上一个null,就是原来的字符串
-- Oracle对于字符型的常量,必须要是用''
-- 而对于列的别名,要是用"" ,或者不使用 ""
SELECT EMPNO || ' 的经理是: ' || MGR   员工信息
FROM EMP ;


-- 包含null的算术表达式结果还是null
SELECT EMPNO,ENAME,SAL ,COMM, (SAL * 12 + COMM) "年收入"
FROM EMP 

-- 包含null的连接表达式就是原来的字符串
SELECT EMPNO || ' 的经理是: ' || MGR   员工信息
FROM EMP ;


-- 去除重复的数据
SELECT   DISTINCT DEPTNO
FROM EMP

-- 去除多列组合时候的重复数据
SELECT  DISTINCT JOB,  DEPTNO
FROM EMP



--加上WHERE 查询条件
SELECT  *
FROM EMP
WHERE   DEPTNO = 20

SELECT *
FROM EMP 
WHERE EMPNO = 7369;


-- 对于字符型和日期类型的数据要加''
-- 字符型的数据对大小写是敏感的
SELECT *
FROM EMP 
WHERE ENAME = 'smith';

-- 日期类型的数据,对于格式是敏感的,默认的个数是 日-月-年
SELECT *
FROM EMP 
WHERE HIREDATE = '17-12月-1980';


SELECT EMPNO AS "Empno",  MGR "Mgr" FROM EMP ;



Select sysdate from dual

alter session set nls_date_format="YYYY-MM-DD HH:MI:SS"

SELECT *
FROM EMP 
WHERE HIREDATE = '1980-12-17';



SELECT *
FROM EMP
WHERE  SAL != 1500;



SELECT *
FROM EMP 
WHERE SAL BETWEEN 2000 AND 3000;


SELECT *
FROM EMP 
WHERE SAL >= 2000 AND SAL <= 3000;


SELECT *
FROM EMP 
WHERE JOB IN ('CLERK', 'SALESMAN','MANAGER');

SELECT  *
FROM EMP 
WHERE JOB = 'CLERK' OR JOB = 'SALESMAN' OR JOB = 'MANAGER';


-- % 表示0个或多个任意的字符
SELECT  *
FROM EMP 
WHERE ENAME LIKE 'A%';


--  _ 可表示一个字符
SELECT *
FROM EMP
WHERE ENAME LIKE 'A_';



SELECT *
FROM EMP
WHERE ENAME LIKE '_M%';



SELECT *
FROM EMP 
WHERE ENAME LIKE '%\%%' escape '\';


SELECT *
FROM EMP 
WHERE COMM IS NULL   AND JOB IS NOT NULL ;


SELECT *
FROM EMP 
WHERE COMM IS NULL   AND JOB IS NOT NULL 
ORDER BY SAL DESC;



SELECT *
FROM EMP 
WHERE COMM IS NULL   AND JOB IS NOT NULL 
ORDER BY  DEPTNO , SAL;

-- 使用别名来进行排序
SELECT ENAME, (SAL * 12) as "年薪" 
FROM EMP 
ORDER BY "年薪" ASC




-- SQL注入攻击,就是因为not and or的运行顺序所引起的
SELECT *
FROM USERS 
WHERE NAME = 'admin' OR    'X'='X'   AND   PASSWORD = '12344343'


SELECT *
FROM USERS 
WHERE (NAME = 'admin' OR   'X'='X')   AND  (PASSWORD = '1234456')



SELECT *
FROM EMP 
WHERE JOB NOT IN  ('CLERK', 'SALESMAN','MANAGER');

SELECT *
FROM EMP
WHERE JOB != 'CLERK' AND JOB != 'SALESMAN' AND JOB != 'MANAGER';


select * from users;


SELECT * 
FROM EMP  for update;


--1、选择部门30中的雇员
SELECT * 
FROM EMP 
WHERE DEPTNO = 30; 


--2、列出所有办事员的姓名、编号和部门
