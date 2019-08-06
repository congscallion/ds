/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.queue;

/**
 * 使用队列实现Queue
 *
 * @author wangcong
 * @version $Id: QueueAsArray.java, v0.1 7/12/19 10:39 AM wangcong Exp $$
 */
public class QueueAsArray {

    private int front, rear, size;
    private int capacity;
    private int[] array;


    public QueueAsArray(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        array = new int[this.capacity];
    }


    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            return;
        }

        this.rear = (this.rear + 1) % capacity;

        this.array[this.rear] = item;
        this.size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }

    public int front() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        return this.array[this.front];
    }


    public int rear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }


}
