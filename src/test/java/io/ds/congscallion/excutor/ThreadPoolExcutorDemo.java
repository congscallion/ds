package io.ds.congscallion.excutor;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorDemo {


    @Test
    public void test1() {

        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println("COUNT_BITS: " + COUNT_BITS + ", COUNT_BITS.binary= " + Integer.toBinaryString(COUNT_BITS));

        int CAPACITY = (1 << COUNT_BITS) - 1;
        System.out.println("CAPACITY: " + CAPACITY + ", CAPACITY.binary= " + Integer.toBinaryString(CAPACITY));

        int FCAPACITY = ~CAPACITY;
        System.out.println("~CAPACITY: " + FCAPACITY + ", ~CAPACITY.binary= " + Integer.toBinaryString(FCAPACITY));

        int RUNNING = -1 << COUNT_BITS;
        System.out.println("RUNNING: " + RUNNING + ", RUNNING.binary= " + Integer.toBinaryString(RUNNING));

        int SHUTDOWN = 0 << COUNT_BITS;
        System.out.println("SHUTDOWN: " + SHUTDOWN + ", SHUTDOWN.binary= " + Integer.toBinaryString(SHUTDOWN));
        int STOP = 1 << COUNT_BITS;
        System.out.println("STOP: " + STOP + ", STOP.binary= " + Integer.toBinaryString(STOP));
        int TIDYING = 2 << COUNT_BITS;
        System.out.println("TIDYING: " + TIDYING + ", TIDYING.binary= " + Integer.toBinaryString(TIDYING));
        int TERMINATED = 3 << COUNT_BITS;
        System.out.println("TERMINATED: " + TERMINATED + ", TERMINATED.binary= " + Integer.toBinaryString(TERMINATED));

    }


    @Test
    public void TestLable() {
        int i = 0;
        outer:
        for (; true; ) {

            System.out.println("before inner loop");

            inner:
            for (; i < 10; i++) {
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }

                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outer;
                }
                if (i == 8) {
                    System.out.println("break outer");
                    break outer;
                }

                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }

                System.out.println("end of inner for");

            }

            System.out.println("after inner loop");
        }
        System.out.println("结束");
    }


    @Test
    public void test3() throws InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 5, 2, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(3));
//        executor.allowCoreThreadTimeOut(true);

        final Random random = new Random();

        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("................");
                }
            });
        }


        executor.awaitTermination(1, TimeUnit.DAYS);

    }


}