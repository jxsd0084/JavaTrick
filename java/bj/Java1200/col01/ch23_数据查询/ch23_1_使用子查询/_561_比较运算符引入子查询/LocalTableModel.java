package bj.Java1200.col01.ch23_数据查询.ch23_1_使用子查询._561_比较运算符引入子查询;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "姓名", "语文成绩" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
