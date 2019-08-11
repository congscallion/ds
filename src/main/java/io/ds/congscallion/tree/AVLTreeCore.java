/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

/**
 *
 *
 * @author wangcong
 * @version $Id: AVLTreeCore.java, v0.1 7/30/19 5:08 PM wangcong Exp $$
 */
public class AVLTreeCore {

  public static void main(String[] args) {
//        testInsert();

    testDelete();
  }


  private static void testDelete() {
    AVLTree tree = new AVLTree();

    /* Constructing tree given in the above figure */
    tree.setRoot(tree.insert(tree.getRoot(), 9));
    tree.setRoot(tree.insert(tree.getRoot(), 5));
    tree.setRoot(tree.insert(tree.getRoot(), 10));
    tree.setRoot(tree.insert(tree.getRoot(), 0));
    tree.setRoot(tree.insert(tree.getRoot(), 6));
    tree.setRoot(tree.insert(tree.getRoot(), 11));
    tree.setRoot(tree.insert(tree.getRoot(), -1));
    tree.setRoot(tree.insert(tree.getRoot(), 1));
    tree.setRoot(tree.insert(tree.getRoot(), 2));

    System.out.println(tree.getRoot());

    System.out.println("Preorder traversal of " +
        "constructed tree is : ");
    tree.preOrder(tree.getRoot());

    tree.setRoot(tree.deleteNode(tree.getRoot(), 10));

        /* The AVL Tree after deletion of 10
        1
        / \
        0 9
        /     / \
        -1 5 11
        / \
        2 6
        */
    System.out.println();
    System.out.println("Preorder traversal after " +
        "deletion of 10 :");
    System.out.println("root: " + tree.getRoot());
    tree.preOrder(tree.getRoot());
  }


  private static void testInsert() {

    AVLTree<Integer> tree = new AVLTree<>();

    tree.setRoot(tree.insert(tree.getRoot(), 10));
    tree.setRoot(tree.insert(tree.getRoot(), 20));
    tree.setRoot(tree.insert(tree.getRoot(), 30));
    tree.setRoot(tree.insert(tree.getRoot(), 40));
    tree.setRoot(tree.insert(tree.getRoot(), 50));
    tree.setRoot(tree.insert(tree.getRoot(), 25));

    System.out.println(tree.getRoot().getData());

    System.out.println("Preorder traversal" +
        " of constructed tree is : ");
    tree.preOrder(tree.getRoot());
  }

}
