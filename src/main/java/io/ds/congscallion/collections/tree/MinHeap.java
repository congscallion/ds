/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 * 最小堆
 *
 * @author wangcong
 * @version $Id: MinHeap.java, v0.1 8/28/19 4:51 PM wangcong Exp $$
 */
public class MinHeap<E extends Comparable> extends AbstractHeap<E> {


  public MinHeap(int capacity) {
    super(capacity);
  }

  public static void main(String[] args) {

    MinHeap minHeap = new MinHeap(15);
    minHeap.insert(5);
    minHeap.insert(3);
    minHeap.insert(17);
    minHeap.insert(10);
    minHeap.insert(84);
    minHeap.insert(19);
    minHeap.insert(6);
    minHeap.insert(22);
    minHeap.insert(9);

    minHeap.print();

    System.out.println("============================");

    Comparable[] arr = {32,12,54,13,15,24,27};
    minHeap.buildFromArray(arr);

    minHeap.print();

    System.out.println("3th smaller number is: ");

    minHeap.remove();
    minHeap.remove();
    System.out.println(minHeap.heap[0]);




  }

  @Override
  protected void insert(E e) {

    if (size >= capacity) {
      return;
    }

    /**
     * 将元素依次放入数组
     */
    heap[size++] = e;

    heapifyUp();

  }

  @Override
  protected boolean bubbleUpCondition(int pos) {
    return less(pos, parentOf(pos));
  }

  @Override
  protected int selectChild(int pos) {
    return less(rightOf(pos), leftOf(pos)) ? rightOf(pos) : leftOf(pos);
  }

  @Override
  protected boolean bubbleDownCondition(int pos) {
    return less(pos, parentOf(pos));
  }
}
