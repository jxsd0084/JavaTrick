package bj.Java1200.col01.ch24_数据库高级应用.ch24_3_使用批处理._593_使用批处理删除数据;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class, String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false, false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "姓名", "性别", "专业" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
