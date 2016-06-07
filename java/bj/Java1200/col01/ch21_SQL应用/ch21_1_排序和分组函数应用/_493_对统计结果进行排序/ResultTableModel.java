package bj.Java1200.col01.ch21_SQL应用.ch21_1_排序和分组函数应用._493_对统计结果进行排序;

public class ResultTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{
			Object.class,
			String.class, Object.class
	};
	boolean[] canEdit = new boolean[]{ false, false, false };

	public ResultTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "姓名", "总分" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
