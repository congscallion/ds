package io.ds.congscallion.collection;

import org.junit.Test;

public class HashMapTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    @Test
    public void test1() {

        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i + ", tableSizeFor=" + tableSizeFor(i));
        }


    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    @Test
    public void test2() {

        for (int i = 0; i < 100; i++) {

            System.out.println(i + " % 16 =" + mod(i, 16) + ", "
                    + i + " & 16 =" + shift(i, 16) + ", " + i + " % 32 =" + mod(i, 32)
                    + ", " + i + " % 32 =" + shift(i, 32));

            System.out.println();
            System.out.println(i + " & 16, " + Integer.toBinaryString(i) + " & " + Integer.toBinaryString(16));
            System.out.println(i + " & 32, " + Integer.toBinaryString(i) + " & " + Integer.toBinaryString(32));
            System.out.println();


        }

    }

    static final int mod(int num, int size) {
        return num & (size - 1);
    }

    static final boolean shift(int a, int b) {
        return (a & b) == 0;
    }
}
