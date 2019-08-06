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

    public AVLNode<E> getRoot() {
        return root;
    }

    public void setRoot(AVLNode<E> root) {
        this.root = root;
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
        setHeight(x);
        setHeight(y);

        return y;
    }

    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.getLeft() != null) {
            current = (AVLNode) current.getLeft();
        }
        return current;
    }


    private AVLNode rotateTree(AVLNode node, int balance, E data) {

        // 如果当前节点变得不平衡，然后需要通过左右旋转平衡树
        // 左左情况
        if (balance > 1 && data.compareTo(node.getLeft().getData()) < 0) {
            return rightRotate(node);
        }

        // 左右情况， 先左旋再右旋
        if (balance > 1 && data.compareTo(node.getLeft().getData()) > 0) {
            node.setLeft(leftRotate((AVLNode) node.getLeft()));
            return rightRotate(node);
        }

        // 右右情况， 左旋
        if (balance < -1 && data.compareTo(node.getRight().getData()) > 0) {
            return leftRotate(node);
        }

        // 右左情况， 先右旋再左旋
        if (balance < -1 && data.compareTo(node.getRight().getData()) < 0) {
            node.setRight(rightRotate((AVLNode) node.getRight()));
            return leftRotate(node);
        }

        return node;

    }


    /**
     * 向avl树中插入新的节点
     *
     */
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

        return rotateTree(node, balance, data);
    }


    /**
     * 在avl树中删除某个节点
     */
    public AVLNode deleteNode(AVLNode root, E data) {

        if (null == root) {
            return root;
        }

        if (data.compareTo(root.getData()) < 0) {
            root.setLeft(deleteNode((AVLNode) root.getLeft(), data));
        } else if (data.compareTo(root.getData()) > 0) {
            root.setRight(deleteNode((AVLNode) root.getRight(), data));
        } else {

            /**
             * 找到被删除的节点。
             *
             * 根据被删除节点是否存在子节点，删除操作又分三种情况
             *
             * 1. 无子节点， 最简单，直接删除该节点即可
             * 2. 一个子节点
             * 3. 两个子节点
             *
             */

            // 只有一个子节点或者没有子节点的情况
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                AVLNode temp = null;
                if (temp == root.getLeft()) {
                    temp = (AVLNode) root.getRight();
                } else {
                    temp = (AVLNode) root.getLeft();
                }

                // 没有子树的情况
                if (null == temp) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
                // 两个节点
            } else {

                // 使用右子树最小节点替换被删除的节点
                AVLNode<E> temp = minValueNode(root);

                root.setData(temp.getData());

                root.setRight(deleteNode((AVLNode) root.getRight(), temp.getData()));

            }

        }

        if (root == null) {
            return root;
        }

        // 更新节点的高
        setHeight(root);

        // 计算负载因子
        int balance = getBalance(root);

        return rotateTree(root, balance, data);
    }


    public void preOrder(BinaryNode node) {
        if (node != null) {

            System.out.print(node.getData() + " ");

            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }


}
