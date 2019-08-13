/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

/**
 * 表示自平衡的二叉搜索树的节点
 *
 * @author wangcong
 * @version $Id: VALNode.java, v0.1 7/30/19 3:32 PM wangcong Exp $$
 */
public class AVLNode<E extends Comparable> extends BinaryNode<E> {

  private int height;

  public AVLNode(E data) {
    super(data);
    this.height = 1;
  }

  public AVLNode(E data, AVLNode<E> left, AVLNode<E> right) {
    super(data, left, right);
    this.height = 1;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }


  @Override
  public String toString() {
    return String.valueOf(getData());
  }
}
