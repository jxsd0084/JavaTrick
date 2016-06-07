package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._117_策略模式的简单应用;

public class JPEGSaver implements ImageSaver {
    
    @Override
    public void save() {
        System.out.println("将图片保存成JPG格式");
    }
}
