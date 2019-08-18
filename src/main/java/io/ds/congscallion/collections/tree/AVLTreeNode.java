/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 * 表示二叉平衡树（AVL Tree）的节点，
 *
 * @author wangcong
 * @version $Id: AVLTreeNode.java, v0.1 8/12/19 10:07 AM wangcong Exp $$
 */
public class AVLTreeNode<E extends Comparable> extends LinkedBinaryTreeNode<E> {

  // 代表树的高度
  int height;


  public AVLTreeNode(E data) {
    super(data);
    this.height = 0; // 叶子节点高度0
  }


}
