package io.juc;

import java.util.Random;

public class Producer extends Thread {

  private SharedFiFOQueue queue;

  public Producer(String name, SharedFiFOQueue queue) {
    super(name);
    this.queue = queue;
  }

  @Override
  public void run() {

    for (; ; ) {

      int i = new Random().nextInt(1000);
      try {
        queue.add(i);
        System.out.println("product: " + i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
