package io.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ParameterizedTypeDemo {

    public static void main(String[] args) throws NoSuchFieldException {


        /**
         *
         * Type[] getActualTypeArguments()：返回这个ParameterizedType类型的参数的实际类型Type数组，Type数组里面的元素有可能是Class、
         *                                  ParameterizedType、TypeVariable、GenericArrayType或者WildcardType之一。
         *                                  值得注意的是，无论泛型符号<>中有几层<>嵌套，这个方法仅仅脱去最外层的<>，之后剩下的内容就作为这个方法的返回值。
         * Type getRawType()：返回的是当前这个ParameterizedType的原始类型，从ParameterizedTypeImpl的源码看来，
         *                   原始类型rawType一定是一个Class<?>实例。举个例子，List<Person>通过getRawType()获取到的Type实例实际上是Class<?>
         *                   实例，和List.class等价。
         * Type getOwnerType()：获取原始类型所属的类型，从ParameterizedTypeImpl的源码看来，就是调用了原始类型rawType的getDeclaringClass()方法，
         *                      而像rawType为List<T>、Map<T>这些类型的getOwnerType()实际上就是调用List.class.getDeclaringClass()，
         *                      Map.class.getDeclaringClass()，返回值都是null。
         *
         *
         */


        Class<Sub> clazz = Sub.class;
        Type genericSuperclass = clazz.getGenericSuperclass();

        if (genericSuperclass instanceof ParameterizedType) {

            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;

            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

            for (Type actualTypeArgument : actualTypeArguments) {

                System.out.println(actualTypeArgument.getTypeName());

            }

        }


        Class<Supper2> supperClazz = Supper2.class;

        TypeVariable<Class<Supper2>>[] typeParameters = supperClazz.getTypeParameters();

        for (TypeVariable<Class<Supper2>> typeParameter : typeParameters) {

            System.out.println("getName --> " + typeParameter.getName());
            System.out.println("getBounds --> " + Arrays.toString(typeParameter.getBounds()));
            System.out.println("getGenericDeclaration  --> " + typeParameter.getGenericDeclaration());
            AnnotatedType[] annotatedBounds = typeParameter.getAnnotatedBounds();
            StringBuilder stringBuilder = new StringBuilder("getAnnotatedBounds --> ");
            for (AnnotatedType annotatedType : annotatedBounds) {
                java.lang.annotation.Annotation[] annotations = annotatedType.getAnnotations();
                for (java.lang.annotation.Annotation annotation : annotations) {
                    stringBuilder.append(annotation).append(",");
                }
            }
            System.out.println(stringBuilder.toString());
            System.out.println("===================");

        }


        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if ("print".equals(method.getName())) {
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                for (Type type : genericParameterTypes) {
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        for (Type actualType : actualTypeArguments) {
                            if (actualType instanceof WildcardType) {
                                WildcardType wildcardType = (WildcardType) actualType;
                                System.out.println("WildcardType --> " + wildcardType + " getUpperBounds--> "
                                        + Arrays.toString(wildcardType.getUpperBounds()) + " getLowerBounds--> " + Arrays.toString(wildcardType.getLowerBounds()));
                            } else {
                                System.out.println("Not WildcardType --> " + actualType);
                            }
                        }

                    }
                }
            }
        }


    }


    public static class Person {

    }

    public static abstract class Supper<T, E> {

    }

    public static class Sub extends Supper<String, List<Person>> {

        public static void print(List<? extends Number> list, Set<? super Person> persons) {

        }

    }


    @Target(ElementType.TYPE)
    public @interface Annotation {

    }

    interface InterFace {

    }

    public static abstract class Supper2<T extends Person & InterFace, E extends Annotation> {

    }


}
