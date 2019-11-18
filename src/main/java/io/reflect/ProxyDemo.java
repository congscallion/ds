package io.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {


    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Simple simple = (Simple) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{Simple.class},
                new SimpleInvocationHandler(new SimpleImpl()));

        simple.sayHello();
        System.out.println(simple.hello());

    }


    public static class SimpleInvocationHandler implements InvocationHandler {

        private Simple simple;

        public SimpleInvocationHandler(Simple simple) {
            this.simple = simple;
        }

        public void before() {
            System.out.println("before invoked method.");
        }

        public void after() {
            System.out.println("after invoked method.");
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            before();
            Object result = method.invoke(simple, args);
            after();

            return result;
        }
    }


    interface Simple {
        void sayHello();

        String hello();
    }


    static class SimpleImpl implements Simple {

        @Override
        public void sayHello() {
            System.out.println("SimpleImpl sayHello");
        }

        @Override
        public String hello() {
            return "SimpleImpl hello";
        }
    }


}
