package bj.Java1200.col01.ch24_数据库高级应用.ch24_4_使用视图._603_删除视图;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class };
	boolean[] canEdit = new boolean[]{ false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "视图名称" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
