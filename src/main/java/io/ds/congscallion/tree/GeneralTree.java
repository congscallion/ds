/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

import java.util.List;

/**
 * 普通树， 子节点数量为任何要求。即一个节点可以拥有任意数量的子节点
 *
 * @author wangcong
 * @version $Id: Tree.java, v0.1 7/15/19 2:47 PM wangcong Exp $$
 */
public class GeneralTree<E> {

  private Node<E> root;

  public GeneralTree() {
    root = new Node<>(null);
  }

  public Node<E> addChild(E child) {

    return addChild(root, child);
  }


  /**
   * 给指定节点添加子节点
   *
   * @param parent 父节点
   * @param e 子节点数据
   * @return 返回添加的数据
   */
  public Node<E> addChild(Node<E> parent, E e) {

    return parent.setChild(new Node<>(e));
  }

  /**
   * 递归打倒输出树
   */
  private <T> void printTree(Node<T> node, String appender) {
    System.out.println(appender + node.getData());
    List<Node<T>> children = node.getChildren();
    for (int i = 0; i < children.size(); i++) {
      printTree(children.get(i), appender + appender);
    }
  }

  /**
   * 打印树
   *
   * @param appender 缩进符
   */
  public void printTree(String appender) {
    printTree(root, appender);
  }


  /**
   * 获取树的根据节点
   *
   * @param node 查询开始的节点
   */
  public Node getRoot(Node node) {
    if (node.getParent() == null) {
      return node;
    } else {
      return getRoot(node.getParent());
    }
  }


  /**
   * 删除节点, 为了删除节点，需要将该节点的子节点分配给已删除的父节点。 如果删除的节点是根节点， 则需要从已删除节点的子节点分配新的根节点。
   */
  public void deleteNode(Node node) {

    // 删除根节点
    if (node.getParent() == null) {
      deleteRootNode();
    } else { // 删除非根节点

      // 被删除节点父节点
      Node parent = node.getParent();

      // 被删除节点子节点
      List<Node> children = node.getChildren();

      // 从被删除节点父节点中删除该子节点
      parent.getChildren().remove(node);

      // 被删除节点子节点指向新的父节点
      for (int i = 0; i < children.size(); i++) {
        children.get(i).setParent(parent);
      }

      // 父节点添加新的子节点
      parent.getChildren().addAll(children);
    }

    node.getChildren().clear();

  }


  public Node<E> deleteRootNode() {
    if (root == null || root.getChildren().isEmpty()) {
      return root;
    }

    // 原根节点的子节点
    List<Node<E>> oldChildren = root.getChildren();

    // 将第一个子节点设置为新的根据
    Node<E> newRoot = oldChildren.get(0);
    newRoot.setParent(null);

    // 原子节点删除新的根
    oldChildren.remove(0);

    // 设置新的父节点
    for (Node<E> node : root.getChildren()) {
      node.setParent(newRoot);
    }

    // 新根添加子节点
    newRoot.getChildren().addAll(oldChildren);

    this.root = newRoot;

    // 清除原子节点集
    oldChildren.clear();

    return newRoot;

  }


}
