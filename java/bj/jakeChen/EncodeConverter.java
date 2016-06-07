package bj.jakeChen;

import java.io.*;

/**
 * 类描述：Linux 下批量转换文件编码格式
 */
public class EncodeConverter {

//	private static String srcDir    = "E:\\Knowledge\\Java\\JavaCodes\\czbk\\传智播客_Java培训_毕向东_Java基础源代码";  // 原文件目录
//	private static String desDir    = "E:\\Knowledge\\Java\\JavaCodes\\czbk1\\"; // 转换后的存放目录

	private static String srcDir    = "E:\\Knowledge\\Java\\JavaCodes\\Java开发实战1200例(第2卷) 源代码\\MR";  // 原文件目录
	private static String desDir    = "E:\\Knowledge\\Java\\JavaCodes\\out_utf-8"; // 转换后的存放目录

	private static String srcEncode = "gbk";   // 源文件编码
	private static String desEncode = "utf-8"; // 输出文件编码

	/**
	 * 入口
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		File desFile = new File(desDir); // 建立目标文件夹
		if (! desFile.exists()) {
			desFile.mkdir();
		}
		desFile = null;
		File srcFile = new File(srcDir);
		readDir(srcFile); // 读取目录 循环转换文件
		srcFile = null;
	}

	/**
	 * 处理的文件过滤,过滤器
	 */
	private static FileFilter filter = new FileFilter() {

		public boolean accept(File pathname) {
			// 只处理：目录 或是 .java文件
			if (pathname.isDirectory() || (pathname.isFile() && pathname.getName().endsWith(".java"))) {
				return true;
			} else {
				return false;
			}
		}
	};

	/**
	 * @param file
	 */
	public static void readDir(File file) {
		// 以过滤器作为参数
		File[] files = file.listFiles(filter);
		for (File subFile : files) {
			/**
			 * 建立目标目录
			 */
			if (subFile.isDirectory()) {
				File file3 = new File(desDir + subFile.getAbsolutePath().substring(srcDir.length() - 5));
				if (! file3.exists()) {
					file3.mkdirs();
				}
				file3 = null;
				readDir(subFile);
			}
			/**
			 * 建立目标文件
			 */
			else {
				System.err.println("一源文件：/t" + subFile.getAbsolutePath() + "/n目标文件：/t" + (desDir + subFile.getAbsolutePath().substring(srcDir.length() - 5)));
				System.err.println("-----------------------------------------------------------------");
				try {
					convert(subFile.getAbsolutePath(), desDir + subFile.getAbsolutePath().substring(srcDir.length() - 5), srcEncode, desEncode);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param infile  源文件路径
	 * @param outfile 输出文件路径
	 * @param from    源文件编码
	 * @param to      目标文件编码
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static void convert(String infile, String outfile, String from,
	                           String to) throws IOException, UnsupportedEncodingException {

		BufferedReader in  = new BufferedReader(new InputStreamReader(new FileInputStream(infile), from));
		PrintWriter    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfile), to)));
		String         reading;
		while ((reading = in.readLine()) != null) {
			out.println(reading);
		}
		out.close();
		in.close();
	}

} 