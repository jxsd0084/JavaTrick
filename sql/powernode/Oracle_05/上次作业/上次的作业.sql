--1����дһ��pl/sql�飻
--1����emp���в�ѯ����ΪFORD�Ĺ��ʣ�����ʾ����Ļ�ϡ�

DECLARE 
  EMP_SAL EMP.SAL%TYPE;
BEGIN
  SELECT SAL INTO EMP_SAL FROM EMP WHERE UPPER(ENAME) = 'FORD';
  DBMS_OUTPUT.PUT_LINE(EMP_SAL);
END;

--2����emp���в�ѯ����Ϊ7934����Ϣ����ʾ����Ļ�ϡ�

SELECT * FROM EMP;

DECLARE
  EMP_TAB    EMP%ROWTYPE;
BEGIN
  SELECT * INTO EMP_TAB FROM EMP WHERE EMPNO = 7934;
  DBMS_OUTPUT.PUT_LINE(EMP_TAB.EMPNO||'  '||EMP_TAB.ENAME||'  '||EMP_TAB.JOB||'  '||EMP_TAB.MGR||'  '||TO_CHAR(EMP_TAB.HIREDATE,'YYYY-MM-DD')||'  '||EMP_TAB.SAL||'  '||EMP_TAB.COMM||'  '||EMP_TAB.DEPTNO);
END;

--2����дһ��pl/sql�飬����1+2+3+4+5+����+100��ֵ������ʾ����Ļ�ϡ�

--FOR ѭ��
DECLARE
  SUM_N NUMBER(4) := 0;
BEGIN
  FOR I IN 1 .. 100 LOOP
    SUM_N := SUM_N + I;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(SUM_N);
END;

--��ѭ��
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

--WHILE ѭ��
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

/*3����дһ��pl/sql�飻
      ��ѯ����Ա���Ĺ���
���ʵ���2000��1500��
���ʽ���2000-3200֮����30%��
���ʸ���3200���䡣
      ��ifʵ�֡�*/
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

/*4������һ����student_��š�����дpl/sql����ʵ�����¹��ܡ�
1���ֶΣ�
Sid   ѧ������
����Ϊ��λ��������  Sname  ѧ������
10λ�ַ���  Ssex  ѧ���Ա�
1λ�ַ�
2������100������
  ѧ�������ֱ���s001,s002,s003,s004����s100��
  �Ա�ֱ��ǣ����sid�ܱ�2������Ϊ���ԣ�����ΪŮ�ԡ�

3����ʾ����oracle�����ʵ�������������ֶΣ�sid���ǡ�*/

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

/*5��  ��дһPL/SQL�������й�Ա�����ǻ���нˮ��10%��н��������Ӻ��нˮ����5000����ȡ���ù�Ա�ļ�н��
�漰��֪ʶ�㣺
1��  �α�Ķ����ʹ��
2��  ʹ��ѭ���α�ʵ��
3��  Current of �α���÷�*/

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
/*6��  ���ݿͻ�������ı�������ѯ�����м�����¼������ʾ��ṹ
�漰��֪ʶ�㣺
1��  Oracle��ϵͳ��ͼ
2��  ��̬SQL��ʹ��
3��  �α��ʹ��
ʵ�ֵĲ��裺
1��  �ҳ��ܹ���ѯ��ṹ��������ͼ����ע������Sqlplus�е������Sql����������SYS�û�����ͼ����Ѱ������ṹ��������ͼ
2��  ����ʲôʱ����Ҫʹ�ö�̬SQL����Ҫʹ���α�*/


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
  DBMS_OUTPUT.PUT_LINE('����������' || V_COUNT);
  FOR EMP_REC IN CUR_EMP(V_TABLE_NAME) LOOP
    DBMS_OUTPUT.PUT_LINE(EMP_REC.column_name || '   ' || EMP_REC.data_type ||
                         '   ' || EMP_REC.data_length);
  END LOOP;

EXCEPTION
  WHEN OTHERS THEN
    V_CODE    := SQLCODE;
    V_MESSAGE := SQLERRM;
    IF (V_CODE = -942) THEN
      DBMS_OUTPUT.put_line('������ı���:' || V_TABLE_NAME || ' ������!');
    END IF;
  
END;


declare
  vtname varchar2(20) := '&����';
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
    dbms_output.put_line(vtname || '���������������룡');
  else
    vsql1 := 'select count(*) from ' || vtname;
    execute immediate vsql1
      into vcount;
    dbms_output.put_line(vtname || '���й���' || vcount || '����¼');
    open c1;
    loop
      fetch c1
        into vcolname, vcoltype, vcollen;
      exit when c1%notfound;
      dbms_output.put_line('����' || '  ' || '����(����)');
      dbms_output.put_line('---------------------------');
      dbms_output.put_line(vcolname || '  ' || vcoltype || '(' || vcollen || ')');
    end loop;
    close c1;
  end if;
end;







