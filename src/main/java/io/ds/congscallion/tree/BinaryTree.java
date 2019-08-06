/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 此类表示二叉搜索数，并提供常用的二叉搜索数操作。
 *
 * @author wangcong
 * @version $Id: BinaryTree.java, v0.1 7/15/19 6:42 PM wangcong Exp $$
 */
public class BinaryTree<E extends Comparable> {

    private BinaryNode<E> root;

    public void add(E e) {
        root = addRecursive(root, e);
    }


    /**
     * 使用递归的方式查询元素应该被正确插入的位置
     *
     * 1、如果新节点的值小于当前节点的值，进入该节点的左子树
     * 2、如果新节点的值大小或者等于当前节点的值，进入该节点的右子树
     * 3、当前节点为空时，可以在该位置插入新节点
     *
     * @param current 正在处理的节点，判断新节点应位于该节点左子树还是右子树
     * @param e 被插入节点的值
     */
    private BinaryNode<E> addRecursive(BinaryNode<E> current, E e) {

        if (current == null) {
            return new BinaryNode<>(e);
        }

        if (e.compareTo(current.getData()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), e));
        } else if (e.compareTo(current.getData()) > 0) {
            current.setRight(addRecursive(current.getRight(), e));
        } else {
            return current;
        }

        return current;
    }


    /**
     * 判断该二叉树是否包含指定的元素
     *
     * 包含返回true, 其它 false.
     */
    public boolean containsNode(E value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(BinaryNode<E> current, E value) {

        if (current == null) {
            return false;
        }

        if (current.getData().compareTo(value) == 0) {
            return true;
        }

        if (current.getData().compareTo(value) >= 0) {
            return containsNodeRecursive(current.getLeft(), value);
        } else {
            return containsNodeRecursive(current.getRight(), value);
        }

    }

    /**
     * 删除节点， 删除逻辑如下：
     *
     * 1、被删除节点无子节点时，修改当前节点在其父节点的引用为null即可。
     * 2、被删除节点只有一个子节点时，使用子节点替换当前节点在父节点的引用即可。
     * 3、被删除节点有两个子节点时，需要重组树。
     *
     * @param e 被删除数据
     * @return 被删除的节点
     */
    public BinaryNode delete(E e) {
        return deleteRecursive(root, e);
    }


    private BinaryNode deleteRecursive(BinaryNode current, E e) {
        if (current == null) {
            return null;
        }

        // 找到被删除节点， 需要处理多种情况
        if (current.getData().compareTo(e) == 0) {
            if (current.getLeft() == null && current.getRight() == null) {
                return processDeleteNoChildren(current);
            }

            if (current.getRight() == null || current.getLeft() == null) {
                return processDeleteOnlyOneChildren(current);
            }

            return processDeleteTwoChildren(current);
        }

        if (current.getData().compareTo(e) > 0) {
            current.setLeft(deleteRecursive(current.getLeft(), e));
            return current;
        }

        current.setRight(deleteRecursive(current.getRight(), e));
        return current;

    }

    /**
     * 被删除节点有两个节点时， 使用该节点右子数中最小节点替换被删除的节点，并从原右子树中删除该节点。
     */
    private BinaryNode processDeleteTwoChildren(BinaryNode current) {
        BinaryNode<E> smallestNode = findSmallestNode(current.getRight());
        current.setData(smallestNode.getData());

        deleteRecursive(current.getRight(), smallestNode.getData());
        return current;
    }

    /**
     * 删除只有一个子节点的节点， 返回其子节点即可
     */
    private BinaryNode processDeleteOnlyOneChildren(BinaryNode current) {
        return current.getRight() == null ? current.getLeft() : current.getRight();
    }

    /**
     * 删除无子节点的节点， 直接返回null.
     */
    private BinaryNode processDeleteNoChildren(BinaryNode current) {
        return null;
    }


    /**
     * 查找给定节点下最小的节点
     */
    private BinaryNode findSmallestNode(BinaryNode root) {
        return root.getLeft() == null ? root : findSmallestNode(root.getLeft());
    }

    /**
     * 遍历数
     *
     * 遍历树分深度优先搜索与广度优先搜索。
     *
     * 深度优先搜索(Depth-first search)： 对任意一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次。 又分为以下三种遍历方式：
     * 1、先序遍历(pre-order):  对任意节点， 先访问根，其次遍历左子树，最后遍历右子树。
     * 2、中序遍历(in-order): 对任意节点， 先遍历左子树，其次访问根，最后遍历右子树。
     * 3、后序遍历(post-order): 对任意节点，先遍历左子树，其次遍历右子树，最后访问根。
     *
     * 广度优先搜索(Breadth-First Search) 进入下一级别之前，访问该级别的所有节点
     */


    public void traverseInOrder() {
        traverseInOrder(root);
    }

    /**
     * 使用中序遍历(in-order)方式遍历指定节点
     *
     * @param root 被遍历的节点
     */
    private void traverseInOrder(BinaryNode<E> root) {

        if (root != null) {

            traverseInOrder(root.getLeft());
            System.out.print(" " + root.getData());
            traverseInOrder(root.getRight());
        }

    }


    public void traversePreOrder() {
        traversePreOrder(root);
    }

    /**
     * 使用先序遍历(pre-order)方式遍历指定节点
     *
     * @param root 被遍历的节点
     */
    private void traversePreOrder(BinaryNode<E> root) {

        if (root != null) {

            System.out.print(" " + root.getData());
            traversePreOrder(root.getLeft());
            traversePreOrder(root.getRight());

        }

    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }


    /**
     * 使用后序遍历(post-order)方式遍历指定节点
     *
     * @param root 被遍历的节点
     */
    private void traversePostOrder(BinaryNode<E> root) {

        if (root != null) {

            traversePostOrder(root.getLeft());
            traversePostOrder(root.getRight());
            System.out.print(" " + root.getData());

        }

    }

    /**
     * 使用广度优先搜索遍历当前树
     */
    public void traverseLevelOrder() {
        traverseLevelOrder(root);
    }

    private void traverseLevelOrder(BinaryNode<E> root) {

        if (root == null) {
            return;
        }

        Queue<BinaryNode<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            BinaryNode<E> remove = queue.remove();

            System.out.print(" " + remove.getData());

            if (remove.getLeft() != null) {
                queue.add(remove.getLeft());
            }

            if (remove.getRight() != null) {
                queue.add(remove.getRight());
            }
        }
    }


    public BinaryNode<E> getRoot() {
        return root;
    }

}
