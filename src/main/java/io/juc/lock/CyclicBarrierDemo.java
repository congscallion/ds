package io.juc.lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {


  public static void main(String[] args) throws InterruptedException {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Solver());

    List<Thread> list = new LinkedList<>();
    for (int i = 1; i <= 5; i++) {
      list.add(new Thread(new Worker(cyclicBarrier), "Thread-" + i));
    }

    list.forEach(Thread::start);
    for (Thread t : list) {
      t.join();
    }

  }
}


class Solver implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " --> Solver running...");
  }
}


class Worker implements Runnable {

  private CyclicBarrier cyclicBarrier;

  Worker(CyclicBarrier barrier) {
    this.cyclicBarrier = barrier;
  }

  public void run() {
    System.out.println(Thread.currentThread().getName() + " --> Worker running start...");
    try {
      cyclicBarrier.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " --> Worker running end...");

  }

}
