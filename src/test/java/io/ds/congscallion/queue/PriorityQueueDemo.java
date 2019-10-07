package io.ds.congscallion.queue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Spliterator;
import org.junit.Test;

public class PriorityQueueDemo {


  @Test
  public void test1() {

    PriorityQueue queue = new PriorityQueue();

    for (int i = 11; i >=1; i--) {
      if((i % 2 == 0)){
        queue.add(i);
      }else{
        queue.offer(i);
      }
    }

    System.out.println(queue);

//    Spliterator spliterator = queue.spliterator();
//    spliterator.forEachRemaining(s -> System.out.println(s));
//    spliterator.tryAdvance(s -> System.out.println(s));
//    Spliterator spliterator1 = spliterator.trySplit();
//    Spliterator spliterator2 = spliterator.trySplit();
//    Spliterator spliterator3 = spliterator1.trySplit();

//    System.out.println();

    Iterator iterator = queue.iterator();

    while (iterator.hasNext()){
      Object next = iterator.next();
      System.out.println(next);
//      iterator.remove();
    }

  }


}
