/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

import io.ds.congscallion.collections.tree.BinaryTreeNode.Visitor;

/**
 * 抽象二叉树类， 提供其于二叉树结构的基础实现。 尽量减少实现基于二叉树结构的新的树结构的代码
 *
 * 本类提供了基于二叉树的新增、删除、遍历的代码。
 *
 * 如果需要实现带平衡条件的树结构时， 子类只需要重写{@link #adjustAfterRemoval(BinaryTreeNode)}方法 和{@link
 * #adjustAfterInsertion(BinaryTreeNode)}即可。 他们分别在节点从树中删除或者节点被添加到树中后调用，用于平衡新生成的树。
 *
 * 当执行删除操作时，{@link #adjustAfterRemoval(BinaryTreeNode)} 会传入被删除节点的替换节点。 当执行添加操作时，{@link
 * #adjustAfterInsertion(BinaryTreeNode)} 会传入替换新增节点。
 *
 * @author wangcong
 * @version $Id: AbstructAVLTree.java, v0.1 8/7/19 5:14 PM wangcong Exp $$
 */
public abstract class AbstractBinarySearchTree<E extends Comparable> {

  protected BinaryTreeNode<E> root = null;

  /**
   * 子类需要覆盖提供的方法
   */


  /**
   * 根据数据创建节点
   */
  protected abstract BinaryTreeNode<E> createNode(E data);


  /**
   * 树中添加节点后， 使用此方法将树平衡
   */
  protected abstract void adjustAfterInsertion(BinaryTreeNode<E> node);


  /**
   * 向树中添加数据， 树中不保存空值
   */
  public void add(E data) {

    if (null == data) {
      return;
    }

    if (null == root) {
      root = createNode(data);
    }

    BinaryTreeNode<E> n = root;

    while (true) {

      int compare = data.compareTo(n.getData());

      // 新值与旧值相等， 使用新值覆盖旧值
      if (compare == 0) {
        n.setData(data);
        return;

        // 新值小于当前节点值， 往当前节点左子树中放
      } else if (compare < 0) {

        // 左节点为null， 创建新节点， 并将当前节点左子点设置为新节点
        if (null == leftOf(n)) {
          n.setLeft(createNode(data));
          adjustAfterInsertion(leftOf(n));
          break;
        }

        n = leftOf(n);

      } else {

        //与上述相反
        if (null == rightOf(n)) {
          n.setRight(createNode(data));
          adjustAfterInsertion(rightOf(n));
          break;
        }

        n = rightOf(n);
      }

    }

  }


  /**
   * 从树中删除指定的值
   */
  public void remove(E data) {

    BinaryTreeNode<E> node = nodeContaining(data);
    if (null == node) {
      // 树中不存在指定的值，不用处理
      return;

    }

    // 被删除节点存在两个子节点
    else if ((null != leftOf(node)) && (null != rightOf(node))) {

      /**
       * 被删除节点有两个节点， 将被删除节点的值设置为替换节点（左子树中最大节点或者右子树中最小节点）的值， 然后从树中删除替换节点。
       *
       * 这样，便把有两个子节点的删除情况转换为了最多只有一个子节点被删除的场景。
       *
       */

      node = removalNodeHasTwoChild(node);
    }

    // 被删除节点有且只有一个子节点
    if (null != rightOf(node) || leftOf(node) != null) {
      removalNodeHasOnlyChild(node);
    }

    // 被删除节点没有子节点时， 如果被删除节点是根， 意味着要清空树，设置将根设置为null
    else if (root == node) {
      setRoot(null);
    }

    // 被删除节点没有子节点时且非根
    else {

      removalLeafNodedAndNotRoot(node);
    }
  }


  /**
   * 从树中删除非根叶节点
   */
  protected void removalLeafNodedAndNotRoot(BinaryTreeNode<E> node) {
    if (needAdjustAfterRemoval(node)) {
      adjustAfterRemoval(node);
    }

    node.removeFromParent();
  }


  /**
   * 从树中删除指定节点， 且被删除节点有两个非空子节点
   *
   * @return 返回用于替换被删除节点的节点
   */
  protected BinaryTreeNode<E> removalNodeHasTwoChild(BinaryTreeNode<E> node) {

    // 查找用于替换被删除节点的值
    BinaryTreeNode<E> predecessor = predecessor(node);

    //将被删除节点的值设置成替代节点的值
    node.setData(predecessor.getData());
    node = predecessor;

    return node;
  }


  /**
   * 从树中删除指定节点， 且被删除节点有且只有一个节点
   */
  protected void removalNodeHasOnlyChild(BinaryTreeNode<E> node) {

    BinaryTreeNode<E> pullUp = (null == leftOf(node)) ? rightOf(node) : leftOf(node);

    // 被删除节点为根节点， 则将替换节点设置为根节点
    if (root == node) {
      setRoot(pullUp);
    }

    // 被删除节点是其父节点的左节点，设置将替换节点设置为父节点的左节点
    else if (leftOf(parentOf(node)) == node) {
      parentOf(node).setLeft(pullUp);
    }

    // 否则，设置为右节点
    else {
      parentOf(node).setRight(pullUp);
    }

    if (needAdjustAfterRemoval(node)) {
      adjustAfterRemoval(pullUp);
    }

  }


  /**
   * 在树中执行删除操作后，是否需要执行平衡操作， 默认不需要
   *
   * @param node 被删除的节点
   */
  protected boolean needAdjustAfterRemoval(BinaryTreeNode<E> node) {
    return false;
  }


  /**
   * 树中删除节点后， 使用此方法将树平衡
   *
   * 当被删除的节点
   */
  protected abstract void adjustAfterRemoval(BinaryTreeNode<E> node);


  /**
   * 设置新节点的为树根
   */
  protected void setRoot(BinaryTreeNode<E> node) {
    if (null != node) {
      node.removeFromParent();
    }
    root = node;
  }


  /**
   * 返回指定节点左子树中最大节点
   */
  protected BinaryTreeNode<E> predecessor(BinaryTreeNode<E> node) {

    BinaryTreeNode<E> n = node.getLeft();

    if (null != n) {
      while (null != n.getRight()) {
        n = n.getRight();
      }
    }

    return n;
  }


  /**
   * 查找在树中包含指定数据的节点
   */
  protected BinaryTreeNode<E> nodeContaining(E data) {
    if (null == data) {
      return null;
    }

    for (BinaryTreeNode n = root; n != null; ) {
      int compare = data.compareTo(n.getData());

      if (compare == 0) {
        return n;
      } else if (compare < 0) {
        n = n.getLeft();
      } else {
        n = n.getRight();
      }
    }

    return null;
  }


  /**
   * 判断树中是否包含指定的数据
   */
  public boolean containts(E data) {
    return nodeContaining(data) != null;
  }


  /**
   * 使用先序遍历的方式访问当前节点
   */
  public void traversePreorder(Visitor visitor) {
    if (root != null) {
      root.traversePreorder(visitor);
    }
  }


  /**
   * 使用中序遍历的方式访问当前节点
   */
  public void traverseInorder(Visitor visitor) {
    if (root != null) {
      root.traverseInorder(visitor);
    }
  }

  /**
   * 使用后序遍历的方式访问当前节点
   */
  public void traversePostorder(Visitor visitor) {
    if (root != null) {
      root.traversePostorder(visitor);
    }
  }

  /**
   * 以格式化的结构打印树
   */
  public void prettyPrint(Visitor visitor, String indent, boolean last) {
    if (root != null) {
      root.prettyPrint(visitor, indent, last);
    }
  }


  /**
   * 工具方法
   */
  protected BinaryTreeNode<E> leftOf(BinaryTreeNode<E> node) {
    return node == null ? null : node.getLeft();
  }

  protected BinaryTreeNode<E> rightOf(BinaryTreeNode<E> node) {
    return node == null ? null : node.getRight();
  }

  protected BinaryTreeNode<E> parentOf(BinaryTreeNode<E> node) {
    return node == null ? null : node.getParent();
  }

  protected BinaryTreeNode<E> grandparentOf(BinaryTreeNode<E> node) {
    return (node == null || node.getParent() == null) ? null : node.getParent().getParent();
  }

  protected BinaryTreeNode<E> siblingOf(BinaryTreeNode<E> node) {
    return (node == null || node.getParent() == null) ? null :
        (node == node.getParent().getLeft()) ? node.getParent().getRight()
            : node.getParent().getLeft();
  }

  /**
   * 平衡树方法
   */

  /**
   * 以给定的节点为根左旋
   */
  protected void rotateLeft(BinaryTreeNode<E> node) {

    /**
     * 没有右节点， 左旋后，没有新节点作为子树的根
     */
    if (null == rightOf(node)) {
      return;
    }

    BinaryTreeNode<E> oldRight = node.getRight();
    node.setRight(leftOf(oldRight));

    // 围绕根节点旋转的情况
    if (null == parentOf(node)) {
      root = oldRight;
    } else if (leftOf(parentOf(node)) == node) {
      parentOf(node).setLeft(oldRight);
    } else {
      parentOf(node).setRight(oldRight);
    }

    oldRight.setLeft(node);
  }

  /**
   * 以给定的节点为根右旋
   */
  protected void rotateRight(BinaryTreeNode<E> node) {
    /**
     * 没有右节点， 左旋后，没有新节点作为子树的根
     */
    if (null == leftOf(node)) {
      return;
    }

    BinaryTreeNode<E> oldLeft = node.getLeft();
    node.setLeft(rightOf(oldLeft));

    // 围绕根节点旋转的情况
    if (null == parentOf(node)) {
      root = oldLeft;
    } else if (rightOf(parentOf(node)) == node) {
      parentOf(node).setRight(oldLeft);
    } else {
      parentOf(node).setLeft(oldLeft);
    }

    oldLeft.setRight(node);

  }


}
