package bj.Java1200.col01.ch23_数据查询.ch23_1_使用子查询._555_用子查询作为派生表;

public class MostlyModel extends javax.swing.table.DefaultTableModel {

	Class[]   types   = new Class[]{ Object.class,
			String.class, String.class, String.class };
	boolean[] canEdit = new boolean[]{ false, false, false, false };

	public MostlyModel() {

		super( new Object[][]{}, new String[]{ "编号", "姓名", "职位", "工资" } );
	}

	public Class getColumnClass( int columnIndex ) {

		return types[ columnIndex ];
	}

	public boolean isCellEditable( int rowIndex, int columnIndex ) {

		return canEdit[ columnIndex ];
	}
}
