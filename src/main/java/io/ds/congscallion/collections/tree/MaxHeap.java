/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

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
 * @author wangcong
 * @version $Id: MaxHeap.java, v0.1 8/28/19 3:56 PM wangcong Exp $$
 */
public class MaxHeap<E extends Comparable> extends AbstractHeap<E> implements Tree {

  public MaxHeap(int capacity) {
    super(capacity);
  }

  public static void main(String[] args) {

    MaxHeap maxHeap = new MaxHeap(15);
    maxHeap.insert(5);
    maxHeap.insert(3);
    maxHeap.insert(17);
    maxHeap.insert(10);
    maxHeap.insert(84);
    maxHeap.insert(19);
    maxHeap.insert(6);
    maxHeap.insert(22);
    maxHeap.insert(9);

    maxHeap.print();

    System.out.println("===========after remove============");
    maxHeap.remove();
    maxHeap.print();


  }

  @Override
  protected void insert(E e) {

    if (size >= capacity) {
      return;
    }

    heap[size++] = e;

    heapifyUp();
  }

  @Override
  protected boolean bubbleUpCondition(int pos) {
    return !less(pos, parentOf(pos));
  }

  @Override
  protected int selectChild(int pos) {
    return !less(rightOf(pos), leftOf(pos)) ? rightOf(pos) : leftOf(pos);
  }

  @Override
  protected boolean bubbleDownCondition(int pos) {

    return !less(pos, parentOf(pos));
  }
}
