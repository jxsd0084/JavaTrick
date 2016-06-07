package bj.Java1200.col01.ch21_SQL应用.ch21_1_排序和分组函数应用._493_对统计结果进行排序;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{
			Object.class,
			String.class, Object.class, Object.class, Object.class, Object.class, Object.class
	};
	boolean[] canEdit = new boolean[]{ false, false, false, false, false, false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "姓名", "语文", "数学", "英语", "历史", "物理", } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
