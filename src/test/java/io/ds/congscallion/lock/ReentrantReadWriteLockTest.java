package io.ds.congscallion.lock;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.junit.Test;

public class ReentrantReadWriteLockTest {

  @Test
  public void test1() {

    System.out.println(1 << 16);
    System.out.println((1 << 16) - 1);

    System.out.println(Integer.toBinaryString((1 << 16)));
    System.out.println(Integer.toBinaryString((1 << 16) - 1));

  }


  @Test
  public void test2() throws InterruptedException {

    ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();

    Thread t1 = new Thread(() -> {
      rrw.readLock().lock();
      rrw.readLock().unlock();
    }, "Thread-Read-1");

    Thread t2 = new Thread(() -> {
      rrw.readLock().lock();
      rrw.readLock().unlock();
    }, "Thread-Read-2");

    Thread t3 = new Thread(() -> {
      rrw.readLock().lock();
      rrw.readLock().unlock();
    }, "Thread-Read-3");

    Thread t4 = new Thread(() -> {
      rrw.writeLock().lock();
      rrw.writeLock().unlock();
    }, "Thread-Write-1");

    Thread t5 = new Thread(() -> {
      rrw.writeLock().lock();
      rrw.writeLock().unlock();
    }, "Thread-Write-2");

    Thread t6 = new Thread(() -> {
      rrw.writeLock().lock();
      rrw.writeLock().unlock();
    }, "Thread-Write-6");

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


  static final int SHARED_SHIFT = 16;
  static final int SHARED_UNIT = (1 << SHARED_SHIFT);
  static final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
  static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;


  @Test
  public void test3() {

    final int SHARED_SHIFT = 16;
    final int SHARED_UNIT = (1 << SHARED_SHIFT);

    System.out.println("SHARED_UNIT = " + SHARED_UNIT);
    System.out.println("SHARED_UNIT binary = " + Integer.toBinaryString(SHARED_UNIT));

    System.out.println("0>>>16 = " + (0 >>> 16));

    int status = 0;

    status = status + SHARED_UNIT;

    System.out.println("status >>> 16 = " + (status >>> SHARED_SHIFT));

    status = status + SHARED_UNIT;

    System.out.println("status >>> 16 = " + (status >>> SHARED_SHIFT));

  }

  static int sharedCount(int c) {
    return c >>> SHARED_SHIFT;
  }

  /**
   * Returns the number of exclusive holds represented in count
   */
  static int exclusiveCount(int c) {
    return c & EXCLUSIVE_MASK;
  }


  @Test
  public void test4() throws InterruptedException {

    ThreadLocal<HoldCounter> tll = new ThreadLocal<>();

    Thread t1 = new Thread(() -> {
      HoldCounter holdCounter = tll.get();

      if (Objects.isNull(holdCounter)) {
        tll.set(new HoldCounter(1, 2));
      }
      holdCounter = tll.get();
      System.out.println(holdCounter);

      tll.remove();

      holdCounter = tll.get();
      System.out.println(holdCounter);
    });

    Thread t2 = new Thread(() -> {
      HoldCounter holdCounter = tll.get();
      System.out.println(holdCounter);

      tll.remove();

      holdCounter = tll.get();
      System.out.println(holdCounter);
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();

  }


  @Test
  public void test5() throws InterruptedException {

    ThreadLockHoldCounter tlhc = new ThreadLockHoldCounter();

    Thread t1 = new Thread(() -> {
      HoldCounter holdCounter = tlhc.get();
      ++holdCounter.count;
      ++holdCounter.count;
      ++holdCounter.count;
      System.out.println(holdCounter);

      tlhc.remove();

      holdCounter = tlhc.get();
      System.out.println(holdCounter);
    });

    Thread t2 = new Thread(() -> {
      HoldCounter holdCounter = tlhc.get();
      ++holdCounter.count;
      ++holdCounter.count;
      System.out.println(holdCounter);

      tlhc.remove();

      holdCounter = tlhc.get();
      System.out.println(holdCounter);
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();

  }


  final static class HoldCounter {

    int count = 0;
    long tid = 1l;

    @Override
    public String toString() {
      return "count=" + count + ", tid=" + tid;
    }

    public HoldCounter(int count, long tid) {
      this.count = count;
      this.tid = tid;
    }

    public HoldCounter() {
      this.tid = new Random().nextInt(100);
    }
  }

  final static class ThreadLockHoldCounter extends ThreadLocal<HoldCounter> {

    @Override
    protected HoldCounter initialValue() {
      return new HoldCounter();
    }
  }

}
