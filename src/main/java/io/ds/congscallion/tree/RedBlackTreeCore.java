/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;


/**
 *
 *
 * @author wangcong
 * @version $Id: RedBlackTreeCore.java, v0.1 8/5/19 11:18 AM wangcong Exp $$
 */
public class RedBlackTreeCore {

    public static void main(String[] args) {

//        RedBlackTree<Integer> tree = new RedBlackTree<>();
//
//        tree.insert(8);
//        tree.insert(18);
//        tree.insert(5);
//        tree.insert(15);
//        tree.insert(17);
//        tree.insert(25);
//        tree.insert(40);
//        tree.insert(80);
//
//        tree.prettyPrint();
//
//        tree.delete(25);
//
//        tree.prettyPrint();

        createRamdonTree();


    }


    private static void createRamdonTree() {

        RedBlackTree<Integer> tree = new RedBlackTree<>();

        for (int i = 0; i < 10; i++) {
            tree.insert(getRandmon());
        }

        tree.prettyPrint();


    }

    private static int getRandmon() {
        return (int) (Math.random() * 80);
    }
}
