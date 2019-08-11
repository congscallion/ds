package io.ds.congscallion.tree;

import org.junit.Test;

public class BinaryTreeTest {


  @Test
  public void test1() {

    BinaryTree<Integer> tree = new BinaryTree<>();

    tree.add(25);
    tree.add(15);
    tree.add(50);
    tree.add(10);
    tree.add(22);
    tree.add(4);
    tree.add(12);
    tree.add(18);
    tree.add(24);
    tree.add(35);
    tree.add(31);
    tree.add(44);
    tree.add(70);
    tree.add(66);
    tree.add(90);

    tree.traversePreOrder();
    System.out.println();
    tree.traverseInOrder();
    System.out.println();
    tree.traversePostOrder();
    System.out.println();
    tree.traverseLevelOrder();

  }

}
