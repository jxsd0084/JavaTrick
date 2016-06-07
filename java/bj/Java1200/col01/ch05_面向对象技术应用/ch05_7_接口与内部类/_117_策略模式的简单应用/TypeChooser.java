package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._117_策略模式的简单应用;

public class TypeChooser {
    
    public static ImageSaver getSaver(String type) {
        if (type.equalsIgnoreCase("GIF")) {
            return new GIFSaver();
        } else if (type.equalsIgnoreCase("JPEG")) {
            return new JPEGSaver();
        } else if (type.equalsIgnoreCase("PNG")) {
            return new PNGSaver();
        } else {
            return null;
        }
    }
}
