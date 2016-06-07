package bj.Java1200.col01.ch24_数据库高级应用.ch24_1_在Java程序中使用存储过程._587_删除存储过程;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class };
	boolean[] canEdit = new boolean[]{ false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "存储过程名称" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
