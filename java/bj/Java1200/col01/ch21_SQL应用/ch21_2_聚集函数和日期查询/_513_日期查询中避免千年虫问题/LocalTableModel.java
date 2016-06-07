package bj.Java1200.col01.ch21_SQL应用.ch21_2_聚集函数和日期查询._513_日期查询中避免千年虫问题;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class, String.class, String.class, String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false, false, false, false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "姓名", "性别", "生日", "专业", "籍贯" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
