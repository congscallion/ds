/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 *
 * 一个简单的接口，代表二叉树节点。 该接口定义了二叉树节点通用的方法，并为其它基于二叉树结构的树提供基础。比如： 二叉搜索树、红黑树。
 *
 *
 * 在树中，节点相关术语：
 *
 * 父亲节点或父节点：若一个节点含有子节点，则这个节点称为其子节点的父节点；
 * 孩子节点或子节点：一个节点含有的子树的根节点称为该节点的子节点；
 * 兄弟节点：具有相同父节点的节点互称为兄弟节点；
 * 节点的层次：从根开始定义起，根为第1层，根的子节点为第2层，以此类推；
 * 深度：对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0；
 * 高度：对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0；
 * 堂兄弟节点：父节点在同一层的节点互为堂兄弟；
 * 节点的祖先：从根到该节点所经分支上的所有节点；
 * 子孙：以某节点为根的子树中任一节点都称为该节点的子孙。
 * 森林：由m（m>=0）棵互不相交的树的集合称为森林；
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
