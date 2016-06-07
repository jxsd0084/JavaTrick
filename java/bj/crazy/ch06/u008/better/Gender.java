package bj.crazy.ch06.u008.better;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public enum Gender {

	MALE, FEMALE;

	private String name;

	public void setName( String name ) {

		switch ( this ) {
			case MALE:
				if ( name.equals( "男" ) ) {
					this.name = name;

				} else {
					System.out.println( "参数错误" );
					return;
				}
				break;

			case FEMALE:
				if ( name.equals( "女" ) ) {
					this.name = name;

				} else {
					System.out.println( "参数错误" );
					return;
				}

				break;
		}

	}

	public String getName() {

		return this.name;
	}
}
