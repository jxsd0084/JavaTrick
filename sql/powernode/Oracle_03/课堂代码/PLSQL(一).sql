SELECT * FROM EMP;

SELECT * FROM DEPT;

DELETE FROM EMP WHERE DEPTNO = 30


DECLARE
    -- 声明了一个变量
    V_DEPTNO  NUMBER(4);    
BEGIN
   DBMS_OUTPUT.put_line('V_DEPTNO =' || V_DEPTNO);
   
   /*查询指定名称的部门编号,赋值给变量V_DEPTNO*/
   SELECT DEPTNO  INTO V_DEPTNO  FROM DEPT WHERE DNAME = 'SALES';   
  
   DBMS_OUTPUT.put_line('V_DEPTNO =' || V_DEPTNO);
         
   DELETE FROM EMP WHERE DEPTNO = V_DEPTNO;      
   DELETE FROM DEPT WHERE DEPTNO = V_DEPTNO;
   ROLLBACK;
END;

------------------------------------------------------------------------------
DECLARE
  -- 在声明部分可以声明变量,并且可以赋值
  -- 声明的变量在整个的PL/SQL程序中都可以使用
  V_1 NUMBER(4) := 1000;

  v_total_sal NUMBER(9, 2) := 0;
  c_tax_rate CONSTANT NUMBER(3, 2) := 8.25;
  v_gender CHAR(1);
  v_valid  BOOLEAN NOT NULL := TRUE;
BEGIN
  
  c_tax_rate := 4.32;
  /*
  DBMS_OUTPUT.put_line('V_1=' || V_1);

  V_1 := 9000;
  DBMS_OUTPUT.put_line('V_1=' || V_1);
  */
END;

------------------------------------------------------------------------------
DECLARE
  v_gender     CHAR(1);
  v_count      BINARY_INTEGER := 0;
  v_total_sal  NUMBER(9) :=   Length('好好学习,天天向上');
  v_order_date DATE := SYSDATE + 7;
  c_tax_rate CONSTANT NUMBER(3, 2) := 8.25;
  v_valid BOOLEAN NOT NULL := TRUE;

BEGIN
   dbms_output.put_line(v_total_sal || '   ' ||   to_char(v_order_date,'YYYY-MM-DD'));
END;

------------------------------------------------------------------------------
DECLARE


BEGIN


END;

------------------------------------------------------------------------------
DECLARE


BEGIN


END;
