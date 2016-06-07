package bj.mldn.javase02.ch06.no10;

interface Pet {    // 定义宠物接口

	public String getName();

	public String getColor();

	public int getAge();
}

class Cat implements Pet {    // 猫是宠物，实现接口

	private String name;    // 宠物名字
	private String color;    // 宠物颜色
	private int    age;        // 宠物年龄

	public Cat(String name, String color, int age) {

		this.setName(name);
		this.setColor(color);
		this.setAge(age);
	}

	public void setName(String name) {

		this.name = name;
	}

	public void setColor(String color) {

		this.color = color;
	}

	public void setAge(int age) {

		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public String getColor() {

		return this.color;
	}

	public int getAge() {

		return this.age;
	}
};

class Dog implements Pet {    // 狗是宠物，实现接口

	private String name;    // 宠物名字
	private String color;    // 宠物颜色
	private int    age;        // 宠物年龄

	public Dog(String name, String color, int age) {

		this.setName(name);
		this.setColor(color);
		this.setAge(age);
	}

	public void setName(String name) {

		this.name = name;
	}

	public void setColor(String color) {

		this.color = color;
	}

	public void setAge(int age) {

		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public String getColor() {

		return this.color;
	}

	public int getAge() {

		return this.age;
	}
}

class PetShop {    // 宠物商店

	private Pet[] pets;    // 保存一组宠物
	private int   foot;

	public PetShop(int len) {

		if (len > 0) {
			this.pets = new Pet[len];    // 开辟数组大小
		} else {
			this.pets = new Pet[1];    // 至少开辟一个空间
		}
	}

	public boolean add(Pet pet) {    // 增加的是一个宠物
		if (this.foot < this.pets.length) {
			this.pets[this.foot] = pet;    // 增加宠物
			this.foot++;
			return true;
		} else {
			return false;
		}
	}

	public Pet[] search(String keyWord) {
		// 应该确定有多少个宠物符合要求
		Pet p[]   = null;
		int count = 0;    // 记录下会有多少个宠物符合查询结果
		for (int i = 0; i < this.pets.length; i++) {
			if (this.pets[i] != null) {        // 表示此位置有宠物
				if (this.pets[i].getName().indexOf(keyWord) != - 1
				    || this.pets[i].getColor().indexOf(keyWord) != - 1) {
					count++;    // 修改查找到的记录数
				}
			}
		}
		p = new Pet[count];    // 开辟指定的大小空间
		int f = 0;    // 增加元素的位置标记
		for (int i = 0; i < this.pets.length; i++) {
			if (this.pets[i] != null) {        // 表示此位置有宠物
				if (this.pets[i].getName().indexOf(keyWord) != - 1
				    || this.pets[i].getColor().indexOf(keyWord) != - 1) {
					p[f] = this.pets[i];
					f++;
				}
			}
		}
		return p;

	}
}

public class PetShopDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		PetShop ps = new PetShop(5);    // 五个宠物
		ps.add(new Cat("白猫", "白色的", 2));    // 增加宠物，成功
		ps.add(new Cat("黑猫", "黑色的", 3));    // 增加宠物，成功
		ps.add(new Cat("花猫", "花色的", 3));    // 增加宠物，成功
		ps.add(new Dog("拉步拉多", "黄色的", 3));    // 增加宠物，成功
		ps.add(new Dog("金毛", "金色的", 2));    // 增加宠物，成功
		ps.add(new Dog("黄狗", "黑色的", 2));    // 增加宠物，失败
		print(ps.search("黑"));
	}

	public static void print(Pet p[]) {

		for (int i = 0; i < p.length; i++) {
			if (p[i] != null) {
				System.out.println(p[i].getName() + "，" + p[i].getColor()
				                   + "，" + p[i].getAge());
			}
		}
	}
}
