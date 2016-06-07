--------------------------------------------------------

--声明
DECLARE

  --专门用来进行调试的语句
  --CREATE OR REPLACE PROCEDURE  PROC_EMP IS

  --根据目标表中字段的类型赋值
  V_EMP EMP%ROWTYPE;

  --创建游标    
  CURSOR CUR_EMP IS
    SELECT * FROM EMP;

  --创建字段,确定字段类型
  V_NUMBER1 NUMBER(2);

  --开始    
BEGIN

  --SQL语句,建立等值查询  
  SELECT * INTO V_EMP FROM EMP WHERE DEPTNO = 60;

  --系统输出信息    
  --DBMS_OUTPUT.put_line(CUR_EMP%ROWCOUNT);

  --给变量赋值   
  V_NUMBER1 := '99';

  --添加数据到数据库中   
  --INSERT INTO DEPT VALUES (10,'技术部',NULL);

  --提交    
  --COMMIT;

--输出系统消息
  DBMS_OUTPUT.PUT_LINE('OK');

--异常处理
EXCEPTION
	
--当发生'TOO_MANY_ROWS'异常时
  WHEN TOO_MANY_ROWS THEN
		
--系统输出异常信息'发生数据太多的异常'		
    DBMS_OUTPUT.put_line('发生数据太多的异常');
		
    /*
--当发生'NO_DATA_FOUND'异常时		
    WHEN  NO_DATA_FOUND   THEN   
			
--系统输出异常信息'发生没有数据的异常'		
       DBMS_OUTPUT.put_line('发生没有数据的异常'); 
    */
		
--当发生'INVALID_CURSOR'异常时		
  WHEN INVALID_CURSOR THEN
--系统输出异常信息'无效的游标'		
    DBMS_OUTPUT.put_line('无效的游标');
		
--当发生'ZERO_DIVIDE'异常时		
  WHEN ZERO_DIVIDE THEN
--系统输出异常信息'除0异常'		
    DBMS_OUTPUT.put_line('除0异常');
		
--当发生'DUP_VAL_ON_INDEX'异常时
  WHEN DUP_VAL_ON_INDEX THEN
--系统输出异常信息'主键重复异常'		
    DBMS_OUTPUT.put_line('主键重复异常');
		
--当发生'VALUE_ERROR'异常时
  WHEN VALUE_ERROR THEN
--系统输出异常信息'赋值错误'		
    DBMS_OUTPUT.put_line('赋值错误');
		
--当发生其他异常时		
  WHEN OTHERS THEN
--系统输出信息'数据库----------------发生异常'		
    DBMS_OUTPUT.put_line('数据库----------------发生异常');
		
--结束		
END;




--------------------------------------------------------

--声明
DECLARE
  v_emp_remaining EXCEPTION;
  PRAGMA EXCEPTION_INIT(v_emp_remaining, -02292);
BEGIN
  DELETE FROM DEPT WHERE DEPTNO = 10;
EXCEPTION
  WHEN v_emp_remaining THEN
    DBMS_OUTPUT.put_line('违反完整性约束异常');
  WHEN OTHERS THEN
    DBMS_OUTPUT.put_line('遇到其他的异常');
END;




--------------------------------------------------------
drop table sm_emp;
CREATE TABLE sm_emp(no char(4),
                    name char(10),
                    salary number(6, 2),
                    phone char(8));

--insert TOM
INSERT INTO sm_emp VALUES ('001', 'TOM', 999.99, '62543678');
INSERT INTO sm_emp VALUES ('002', 'TOM', 999.99, '62543678');
INSERT INTO sm_emp VALUES ('003', 'TOM3', 999.99, NULL);

commit;

--如果用户的电话为null,则认为发生一个异常

DECLARE
  CURSOR CUR_EMP IS
    SELECT * FROM SM_EMP;
  phonelostexception EXCEPTION;
  v_name SM_EMP.NAME%TYPE;
BEGIN
  FOR V_EMP IN CUR_EMP LOOP
    IF V_EMP.PHONE IS NULL THEN
      v_name := V_EMP.NAME;
      RAISE phonelostexception;
    END IF;
  END LOOP;
EXCEPTION
  WHEN phonelostexception THEN
    DBMS_OUTPUT.put_line('phonelostexception：' || v_name || '的电话为空');
END;




--------------------------------------------------------
DROP TABLE ERR_LOG;
CREATE TABLE ERR_LOG(CODE NUMBER(10), MESSAGE VARCHAR2(255), DATETIME DATE);

drop table test;
create table test(id number(5) primary key,
                  name varchar2(20),
                  salary number(8, 2));

SELECT * FROM ERR_LOG;

DECLARE
  V_CODE    ERR_LOG.CODE%TYPE;
  V_MESSAGE ERR_LOG.MESSAGE%TYPE;
BEGIN
  INSERT INTO TEST VALUES (1, 'AAA', 3000);
  INSERT INTO TEST VALUES (1, NULL, NULL);
EXCEPTION
  WHEN OTHERS THEN
    V_CODE    := SQLCODE;
    V_MESSAGE := SQLERRM;
    INSERT INTO ERR_LOG VALUES (V_CODE, V_MESSAGE, SYSDATE);
    COMMIT;
    DBMS_OUTPUT.put_line('发生异常');
END;




--------------------------------------------------------
DECLARE

BEGIN

END;
--------------------------------------------------------
