/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;


import java.util.Arrays;

/**
 * <p><pre>
 * 堆是二叉树，最多意味着每个父级有两个子级。
 *
 * 与二叉搜索树不同，节点的左子节点不需要小于父节点的键。很自然地，节点的右子节点不必大于父节点的子节点。
 * 对于树的每个级别，数据从左到右插入。
 * 在从左到右填充当前级别未满之前，不会启动树的新级别。
 *
 * 有两种类型的堆：
 *
 * 最大堆： 最大堆的根节点是堆中的最高值， 该属性定义满足树中所有节点。 即任意一节点值将大于其子节点值。
 * 最小堆： 最小堆具有分配给根节点的最小值， 该属性定义满足树中所有节点。 即任意一节点值将小于其子节点值。
 *
 * 堆数据结构主要应用：
 * 1、查找数据集合中的最小值，最大值，中值。
 * 2、优先队列。 堆是优先级队列抽象数据类型的具体实现。
 * 3、调度程序（用于查找计划中的第一个/最早的操作项）。
 * 4、图算法：优先级队列特别用于图算法，如Dijkstra的最短路径和Prim的最小生成树。
 * 5、使用Heaps可以有效地解决许多问题。请参阅以下示例。
 *      a）数组中最大的元素。
 *      b）对几乎排序的数组进行排序/
 *      c）合并K排序的数组。
 *
 * </pre>
 *
 * <p><pre>
 * 使用数组实现堆数据结构， 父节点与子节点索引对应关系：
 *
 * 使用0下标时，即root节点存储在索引0位置。 假定任意节点N对应的索引为i, 其父节点与子节点的关系
 *  Arr[i]: 表示当前节点
 *  Arr[(i-1) / 2]: 表示父节点
 *  Arr[(2*i) + 1]: 表示左子节点
 *  Arr[(2*i) + 2]: 表示右子节点
 *
 * 不使用0下标时，即root节点存储在索引1位置。 假定任意节点N对应的索引为i, 其父节点与子节点的关系
 *  Arr[i]: 表示当前节点
 *  Arr[i / 2]: 表示父节点
 *  Arr[2*i]: 表示左子节点
 *  Arr[(2*i) + 1]: 表示右子节点
 *
 * </pre></p>
 *
 * <note>本实现使用0位置</note>
 *
 * @author wangcong
 * @version $Id: AbstractHeap.java, v0.1 8/28/19 4:36 PM wangcong Exp $$
 */
public abstract class AbstractHeap<E extends Comparable> implements Tree {

  protected E[] heap;
  protected int size;
  protected int capacity;


  public AbstractHeap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    heap = (E[]) new Comparable[this.capacity];
  }


  /**
   * 计算指定位置的左节点
   */
  protected int leftOf(int pos) {

    return 2 * pos + 1;
  }

  protected boolean hasLeftChild(int pos) {
    return leftOf(pos) < size;
  }


  /**
   * 计算指定位置的右节点
   */
  protected int rightOf(int pos) {

    return (2 * pos) + 2;
  }

  protected boolean hasRightChild(int pos) {
    return rightOf(pos) < size;
  }


  /**
   * 计算指定位置节点的父节点
   */
  protected int parentOf(int pos) {

    return (pos - 1) / 2;
  }

  protected boolean hasParent(int pos) {
    return parentOf(pos) >= 0;
  }

  /**
   * 交换两个位置节点的值
   */
  protected void swap(int first, int second) {

    E tmp = heap[first];
    heap[first] = heap[second];
    heap[second] = tmp;
  }


  /**
   * 判断指定位置是否为叶节点
   */
  protected boolean isLeaf(int pos) {

    return (pos >= (size / 2)) && (pos <= size);
  }


  /**
   * 比较两个位置元素大小， 第一个位置元素小于第二个位置时，返回True.
   */
  protected boolean less(int first, int second) {

    return heap[first].compareTo(heap[second]) < 0;
  }


  /**
   * 向堆中插入元素
   */
  protected void insert(E e) {

    ensureExtraCapacity();

    heap[size++] = e;

    heapifyUp();
  }


  /**
   * 自下而上重塑堆(即从数组最后一个元素开始)， 使堆满足{@link #bubbleUpCondition(int)} 特征
   */
  protected void heapifyUp() {
    int current = size - 1;

    while (current >= 1 && hasParent(current) && bubbleUpCondition(current)) {
      swap(current, parentOf(current));
      current = parentOf(current);
    }
  }

  /**
   * 根据堆的性质，删除最大(大堆)或最小(小堆)元素
   */
  protected E remove() {

    if (isEmpty()) {
      throw new IllegalStateException();
    }

    E first = heap[0];
    heap[0] = heap[--size];

    heapifyDown();
    return first;
  }


  protected boolean isEmpty() {
    return size == 0;
  }

  /**
   * 自上而下重塑堆(即从数组第一个元素开始)， 使堆满足{@link #bubbleDownCondition(int)} 特征
   */
  protected void heapifyDown() {

    int current = 0;

    /**
     * 由于堆是完整的二叉树， 因此， 存在右节点时，一定会存在左节点。
     */
    while (hasLeftChild(current)) {

      /**
       * 计算左右子节点较小的节点
       */
      int smallerChildIndex = leftOf(current);
      if (hasRightChild(current)) {
        smallerChildIndex = selectChild(current);
      }

      /**
       * 当前节点与左右子节点中较小的节点比较
       */
      if (bubbleDownCondition(smallerChildIndex)) {
        swap(current, smallerChildIndex);
      } else {
        break;
      }

      current = smallerChildIndex;
    }

  }


  protected abstract boolean bubbleUpCondition(int pos);

  protected abstract boolean bubbleDownCondition(int pos);

  protected abstract int selectChild(int pos);

  protected void ensureExtraCapacity() {
    if (size == capacity) {
      heap = Arrays.copyOf(heap, capacity << 1);
    }
    capacity = capacity << 1;
  }


  public void print() {
    for (int i = 0; i <= size / 2; i++) {
      System.out.print(" PARENT : " + heap[i]
          + " LEFT CHILD : " + heap[leftOf(i)]
          + " RIGHT CHILD :" + heap[rightOf(i)]);
      System.out.println();
    }
  }

}
