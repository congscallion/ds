package io.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        /**
         *
         * Class<?> getDeclaringClass()	获取方法对应的Class
         * Object getDefaultValue()	获取方法上的注解成员的默认值
         * Class<?>[] getExceptionTypes()	获取方法上的异常类型数组，如果没有则返回一个长度为0的数组
         * Type[] getGenericExceptionTypes()	获取方法上的异常泛型类型Type数组，如果没有则返回一个长度为0的数组
         * Parameter[] getParameters()	返回方法的参数Parameter数组，如果没有则返回一个长度为0的数组
         * int getParameterCount()	返回方法的参数的数量
         * Class<?>[] getParameterTypes()	返回方法的参数的类型Class数组，如果没有则返回一个长度为0的数组
         * Annotation[][] getParameterAnnotations()	返回方法的注解Annotation数组，这里使用二维数组的原因是一个参数可以使用多个注解
         * TypeVariable<Method>[] getTypeParameters()	返回方法的泛型参数的类型变量
         * Type[] getGenericParameterTypes()	返回方法参数的泛型类型Type数组
         * Class<?> getReturnType()	返回方法的返回值的类型Class
         * Type getGenericReturnType()	返回方法的返回值的泛型类型Type
         * AnnotatedType getAnnotatedReturnType()	获取方法返回值的注解类型实例AnnotatedType
         * boolean isBridge()	是否桥方法
         * boolean isDefault()	是否接口的默认方法
         * boolean isSynthetic()	是否复合的
         * boolean isVarArgs()	是否使用了不定参数
         * String toGenericString()	返回方法带有泛型字面量的描述字符串
         * String getName()	返回方法的名称
         * int getModifiers()	返回方法的修饰符
         * Object invoke(Object obj, Object… args)	对带有指定参数的指定对象调用由此方法对象表示的底层方法
         * void setAccessible(boolean flag)	抑制方法访问修饰符的权限判断
         *
         *
         */

        Class<Supper> supperClass = Supper.class;
        Supper supper = supperClass.newInstance();
        Method sayHello = supperClass.getDeclaredMethod("sayHello", String.class);
        sayHello.setAccessible(Boolean.TRUE);
        sayHello.invoke(supper, "jetty");


    }

    public static class Supper {
        private void sayHello(String name) {
            System.out.println(String.format("%s say hello!", name));
        }
    }
}
