package io.juc;

public class SharedFiFOQueueMain {

  public static void main(String[] args) throws InterruptedException {

    SharedFiFOQueue queue = new SharedFiFOQueue(10);

    Producer producer = new Producer("producer", queue);
    Consumer consumer = new Consumer("consumer", queue);

    producer.start();
    consumer.start();

    producer.join();
    consumer.join();

  }


}
