SELECT  MAX( SAL ) AS 最高工资, MIN( SAL ) AS 最低工资, AVG( SAL ) AS "平均工资", SUM( SAL ) AS "工资总和"
FROM EMP;


-- SUM,AVG 只能针对数值型的数据
SELECT AVG( SAL ) AS "平均工资", SUM( SAL ) AS "工资总和"
FROM EMP;



-- MAX,MIN 可以针对任何类型
SELECT MAX( E.HIREDATE ), MIN( E.HIREDATE )
FROM EMP E;


SELECT MAX( E.ENAME ), MIN( E.ENAME )
FROM EMP E;

-- COUNT(*) 查询所有数据的总条数
SELECT COUNT( * )
FROM EMP;



-- COUNT(字段)  忽略空值
SELECT COUNT( COMM )
FROM EMP;


-- 所有的组函数都是忽略空值的
SELECT SUM( COMM ) AS "佣金总和", AVG( COMM ) AS "平均佣金", SUM( COMM )/COUNT( COMM ) AS "平均佣金一"
FROM EMP E;


-- AVG(COMM) !=  SUM(COMM) /COUNT(*)
-- AVG(COMM) =  SUM(COMM) /COUNT(COMM)



SELECT SUM( COMM )/COUNT( * ) AS "平均佣金", AVG( NVL( COMM, 0 ) ) AS "平均佣金1"
FROM EMP E;

-- 按照部门编号进行分组,求每个部门的最高工资,最低工资
-- 使用GROUP的原则
-- 出现在查询列表中的字段,要么出现在组函数中,要么出现在GROUP BY子句中
-- 或者只出现在 GROUP BY子句中
-- 只有以上两种情况是合法的,其他的都是非法的
SELECT DEPTNO, MAX( SAL ) AS "最高工资", MIN( SAL ) AS "最低工资", AVG( SAL ) AS "平均工资", SUM( SAL ) AS "工资总和"
FROM EMP
GROUP BY DEPTNO;


SELECT DEPTNO, JOB, MAX( SAL ) AS "最高工资", MIN( SAL ) AS "最低工资", AVG( SAL ) AS "平均工资", SUM( SAL ) AS "工资总和"
FROM EMP
GROUP BY DEPTNO, JOB;


SELECT JOB, MAX( SAL ) AS "最高工资", MIN( SAL ) AS "最低工资", AVG( SAL ) AS "平均工资", SUM( SAL ) AS "工资总和"
FROM EMP
GROUP BY JOB
ORDER BY "最高工资";


--错误的用法
SELECT DEPTNO, AVG( SAL ) AS "平均工资"
FROM EMP
WHERE AVG( SAL ) > 2000
GROUP BY DEPTNO
ORDER BY DEPTNO;

-- 对分组以后的数据,要进行过滤,要是用另外的一个子句,having
SELECT AVG( SAL ) AS "平均工资"
FROM EMP
GROUP BY DEPTNO
HAVING AVG( SAL ) > 2000
ORDER BY  "平均工资" ASC;


-- 先用WHERE对数据进行过滤
-- 再用GROUP对数据进行分组
-- 用HAVING对分组以后的数据再过略
-- 再用ORDER对分组过略以后的数据进行排序
SELECT DEPTNO, AVG( SAL )
FROM EMP
WHERE JOB IN ( 'CLERK', 'MANAGER', 'SALESMAN' )
GROUP BY DEPTNO
HAVING AVG( SAL ) > 1600
ORDER BY DEPTNO;



SELECT MAX ( AVG( SAL ) )
FROM EMP
GROUP BY DEPTNO;

-- 如果没有使用GROUP BY子句,组函数不能嵌套
SELECT MAX( AVG( SAL ) )
FROM EMP;

-- 分组函数最多只能嵌套两层
SELECT MAX( MAX( AVG( E.SAL ) ) )
FROM EMP E
GROUP BY E.DEPTNO;







SELECT DEPTNO, SAL
FROM EMP
WHERE JOB IN ( 'CLERK', 'MANAGER', 'SALESMAN' )









SELECT * FROM EMP;
