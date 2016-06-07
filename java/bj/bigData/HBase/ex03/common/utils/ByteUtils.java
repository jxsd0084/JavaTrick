package bj.bigData.HBase.ex03.common.utils;
/**
 * byte处理的公共类
 * @author ranhualin
 * @date 2013-4-15
 */
public class ByteUtils {
	private ByteUtils(){
		
	}
	/**
	 * 反转byte数组
	 * @param in
	 * @return
	 */
	public static byte[] invers(byte[] in){
		byte[] out = new byte[in.length];
		for(int i=in.length-1;i>=0;i--){
			out[in.length-1-i] = in[i];
		}
		return out;
	}
	/**
	 * 返回长度为length的数组，如果in的长度小于length则前面填充def
	 * 如果in的长度大于length，则截取in的后面部分
	 * @param in
	 * @param length
	 * @param def
	 * @return
	 */
	public static byte[] fillStarts(byte[] in,int length,byte def){
		byte[] out = createArray(length,def);
		if(in.length<length){
			System.arraycopy(in, 0, out, length-in.length, in.length);
		}else{
			System.arraycopy(in, in.length-length, out, 0, length);
		}
		return out;
	}
	/**
	 * 返回长度为length的数组，如果in的长度小于length则后面填充def
	 * 如果in的长度大于length，则截取in的前面部分
	 * @param in
	 * @param length
	 * @param def
	 * @return
	 */
	public static byte[] fillEnds(byte[] in,int length,byte def){
		byte[] out = createArray(length,def);
		if(in.length<length){
			System.arraycopy(in, 0, out, 0, in.length);
		}else{
			System.arraycopy(in, 0, out, 0, length);
		}
		return out;
	}
	/**
	 * 创建长度为length的数组，里面的元素为def
	 * @param length
	 * @param def
	 * @return
	 */
	public static byte[] createArray(int length,byte def){
		byte [] out = new byte[length];
		for(int i=0;i<length;i++){
			out[i] = def;
		}
		return out;
	}
	/**
	 * 拷贝数组，如果数组为null或者长度小于length长度
	 * 则不执行操作
	 * @param from
	 * @param start
	 * @param to
	 * @param tostart
	 * @param length
	 * @return
	 */
	public static byte[] tryArrayCopy(byte[] from,int start,byte [] to,int tostart,int length){
		if(from!=null&&from.length>=length+start){
			System.arraycopy(from, start, to, tostart, length);
		}
		return to;
	}
	
	
	/**
	 * 截取输入数组的指定后  N位  不足的前面补零 并进行反转  
	 * 将高位置前  后面补零     效果等同
	 * @param in
	 * @param len
	 * @return
	 */
	public static byte[] cutAndInvers(byte[] in, final int len) {
		int size = in.length;
		byte[] out = new byte[len];
		for (int i = 0; i < len; i++) {
			if (size <= 0) {
				out[i] = (byte)'0';
				continue;
			}
			out[i] = in[--size];
		}
		return out;
	}
	
	public static void main(String[] args) {
		System.out.println(new String(ByteUtils.fillEnds("123456".getBytes(),2,(byte)'0')));
		System.out.println(cutAndInvers("123".getBytes(), 6));
	}

}
