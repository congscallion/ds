package io.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class RepeatableDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<A> clz = (Class<A>) Class.forName("io.reflect.A");

        Roles clzRoles = clz.getDeclaredAnnotation(Roles.class);
        for (Role role : clzRoles.value()) {
            System.out.println(role.value());
        }

        Method[] declaredMethods = clz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Roles methodRoles = declaredMethod.getDeclaredAnnotation(Roles.class);
            for (Role role : methodRoles.value()) {
                System.out.println(role.value());
            }
        }


    }


}

@Role("A")
@Role("B")
@Role("C")
class A {

    @Role("D")
    @Role("E")
    @Role("F")
    public void hello() {
        System.out.println("hello");
    }

    @Roles({@Role("G"), @Role("H"), @Role("I")})
    public void say() {
        System.out.println("say");
    }

}


/**
 * @Repeatable 注解，jdk8新增，解决同一个注解其修饰的地方可重复注解。 比如上面的 Class A. 不添加此注解是不能多次修饰的。
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Roles.class)
@interface Role {
    String value();
}

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Roles {
    Role[] value();
}
