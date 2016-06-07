package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._185_自定义泛型化数组类;

import java.lang.reflect.Array;

public class GenericArray<T> {
    
    private T[] array;
    private int size;
    
    @SuppressWarnings("unchecked")
    public GenericArray(Class<T> type, int size) {
        this.size = size;
        array = (T[]) Array.newInstance(type, size);
    }
    
    public void put(int index, T item) {
        if (size > index) {
            array[index] = item;
        }
    }
    
    public T get(int index) {
        
        if (size > index) {
            return array[index];
        } else {
            return null;
        }
    }
}
