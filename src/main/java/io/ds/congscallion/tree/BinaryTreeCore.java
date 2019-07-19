/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

/**
 * @author wangcong
 * @version $Id: BinaryTreeCore.java, v0.1 7/18/19 10:01 AM wangcong Exp $$
 */
public class BinaryTreeCore {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        System.out.println(tree.containsNode(6));
        System.out.println(tree.containsNode(2));
        System.out.println(tree.containsNode(9));
        System.out.println(tree.containsNode(10));


    }

}
