---------------------------------------------------------------------
DECLARE
  -- 声明了一中只能存放VARCHAR2(50)类型的表类型
  TYPE NAMED_TABLE_TYPE IS TABLE OF VARCHAR2(50) INDEX BY BINARY_INTEGER;
  V_TABLE1 NAMED_TABLE_TYPE;
  V_TABLE2 NAMED_TABLE_TYPE;
  
  
  -- 声明了一中只能存放NUMBER(4)类型的表类型
  TYPE NAMED1_TABLE_TYPE IS TABLE OF NUMBER(4) INDEX BY BINARY_INTEGER;
  
BEGIN
  V_TABLE2(1) := 'Hello';
  V_TABLE2(2) := 'Oracle';
  V_TABLE2(3) := 'PL/SQL';

  DBMS_OUTPUT.put_line('V_TABLE1(1)=' || V_TABLE2(1) || '   V_TABLE1(2)=' ||
                       V_TABLE2(2) || '  V_TABLE1(3)=' || V_TABLE2(3));

END;
---------------------------------------------------------------------
DECLARE
    TYPE  EMP_REC IS RECORD (
        EMPNO     NUMBER(4),
        ENAME     VARCHAR2(20),
        JOB       VARCHAR2(20),
        MGR       NUMBER(4),
        HIREDATE  DATE 
    );
    
    EMP_REC_1    EMP_REC;
BEGIN
    EMP_REC_1.EMPNO  := 8000;
    EMP_REC_1.ENAME   := '张一';
    EMP_REC_1.JOB     := '工程师';
    EMP_REC_1.mgr     := 8765;
    EMP_REC_1.hiredate  := TO_DATE('1987-12-23' ,'YYYY-MM-DD');
    
    DBMS_OUTPUT.put_line(EMP_REC_1.EMPNO ||EMP_REC_1.ENAME || EMP_REC_1.JOB || EMP_REC_1.MGR ||  TO_CHAR( EMP_REC_1.HIREDATE ,'YYYY-MM-DD') );

END;
---------------------------------------------------------------------
DECLARE
  V_EMPNO DATE;

  -- 把V_EMPNO的类型取出来,作为V_1的类型
  -- %TYPE的前缀可以是一个已经声明过的变量(可以是基本类型变量,也可以使表类型的变量)
  -- 还可以是一个表的某个字段(这表的这个字段的类型作为该变量的类型,并且会自动保持同步)

  V_1 V_EMPNO%TYPE;

  TYPE NAMED_TABLE_TYPE IS TABLE OF VARCHAR2(50) INDEX BY BINARY_INTEGER;
  V_TABLE1 NAMED_TABLE_TYPE;

  V_2 V_TABLE1%TYPE;

  -- 把EMP表的ENAME字段的类型作为V_3的类型
  V_3 EMP.ENAME%TYPE;

BEGIN
  V_1 := '12-3月-1989';

  DBMS_OUTPUT.put_line('V_1 =' || V_1);

  V_2(1) := 'HELLO1';
  V_2(2) := 'HELLO2';
  DBMS_OUTPUT.put_line(V_2(1) || V_2(2));

  V_3 := '张三';
  DBMS_OUTPUT.put_line(V_3);
END;
---------------------------------------------------------------------
DECLARE
    -- V_EMP_REC 是一个记录类型的变量
    -- 取出emp表的所有的字段和类型,作为V_EMP_REC这个记录类型变量的字段
    
    -- %ROWTYPE的前缀可以是一个表,
    -- 也可以是一个已经声明的记录类型的变量
    --(但是该变量必须要参照与一个表,而不能是一个自己定义的记录类型的变量)
    
    --V_EMP_REC    EMP%ROWTYPE;        
    --V_EMP_REC2     V_EMP_REC%ROWTYPE;
    
    
    TYPE   EMP_REC  IS RECORD(
        EMPNO     NUMBER(4),
        ENAME     VARCHAR2(20),
        JOB       VARCHAR2(20),
        MGR       NUMBER(4),
        HIREDATE  DATE 
    );
    
    -- 自定义的RECODE 类型的变量不能作为%ROWTYPE的前缀
    V_1   EMP_REC;    
    V_EMP_REC2    V_1%ROWTYPE;
    
BEGIN
   V_EMP_REC2.EMPNO := 3456;
   V_EMP_REC2.ENAME  := '张一';
   V_EMP_REC2.JOB   := '工程师';
   V_EMP_REC2.mgr   := 2345;
   V_EMP_REC2.HIREDATE  := '12-4月-1987'; 
   
    DBMS_OUTPUT.put_line(V_EMP_REC2.EMPNO ||V_EMP_REC2.ENAME || V_EMP_REC2.JOB || V_EMP_REC2.MGR ||  TO_CHAR( V_EMP_REC2.HIREDATE ,'YYYY-MM-DD') );
END;
---------------------------------------------------------------------
declare
  --v_weight number(3) := 100;
begin
  -----------------嵌套块 字块---------------------
  -- 字块中可以看到父块中的内容
  -- 父块中不能看到字块的内容
  declare
     v_weight number(3) := 1;
  begin
     v_weight := v_weight + 1;
     dbms_output.put_line('在嵌套块中v_weight的值是:' || v_weight);
  end;
  --------------------------------------------
  v_weight := v_weight + 1;
  dbms_output.put_line('在嵌套块外v_weight的值是:' || v_weight);
end;
/

---------------------------------------------------------------------
DECLARE
--CREATE OR REPLACE PROCEDURE  P_EMP IS
   v_b1   boolean   := true;
   v_b2   boolean   := true;
   
   v_b3   boolean  ;
BEGIN
   v_b3 := (v_b1 = v_b2);
   IF( v_b3 )  THEN
      DBMS_OUTPUT.put_line('真的');
   ELSE
       DBMS_OUTPUT.put_line('假的');   
   END IF;
END;
---------------------------------------------------------------------
declare
  v_1 varchar2(20) ;
begin
  v_1 := USER||': '|| TO_CHAR(SYSDATE,'YYYY-MM-DD');
 -- v_1 := USER||': '||SYSDATE;
   dbms_output.put_line(v_1);
end;


SELECT * FROM EMP;

SELECT MAX(SAL) 
    FROM EMP 
    GROUP BY DEPTNO;
---------------------------------------------------------------------
DECLARE
    --V_EMPNO   EMP.EMPNO%TYPE; 
    --V_ENAME   EMP.ENAME%TYPE;
    
    --V_EMP_REC   EMP%ROWTYPE;
    
    v_sal   emp.sal%type;
BEGIN
    
    -- SELECT 只能返回一条结果,并且要是用INTO
    SELECT MAX(SAL)  INTO v_sal
    FROM EMP 
    GROUP BY DEPTNO;       
    DBMS_OUTPUT.put_line( v_sal);

END;
---------------------------------------------------------------------

SELECT * FROM DEPT;

      
BEGIN
   -- 在PL/SQL中执行DML,事务控制语句,没有任何变化
   INSERT INTO DEPT VALUES (40,'开发部',1001);
   INSERT INTO DEPT VALUES (50,'开发一部',1001);
   UPDATE DEPT SET DNAME = '生产部' WHERE DEPTNO = 50;
   DELETE FROM DEPT WHERE DEPTNO = 40;
   COMMIT;
END;
---------------------------------------------------------------------

CREATE TABLE USERS(
    ID        NUMBER(4) PRIMARY KEY,
    NAME      VARCHAR2(20),
    SEX       CHAR(2),
    CONSTRAINTS  AVAL_SEX   CHECK  (SEX IN ('男','女'))     
)



BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE  USERS';
END;   
 



BEGIN
   EXECUTE IMMEDIATE 'CREATE TABLE USERS(
       ID        NUMBER(4) PRIMARY KEY,
       AME      VARCHAR2(20),
       SEX       CHAR(2)
    )';
END;


INSERT INTO  USERS  VALUES (1,'张一','非')


BEGIN
   EXECUTE IMMEDIATE 'CREATE TABLE USERS(
    ID        NUMBER(4) PRIMARY KEY,
    NAME      VARCHAR2(20),
    SEX       CHAR(2),
    CONSTRAINTS  AVAL_SEX   CHECK  (SEX IN (''男'',''女''))     
)';
END;

---------------------------------------------------------------------
--DECLARE
CREATE OR REPLACE PROCEDURE  P_EMP IS
     V_TABLE  VARCHAR2(20) := '&TABLE';
     V_SQL    VARCHAR2(200); 
     V_COUNT   NUMBER(3);        
BEGIN
    V_SQL := 'SELECT COUNT(*) FROM ' || V_TABLE;
    
    EXECUTE IMMEDIATE  V_SQL INTO V_COUNT;    
    DBMS_OUTPUT.PUT_LINE(V_COUNT);    
END;
---------------------------------------------------------------------
DECLARE
   V_SCORE   NUMBER(3) := 70;
BEGIN
   IF( V_SCORE < 60)  THEN
      DBMS_OUTPUT.put_line('不及格');
   ELSIF  ( V_SCORE < 70) THEN
       DBMS_OUTPUT.put_line('及格');
   ELSIF  ( V_SCORE < 80) THEN
       DBMS_OUTPUT.put_line('良');
   ELSE 
      DBMS_OUTPUT.put_line('优');      
   END IF;       
END;
---------------------------------------------------------------------
SELECT *  FROM EMP WHERE EMPNO = 7369;

declare
  V_SAL EMP.SAL%TYPE;
begin
  SELECT SAL INTO V_SAL FROM EMP WHERE EMPNO = 7369;
  IF (V_SAL < 1000) THEN
    UPDATE EMP SET COMM = V_SAL * 0.8 WHERE EMPNO = 7369;
  ELSE
    UPDATE EMP SET COMM = V_SAL * 1.0 WHERE EMPNO = 7369;
  END IF;
  COMMIT;
end;



---------------------------------------------------------------------
DECLARE
  V_COUNT NUMBER(2) := 0;
  V_NAME  VARCHAR2(20);
BEGIN
  LOOP
    V_NAME := 'NAME' || V_COUNT;
    INSERT INTO USERS VALUES (V_COUNT, V_NAME, '男');
    V_COUNT := V_COUNT + 1;
    EXIT WHEN V_COUNT > 10;
  END LOOP;  
  COMMIT;
END;
---------------------------------------------------------------------
DECLARE
  V_COUNT NUMBER(2) := 0;
  V_NAME  VARCHAR2(20);
BEGIN
  DELETE FROM USERS;

  WHILE (V_COUNT <= 10) LOOP
    V_NAME := 'NAME-' || V_COUNT;
    INSERT INTO USERS VALUES (V_COUNT, V_NAME, '男');
    V_COUNT := V_COUNT + 1;
  END LOOP;
  
  COMMIT;
END;
---------------------------------------------------------------------

SELECT * FROM USERS;


INSERT INTO USERS VALUES (11,'张一','女')

UPDATE USERS SET SEX = '女' 
DECLARE  
  V_NAME  VARCHAR2(20);
BEGIN
    DELETE FROM USERS;
    
    /*FOR 循环回自动的维护计数器,并且进行计数器的迭代*/
    FOR V_COUNT  IN  REVERSE 0..10  LOOP
        V_NAME := 'NAME__' || V_COUNT;
        INSERT INTO USERS VALUES (V_COUNT, V_NAME, '男');
    END LOOP ;
    
    COMMIT;
END;
---------------------------------------------------------------------
DECLARE
   V_COUNT   NUMBER(2);  
BEGIN
   DELETE FROM USERS;
   V_COUNT := SQL%ROWCOUNT;
   DBMS_OUTPUT.put_line('共删除数据:' || V_COUNT);  
END;
---------------------------------------------------------------------
DECLARE
    -- 声明游标,就是将游标和一个查询语句绑在一起
    CURSOR     CUR_EMP  IS
       SELECT * FROM EMP;
    EMP_REC     EMP%ROWTYPE;   
BEGIN
    -- OPEN 游标,执行了游标绑定的查询语句,并且把查询结果放到了游标区域中
    OPEN  CUR_EMP;
    
    -- 取出游标中的一条数据,装入到一个记录类型变量中
    FETCH CUR_EMP INTO EMP_REC;
    DBMS_OUTPUT.put_line(EMP_REC.EMPNO || EMP_REC.ENAME || EMP_REC.JOB || EMP_REC.MGR || EMP_REC.HIREDATE || EMP_REC.COMM || EMP_REC.DEPTNO);
    
    CLOSE CUR_EMP;

END;
---------------------------------------------------------------------
DECLARE
--CREATE OR REPLACE PROCEDURE  V_EMP IS
  -- 声明游标,就是将游标和一个查询语句绑在一起
  CURSOR CUR_EMP IS
    SELECT * FROM EMP   WHERE DEPTNO = 10 ;
  EMP_REC EMP%ROWTYPE;
BEGIN
  -- OPEN 游标,执行了游标绑定的查询语句,并且把查询结果放到了游标区域中
  OPEN CUR_EMP;

  LOOP
    FETCH CUR_EMP
      INTO EMP_REC;    
    EXIT WHEN CUR_EMP%NOTFOUND;
    DBMS_OUTPUT.put_line(EMP_REC.EMPNO || EMP_REC.ENAME || EMP_REC.JOB ||
                         EMP_REC.MGR || EMP_REC.HIREDATE || EMP_REC.COMM ||
                         EMP_REC.DEPTNO);
  END LOOP;
  
  --DBMS_OUTPUT.put_line('数据总条数:' || CUR_EMP%ROWCOUNT);
  
  CLOSE CUR_EMP;
  -- 游标关闭之后,游标区域会被清空
  DBMS_OUTPUT.put_line('数据总条数:' || CUR_EMP%ROWCOUNT);

END;
---------------------------------------------------------------------
--DECLARE
CREATE OR REPLACE PROCEDURE  V_EMP IS
  -- 声明游标,就是将游标和一个查询语句绑在一起
  CURSOR CUR_EMP IS
    SELECT * FROM EMP   /*WHERE DEPTNO = 10*/ ;
  EMP_REC EMP%ROWTYPE;
BEGIN
  -- OPEN 游标,执行了游标绑定的查询语句,并且把查询结果放到了游标区域中
  OPEN CUR_EMP;
  FETCH  CUR_EMP INTO EMP_REC;
  WHILE (CUR_EMP%FOUND) LOOP     
      DBMS_OUTPUT.put_line(EMP_REC.EMPNO || EMP_REC.ENAME || EMP_REC.JOB ||
                         EMP_REC.MGR || EMP_REC.HIREDATE || EMP_REC.COMM ||
                         EMP_REC.DEPTNO);
      FETCH  CUR_EMP INTO EMP_REC;                   
  END LOOP;    
  DBMS_OUTPUT.put_line('数据总条数:' || CUR_EMP%ROWCOUNT);
  
  CLOSE CUR_EMP;  
END;
---------------------------------------------------------------------
-- FOR 循环可以简化游标的开发,游标别隐式的open fetch close;
-- 并且自动维护记录类型的变量
DECLARE
  CURSOR CUR_EMP IS
    SELECT * FROM EMP ;
BEGIN
  FOR EMP_REC IN CUR_EMP LOOP
    DBMS_OUTPUT.put_line(EMP_REC.EMPNO || EMP_REC.ENAME || EMP_REC.JOB ||
                         EMP_REC.MGR || EMP_REC.HIREDATE || EMP_REC.COMM ||
                         EMP_REC.DEPTNO);
  END LOOP;  
  DBMS_OUTPUT.put_line('数据总条数:' || CUR_EMP%ROWCOUNT);

END;
---------------------------------------------------------------------
--DECLARE

CREATE OR REPLACE PROCEDURE PROC_EMP(PARAM_DEPTNO DEPT.DEPTNO%TYPE) IS
  -- 声明了一个带有参数的游标
  CURSOR CUR_EMP(P_DEPTNO NUMBER) IS
    SELECT * FROM EMP WHERE DEPTNO = P_DEPTNO;
  --EMP_REC EMP%ROWTYPE;  
BEGIN

  /*
  OPEN CUR_EMP(50);
  FETCH  CUR_EMP INTO EMP_REC;
  WHILE (CUR_EMP%FOUND) LOOP     
      DBMS_OUTPUT.put_line(EMP_REC.EMPNO || EMP_REC.ENAME || EMP_REC.JOB ||
                         EMP_REC.MGR || EMP_REC.HIREDATE || EMP_REC.COMM ||
                         EMP_REC.DEPTNO);
      FETCH  CUR_EMP INTO EMP_REC;                   
  END LOOP;    
  DBMS_OUTPUT.put_line('数据总条数:' || CUR_EMP%ROWCOUNT);
  
  CLOSE CUR_EMP;
  */
  FOR EMP_REC IN CUR_EMP(PARAM_DEPTNO) LOOP
    DBMS_OUTPUT.put_line(EMP_REC.EMPNO || EMP_REC.ENAME || EMP_REC.JOB ||
                         EMP_REC.MGR || EMP_REC.HIREDATE || EMP_REC.COMM ||
                         EMP_REC.DEPTNO);
  END LOOP;

END;
---------------------------------------------------------------------
SELECT E.SAL  FROM EMP E WHERE UPPER(ENAME) = 'CLARK' FOR UPDATE;

--DECLARE
CREATE OR REPLACE  PROCEDURE PROC_EMP IS
      EMP_SAL     EMP.SAL%TYPE;
BEGIN

      SELECT E.SAL INTO EMP_SAL FROM EMP E WHERE UPPER(ENAME) = 'CLARK';           
      IF (EMP_SAL < 2000)  THEN 
          EMP_SAL := EMP_SAL + 1500;
      ELSIF (EMP_SAL >2000 AND EMP_SAL <3200)  THEN
          EMP_SAL := EMP_SAL + EMP_SAL * 0.3;
      ELSE 
          EMP_SAL := EMP_SAL;
      END IF;
      DBMS_OUTPUT.PUT_LINE(EMP_SAL);
      UPDATE EMP SET SAL = EMP_SAL WHERE UPPER(ENAME) = 'CLARK' ;
      COMMIT;    
END;

SELECT SAL FROM EMP ;
---------------------------------------------------------------------
DECLARE
   CURSOR  CUR_EMP IS  
      SELECT SAL FROM EMP FOR UPDATE;
   V_ADD_SAL   EMP.SAL%TYPE;   
BEGIN
   FOR  EMP_REC  IN CUR_EMP LOOP
       IF(EMP_REC.SAL < 2000 ) THEN
            V_ADD_SAL := EMP_REC.SAL + 1500;
       ELSIF( EMP_REC.SAL < 3200) THEN
            V_ADD_SAL :=  EMP_REC.SAL*1.3;
       ELSE
            V_ADD_SAL :=   EMP_REC.SAL;
       END IF;         
       UPDATE EMP SET SAL = V_ADD_SAL WHERE CURRENT  OF CUR_EMP;     
   END LOOP;
   COMMIT;
END;


---------------------------------------------------------------------
select column_name, data_type, data_length from user_tab_columns
  where TABLE_NAME = 'EMP'


select   UT.column_name, UT.data_type, UT.data_length from user_tab_columns UT
  where UT.TABLE_NAME =  UPPER('emp')



DECLARE
     V_TABLE_NAME   VARCHAR2(20)  := '&TABLE';
     CURSOR  CUR_EMP(P_TABLENAME   VARCHAR2)  IS 
         SELECT   UT.column_name, UT.data_type, UT.data_length FROM user_tab_columns UT
     WHERE  UT.TABLE_NAME =  UPPER(P_TABLENAME);
     V_SQL     VARCHAR2(200) := 'SELECT COUNT(*) FROM ' || V_TABLE_NAME;
     V_COUNT NUMBER(4);
BEGIN
     EXECUTE IMMEDIATE V_SQL INTO V_COUNT;
     OPEN  CUR_EMP(V_TABLE_NAME);
END;
---------------------------------------------------------------------
DECLARE

BEGIN


END;
---------------------------------------------------------------------
DECLARE

BEGIN


END;
