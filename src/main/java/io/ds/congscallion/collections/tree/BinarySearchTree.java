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
public class BinarySearchTree<E extends Comparable> extends AbstractBinarySearchTree<E> implements Tree {


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

        class A implements Visitor {

            @Override
            public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
                System.out.print(node.getData() + ", ");
            }
        }

        A a = new A();

        class A2 implements Visitor {

            @Override
            public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
                System.out.println(node.getData());
            }
        }

        A2 a2 = new A2();

        BinarySearchTree bst = new BinarySearchTree();
        bst.add(200);

        bst.add(99);
        bst.add(301);
        bst.add(120);
        bst.add(330);
        bst.add(70);
        bst.add(220);
        bst.add(140);
        bst.add(320);
        bst.add(81);
        bst.add(251);
        bst.add(131);
        bst.add(341);
        bst.add(50);
        bst.add(230);

        bst.traverseInorder(a);

        printSplitLine();

        bst.traversePreorder(a);

        printSplitLine();

        bst.traversePostorder(a);

        printSplitLine();

        bst.prettyPrint(a2, "", true);

        printSplitLine();

        bst.remove(301);

        bst.prettyPrint(a2, "", true);

    }


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
