/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 *
 * 伸展树
 *
 *
 * @author wangcong
 * @version $Id: SplayTree.java, v0.1 8/13/19 6:27 PM wangcong Exp $$
 */
public class SplayTree<E extends Comparable> extends AbstractBinarySearchTree<E> implements Tree {


  @Override
  protected BinaryTreeNode<E> createNode(E data) {
    return null;
  }

  @Override
  protected void adjustAfterInsertion(BinaryTreeNode<E> node) {

  }

  @Override
  protected void adjustAfterRemoval(BinaryTreeNode<E> node) {

  }
}
