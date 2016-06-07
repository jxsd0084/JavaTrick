

-- 多表查询,就是用单个的Select语句,从多个表中查询出相关的数据
SELECT EMPNO ,ENAME ,DEPT.DEPTNO ,DNAME,LOC
FROM EMP ,DEPT 
WHERE  EMP.DEPTNO = DEPT.DEPTNO;

SELECT E.EMPNO,E.ENAME ,D.DEPTNO  , D.DNAME,D.LOC
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO;

SELECT  D.DEPTNO,D.DNAME,D.LOC_ID,L.LNAME
FROM DEPT D,LOCATIONS L
WHERE D.LOC_ID = L.LID
ORDER BY D.DEPTNO;

-- 等值查询,建立在主外键基础之上,用 = 连接两个表的字段
-- 做n个表的等值查询,需要n-1个等值条件
SELECT E.EMPNO,E.ENAME,E.JOB ,E.DEPTNO,D.DNAME,L.LID,L.LNAME
FROM EMP E,DEPT D,LOCATIONS L
WHERE E.DEPTNO = D.DEPTNO AND D.LOC_ID = L.LID   AND   UPPER( E.ENAME) = 'SMITH';


-- 非等值查询 ,两个表之间没有主外键关系并且用 非 = 连接两个表的字段
SELECT E.ENAME ,E.SAL ,S.GRADE,S.LOSAL,S.HISAL
FROM EMP E,SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL  AND UPPER(E.ENAME) = 'SMITH';


SELECT E.ENAME ,E.SAL ,S.GRADE,S.LOSAL,S.HISAL
FROM EMP E,SALGRADE S
WHERE E.SAL >= S.LOSAL AND E.SAL <= S.HISAL AND S.GRADE = 4;



SELECT E.EMPNO,E.ENAME ,D.DEPTNO  , D.DNAME,D.LOC_ID
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO;


-- 外连接 
-- 左外连接 ,在等着查询的基础之上,可以把右边表的不满足等值条件的数据全部显示(例如:40这个部门没有员工)
SELECT E.EMPNO,E.ENAME,D.DEPTNO ,D.DNAME
FROM EMP E,DEPT D
WHERE E.DEPTNO (+)= D.DEPTNO;

SELECT E.EMPNO,E.ENAME,D.DEPTNO ,D.DNAME
FROM EMP E,DEPT D
WHERE  D.DEPTNO(+) =  E.DEPTNO;


-- 右外连接 ,在等着查询的基础之上,可以把左边表的不满足等值条件的数据全部显示(例如:Smith这个员工没有部门)
SELECT E.EMPNO,E.ENAME,D.DEPTNO ,D.DNAME
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO (+);

SELECT E.EMPNO,E.ENAME,D.DEPTNO ,D.DNAME
FROM EMP E,DEPT D
WHERE  D.DEPTNO =  E.DEPTNO (+);


 -- + 不能同时出现在 = 的两边
SELECT E.EMPNO,E.ENAME,D.DEPTNO ,D.DNAME
FROM EMP E,DEPT D
WHERE  D.DEPTNO (+)=  E.DEPTNO (+);


-- 自连接 ,通过别名,将一个表虚拟成两个表,然后在这两个表的基础上作等值查询
SELECT E.EMPNO || ' 的经理是:' || M.EMPNO
FROM EMP E,EMP M
WHERE E.MGR = M.EMPNO ;





-- 新标准
--1.CROSS JOIN ,产生一个笛卡尔乘积
SELECT E.EMPNO,E.ENAME,D.DEPTNO,D.DNAME
FROM EMP E
CROSS JOIN  DEPT D;

SELECT E.EMPNO,E.ENAME,D.DEPTNO,D.DNAME
FROM EMP E,DEPT D;


-- NATURAL JOIN   自动去查找两个表中所有的列名完全相同的字段,在所有的这些字段之上,做等值查询
-- 参照列不能加任何前缀
SELECT E.EMPNO,E.ENAME  ,DEPTNO  ,D.DNAME
FROM EMP E
NATURAL JOIN DEPT D;

SELECT D.DNAME, L.LNAME
FROM DEPT D
NATURAL JOIN LOCATIONS L;


-- JOIN  USING  子句 ,是对NATURAL JOIN的改进,使用USING()指定的参照列作为等值查询的条件
-- 参照列上不能使用别名
SELECT E.EMPNO,E.ENAME,DEPTNO , D.DNAME,D.LOC_ID
FROM EMP E
JOIN  DEPT D USING(DEPTNO);

-- JOIN .. ON ()  在ON ()子句里面写条件
SELECT  D.DEPTNO,D.DNAME,D.LOC_ID,L.LID,L.LNAME
FROM DEPT D
JOIN  LOCATIONS  L ON (D.LOC_ID = L.LID  AND D.DEPTNO = 10 );


SELECT  E.ENAME,E.SAL ,S.GRADE,S.LOSAL,S.HISAL
FROM EMP E
INNER JOIN SALGRADE S  ON (E.SAL BETWEEN S.LOSAL AND S.HISAL);

-- 做N个表的INNER JOIN ,需呀n-1个INNER JOIN 子句
SELECT E.EMPNO,E.ENAME,E.DEPTNO,D.DNAME,D.LOC_ID,L.LNAME
FROM EMP E
INNER JOIN DEPT D ON (E.DEPTNO = D.DEPTNO  AND UPPER(E.ENAME) = 'SMITH' )
INNER JOIN LOCATIONS L ON (D.LOC_ID = L.LID) ;



-- OUTER JOIN ..ON  可以查询不满足等值条件的数据
-- LEFT OUTER JOIN ..ON
SELECT E.ENAME,D.DEPTNO,D.DNAME
FROM  DEPT D
LEFT OUTER JOIN  EMP E ON ( D.DEPTNO =   E.DEPTNO);


SELECT  E.ENAME,D.DEPTNO,D.DNAME
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO(+);


-- RIGHT OUTER JOIN ..ON
SELECT E.ENAME,D.DEPTNO,D.DNAME
FROM  EMP E
RIGHT OUTER JOIN  DEPT D  ON (  E.DEPTNO  = D.DEPTNO );



-- FULL OUTER JOIN ..ON
SELECT E.ENAME,D.DEPTNO,D.DNAME
FROM  EMP E
FULL OUTER JOIN  DEPT D  ON (  E.DEPTNO  = D.DEPTNO );




-- UNION  去除重复的数据
-- UNION ALL 包括重复的数据
SELECT  E.ENAME,D.DEPTNO,D.DNAME
FROM EMP E,DEPT D
WHERE E.DEPTNO(+) = D.DEPTNO
UNION /* ALL*/
SELECT  E.ENAME,D.DEPTNO,D.DNAME
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO(+);


SELECT E.*
FROM EMP E 
WHERE  UPPER(E.ENAME) = 'SMITH'
FOR UPDATE;



-- 子查询:是为了给主查询提供条件,而首先要执行的一个查询
-- 为了便于阅读,子查询出现在比较符号的右边,并且写在()里面

SELECT E.ENAME, E.SAL
  FROM EMP E
 WHERE E.SAL > (2975)


SELECT E.ENAME, E.SAL
  FROM EMP E
 WHERE  E.SAL  =  (SELECT E.SAL FROM EMP E WHERE UPPER(E.ENAME) = 'JONES');


-- 单行单列子查询
SELECT E.EMPNO, E.ENAME, E.JOB
  FROM EMP E
 WHERE E.JOB = (SELECT E.JOB FROM EMP E WHERE E.EMPNO = 7566);



SELECT E.ENAME, E.SAL
  FROM EMP E
 WHERE SAL > (SELECT MAX(AVG(SAL)) FROM EMP E GROUP BY DEPTNO);


-- 在HAVING中使用子查询
SELECT E.DEPTNO, MIN(E.SAL)
  FROM EMP E
 WHERE E.DEPTNO IS NOT NULL 
 GROUP BY E.DEPTNO
HAVING MIN(E.SAL) > (SELECT MIN(E.SAL) FROM EMP E WHERE E.DEPTNO = 20);

-- 子查询没有结果,主查询不会报错,只是没有结果
SELECT E.EMPNO, E.ENAME, E.JOB
  FROM EMP E
 WHERE E.JOB = (SELECT E.JOB FROM EMP E WHERE E.EMPNO = 8566);

SELECT E.EMPNO, E.ENAME, E.JOB
  FROM EMP E
 WHERE E.JOB = '工程师'

SELECT EMPNO, ENAME
  FROM EMP
 WHERE SAL = (SELECT MIN(SAL) FROM EMP GROUP BY DEPTNO);
 
-- 多行单例子查询不能使用单行比较操作符,而是要是用多行比较操作符 IN   ANY   ALL


SELECT E.ENAME, E.SAL, E.JOB
  FROM EMP E
 WHERE E.JOB IN (SELECT DISTINCT JOB FROM EMP E WHERE SAL > 2000);
 
 

--  >ALL   大于子查询的最大值
SELECT EMPNO, ENAME ,SAL
  FROM EMP E
 WHERE SAL  >ALL   (SELECT MIN(SAL) FROM EMP    GROUP BY DEPTNO); 


--  <ALL   小于子查询的最小值
SELECT EMPNO, ENAME ,SAL
  FROM EMP E
 WHERE SAL  <ALL   (SELECT MIN(SAL) FROM EMP  WHERE DEPTNO IS NOT NULL GROUP BY DEPTNO);  
 
--  >ANY   大于子查询的最小值
SELECT EMPNO, ENAME ,SAL
  FROM EMP E
 WHERE SAL  >ANY   (SELECT MIN(SAL) FROM EMP  WHERE DEPTNO IS NOT NULL GROUP BY DEPTNO); 

--  <ANY   小于子查询的最大值
SELECT EMPNO, ENAME ,SAL
  FROM EMP E
 WHERE SAL  < ANY   (SELECT MIN(SAL) FROM EMP  WHERE DEPTNO IS NOT NULL GROUP BY DEPTNO);  


-- 多行多列子查询
 
SELECT E.JOB, E.DEPTNO
  FROM EMP E
 WHERE (E.JOB, E.DEPTNO) IN
       (SELECT DISTINCT M.JOB, M.DEPTNO FROM EMP M WHERE M.SAL > 2000)

-- 成对的比较
SELECT empno, mgr, deptno
  FROM emp
 WHERE (mgr, deptno) IN
       (SELECT mgr, deptno FROM emp WHERE empno IN (7521, 7876))
   AND empno NOT IN (7521, 7876);


-- 把一个多行多列的子查询拆分长两个多行单列的子查询,然后分别用单个字段和多行单列的子查询进行比较
SELECT empno, mgr, deptno
  FROM emp
 WHERE mgr IN (SELECT mgr FROM emp WHERE empno IN (7521, 7876))
   AND deptno IN (SELECT deptno FROM emp WHERE empno IN (7521, 7876))
   AND empno NOT IN (7521, 7876);


SELECT  EE.员工编号,EE.员工姓名,EE.职位,EE.经理 
  FROM (SELECT E.EMPNO "员工编号", E.ENAME 员工姓名, E.JOB 职位, E.MGR 经理 FROM EMP E WHERE SAL > 2000) EE
WHERE   EE.职位 = 'MANAGER'


CREATE OR REPLACE VIEW  V_EMP
AS
SELECT E.EMPNO "员工编号", E.ENAME 员工姓名, E.JOB 职位, E.MGR 经理 ,SAL 工资 FROM EMP E WHERE SAL > 2000;


SELECT  EE.员工编号,EE.员工姓名,EE.职位,EE.经理 
  FROM V_EMP EE
WHERE   EE.职位 = 'MANAGER'


SELECT  MAX(工资)
FROM V_EMP 
GROUP BY 职位


-- 分级查询.从底下向上遍历树
SELECT EMPNO, ENAME, JOB, MGR
FROM   EMP
START  WITH  EMPNO = 7369
CONNECT BY PRIOR MGR = EMPNO ;



-- 从上向下遍历树
SELECT EMPNO, ENAME, JOB, MGR
FROM   EMP
START  WITH  EMPNO = 7839
CONNECT BY PRIOR EMPNO =   MGR;

-- 从顶向下进行遍历
SELECT    LPAD(ENAME, LENGTH(ENAME)+(LEVEL*2)-2,'*') ,  LEVEL 
       AS org_chart
FROM   EMP 
START WITH ENAME='KING' 
CONNECT BY PRIOR EMPNO=MGR 


-- 去除'JONES'节点,但是JONES下面的节点保留
SELECT    LPAD(ENAME, LENGTH(ENAME)+(LEVEL*2)-2,'*') ,  LEVEL 
       AS org_chart
FROM   EMP 
WHERE ENAME != 'JONES'
START WITH ENAME='KING' 
CONNECT BY PRIOR EMPNO=MGR 



-- 去除'JONES'整个的分支
SELECT    LPAD(ENAME, LENGTH(ENAME)+(LEVEL*2)-2,'*') ,  LEVEL 
       AS org_chart
FROM   EMP 
--WHERE ENAME != 'JONES'
START WITH ENAME='KING' 
CONNECT BY PRIOR EMPNO=MGR  AND ENAME != 'JONES'


SELECT * FROM EMP;




SELECT  MAX( AVG(SAL))
FROM EMP E
GROUP BY DEPTNO 



SELECT E.SAL
FROM EMP E 
WHERE  UPPER(E.ENAME) = 'JONES'


SELECT * FROM EMP;

SELECT * FROM SALGRADE;

SELECT * FROM DEPT;

SELECT * FROM LOCATIONS;


