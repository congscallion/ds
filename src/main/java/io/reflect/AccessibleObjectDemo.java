package io.reflect;

public class AccessibleObjectDemo {
    public static void main(String[] args) {

        /**
         * AccessibleObject 类的方法介绍
         *
         * void setAccessible(boolean flag)	设置实例是否可以访问，如果设置为true，可以抑制修饰符，直接进行访问
         * boolean isAccessible()	返回实例是否可以访问，实际上这个值并不准确，它只有在setAccessible被调用的时候才会更新
         * boolean trySetAccessible()	功能类似于setAccessible(boolean flag)，返回值决定是否抑制修饰符成功
         * static void setAccessible(AccessibleObject[] array, boolean flag)	setAccessible(boolean flag)的批量操作方法
         *
         */


    }
}
