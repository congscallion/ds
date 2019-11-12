package io.juc.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

  public static void main(String[] args) throws InterruptedException {

//    test1();
    test2();

  }


  /**
   * 测试park()方法是否响应中断
   *
   * 结论：即可以通过unpark()方法从阻塞中恢复，也可以在发生中断信号会从阻塞状态中恢复。如果在阻塞期间发生中断 ，则线程 isInterrupted()方法返回true.
   */
  private static void test1() throws InterruptedException {
    Thread t1 = new Thread(() -> {
      int i = 0;
      while (true) {
        if (i % 2 == 0) {
          System.out.println(
              Thread.currentThread().getName() + "--->" + "running" + "--->isInterrupted: " + Thread
                  .currentThread().isInterrupted());
        }

        i++;

        if (i > 10) {

          System.out.println(
              Thread.currentThread().getName() + "--->" + "running" + "--->park");

          LockSupport.park();

          System.out.println(
              Thread.currentThread().getName() + "--->" + "running" + "--->isInterrupted: " + Thread
                  .currentThread().isInterrupted());

          break;


        }

      }
    }, "Thread-1");
    t1.start();

//    Thread.sleep(10000);
//    LockSupport.unpark(t1);
//    System.out.println("main 线程唤醒 Thread-1线程");

    Thread.sleep(10000);
    System.out.println("main 线程中断 Thread-1线程");
    t1.interrupt();

    t1.join();
  }

  /**
   * 测试try catch 语句中， catch读句中是否会传播中断信号 。
   *
   * 结论：从例子中可以看出，线程虽然是因为其它的线程的调用了线程的interrupt()产生中断。而线程也确实是从阻塞状态恢复并被catch 语句中捕获，
   * 但是，在catch块中的确检测不出中断信号。 因此，在catch中，如果选择忽略中断信号 ，需要再自我中断一次，以恢复中断信号。
   */
  public static void test2() throws InterruptedException {

    Thread t1 = new Thread(() -> {

      System.out.println(Thread.currentThread().getName() + "-> is running.");

      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {

        System.out
            .println("catch 块中， 中断信号是isInterrupted： " + Thread.currentThread().isInterrupted());

        // 这里isInterrupted()方法将返回false.  明明是发生了中断啊。
        // 所以这里不选择处理中断异常，或者抛出， 需要将中断信号传播到调用方。
        Thread.currentThread().interrupt();


      }

    }, "Thread-1");
    t1.start();

    Thread.sleep(2000);

    System.out.println("main线程中断Tread-1线程");

    t1.interrupt();

    t1.join();

  }


}
