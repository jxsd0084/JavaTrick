package bj.Java1200.col01.ch21_SQL应用.ch21_1_排序和分组函数应用._491_对数据进行降序查询;
public class LocalTableModel extends javax.swing.table.DefaultTableModel {
	Class[] types = new Class[] { Object.class,
			String.class, String.class, String.class, String.class};
	boolean[] canEdit = new boolean[] { false, false, false,false,false };
	public LocalTableModel() {
		super(new Object[][] {}, new String[] { "编号", "书名", "作者","售价","库存" });
	}
	public Class getColumnClass(int columnIndex) {
		return types[columnIndex];
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}
}
