/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: QueueAsArrayTest.java, v0.1 7/12/19 4:43 PM wangcong Exp $$
 */
public class QueueAsArrayTest {

    @Test
    public void testIsFull(){

        QueueAsArray queue = new QueueAsArray(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assertions.assertThat(queue.isFull()).isFalse();


        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(3);

        Assertions.assertThat(queue.isFull()).isTrue();

    }


    @Test
    public void testIsEmpty(){
        QueueAsArray queue = new QueueAsArray(10);
        Assertions.assertThat(queue.isEmpty()).isTrue();
    }


    @Test
    public void testEnqueue(){
        QueueAsArray queue = new QueueAsArray(10);
        queue.enqueue(1);

        Assertions.assertThat(queue.isEmpty()).isFalse();

        int dequeue = queue.dequeue();

        Assertions.assertThat(dequeue==1).isTrue();
    }


    @Test
    public void testEnqueue2(){
        QueueAsArray queue = new QueueAsArray(5);

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

    }





}
