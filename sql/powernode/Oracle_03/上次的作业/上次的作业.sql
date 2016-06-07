

/*
使用Scott用户下的emp表，其中job表示雇员的职位，clerk为办事员、manager为经理、
hiredate 字段：受雇日期；sal字段：薪金；comm字段：佣金；mgr：上级编号；
*/
select * from emp  for update;
SELECT * FROM DEPT;



--1、列出至少有一个雇员的所有部门
SELECT e.deptno "部门编号", COUNT( e.deptno )
FROM emp e
where e.deptno is not null
GROUP BY e.deptno;



--select * from emp 
--for update;
--2、列出薪金比"SMITH"多的所有雇员
SELECT ename "员工工资", sal "工资"
FROM emp 
WHERE sal > ( SELECT sal FROM emp WHERE UPPER( ename ) = 'SMITH' );



--3、列出所有雇员的姓名及其直接上级的姓名
SELECT e.ename "员工姓名", d.ename "领导"
FROM emp e
--JOIN emp d ON ( e.mgr = d.empno );
JOIN emp d ON ( e.mgr = d.empno );



--4、列出入职日期早于其直接上级的所有雇员
SELECT e.ename "员工姓名", e.hiredate "入职日期", d.ename "领导姓名", d.hiredate "领导入职"
FROM emp e
JOIN emp d ON ( e.mgr = d.empno AND e.hiredate < d.hiredate );



--5、列出部门名称和这些部门的雇员,同时列出那些没有雇员的部门
SELECT e.ename "员工姓名", D.DEPTNO, d.dname "所属部门"
FROM emp e
RIGHT OUTER JOIN dept d ON ( e.deptno = d.deptno );



--6、列出所有“CLERK”（办事员）的姓名及其部门名称
SELECT e.ename "办事员姓名", e.job, d.dname "所属部门"
FROM emp e
JOIN dept d ON ( e.deptno = d.deptno )
WHERE e.job = 'CLERK';



--7、列出各种工作类别的最低薪金，显示最低薪金大于1500的记录
SELECT E.JOB, MIN( E.SAL )
FROM EMP E
GROUP BY E.JOB
HAVING MIN( E.SAL ) > 1500;



--8、列出从事“SALES”（销售）工作的雇员的姓名，假定不知道销售部的部门编号
SELECT e.ename "员工姓名", E.JOB
FROM emp e
WHERE UPPER( e.job ) = 'SALESMAN';

SELECT E.ENAME, E.JOB, E.DEPTNO, D.DNAME
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND D.DNAME = 'SALES';



select e.ename, E.DEPTNO
from emp e
where e.deptno = ( select d.deptno from dept d where d.dname = 'SALES' );


SELECT * FROM EMP;
SELECT * FROM DEPT;

--9、列出薪金高于公司平均水平的所有雇员
SELECT e.ename "高于平均的员工"
  FROM emp e
 WHERE e.sal > ( SELECT AVG( emp.sal ) FROM emp );
 
 
--10、列出与“SCOTT”从事相同工作的所有雇员
SELECT e.ename "员工姓名", e.job "从事工作"
  FROM emp e
--WHERE e.job = ( SELECT job FROM emp WHERE UPPER( ename ) = 'SCOTT' );
  JOIN emp d ON ( UPPER( d.ename ) = 'SCOTT' AND e.job = d.job );
  
  
--11、列出某些雇员的姓名和薪金，条件是他们的薪金等于部门30中任何一个雇员的薪金
SELECT e.ename "姓名", e.sal "薪金", e.deptno "部门"
  FROM emp e
 WHERE ( e.sal IN ( SELECT sal FROM emp WHERE deptno = 30 ) )
   
--12、列出某些雇员的姓名和薪金，条件是他们的薪金高于部门30中所有雇员的薪金
SELECT e.ename "姓名", e.sal "薪金", e.deptno "部门"
  FROM emp e
 WHERE ( e.sal > ALL ( SELECT sal FROM emp WHERE deptno = 30 ) )
   
   
   
--13、列出每个部门的信息以及该部门中雇员的数量
SELECT COUNT( * ), d.dname, d.loc, d.deptno
FROM  emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY e.deptno, d.dname, d.loc, d.deptno;

SELECT COUNT(e.deptno),d.dname,d.loc,d.deptno
FROM  emp e
RIGHT OUTER JOIN dept d ON (e.deptno=d.deptno)
GROUP BY e.deptno,d.dname,d.loc,d.deptno



SELECT * FROM EMP FOR UPDATE;



--14、列出所有雇员的雇员名称、部门名称和薪金
SELECT ename "姓名",d.dname "部门名称",sal "薪金"
FROM emp e
JOIN dept d ON(d.deptno=e.deptno); 



--15、列出从事同一种工作但属于不同部门的雇员的不同组合
SELECT e.ename "姓名", e.deptno "部门", e.job "工种"
FROM emp e
JOIN emp d ON ( e.job = d.job AND e.deptno != d.deptno );



--16、列出分配有雇员数量的所有部门的详细信息，即使是分配有0个雇员
SELECT COUNT( e.deptno ), d.dname, d.loc, d.deptno
FROM emp e
RIGHT JOIN dept d ON ( e.deptno = d.deptno )
GROUP BY d.deptno, d.dname, d.loc, e.deptno;



--17、列出各种类别工作的最低工资
SELECT e.job "工作", MIN( e.sal )
FROM emp e 
GROUP BY e.job;



--18、列出各个部门的MANAGER（经理）的最低薪金
SELECT e.deptno "部门", MIN( e.sal ) "薪金"
FROM emp e
WHERE E.JOB = 'MANAGER'
GROUP BY e.deptno;


SELECT * FROM EMP FOR UPDATE;

SELECT EE.DEPTNO, MIN( EE.SAL )
FROM ( SELECT E.* FROM EMP E WHERE E.JOB = 'MANAGER' ) EE
GROUP BY EE.DEPTNO;


--19、列出按计算的字段排序的所有雇员的年薪
SELECT e.ename "姓名", ( sal * 12 + NVL( E.COMM, 0) ) "年薪"
FROM emp e 
ORDER BY "年薪";


--20、列出薪金水平处于第四位的雇员(按工资水平排，处于第4档的员工)
SELECT e.ename, e.sal, s.losal, s.hisal
FROM emp e 
JOIN SALGRADE s ON ( e.sal >= s.losal AND e.sal <= s.hisal )
WHERE s.grade = 4;


-- 使用试图
CREATE OR REPLACE VIEW V_EMP
AS
SELECT ROWNUM RN, EE.*
FROM ( SELECT E.ENAME, E.SAL FROM EMP E ORDER BY E.SAL DESC ) EE

SELECT * FROM V_EMP WHERE RN = 4;

--使用子查询
SELECT EEE.*
  FROM ( SELECT ROWNUM RN, EE.*
    FROM ( SELECT E.ENAME, E.SAL FROM EMP E ORDER BY E.SAL DESC ) EE ) EEE
      WHERE EEE.RN = 4;




