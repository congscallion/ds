package io.reflect;

public class MemberDemo {

    /**
     * Member 接口的方法介绍：
     * Class<?> getDeclaringClass()	获取声明的Class对象，也就是获取当前Member实例的来源Class对象
     * String getName()	获取实例的名称，对于Constructor返回全类名，对于Method返回方法名，对于Field返回属性名
     * int getModifiers()	获取实例的修饰符
     * boolean isSynthetic()	是否合成的
     */


    private static class Inner {
    }

    static void checkSynthetic(String name) {
        try {
            System.out.println(name + " : " + Class.forName(name).isSynthetic());
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) throws Exception {
        new Inner();
        checkSynthetic("io.reflect.MemberDemo");
        checkSynthetic("io.reflect.MemberDemo$Inner");
        checkSynthetic("io.reflect.MemberDemo$1");
    }

}
