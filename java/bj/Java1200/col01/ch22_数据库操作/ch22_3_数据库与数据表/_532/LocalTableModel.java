package bj.Java1200.col01.ch22_数据库操作.ch22_3_数据库与数据表._532;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class, String.class,
			String.class, String.class,
			String.class, String.class,
			String.class };
	boolean[] canEdit = new boolean[]{ false, false, false, false, false, false, false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "字段编号", "字段名", "字段长度", "字段类别",
				"描述", "是否为空", "小数位数", "默认值" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
