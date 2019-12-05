package io.ds.congscallion.lock;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

    private static final int NCPU = Runtime.getRuntime().availableProcessors();

    private static final int SPINS = (NCPU > 1) ? 1 << 6 : 0;

    /**
     * Maximum number of retries before blocking at head on acquisition
     */
    private static final int HEAD_SPINS = (NCPU > 1) ? 1 << 10 : 0;

    /**
     * Maximum number of retries before re-blocking
     */
    private static final int MAX_HEAD_SPINS = (NCPU > 1) ? 1 << 16 : 0;

    @Test
    public void test1() {

        System.out.println("NPU=" + NCPU);
        System.out.println("SPINS=" + SPINS);
        System.out.println("HEAD_SPINS=" + HEAD_SPINS);
        System.out.println("MAX_HEAD_SPINS=" + MAX_HEAD_SPINS);

    }

    private static final int LG_READERS = 7;
    private static final long WBIT = 1L << LG_READERS;
    private static final long RBITS = WBIT - 1L;
    private static final long RFULL = RBITS - 1L;
    private static final long ABITS = RBITS | WBIT;
    private static final long SBITS = ~RBITS; // note overlap with ABITS
    private static final long ORIGIN = WBIT << 1;

    @Test
    public void test2() {
        System.out.println("WBIT=" + WBIT + ", binary=" + Long.toBinaryString(WBIT));
        System.out.println("RBITS=" + RBITS + ", binary=" + Long.toBinaryString(RBITS));
        System.out.println("RFULL=" + RFULL + ", binary=" + Long.toBinaryString(RFULL));
        System.out.println("ABITS=" + ABITS + ", binary=" + Long.toBinaryString(ABITS));
        System.out.println("SBITS=" + SBITS + ", binary=" + Long.toBinaryString(SBITS));
        System.out.println("ORIGIN=" + ORIGIN + ", binary=" + Long.toBinaryString(ORIGIN));
        long a = ORIGIN + WBIT;
        System.out.println("a=" + a + ", binary=" + Long.toBinaryString(a));

    }

    @Test
    public void test3() {

        StampedLock lock = new StampedLock();

        long stamp = lock.writeLock();
        try {
            // 死锁
//            long l = lock.readLock();
//            lock.unlockRead(l);

            System.out.println("a = " + 1);

        } finally {
            lock.unlockWrite(stamp);
        }


    }


    @Test
    public void test4() {

        StampedLock lock = new StampedLock();
        long r1 = lock.readLock();
        long r2 = lock.readLock();
        long r3 = lock.readLock();
        long r4 = lock.readLock();

        lock.unlockRead(r1);
        lock.unlockRead(r2);
        lock.unlockRead(r3);
        lock.unlockRead(r4);
    }

    @Test
    public void test5() {

        WNode node = null, p = null, p2 = null;

        WNode n = new WNode();
        node = n;
        p = n;
        p2 = n;


    }


    class WNode {

    }


    @Test
    public void test6() {

        for (int i = 0; i < 10; i++) {
            System.out.println(nextSecondarySeed());
        }

    }


    static final int nextSecondarySeed() {
        int r;
        Thread t = Thread.currentThread();
        if ((r = UNSAFE.getInt(t, SECONDARY)) != 0) {
            r ^= r << 13;   // xorshift
            r ^= r >>> 17;
            r ^= r << 5;
        } else if ((r = java.util.concurrent.ThreadLocalRandom.current().nextInt()) == 0) {
            r = 1; // avoid zero
        }
        UNSAFE.putInt(t, SECONDARY, r);
        return r;
    }


    private static final long SECONDARY;
    private static final sun.misc.Unsafe UNSAFE;

    static {
        try {

            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);

            Class<?> tk = Thread.class;
            SECONDARY = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("threadLocalRandomSecondarySeed"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }


    @Test
    public void test7() throws InterruptedException {

        StampedLock lock = new StampedLock();

        Runnable r1 = () -> {
            long stamped = lock.writeLock();

            int i = 1;
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);

            lock.unlockWrite(stamped);
        };
        Runnable r2 = () -> {
            long stamped = lock.writeLock();

            int i = 1;
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);

            lock.unlockWrite(stamped);
        };

        Runnable r3 = () -> {
            long stamped = lock.readLock();

            int i = 1;
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);

            lock.unlockRead(stamped);
        };

        Runnable r4 = () -> {
            long stamped = lock.readLock();

            int i = 1;
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);

            lock.unlockRead(stamped);
        };

        Runnable r5 = () -> {
            long stamped = lock.readLock();

            int i = 1;
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);

            lock.unlockRead(stamped);
        };
        Runnable r6 = () -> {
            long stamped = lock.writeLock();

            int i = 1;
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);
            System.out.println(Thread.currentThread().getName() + "->" + i++);

            lock.unlockWrite(stamped);
        };

        Thread t1 = new Thread(r1, "Thread-1");
        Thread t2 = new Thread(r2, "Thread-2");
        Thread t3 = new Thread(r3, "Thread-3");
        Thread t4 = new Thread(r4, "Thread-4");
        Thread t5 = new Thread(r5, "Thread-5");
        Thread t6 = new Thread(r6, "Thread-6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();

    }


    @Test
    public void test8() {

        int HEAD_SPINS = 1 << 10;

        int MAX_HEAD_SPINS = 1 << 16;

        int spins = HEAD_SPINS;
        int sum = spins;
        while (spins < MAX_HEAD_SPINS) {

            spins <<= 1;

            sum += spins;
        }

        System.out.println("sum=" + sum);

        sum = 1024 + 1024 * 2 + 1024 * 4 + 1024 * 8 + 1024 * 16 + 1024 * 32 + 1024 * 64;
        System.out.println("sum=" + sum);


    }


    @Test
    public void test9() {

        StampedLock lock = new StampedLock();

        long l = lock.writeLock();
        lock.unlockWrite(l);

        l = lock.writeLock();
        lock.unlockWrite(l);

        l = lock.readLock();
        lock.unlockRead(l);

    }


    @Test
    public void test10() {

        StampedLock lock = new StampedLock();
        long[] starr = new long[130];
        for (int i = 0; i < 130; i++) {
            long l = lock.readLock();
            starr[i] = l;
        }

        for (int i = 0; i < 130; i++) {
            lock.unlockRead(starr[i]);
        }
    }

    @Test
    public void test11() throws InterruptedException {

        StampedLock lock = new StampedLock();

        long l = lock.writeLock();

        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName() + " unlock stamped " + l);
            lock.unlockWrite(l);
            System.out.println(Thread.currentThread().getName() + " unlock stamped " + l + " success.");
        };
        Thread t1 = new Thread(r1);
        t1.start();

        long l2 = lock.writeLock();
        System.out.println("l2");
        lock.unlockWrite(l2);

        t1.join();


    }

    @Test
    public void test12() throws InterruptedException {

        StampedLock lock = new StampedLock();

        long l1 = lock.writeLock();
        long l = lock.readLock();
        long l2 = lock.readLock();
        System.out.println("l2");
        lock.unlockRead(l2);
        lock.unlockRead(l);


    }
}
