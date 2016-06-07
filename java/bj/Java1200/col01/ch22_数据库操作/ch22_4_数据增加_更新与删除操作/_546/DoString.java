package bj.Java1200.col01.ch22_数据库操作.ch22_4_数据增加_更新与删除操作._546;

public class DoString {

	private String getstr;
	private String checkstr;

	public DoString() {

	}

	public void setGetstr( String getstr ) {

		this.getstr = getstr;
		dostring();
	}

	public String getGetstr() {

		return this.getstr;
	}

	public String getCheckstr() {

		return this.checkstr;
	}

	public void dostring() {

		this.checkstr = this.getstr;
		this.checkstr = this.checkstr.replaceAll( "&", "&amp;" ); // 替换字符处理
		this.checkstr = this.checkstr.replaceAll( ";", "" );
		this.checkstr = this.checkstr.replaceAll( "'", "" );
		this.checkstr = this.checkstr.replaceAll( "<", "&lt;" );
		this.checkstr = this.checkstr.replaceAll( ">", "&gt;" );
		this.checkstr = this.checkstr.replaceAll( "--", "" );
		this.checkstr = this.checkstr.replaceAll( "\"\"", "&quot;" );
		this.checkstr = this.checkstr.replaceAll( "/", "" );
		this.checkstr = this.checkstr.replaceAll( "%", "" );

	}
}
