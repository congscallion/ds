package io.reflect;

import java.lang.annotation.*;

public class AnnotationElementDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        Class clz = Class.forName("io.reflect.D");


        /**
         *
         * AnnotationElement 接口方法功能验证
         *
         */

        /*
         *  boolean isAnnotationPresent(Class<? extends Annotation> annotationClass)
         *  判断指定的注解类型在当前的实例上是否存在
         */

        boolean hPresent = clz.isAnnotationPresent(H.class);
        System.out.println("class D isAnnotationPresent @H: " + hPresent);

        boolean fPresent = clz.isAnnotationPresent(F.class);
        System.out.println("class D isAnnotationPresent @F: " + fPresent);


        /*
         * <T extends Annotation> T getAnnotation(Class<T> annotationClass)
         * 获取当前实例上指定注解类型的注解实例，不存在时返回null
         */


        Annotation hAnnotation = clz.getAnnotation(H.class);
        System.out.println(hAnnotation.toString());

        Annotation fAnnotation = clz.getAnnotation(F.class);
        System.out.println(null == fAnnotation ? "null" : fAnnotation.toString());


        /*
            Annotation[] getAnnotations()
            获取当前实例上所有注解实例，包括继承获得的注解，不存在则返回长度为0的数组

            <T extends Annotation> T getDeclaredAnnotation(Class<T> annotationClass)
            获取当前实例上指定注解类型的注解实例，不包括继承获得的注解，不存在则返回长度为0的数组

            <T extends Annotation> T[] getDeclaredAnnotations(Class<T> annotationClass)
            获取当前实例上所有的注解实例，不包括继承获得的注解，不存在则返回长度为0的数组

            <T extends Annotation> T[] getDeclaredAnnotationsByType(Class<T> annotationClass)
            在不使用@Repeatable的时候，功能和getDeclaredAnnotations方法一致，如果使用了@Repeatable，则合并解析@Repeatable后的结果

            <T extends Annotation> T[] getAnnotationsByType(Class<T> annotationClass)
            如果指定annotationClass注解类型可继承(使用了@Inherited)，那么递归调用getDeclaredAnnotationsByType

         */

        System.out.println("==================getDeclaredAnnotationsByType==================");
        Annotation[] yByType = clz.getDeclaredAnnotationsByType(Y.class);
        for (Annotation annotation : yByType) {
            System.out.println(annotation.toString());
        }
        System.out.println("==================getDeclaredAnnotationsByType==================");


    }
}


@H
@X({@Y("1"), @Y("2")})
class D extends I {


}

@F
class I {

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// 加上此注解， 当父类包含此注解时，子类才能检查得到
@Inherited
@interface F {

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface H {

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface X {

    Y[] value();

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Y {
    String value();
}