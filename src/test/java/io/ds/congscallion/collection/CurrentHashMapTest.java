package io.ds.congscallion.collection;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

public class CurrentHashMapTest {

    @Test
    public void test1() {

        for (int i = 0; i < 100; i++) {
            System.out.println(i + " - (" + i + " >>> 2) = " + (i - (i >>> 2)));
        }

    }

    @Test
    public void test2() {
        System.out.println(Integer.toBinaryString(32));
        System.out.println(Integer.toBinaryString(32 - 1));
    }


    @Test
    public void test3() throws InterruptedException {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.put("T1" + i + "", "T1" + i + "");
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                hashMap.put("T2" + i + "", "T2" + i + "");
            }
        }, "Thread-2");

        t1.start();
        t2.start();


        t1.join();
        t2.join();


    }

    @Test
    public void test4() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "--> " + Integer.numberOfLeadingZeros(i));
        }
    }


}
