package bj.Java1200.col01.ch23_数据查询.ch23_2_嵌套查询._567_动态指定查询条件;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class, String.class, String.class, String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false, false, false, false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "姓名", "性别", "英语", "语文", "数学" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
