package bj.Java1200.col01.ch21_SQL应用.ch21_1_排序和分组函数应用._501_按列的编号排序;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{
			java.lang.Object.class,
			java.lang.String.class
	};
	boolean[] canEdit = new boolean[]{ false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "名称", "销量", } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
