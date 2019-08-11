/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

import io.ds.congscallion.collections.tree.BinaryTreeNode.Visitor;

/**
 *
 * 具有插入，删除和查找的二叉搜索树类。
 *
 * 树中不允许添加 null值
 *
 * @author wangcong
 * @version $Id: BinarySearchTree.java, v0.1 8/7/19 11:43 AM wangcong Exp $$
 */
public class BinarySearchTree<E extends Comparable> extends AbstractBinarySearchTree<E> {


  public BinarySearchTree() {
  }

  /**
   *
   *
   * 测试二叉搜索树功能
   *
   *
   *
   */


  public static void main(String[] args) {

    BinarySearchTree bst = new BinarySearchTree();
    bst.add(200);

    bst.add(99);
    bst.add(300);
    bst.add(120);
    bst.add(330);
    bst.add(70);
    bst.add(220);
    bst.add(140);
    bst.add(320);
    bst.add(80);
    bst.add(250);
    bst.add(130);
    bst.add(340);
    bst.add(50);
    bst.add(230);

    bst.traverseInorder(new Visitor() {
      @Override
      public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
        System.out.print(node.getData() + ", ");
      }
    });

    printSplitLine();

    bst.traversePreorder(new Visitor() {
      @Override
      public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
        System.out.print(node.getData() + ", ");
      }
    });

    printSplitLine();

    bst.traversePostorder(new Visitor() {
      @Override
      public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
        System.out.print(node.getData() + ", ");
      }
    });

    printSplitLine();

    bst.prettyPrint(new Visitor() {
      @Override
      public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
        System.out.println(node.getData());
      }
    }, "", true);

    printSplitLine();

    bst.remove(300);

    bst.prettyPrint(new Visitor() {
      @Override
      public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
        System.out.println(node.getData());
      }
    }, "", true);

  }

//    /**
//     * 向树中添加数据， 如果树中已存在相同数据，则使用新值替换旧值。
//     *
//     * @param data
//     */
//    public void add(E data) {
//
//        if (null == data) {
//            return;
//        }
//
//        if (root == null) {
//            root = new LinkedBinaryTreeNode<>(data);
//        }
//
//        BinaryTreeNode<E> n = root;
//        while (true) {
//
//            int compare = data.compareTo(n.getData());
//
//            if (compare == 0) {
//                n.setData(data);
//                return;
//
//            } else if (compare > 0) {
//
//                if (null == n.getRight()) {
//                    n.setRight(new LinkedBinaryTreeNode<>(data));
//                    return;
//                }
//
//                n = n.getRight();
//
//            } else {
//
//                if (null == n.getLeft()) {
//                    n.setLeft(new LinkedBinaryTreeNode<>(data));
//                    return;
//                }
//
//                n = n.getLeft();
//            }
//
//        }
//
//    }
//
//
//    /**
//     * 将指定的数据从树中删除
//     *
//     * @param data
//     */
//    public void remove(E data) {
//
//        BinaryTreeNode<E> node = nodeContaining(data);
//
//        // 树中不包含指定的值
//        if (null == node) {
//            return;
//        } else if ((null != node.getLeft()) && (null != node.getRight())) {
//
//            BinaryTreeNode<E> predecessor = predecessor(node);
//
//            node.setData(predecessor.getData());
//            node = predecessor;
//        }
//
//        // 处理 node 没有子节点或者只有一个节点的情况
//        BinaryTreeNode<E> pullUp = (node.getLeft() == null) ? node.getRight() : node.getLeft();
//        if (node == root) {
//            setRoot(pullUp);
//
//        } else if (node.getParent().getRight() == node) {
//            node.getParent().setRight(pullUp);
//
//        } else {
//
//            node.getParent().setLeft(pullUp);
//        }
//
//    }

  private static void printSplitLine() {
    System.out.println();
    System.out.println("-----------------------------------");
    System.out.println();
  }

  @Override
  protected LinkedBinaryTreeNode<E> createNode(E data) {
    return new LinkedBinaryTreeNode<>(data);
  }

  /**
   *
   * 二叉树不用平衡， 不需要处理
   *
   * @param node
   */
  @Override
  protected void adjustAfterRemoval(BinaryTreeNode<E> node) {

  }

  /**
   *
   * 二叉树不用平衡， 不需要处理
   *
   * @param node
   */
  @Override
  protected void adjustAfterInsertion(BinaryTreeNode<E> node) {

  }

}
