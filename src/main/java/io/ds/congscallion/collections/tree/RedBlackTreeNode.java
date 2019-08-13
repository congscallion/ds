/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 * 代表红黑树的节点， 存储节点颜色与数据
 *
 * @author wangcong
 * @version $Id: RedBlackTreeNode.java, v0.1 8/8/19 11:16 AM wangcong Exp $$
 */
public class RedBlackTreeNode<E extends Comparable> extends LinkedBinaryTreeNode<E> {

  Color color = Color.BLACK;


  public RedBlackTreeNode(E data) {
    super(data);
  }


  /**
   * 表示红黑树中的颜色
   */
  enum Color {
    RED, BLACK
  }

}
