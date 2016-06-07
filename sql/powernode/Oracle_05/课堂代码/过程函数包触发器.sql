  --����һ���洢����
  CREATE OR REPLACE PROCEDURE PROC_INSER_DEPT(P_DEPTNO NUMBER,
                                              P_DNAME  VARCHAR2,
                                              P_LOC    NUMBER) IS
  -- ��is֮��,begin֮ǰ,����������
BEGIN

  --����������ύ 
  INSERT INTO DEPT VALUES (P_DEPTNO, P_DNAME, P_LOC);

  --�ύ  
  COMMIT;

  --����  
END;
  --------------------------------------------------------------------------------------------------------

  SELECT * FROM DEPT;

  --------------------------------------------------------------------------------------------------------

  -- ������һ���������е��ô洢����
  DECLARE
  --V_DEPTNO    DEPT.DEPTNO%TYPE  := 60;
  --V_DNAME    DEPT.DNAME%TYPE := '������';
  --V_LOC    DEPT.LOC_ID%TYPE := 1001;    
BEGIN
  --PROC_INSER_DEPT(V_DEPTNO,V_DNAME,V_LOC);

  -- ����λ�ý��е���
  PROC_INSER_DEPT(70, 'ά�޲�', 1001);

  -- �������ƽ��е���
  PROC_INSER_DEPT(P_LOC => 1001, P_DNAME => '����һ��', P_DEPTNO => 90);

END;

  --------------------------------------------------------------------------------------------------------

  --�����洢����,����:P_IN IN VARCHAR2, P_OUT OUT VARCHAR2, P_IN_OUT IN OUT VARCHAR2
  --in'��';out'��';in-out'�����ֳ�';
  CREATE OR REPLACE PROCEDURE PARAM_TEST(P_IN IN VARCHAR2, P_OUT OUT VARCHAR2, P_IN_OUT IN OUT VARCHAR2) IS

  --��ʼ
BEGIN

  --ϵͳ�����Ϣ
  DBMS_OUTPUT.put_line('�ڹ����е����===================P_IN=' || P_IN); DBMS_OUTPUT.put_line('�ڹ����е����===================P_OUT=' || P_OUT); DBMS_OUTPUT.put_line('�ڹ����е����===================P_IN_OUT=' || P_IN_OUT); P_OUT := 'OUT���͵ı����ڹ����б����¸�ֵ'; P_IN_OUT := 'IN OUT���͵ı����ڹ����б����¸�ֵ';

  --����
END;

  --------------------------------------------------------------------------------------------------------

  --����
  DECLARE

  -- IN���͵Ĳ�������ʹһ���Ѿ���ʼ���õı���,Ҳ������һ���ַ�����
  V_IN VARCHAR2(100) := 'IN�������ݵ�ԭʼֵ';

  -- OUT���͵Ĳ���,������һ������
  V_OUT VARCHAR2(100) := 'OUT�������ݵ�ԭʼֵ';

  -- IN OUT ���͵Ĳ���,ֻ����һ����ʼ���õı���
  V_IN_OUT VARCHAR2(100) := 'IN OUT�������ݵ�ԭʼֵ';

  --��ʼ
BEGIN

  --������ָ��
  PARAM_TEST(P_IN => V_IN, P_OUT => V_OUT, P_IN_OUT => V_IN_OUT);

  --�����Ϣ
  DBMS_OUTPUT.put_line('���ù���֮��*********************V_IN=' || V_IN); DBMS_OUTPUT.put_line('���ù���֮��*********************V_OUT=' || V_OUT); DBMS_OUTPUT.put_line('���ù���֮��*********************V_IN_OUT=' || V_IN_OUT);

  --����
END;

  --------------------------------------------------------------------------------------------------------

  -- ����һ������,������һ��Ա��������,
  -- �ں����в�ѯ��Ա���Ĺ���,
  -- ���ݲ�ͬ�����,���ع��ʵ�������
  --�������з���ֵ��,������return�ؼ��� 
  CREATE OR REPLACE FUNCTION ADD_SAL(P_NAME VARCHAR2) RETURN NUMBER IS

  V_SAL EMP.SAL%TYPE;

BEGIN

  /* �ں�������Ȼ����ִ��DML���,����û��ʲô����,Υ������������
  UPDATE EMP SET SAL = 9000 WHERE UPPER(ENAME) = UPPER(P_NAME);
  COMMIT;
  */

  --���ֶν�����ʽ��ѯ   
  SELECT SAL INTO V_SAL FROM EMP WHERE UPPER(ENAME) = UPPER(P_NAME);

  --��нˮv_salС��2000ʱ,��   
  IF (V_SAL < 2000) THEN

  --����нˮ*1.5��   
  RETURN V_SAL * 1.5;

  --��нˮС��3000ʱ,��       
  ELSIF(V_SAL < 3000) THEN

  --����нˮ*1.3��   
  RETURN V_SAL * 1.3;

  --��нˮС��4000ʱ       
  ELSIF(V_SAL < 4000) THEN

  --����нˮ*1.1��   
  RETURN V_SAL * 1.1; ELSE

  --�������������нˮ     
  RETURN V_SAL;
	
--����if�����ж�	
END IF;

  --�����쳣
EXCEPTION

  --������NO_DATA_FOUND�쳣ʱ,�����Ϣ
  WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.put_line('�������Ա������:' || P_NAME || ' ������!');

  --����
END;

--------------------------------------------------------------------------------------------------------

  --����emp��������
  SELECT * FROM EMP FOR UPDATE
	
--------------------------------------------------------------------------------------------------------	

  --����emp�����ֶε�������������
  DECLARE V_NAME EMP.ENAME%TYPE := 'SMITH'; V_ADD_SAL EMP.SAL%TYPE;

BEGIN

  --�Ա������и�ֵ
  V_ADD_SAL := ADD_SAL(P_NAME => V_NAME); DBMS_OUTPUT.put_line('V_ADD_SAL=' || V_ADD_SAL);

END;

  SELECT E.ENAME, E.SAL ԭ���Ĺ���, ADD_SAL(E.ENAME) "������Ĺ���" FROM EMP E;

  select * from emp;
