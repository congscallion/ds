package io.ds.congscallion.reflect;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;

public class ClassDemo {


    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clz = Class.forName("io.ds.congscallion.reflect.TT");

        Method[] methods = clz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("=============field================");
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("=============field================");


        boolean instance = clz.isInstance(new TT());
        System.out.println("new TT() isInstance " + clz.getName() + " ?, result= " + instance);

        // 创建实例
        try {
            TT t1 = (TT) clz.newInstance();
            t1.sayHello();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Constructor<TT> constructor = clz.getDeclaredConstructor(int.class, String.class);
        TT t2 = constructor.newInstance(20, "lili");
        t2.sayHello();

        System.out.println("invoked syaHello Method");
        Method sayHello = clz.getMethod("sayHello", null);
        sayHello.invoke(t2, null);

        Object o = Array.newInstance(String.class, 20);
        Array.set(o, 0, "java");
        Array.set(o, 1, "c++");
        Array.set(o, 2, "python");

        System.out.println(Array.get(o,2));


    }


}

class TT {
    public int a;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TT() {
    }

    public TT(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void sayHello() {
        System.out.println("say hello");
    }
}
