package bj.Java1200.col01.ch23_数据查询.ch23_4_函数查询._581_计算商品销售额所占百分比;

public class LocalTableModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class, String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false, false, false };

	public LocalTableModel() {

		super( new Object[][]{}, new String[]{ "编号", "商品名称", "销售额", "所占比例" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
