/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 *
 * 一个简单的接口，代表二叉树节点。 该接口定义了二叉树节点通用的方法，并为其它基于二叉树结构的树提供基础。比如： 二叉搜索树、红黑树。
 *
 * @author wangcong
 * @version $Id: BinaryTreeNode.java, v0.1 8/6/19 11:19 AM wangcong Exp $$
 */
public interface BinaryTreeNode<E extends Comparable> {

    /**
     * 返回存储在该节点的数据
     *
     * @return
     */
    E getData();

    /**
     * 更新存储在该节点的数据
     *
     * @param data
     */
    void setData(E data);

    /**
     * 返回当前节点的父节点
     *
     * @return
     */
    BinaryTreeNode<E> getParent();


    /**
     *
     * 返回当前节点的左子节点
     *
     * @return
     */
    BinaryTreeNode<E> getLeft();


    /**
     * 更新当前节点的左子节点
     *
     * @param child
     */
    void setLeft(BinaryTreeNode<E> child);


    /**
     *
     * 返回当前节点的右子节点
     *
     * @return
     */
    BinaryTreeNode<E> getRight();


    /**
     * 更新当前节点的右子节点
     *
     * @param child
     */
    void setRight(BinaryTreeNode<E> child);


    /**
     *
     * 从节点所在树中删除当前节点以及节点的所有子节点，如果当前节点是根，则不执行任何操作。
     *
     */
    void removeFromParent();

    /**
     * 使用先序遍历的方式访问当前节点
     */
    void traversePreorder(Visitor visitor);


    /**
     * 使用中序遍历的方式访问当前节点
     */
    void traverseInorder(Visitor visitor);

    /**
     * 使用后序遍历的方式访问当前节点
     */
    void traversePostorder(Visitor visitor);


    /**
     * 以格式化的结构打印树
     *
     * @param visitor
     */
    void prettyPrint(Visitor visitor, String indent, boolean last);


    interface Visitor {

        <E extends Comparable> void visitor(BinaryTreeNode<E> node);
    }

}
