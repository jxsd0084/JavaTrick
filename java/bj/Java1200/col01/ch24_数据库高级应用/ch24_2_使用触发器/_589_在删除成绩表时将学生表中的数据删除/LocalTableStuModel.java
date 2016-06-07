package bj.Java1200.col01.ch24_数据库高级应用.ch24_2_使用触发器._589_在删除成绩表时将学生表中的数据删除;

public class LocalTableStuModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class, String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false, false, false };

	public LocalTableStuModel() {

		super( new Object[][]{}, new String[]{ "编号", "姓名", "性别", "专业" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
