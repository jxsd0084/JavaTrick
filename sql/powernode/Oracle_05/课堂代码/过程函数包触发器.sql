  --创建一个存储过程
  CREATE OR REPLACE PROCEDURE PROC_INSER_DEPT(P_DEPTNO NUMBER,
                                              P_DNAME  VARCHAR2,
                                              P_LOC    NUMBER) IS
  -- 在is之后,begin之前,是声明部分
BEGIN

  --传入参数并提交
  INSERT INTO DEPT VALUES (P_DEPTNO, P_DNAME, P_LOC);

  --提交
  COMMIT;

  --结束
END;
  --------------------------------------------------------------------------------------------------------

  SELECT * FROM DEPT;

  --------------------------------------------------------------------------------------------------------

  -- 可以在一个匿名块中调用存储过程
  DECLARE
  --V_DEPTNO    DEPT.DEPTNO%TYPE  := 60;
  --V_DNAME    DEPT.DNAME%TYPE := '开发部';
  --V_LOC    DEPT.LOC_ID%TYPE := 1001;
BEGIN
  --PROC_INSER_DEPT(V_DEPTNO,V_DNAME,V_LOC);

  -- 按照位置进行调用
  PROC_INSER_DEPT(70, '维修部', 1001);

  -- 按照名称进行调用
  PROC_INSER_DEPT(P_LOC => 1001, P_DNAME => '开发一部', P_DEPTNO => 90);

END;

  --------------------------------------------------------------------------------------------------------

  --创建存储过程,参数:P_IN IN VARCHAR2, P_OUT OUT VARCHAR2, P_IN_OUT IN OUT VARCHAR2
  --in'入';out'出';in-out'即入又出';
  CREATE OR REPLACE PROCEDURE PARAM_TEST(P_IN IN VARCHAR2, P_OUT OUT VARCHAR2, P_IN_OUT IN OUT VARCHAR2) IS

  --开始
BEGIN

  --系统输出信息
  DBMS_OUTPUT.put_line('在过程中的输出===================P_IN=' || P_IN); DBMS_OUTPUT.put_line('在过程中的输出===================P_OUT=' || P_OUT); DBMS_OUTPUT.put_line('在过程中的输出===================P_IN_OUT=' || P_IN_OUT); P_OUT := 'OUT类型的变量在过程中被重新赋值'; P_IN_OUT := 'IN OUT类型的变量在过程中被重新赋值';

  --结束
END;

  --------------------------------------------------------------------------------------------------------

  --声明
  DECLARE

  -- IN类型的参数可以使一个已经初始化好的变量,也可以是一个字符常量
  V_IN VARCHAR2(100) := 'IN类型数据的原始值';

  -- OUT类型的参数,必须是一个变量
  V_OUT VARCHAR2(100) := 'OUT类型数据的原始值';

  -- IN OUT 类型的参数,只能是一个初始化好的变量
  V_IN_OUT VARCHAR2(100) := 'IN OUT类型数据的原始值';

  --开始
BEGIN

  --将变量指向
  PARAM_TEST(P_IN => V_IN, P_OUT => V_OUT, P_IN_OUT => V_IN_OUT);

  --输出信息
  DBMS_OUTPUT.put_line('调用过程之后*********************V_IN=' || V_IN); DBMS_OUTPUT.put_line('调用过程之后*********************V_OUT=' || V_OUT); DBMS_OUTPUT.put_line('调用过程之后*********************V_IN_OUT=' || V_IN_OUT);

  --结束
END;

  --------------------------------------------------------------------------------------------------------

  -- 创建一个函数,参数是一个员工的名字,
  -- 在函数中查询该员工的工资,
  -- 根据不同的情况,返回工资的增长数
  --函数是有返回值的,所以有return关键字
  CREATE OR REPLACE FUNCTION ADD_SAL(P_NAME VARCHAR2) RETURN NUMBER IS

  V_SAL EMP.SAL%TYPE;

BEGIN

  /* 在函数中虽然可以执行DML语句,但是没有什么意义,违背函数的用意
  UPDATE EMP SET SAL = 9000 WHERE UPPER(ENAME) = UPPER(P_NAME);
  COMMIT;
  */

  --对字段建立等式查询
  SELECT SAL INTO V_SAL FROM EMP WHERE UPPER(ENAME) = UPPER(P_NAME);

  --当薪水v_sal小于2000时,则
  IF (V_SAL < 2000) THEN

  --返回薪水*1.5倍
  RETURN V_SAL * 1.5;

  --当薪水小于3000时,则
  ELSIF(V_SAL < 3000) THEN

  --返回薪水*1.3倍
  RETURN V_SAL * 1.3;

  --当薪水小于4000时
  ELSIF(V_SAL < 4000) THEN

  --返回薪水*1.1倍
  RETURN V_SAL * 1.1; ELSE

  --其他情况不增加薪水
  RETURN V_SAL;

--结束if条件判断
END IF;

  --处理异常
EXCEPTION

  --当发生NO_DATA_FOUND异常时,输出信息
  WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.put_line('你输入的员工名称:' || P_NAME || ' 不存在!');

  --结束
END;

--------------------------------------------------------------------------------------------------------

  --更新emp表中数据
  SELECT * FROM EMP FOR UPDATE

--------------------------------------------------------------------------------------------------------

  --根据emp表中字段的类型声明变量
  DECLARE V_NAME EMP.ENAME%TYPE := 'SMITH'; V_ADD_SAL EMP.SAL%TYPE;

BEGIN

  --对变量进行赋值
  V_ADD_SAL := ADD_SAL(P_NAME => V_NAME); DBMS_OUTPUT.put_line('V_ADD_SAL=' || V_ADD_SAL);

END;

  SELECT E.ENAME, E.SAL 原来的工资, ADD_SAL(E.ENAME) "增长后的工资" FROM EMP E;

  select * from emp;
