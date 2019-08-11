/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

/**
 * @author wangcong
 * @version $Id: GeneralTreeCore.java, v0.1 7/15/19 4:17 PM wangcong Exp $$
 */
public class GeneralTreeCore {

  public static void main(String[] args) {

    GeneralTree<String> tree = new GeneralTree<>();

    Node<String> node1 = tree.addChild("node 1");

    Node<String> node11 = tree.addChild(node1, "node 11");

    tree.addChild(node11, "node 111");
    tree.addChild(node11, "node 112");

    Node<String> node12 = tree.addChild(node1, "node 12");

    tree.addChild(node12, "node 121");
    tree.addChild(node12, "node 122");

    Node<String> node2 = tree.addChild("node 2");

    Node<String> node21 = tree.addChild(node2, "node 21");

    tree.addChild(node21, "node 211");
    tree.addChild(node21, "node 212");

    Node<String> node22 = tree.addChild(node2, "node 22");
    tree.addChild(node22, "node 221");
    tree.addChild(node22, "node 222");

    tree.printTree(" ");

    System.out.println("========================================");
    tree.deleteRootNode();
    tree.printTree(" ");

    System.out.println("========================================");
    tree.deleteNode(node2);
    tree.printTree(" ");


  }

}
