package bj.mldn.javase01.no41;

public class PetShop {

	private Pet pets[]; // 表示有多个宠物
	private int foot; // 定义脚标

	public PetShop( int len ) {// 宠物的个数可以通过外部指定
		if ( len > 0 ) {// 判断输入的个数长度是否大于0
			this.pets = new Pet[ len ];

		} else {
			this.pets = new Pet[ 1 ];// 至少保留一个宠物
		}
	}

	public boolean add( Pet pet ) {// 增加宠物，返回是否增加成功的信息
		if ( this.foot < this.pets.length ) {// 可以增加宠物
			this.pets[ this.foot ] = pet; // 保存宠物
			this.foot++;// 修改脚标
			return true; // 增加成功

		} else {
			return false;// 增加失败
		}
	}

	// 因为查询的时候可能返回多个内容，所以还应该以数组的形式表示
	public Pet[] search( String keyWord ) {// 根据关键字查询
		Pet[] result = null; // 声明数组，但是，大小不指定
		int   count  = 0; // 记录出有多少种宠物符合信息

		for ( int i = 0; i < this.pets.length; i++ ) {// 循环查询

			if ( this.pets[ i ] != null ) {// 表示有宠物信息

				if ( this.pets[ i ].getName().indexOf( keyWord ) != -1 ) {// 查询到结果

					count++; // 修改查询个数
				}
			}
		}
		result = new Pet[ count ]; // 根据查找的个数开辟数组空间
		count = 0; // 加入内容

		for ( int i = 0; i < this.pets.length; i++ ) {// 循环查询

			if ( this.pets[ i ] != null ) {// 表示有宠物信息

				if ( this.pets[ i ].getName().indexOf( keyWord ) != -1 ) {// 查询到结果

					result[ count ] = this.pets[ i ];// 返回查询的内容
					count++; // 修改查询个数
				}
			}
		}
		return result;
	}

}
