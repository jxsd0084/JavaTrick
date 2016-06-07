package bj.Java1200.col01.ch21_SQL应用.ch21_3_大小比较与逻辑应用._521_在查询语句中过滤掉字符串中的空格;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class, String.class, String.class, String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false, false, false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "书名", "库存", "价格", "出版社" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
