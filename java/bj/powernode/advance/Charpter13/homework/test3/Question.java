package bj.powernode.advance.Charpter13.homework.test3;

import java.util.ArrayList;

/*
 * Question类    试题类属性：题号 题目描述    若干选项    正确答案  该题的分数  提示：若干选项用ArrayList
 */
public class Question {

	private String              qno;        // 题号
	private String              qname;      // 题目
	private ArrayList< String > arrayList;  // 选项
	private String              right;      // 正确答案
	private int                 thisScope;  // 本题的分数

	public int getThisScope() {

		return thisScope;
	}

	public void setThisScope( int thisScope ) {

		this.thisScope = thisScope;
	}

	public String getQid() {

		return qno;
	}

	public void setQid( String qid ) {

		this.qno = qid;
	}

	public String getQname() {

		return qname;
	}

	public void setQname( String qname ) {

		this.qname = qname;
	}

	public ArrayList< String > getArrayList() {

		return arrayList;
	}

	public void setArrayList( ArrayList< String > arrayList ) {

		this.arrayList = arrayList;
	}

	public String getRight() {

		return right;
	}

	public void setRight( String right ) {

		this.right = right;
	}

	public Question( String qid, String qname, ArrayList< String > arrayList,
	                 String right, int thisScope ) {

		this.qno = qid;
		this.qname = qname;
		this.arrayList = arrayList;
		this.right = right;
		this.thisScope = thisScope;
	}

	@Override
	public String toString() {

		return this.qno + this.qname + "\n" + "\t" + "A.  "
		       + this.arrayList.get( 0 ) + "     B.  " + this.arrayList.get( 1 )
		       + "\n" + "\t" + "C.  " + this.arrayList.get( 2 ) + "     D.  "
		       + this.arrayList.get( 3 );
	}

}
