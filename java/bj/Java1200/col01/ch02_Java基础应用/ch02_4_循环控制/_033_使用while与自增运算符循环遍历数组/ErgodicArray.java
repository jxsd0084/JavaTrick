package bj.Java1200.col01.ch02_Java基础应用.ch02_4_循环控制._033_使用while与自增运算符循环遍历数组;

/**
 * @author 李钟尉
 */
public class ErgodicArray {

	public static void main( String[] args ) {
		// 创建鸟类数组
		String[] aves = new String[]{
				"白鹭", "丹顶鹤", "黄鹂", "鹦鹉", "乌鸦", "喜鹊",
				"布谷鸟", "灰纹鸟", "百灵鸟"
		};
		int index = 0;// 创建索引变量
		System.out.println( "我的花园里有很多鸟，种类大约包括：" );
		while ( index < aves.length ) {// 遍历数组
			System.out.println( aves[ index++ ] );// 自增索引值
		}
	}
}
