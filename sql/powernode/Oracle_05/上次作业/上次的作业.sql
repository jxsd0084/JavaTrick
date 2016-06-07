

--1、编写一个pl/sql块；
--1）在emp表中查询姓名为FORD的工资，并显示在屏幕上。

DECLARE 
  EMP_SAL EMP.SAL%TYPE;
BEGIN
  SELECT SAL INTO EMP_SAL FROM EMP WHERE UPPER(ENAME) = 'FORD';
  DBMS_OUTPUT.PUT_LINE(EMP_SAL);
END;

--2）在emp表中查询代号为7934的信息并显示在屏幕上。

SELECT * FROM EMP;

DECLARE
  EMP_TAB    EMP%ROWTYPE;
BEGIN
  SELECT * INTO EMP_TAB FROM EMP WHERE EMPNO = 7934;
  DBMS_OUTPUT.PUT_LINE(EMP_TAB.EMPNO||'  '||EMP_TAB.ENAME||'  '||EMP_TAB.JOB||'  '||EMP_TAB.MGR||'  '||TO_CHAR(EMP_TAB.HIREDATE,'YYYY-MM-DD')||'  '||EMP_TAB.SAL||'  '||EMP_TAB.COMM||'  '||EMP_TAB.DEPTNO);
END;





--2、编写一个pl/sql块，计算1+2+3+4+5+……+100的值，并显示在屏幕上。

--FOR 循环
DECLARE
  SUM_N NUMBER(4) := 0;
BEGIN
  FOR I IN 1 .. 100 LOOP
    SUM_N := SUM_N + I;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(SUM_N);
END;

--简单循环
DECLARE
  SUM_N NUMBER(4) := 0;
  I     NUMBER(3) := 0;
BEGIN
  LOOP
    I     := I + 1;
    SUM_N := SUM_N + I;
    EXIT WHEN I >=100;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(SUM_N);
END;

--WHILE 循环
DECLARE
  SUM_N NUMBER(4) := 0;
  I     NUMBER(3) := 0;
BEGIN
  WHILE (I < 100) LOOP
    I     := I + 1;
    SUM_N := SUM_N + I;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(SUM_N);
END;





/*3、编写一个pl/sql块；
      查询所有员工的工资
工资低于2000涨1500；
工资介于2000-3200之间涨30%；
工资高于3200不变。
      用if实现。*/
DECLARE
  CURSOR CUR_EMP IS
    SELECT SAL FROM EMP FOR UPDATE;
  EMP_SAL EMP.SAL%TYPE;
BEGIN
  FOR EMP_SAL IN CUR_EMP LOOP
    IF (EMP_SAL < 2000) THEN
      EMP_SAL := EMP_SAL + 1500;
    ELSIF (EMP_SAL < 3200) THEN
      EMP_SAL := EMP_SAL * 1.3;
    ELSE
      EMP_SAL := EMP_SAL;
    END IF;
    DBMS_OUTPUT.PUT_LINE(EMP_SAL);
    UPDATE EMP SET SAL = EMP_SAL WHERE CURRENT OF CUR_EMP;
    COMMIT;
  END LOOP;
END;
  
DBMS_OUTPUT.PUT_LINE





/*4、建立一个表“student_班号”，编写pl/sql块来实现如下功能。
1）字段：
Sid   学生代码
必须为六位整型数字  Sname  学生姓名
10位字符型  Ssex  学生性别
1位字符
2）插入100条数据
  学生姓名分别是s001,s002,s003,s004……s100，
  性别分别是：如果sid能被2整除，为男性，否则为女性。

3）提示：在oracle中如何实现类似自增长字段？sid就是。*/

CREATE TABLE STUDENT_CNO(
       SID        NUMBER(6),
       --SID        CHAR(6)
       SNAME      VARCHAR2(10),
       SSEX       CHAR(1)
)

TRUNCATE TABLE STUDENT_CNO;

--DECLARE
CREATE OR REPLACE PROCEDURE PORC_EMP IS
  m     NUMBER(3) := 1;
  SNAME STUDENT_CNO.SNAME%TYPE;
  SSEX  STUDENT_CNO.SSEX%TYPE;
BEGIN  
  FOR SID IN 100001 .. 100100 LOOP
    IF SID MOD 2 = 0 THEN
      SSEX := 'B';
    ELSE
      SSEX := 'G';
    END IF;
    SNAME := 's' || TO_CHAR(m, '000');
    INSERT INTO STUDENT_CNO VALUES (SID, SNAME, SSEX);
    m := m + 1;  
  END LOOP;
  COMMIT;
END;


SELECT * FROM STUDENT_CNO;





/*5、  编写一PL/SQL，对所有雇员按他们基本薪水的10%加薪，如果增加后的薪水大于5000，则取消该雇员的加薪。
涉及的知识点：
1）  游标的定义和使用
2）  使用循环游标实现
3）  Current of 游标的用法*/

--CREATE OR REPLACE PROCEDURE P_EMP IS
DECLARE
  CURSOR CUR_EMP IS
    SELECT SAL FROM EMP FOR UPDATE;
  EMP_SAL EMP.SAL%TYPE;
BEGIN
  FOR EMP_REC IN CUR_EMP LOOP
    IF (EMP_REC.SAL * 1.1) <= 5000 THEN
      EMP_SAL := EMP_REC.SAL * 1.1;
      UPDATE EMP SET SAL = EMP_SAL WHERE CURRENT OF CUR_EMP;
    END IF;
  END LOOP;
  COMMIT;
END;

SELECT * FROM EMP;




/*6、  根据客户端输入的表名，查询表中有几条记录，并显示表结构
涉及的知识点：
1）  Oracle的系统视图
2）  动态SQL的使用
3）  游标的使用
实现的步骤：
1）  找出能够查询表结构的数据视图——注意区分Sqlplus中的命令和Sql语句的区别。在SYS用户的视图中找寻描述表结构的数据视图
2）  考虑什么时候需要使用动态SQL，需要使用游标*/


SELECT COUNT(*) FROM EMPS


DECLARE
  --CREATE OR REPLACE PROCEDURE P_EMP IS
  V_TABLE_NAME VARCHAR2(20) := '&TABLE';
  CURSOR CUR_EMP(P_TABLENAME VARCHAR2) IS
    SELECT UT.column_name, UT.data_type, UT.data_length
      FROM user_tab_columns UT
     WHERE UT.TABLE_NAME = UPPER(P_TABLENAME);
  V_SQL     VARCHAR2(200);
  V_COUNT   NUMBER(4);
  V_CODE    NUMBER(10);
  V_MESSAGE varchar2(200);

BEGIN
  V_SQL := 'SELECT COUNT(*) FROM ' || V_TABLE_NAME;
  EXECUTE IMMEDIATE V_SQL
    INTO V_COUNT;
  DBMS_OUTPUT.PUT_LINE('数据条数：' || V_COUNT);
  FOR EMP_REC IN CUR_EMP(V_TABLE_NAME) LOOP
    DBMS_OUTPUT.PUT_LINE(EMP_REC.column_name || '   ' || EMP_REC.data_type ||
                         '   ' || EMP_REC.data_length);
  END LOOP;

EXCEPTION
  WHEN OTHERS THEN
    V_CODE    := SQLCODE;
    V_MESSAGE := SQLERRM;
    IF (V_CODE = -942) THEN
      DBMS_OUTPUT.put_line('你输入的表名:' || V_TABLE_NAME || ' 不存在!');
    END IF;
  
END;


declare
  vtname varchar2(20) := '&表名';
  vcount number;
  vsql1  varchar2(1000);
  cursor c1 is
    select column_name, data_type, data_length
      from user_tab_columns
     where upper(table_name) = upper(vtname);
  vcolname user_tab_columns.column_name%type;
  vcoltype user_tab_columns.data_type%type;
  vcollen  user_tab_columns.data_length%type;
begin
  select count(*)
    into vcount
    from user_tables
   where upper(table_name) = upper(vtname);
  if vcount < 1 then
    dbms_output.put_line(vtname || '表不存在请重新输入！');
  else
    vsql1 := 'select count(*) from ' || vtname;
    execute immediate vsql1
      into vcount;
    dbms_output.put_line(vtname || '表中共有' || vcount || '条记录');
    open c1;
    loop
      fetch c1
        into vcolname, vcoltype, vcollen;
      exit when c1%notfound;
      dbms_output.put_line('列名' || '  ' || '类型(长度)');
      dbms_output.put_line('---------------------------');
      dbms_output.put_line(vcolname || '  ' || vcoltype || '(' || vcollen || ')');
    end loop;
    close c1;
  end if;
end;







