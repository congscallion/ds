package io.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

  public static void main(String[] args) throws InterruptedException {

    ReentrantLock lock = new ReentrantLock();

    new Thread(() -> {

      try{
        System.out.println("Thread-1　running...");
        lock.lock();
        System.out.println("Thread-1　lock success...");

        Thread.sleep(1000 * 5);

        System.out.println("Thread-1 finished...");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
        System.out.println("Thread-1 release lock success...");
      }
    },"Thread-1").start();

    new Thread(() -> {
      try{
        System.out.println("Thread-2　running...");
        lock.lock();
        System.out.println("Thread-2　lock success...");

        Thread.sleep(1000 * 5);
        System.out.println("Thread-2 finished...");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
        System.out.println("Thread-2 release lock success...");
      }
    },"Thread-2").start();

    Thread.sleep(1000 * 2000);
  }



}
