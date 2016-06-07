package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._117_策略模式的简单应用;

public class User {
    public static void main(String[] args) {
        System.out.print("用户选择了GIF格式：");
        ImageSaver saver = TypeChooser.getSaver("GIF");
        saver.save();
        System.out.print("用户选择了JPEG格式：");
        saver = TypeChooser.getSaver("JPEG");
        saver.save();
        System.out.print("用户选择了PNG格式：");
        saver = TypeChooser.getSaver("PNG");
        saver.save();
    }
}
