package bj.mldn.javase01.no41;

public class TestPetShop {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		PetShop shop = new PetShop( 5 );        // 定义能存放5个宠物的商店

		shop.add( new Cat( "黑猫", 3, 89.4f ) ); // 增加宠物，成功
		shop.add( new Cat( "白猫", 2, 19.4f ) ); // 增加宠物，成功
		shop.add( new Cat( "花猫", 3, 89.4f ) ); // 增加宠物，成功
		shop.add( new Cat( "白狗", 3, 89.4f ) ); // 增加宠物，成功
		shop.add( new Cat( "黑狗", 3, 89.4f ) ); // 增加宠物，成功
		shop.add( new Cat( "猪狗", 3, 89.4f ) ); // 增加宠物，失败

		Pet p[] = shop.search( "狗" );
		for ( int x = 0; x < p.length; x++ ) {

			System.out.println( p[ x ] );
		}

	}

}
