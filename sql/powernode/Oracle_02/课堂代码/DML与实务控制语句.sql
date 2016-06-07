-- 实务开始于第一个DML语句,结束于commit,或rollbacke
INSERT INTO DEPT VALUES (50,'开发部',1002);

INSERT INTO DEPT VALUES (60,'开发部',1002);
INSERT INTO DEPT VALUES (70,'开发部',1002);

COMMIT;
ROLLBACK;

INSERT INTO DEPT(DEPTNO ,DNAME,LOC_ID) VALUES (80,'技术部',NULL); 

INSERT INTO DEPT(DEPTNO ,DNAME) VALUES (80,'技术部'); 

INSERT INTO DEPT VALUES (80,'技术部' ,NULL); 


INSERT INTO EMP (EMPNO,ENAME,HIREDATE) VALUES (9000,'张三','12-8月-1987');

INSERT INTO EMP (EMPNO,ENAME,HIREDATE) VALUES (9000,'张三', TO_DATE( '1987-12-23'  ,'YYYY-MM-DD'));


DROP TABLE DEPT_BAK;

CREATE TABLE DEPT_BAK
AS
SELECT * FROM DEPT WHERE DEPTNO >100


-- 把查询的数据插入到数据库中,是DML语句,会引起事务
INSERT INTO DEPT_BAK
SELECT * FROM DEPT WHERE DEPTNO <= 40


UPDATE DEPT SET DNAME= '销售部' ,LOC_ID = 1001 WHERE DEPTNO = 70


DELETE FROM DEPT  WHERE DEPTNO > 40


MERGE INTO DEPT_BAK D 
USING DEPT S
ON (D.DEPTNO = S.DEPTNO)
WHEN MATCHED THEN
  UPDATE SET  /*D.DEPTNO = S.DEPTNO,*/  D.DNAME = S.DNAME, D.LOC_ID = S.LOC_ID
WHEN NOT MATCHED THEN
  INSERT VALUES (S.DEPTNO, S.DNAME, S.LOC_ID);



SELECT * FROM DEPT_BAK;


UPDATE DEPT SET DNAME = '销售部' WHERE DEPTNO = 50;

DELETE FROM DEPT WHERE DEPTNO = 40;


rollback;


-- 在事务中的DDL,DCL会隐式的提交事务
INSERT INTO DEPT VALUES (60,'销售部',1002);
DROP TABLE DEPT_BAK;



-- 记录点只在事务中有效
INSERT INTO DEPT VALUES (50, '开发', 1001);
SAVEPOINT A;
DELETE FROM DEPT D WHERE D.DEPTNO > 30;
SAVEPOINT B;
UPDATE DEPT D SET D.DNAME = '人事部' where d.deptno = 10;
ROLLBACK TO B;
COMMIT;
ROLLBACK TO A;




SELECT * FROM EMP;

DELETE FROM DEPT WHERE DEPTNO > 40

SELECT * FROM DEPT;
