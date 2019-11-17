package io.reflect;

public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        /**
         *
         *
         * Class<?> forName(String className)	传入全类名创建Class实例
         * T newInstance()	通过当前的Class实例进行实例化对象，返回的就是新建的对象
         * int getModifiers()	native方法，返回当前Class的修饰符
         * String getName()	返回类名称，虚拟机中类名表示
         * String getCanonicalName()	返回类名称，便于理解的类名表示
         * String getSimpleName()	返回类名称，源代码中给出的底层类的简单名称
         * Package getPackage()	返回类的包属性
         * String getPackageName()	返回类的包路径名称
         * String toGenericString()	返回描述此Class的字符串，其中包括类型参数的字面量
         * TypeVariable<Class<T>>[] getTypeParameters()	获取类定义泛型的类型变量
         * Class<?>[] getClasses()	获取所有的修饰符为public的成员Class，包括父类
         * Class<?>[] getDeclaredClasses()	获取本类所有修饰符的成员Class，不包括父类
         * Constructor<?>[] getConstructors()	获取所有的修饰符为public的构造器，包括父类
         * Constructor<T> getConstructor(Class<?>... parameterTypes)	获取参数类型匹配的修饰符为public的构造器，包括父类
         * Constructor<?>[] getDeclaredConstructors()	获取本类所有修饰符的构造器，不包括父类
         * Constructor<T>[] getDeclaredConstructor(Class<?>... parameterTypes)	获取本类参数类型匹配的所有修饰符的构造器，不包括父类
         * Method[] getMethods()	获取本类所有的修饰符为public的方法列表，包括父类
         * Method[] getDeclaredMethods()	获取本类所有修饰符的方法列表，不包括父类
         * Method getMethod(String name, Class<?>... parameterTypes)	通过指定方法名和参数类型获取本类修饰符为public的方法，包括父类
         * Method getDeclaredMethod(String name, Class<?>... parameterTypes)	通过指定方法名和参数类型获取本类不限修饰符的方法，不包括父类
         * Field[] getFields()	获取本类所有的修饰符为public的属性列表，包括父类
         * Field[] getDeclaredFields()	获取本类所有修饰符的属性列表，不包括父类
         * Field getField(String name)	通过指定属性名名获取本类修饰符为public的属性，包括父类
         * Field getDeclaredField(String name)	通过指定属性名获取本类不限修饰符的属性，不包括父类
         * Class<?>[] getInterfaces()	获取类实现的所有接口的Class数组
         * Type[] getGenericInterfaces()	获取类实现的所有泛型参数接口的Type数组
         * Class<? super T> getSuperclass()	获取当前类的父类的Class，如果当前类是Object、接口、基本数据类型(primitive)或者void，则返回null
         * Type getGenericSuperclass()	获取当前类的泛型参数父类的Type，如果当前类是Object、接口、基本数据类型(primitive)或者void，则返回null
         * native boolean isInstance(Object obj)	判断传入的object是否当前类的实例
         * native boolean isAssignableFrom(Class<?> cls)	判断传入的Class对象是否和当前类相同，或者是否当前类的超类或超接口
         * native boolean isInterface()	判断当前类是否接口
         * native boolean isArray()	判断当前类是否数组
         * native boolean isPrimitive()	判断当前类是否基本数据类型
         * boolean isAnnotation()	判断当前类是否注解类型
         * boolean isSynthetic()	判断当前类是否复合
         * native Class<?> getComponentType()	如果当前类是数组，返回数组元素的类型
         * Class<?> getEnclosingClass()	返回一个类，当前类(一般是成员类)在这个类(封闭类，相对于内部类的外部类或者说外面一层)中定义
         * Constructor<?> getEnclosingConstructor()	返回构造器，当前类是在这个构造函数中定义
         * Method getEnclosingMethod()	返回方法，当前类是在这个方法中定义
         * Module getModule()	返回模块，JDK9新增方法
         *
         */


        Class<?> supperClass = Supper.class;
        Supper supper = (Supper) supperClass.newInstance();
        System.out.println(supper.sayHello("jetty"));

        Class clz = T.class;
        T t = (T) clz.newInstance();
        System.out.println(t.sayHello("tomcat"));


        /**
         *
         *
         * getEnclosingClass()：返回一个类，当前类(一般是成员类)在这个类(一般叫封闭类，相对于内部类的外部类或者说外面一层)中定义。
         * getEnclosingConstructor()：返回构造器，当前类是在这个构造函数中定义。
         * getEnclosingClass()：返回方法，当前类是在这个方法中定义。
         *
         */


        Class<Outter.Inner> clazz = Outter.Inner.class;
        System.out.println("getEnclosingConstructor=" + clazz.getEnclosingConstructor());
        System.out.println("getEnclosingClass=" + clazz.getEnclosingClass());
        System.out.println("getEnclosingMethod=" + clazz.getEnclosingMethod());


        Outter outter = new Outter();
        outter.sayHello();

    }

    static class Supper {
        public Supper() {
        }

        public String sayHello(String name) {
            return String.format("%s say hello!", name);
        }
    }


    public static class Outter {

        public Outter() {

            class InnerInConstruct {

            }
            Class<InnerInConstruct> innerClass = InnerInConstruct.class;
            System.out.println("getEnclosingClass=" + innerClass.getEnclosingClass());
            System.out.println("getEnclosingConstructor=" + innerClass.getEnclosingConstructor());
            System.out.println("getEnclosingMethod=" + innerClass.getEnclosingMethod());
        }


        private void sayHello() {

            class InnerInMethod {

            }


            Class<InnerInMethod> innerClass = InnerInMethod.class;
            System.out.println("getEnclosingClass=" + innerClass.getEnclosingClass());
            System.out.println("getEnclosingConstructor=" + innerClass.getEnclosingConstructor());
            System.out.println("getEnclosingMethod=" + innerClass.getEnclosingMethod());


        }


        public static class Inner {

        }
    }

}


