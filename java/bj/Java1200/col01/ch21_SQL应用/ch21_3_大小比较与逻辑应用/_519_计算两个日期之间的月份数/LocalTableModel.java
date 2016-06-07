package bj.Java1200.col01.ch21_SQL应用.ch21_3_大小比较与逻辑应用._519_计算两个日期之间的月份数;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class };
	boolean[] canEdit = new boolean[]{ false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "产品名称", "上市月份" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
