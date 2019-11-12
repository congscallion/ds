package io.juc.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

  public static void main(String[] args) throws InterruptedException {

    Pool pool = new Pool(3);

    pool.getItem();
    pool.getItem();
    pool.getItem();
    pool.getItem();

    pool.putItem(1);
    pool.putItem(2);
    pool.putItem(3);
    pool.putItem(4);


  }

}

class Pool {

  private static final int MAX_AVAILABLE = 100;
  private final Semaphore available;
  private Object[] items;
  private boolean[] used;
  private int size;


  public Pool() {
    this.size = MAX_AVAILABLE;
    available = new Semaphore(this.size);
    items = new Object[this.size];
    used = new boolean[this.size];
  }

  public Pool(int size) {
    this.size = size;
    available = new Semaphore(this.size);
    items = new Object[this.size];
    used = new boolean[this.size];
  }

  public Object getItem() throws InterruptedException {
    available.acquire();
    return getNextAvailableItem();
  }

  public void putItem(Object x) {
    if (markAsUnused(x)) {
      available.release();
    }
  }

  protected synchronized Object getNextAvailableItem() {
    for (int i = 0; i < size; ++i) {
      if (!used[i]) {
        used[i] = true;
        return items[i];
      }
    }
    return null; // not reached
  }

  protected synchronized boolean markAsUnused(Object item) {
    for (int i = 0; i < size; ++i) {
      if (item == items[i]) {
        if (used[i]) {
          used[i] = false;
          return true;
        } else {
          return false;
        }
      }
    }
    return false;
  }
}
