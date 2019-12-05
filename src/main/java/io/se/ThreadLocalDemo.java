package io.se;

import java.lang.reflect.Field;
import java.util.Objects;

public class ThreadLocalDemo {

    private static class MyT extends ThreadLocal<Object> {

        @Override
        protected Object initialValue() {
            return 1;
        }
    }

    private static class InMyT extends InheritableThreadLocal<Object> {
        @Override
        protected Object initialValue() {
            return 1;
        }
    }


    public static void main(String[] args) throws InterruptedException {
//    test1();

        test2();
    }


    private static void test2() throws InterruptedException {
        MyT myT = new MyT();
        InMyT inMyT = new InMyT();
        Thread parent = new Thread(() -> {

            System.out.println("类线程调用ThreadLocal#set()方法设置：" + Thread.currentThread().getName());
            myT.set(Thread.currentThread().getName());

            System.out.println("类线程调用InheritableThreadLocal#set()方法设置：" + Thread.currentThread().getName());
            inMyT.set(Thread.currentThread().getName());

            Thread sub = new Thread(() -> {
                System.out.println("通过父类线程：parent创建子线程： " + Thread.currentThread().getName());

                Class<Thread> clz = (Class<Thread>) Thread.currentThread().getClass();
                try {

                    Field threadLocals = clz.getDeclaredField("threadLocals");
                    threadLocals.setAccessible(true);
                    Object threadLocalMap2 = threadLocals.get(Thread.currentThread());
                    if (Objects.isNull(threadLocalMap2)) {
                        System.out.println("子线程threadLocals is null");
                    }


                    Field inheritableThreadLocals = clz.getDeclaredField("inheritableThreadLocals");
                    inheritableThreadLocals.setAccessible(true);
                    Object threadLocalMap = inheritableThreadLocals.get(Thread.currentThread());
                    if (Objects.isNull(threadLocalMap)) {
                        System.out.println("子线程inheritableThreadLocals is null");
                        return;
                    }


                    Class<?> aClass = threadLocalMap.getClass();

                    Field value = aClass.getDeclaredField("table");
                    value.setAccessible(true);
                    Object[] entryArr = (Object[]) value.get(threadLocalMap);
                    System.out.println("===========子线程inheritableThreadLocals值================");
                    for (Object o : entryArr) {
                        if (Objects.nonNull(o)) {

                            Class<?> entryClz = o.getClass();
                            Field referent = entryClz.getSuperclass().getSuperclass().getDeclaredField("referent");
                            referent.setAccessible(true);
                            Object key = referent.get(o);

                            Field enVal = entryClz.getDeclaredField("value");
                            enVal.setAccessible(true);
                            Object val = enVal.get(o);

                            System.out.println("key->" + key + ", value->" + val);
                        }
                    }


                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


            });
            sub.start();
        });

        parent.start();
        parent.join();

    }


    private static void test1() throws InterruptedException {
        MyT myT = new MyT();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    myT.set(Thread.currentThread().getName() + "->Myt->" + j);
                }

                System.out.println(Thread.currentThread().getName() + "->value>" + myT.get());
            });

            t.start();
            threads[i] = t;
        }


        for (Thread thread : threads) {
            thread.join();
        }
    }


}
