package bj.mldn.javase01.no83.Class.demo.factorydemo03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

interface Fruit {

	public void eat();
}

class Apple implements Fruit {

	public void eat() {

		System.out.println("吃苹果。");
	}
}

class Orange implements Fruit {

	public void eat() {

		System.out.println("吃橘子");
	}
}

class Factory {

	public static Fruit getInstance(String className) {

		Fruit f = null;
		try {
			f = (Fruit) Class.forName(className).newInstance();
		} catch (Exception e) {
		}
		return f;
	}
}

class PropertiesOperate {// 属性操作类
	private Properties pro  = null;
	private File       file = new File("d:" + File.separator + "fruit.properties");

	public PropertiesOperate() {

		this.pro = new Properties();
		if (file.exists()) {// 文件存在
			try {
				pro.loadFromXML(new FileInputStream(file)); // 读取
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.save();
		}
	}

	private void save() {

		this.pro.setProperty("apple", "org.lxh.demo.factorydemo03.Apple");
		this.pro.setProperty("orange", "org.lxh.demo.factorydemo03.Orange");
		try {
			this.pro.storeToXML(new FileOutputStream(this.file), "Fruit");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Properties getProperties() {

		return this.pro;
	}
}

public class FactoryDemo03 {

	public static void main(String[] args) {

		Properties pro = new PropertiesOperate().getProperties();
		Fruit      f   = Factory.getInstance(pro.getProperty("apple"));
		f.eat();
	}
}
