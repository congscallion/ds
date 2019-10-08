package io.juc;

public class Consumer extends Thread {

  private SharedFiFOQueue queue;

  public Consumer(String name, SharedFiFOQueue queue) {
    super(name);
    this.queue = queue;
  }


  @Override
  public void run() {

    for (; ; ) {

      try {
        Object remove = queue.remove();

        System.out.println("consumer: " + remove);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }

  }
}
