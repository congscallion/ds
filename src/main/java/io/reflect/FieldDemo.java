package io.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FieldDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {


        /**
         *
         * String getName()	返回该属性的名称
         * int getModifiers()	返回该属性的修饰符
         * Class<?> getType()	返回该属性的类型Class
         * Class<?> getParameterizedType()	返回该属性的泛型类型Type
         * boolean isSynthetic()	该属性是否复合的
         * boolean isEnumConstant()	该属性是否枚举类型的元素
         * Object get(Object obj)	通过对象实例获取该属性的值
         * void set(Object obj,Object value)	通过对象实例设置该属性的值
         * void setAccessible(boolean flag)	抑制属性访问修饰符的权限判断
         *
         */

        Class<Supper> supperClass = Supper.class;
        Supper supper = supperClass.newInstance();
        Method sayHello = supperClass.getDeclaredMethod("sayHello");
        sayHello.setAccessible(Boolean.TRUE);
        Field name = supperClass.getDeclaredField("name");
        name.setAccessible(Boolean.TRUE);
        name.set(supper, "jetty");
        System.out.println("Field get-->" + name.get(supper));
        sayHello.invoke(supper);
        name.set(supper, "tomcat");
        System.out.println("Field get-->" + name.get(supper));
        sayHello.invoke(supper);


    }


    public static class Supper {

        private String name;

        private void sayHello() {
            System.out.println(String.format("%s say hello!", name));
        }
    }
}
