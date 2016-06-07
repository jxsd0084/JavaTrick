package bj.Java1200.col01.ch21_SQL应用.ch21_3_大小比较与逻辑应用._520_格式化金额;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "姓名", "年薪" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
