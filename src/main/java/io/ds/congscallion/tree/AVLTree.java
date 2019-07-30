/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

/**
 * 实现一个自平衡的二叉搜索树
 *
 * @author wangcong
 * @version $Id: AVLTree.java, v0.1 7/30/19 3:31 PM wangcong Exp $$
 */
public class AVLTree<E extends Comparable> {

    private AVLNode<E> root;

    public void setRoot(AVLNode<E> root) {
        this.root = root;
    }

    public AVLNode<E> getRoot() {
        return root;
    }

    /**
     * 获取指定节点的高
     *
     */
    private int height(AVLNode n) {
        if (n == null) {
            return 0;
        }
        return n.getHeight();
    }


    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private void setHeight(AVLNode n) {
        if (null == n) {
            return;
        }
        int height = max(height((AVLNode) n.getLeft()), height((AVLNode) n.getRight())) + 1;
        n.setHeight(height);
    }

    private int getBalance(AVLNode n) {
        if (n == null) {
            return 0;
        }

        return height((AVLNode) n.getLeft()) - height((AVLNode) n.getRight());
    }


    /**
     * 右旋指定节点的子树
     */
    public AVLNode rightRotate(AVLNode y) {

        AVLNode<E> x = (AVLNode<E>) y.getLeft();
        AVLNode<E> T2 = (AVLNode<E>) x.getRight();

        y.setLeft(T2);
        x.setRight(y);

        //更新节点的高
        setHeight(y);
        setHeight(x);

        return x;
    }

    /**
     * 左旋指定节点的子树
     */
    public AVLNode leftRotate(AVLNode x) {

        AVLNode<E> y = (AVLNode<E>) x.getRight();
        AVLNode<E> T2 = (AVLNode<E>) y.getLeft();

        x.setRight(T2);
        y.setLeft(x);

        //更新节点的高
        setHeight(y);
        setHeight(x);

        return y;
    }

    public AVLNode insert(AVLNode node, E data) {

        if (node == null) {
            return new AVLNode(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert((AVLNode) node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert((AVLNode) node.getRight(), data));
        } else {
            return node;
        }

        // 更新当前节点的高
        setHeight(node);

        // 计算当前节点的平衡因子
        int balance = getBalance(node);

        // 如果当前节点变得不平衡，然后需要通过左右旋转平衡树
        if (balance > 1 && data.compareTo(node.getLeft().getData()) < 0) {
            return rightRotate(node);
        }

        if (balance > 1 && data.compareTo(node.getLeft().getData()) > 0) {
            node.setLeft(leftRotate((AVLNode) node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && data.compareTo(node.getRight().getData()) > 0) {
            return leftRotate(node);
        }

        if (balance < -1 && data.compareTo(node.getRight().getData()) < 0) {
            node.setRight(rightRotate((AVLNode) node.getRight()));
            return leftRotate(node);
        }

        return node;
    }


    public void preOrder(BinaryNode node) {
        if (node != null) {

            System.out.print(node.getData() + " ");

            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }


}
