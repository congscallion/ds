package io.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个先进先出的阻塞队列。
 *
 * 队列满时，添加元素时阻塞直到队列可用 弹出元素时，队列为空，则阻塞直到有可用元素为止
 */
public class SharedFiFOQueue {

  private Object[] data;

  public SharedFiFOQueue(int capacity) {
    data = new Object[capacity];
  }

  private int size = 0;
  private int placeIndex = 0;
  private int removeIndex = 0;

  private final ReentrantLock lock = new ReentrantLock();
  private final Condition isFull = lock.newCondition();
  private final Condition isEmpty = lock.newCondition();

  /**
   * 添加元素
   */
  public void add(Object e) throws InterruptedException {

    try {
      lock.lock();

      while (size >= data.length) {
        isFull.await();
      }

      data[placeIndex] = e;

      placeIndex = (placeIndex + 1) % data.length;

      ++size;

      isEmpty.signal();

    } finally {
      lock.unlock();
    }

  }


  public Object remove() throws InterruptedException {
    Object o = null;

    try {

      lock.lock();

      while (size <= 0) {
        isEmpty.await();
      }

      o = data[removeIndex];

      removeIndex = (removeIndex + 1) % data.length;

      --size;

      isFull.signal();

    } finally {
      lock.unlock();
    }

    return o;
  }

}
