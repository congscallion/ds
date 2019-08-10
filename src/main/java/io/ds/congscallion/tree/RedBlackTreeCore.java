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

//        createRamdonTree();

        add();

    }


    private static void add(){
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        rbt.insert(99);
        rbt.insert(300);
        rbt.insert(120);
//        rbt.insert(330);
        rbt.insert(70);
        rbt.insert(220);
        rbt.insert(140);
        rbt.insert(320);
        rbt.insert(80);
        rbt.insert(250);
        rbt.insert(130);
        rbt.insert(340);
        rbt.insert(50);

        rbt.prettyPrint();
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
