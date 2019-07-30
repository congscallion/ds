/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
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
