package bj.Java1200.col01.ch22_数据库操作.ch22_4_数据增加_更新与删除操作._553_字符串大小写转换;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class, String.class, String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false, false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "姓氏", "名字", "国籍", "专业" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
