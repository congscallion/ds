/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 *
 *  LinkedBinaryTreeNode是{@link BinaryTreeNode}的一个实现， 其中节点以直接连接的方式存储左节点、右节点以及父节点。
 *
 * @author wangcong
 * @version $Id: LinkedBinaryTreeNode.java, v0.1 8/7/19 11:02 AM wangcong Exp $$
 */
public class LinkedBinaryTreeNode<E extends Comparable> implements BinaryTreeNode<E> {

    protected E data;
    protected LinkedBinaryTreeNode<E> parent;
    protected LinkedBinaryTreeNode<E> left;
    protected LinkedBinaryTreeNode<E> right;

    public LinkedBinaryTreeNode(E data) {
        this.data = data;
    }

    @Override
    public E getData() {
        return this.data;
    }

    @Override
    public void setData(E data) {
        this.data = data;
    }

    @Override
    public BinaryTreeNode<E> getParent() {
        return this.parent;
    }

    @Override
    public BinaryTreeNode<E> getLeft() {
        return this.left;
    }

    @Override
    public void setLeft(BinaryTreeNode<E> child) {
        if (null == child) {
            return;
        }

        /**
         * 确保子节点要小于当前节点
         */
        if (this.getData().compareTo(child.getData()) < 0) {
            throw new IllegalArgumentException();
        }

        /***
         * 确认子节点不是父节点
         */
        for (LinkedBinaryTreeNode<E> n = this; n != null; n = n.parent) {
            if (n == child) {
                throw new IllegalArgumentException();
            }
        }

        LinkedBinaryTreeNode<E> childNode = (LinkedBinaryTreeNode<E>) child;
        if (this.left != null) {
            left.parent = null;
        }

        childNode.removeFromParent();
        childNode.parent = this;

        this.left = childNode;
    }

    @Override
    public BinaryTreeNode<E> getRight() {
        return this.right;
    }

    @Override
    public void setRight(BinaryTreeNode<E> child) {

        if (null == child) {
            return;
        }

        /**
         * 确保子节点要大于当前节点
         */
        if (this.getData().compareTo(child.getData()) >= 0) {
            throw new IllegalArgumentException();
        }

        /***
         * 确认子节点不是父节点
         */
        for (LinkedBinaryTreeNode<E> n = this; n != null; n = n.parent) {
            if (n == child) {
                throw new IllegalArgumentException();
            }
        }

        LinkedBinaryTreeNode<E> childNode = (LinkedBinaryTreeNode<E>) child;
        if (this.right != null) {
            right.parent = null;
        }

        childNode.removeFromParent();
        childNode.parent = this;

        this.right = childNode;

    }


    /**
     * 将当前节点以及其子节点从树中删除
     */
    @Override
    public void removeFromParent() {

        if (null != parent) {
            if (parent.left == this) {
                parent.left = null;
            } else if (parent.right == this) {
                parent.right = null;
            }

            this.parent = null;
        }


    }

    @Override
    public void traversePreorder(BinaryTreeNode.Visitor visitor) {

        visitor.visitor(this);

        if (null != left) {
            left.traversePreorder(visitor);
        }

        if (null != right) {
            right.traversePreorder(visitor);
        }


    }

    @Override
    public void traverseInorder(BinaryTreeNode.Visitor visitor) {

        if (null != left) {
            left.traverseInorder(visitor);
        }

        visitor.visitor(this);

        if (null != right) {
            right.traverseInorder(visitor);
        }


    }

    @Override
    public void traversePostorder(BinaryTreeNode.Visitor visitor) {

        if (null != left) {
            left.traversePostorder(visitor);
        }

        if (null != right) {
            right.traversePostorder(visitor);
        }

        visitor.visitor(this);

    }


    @Override
    public void prettyPrint(BinaryTreeNode.Visitor visitor, String indent, boolean last) {

        System.out.print(indent);

        if (last) {
            System.out.print("R----");
            indent += "     ";
        } else {
            System.out.print("L----");
            indent += "|    ";
        }


        visitor.visitor(this);

        if (null != left) {
            left.prettyPrint(visitor, indent, false);
        }

        if (null != right) {
            right.prettyPrint(visitor, indent, true);
        }

    }
}
