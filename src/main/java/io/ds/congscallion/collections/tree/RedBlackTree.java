/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

import io.ds.congscallion.collections.tree.BinaryTreeNode.Visitor;
import io.ds.congscallion.collections.tree.RedBlackTreeNode.Color;

/**
 * 红黑树是一种特殊的二叉搜索树，其特征如下：
 * <p>
 *      1、树中每个节点要么红色要么黑色
 *
 *      2、树的根节点必须是黑色
 *
 *      3、每个NULL节点都是黑色（NULL节点是叶节点。它们不包含任何键。当搜索树中不存在的键时，认为到达NULL节点。）
 *
 *      4、如果节点为红色，则两个子节点必须是黑色。 这意味着树任何路径上不会存在两个连续的红色节点
 *
 *      5、从根节点到任意NULL节点的路径上，有相同数量的黑色节点
 * </p>
 *
 * 平衡红黑树的方法：
 * <p>
 *      1、左旋
 *      2、右旋
 *      3、重新着色
 * </p>
 *
 * 红黑树插入逻辑：
 * <p>
 *      1、规定插入节点为K，父节点为P, 父节点的父节点为G, 父节点的兄弟节点为U, T代表整颗树。
 *      2、标记K为红色。
 *      3、使用普通的二叉搜索树插入方法插入K到正确位置。
 *      4、检查插入K之后，树是否满足红黑树牲。 检查逻辑如下：
 *
 *        4.1.  T是空树，则将K标记为树根，并将其着色为黑色
 *        4.2.  P是黑色，不做任何处理
 *        4.3.  P是红色，根据U的颜色处理
 *
 *            4.3.1. U是红色， 重新着色P，G，U.  即： P，U着黑色，G着红色
 *
 *            4.3.2. U是黑色或NULL， P是G的右子节点，K是P的右子节点
 *               则以G为根左旋子树，使G成为K的兄弟节点S。然后S着红色，P着黑色
 *
 *            4.3.3. U是黑色或NULL， P是G的右子节点，K是P的左子节点
 *                则先以P为根右旋，之后，使用4.3.2描述的规则处理
 *
 *            4.3.4. U是黑色或NULL， P是G的左子节点，K是P的左子节点
 *                则以G为根右旋子树，使G成为K的兄弟节点S。然后S着红色，P着黑色
 *
 *            4.3.5. U是黑色或NULL， P是G的左子节点，K是P的右子节点
 *                则先以P为根左旋，之后，使用4.3.4描述的规则处理
 * </p>
 *
 * @author wangcong
 * @version $Id: RedBlackTree.java, v0.1 8/8/19 10:57 AM wangcong Exp $$
 */
public class RedBlackTree<E extends Comparable> extends AbstractBinarySearchTree<E> {


    @Override
    protected BinaryTreeNode<E> createNode(E data) {
        return new RedBlackTreeNode<>(data);
    }

    @Override
    protected void adjustAfterRemoval(BinaryTreeNode<E> node) {

    }


    /**
     *
     * 红黑树中添加节点后，平衡树
     *
     *
     *
     *
     *
     * @param node
     */
    @Override
    protected void adjustAfterInsertion(BinaryTreeNode<E> node) {
        adjustAfterInsertion0((RedBlackTreeNode) node);
    }


    private void adjustAfterInsertion0(RedBlackTreeNode<E> node) {
        // 第一步， 将节点标记为红色 （新插入节点都是红色）
        setColor(node, Color.RED);

        // 第二步， 解决两个红色球相连的情况
        if (null != node && node != root && isRed(parentOf(node))) {

            // 4.3.1. U是红色， 重新着色P，G，U.  即： P，U着黑色，G着红色
            if (isRed(siblingOf(parentOf(node)))) {

                setColor(parentOf(node), Color.BLACK);
                setColor(siblingOf(parentOf(node)), Color.BLACK);
                setColor(grandparentOf(node), Color.RED);

                adjustAfterInsertion(grandparentOf(node));
            }

            // case 4.3.2 && 4.3.3
            else if (parentOf(node) == rightOf(grandparentOf(node))) {

                if (node == leftOf(parentOf(node))) {
                    rotateRight(node = (RedBlackTreeNode<E>) parentOf(node));
                }

                setColor(parentOf(node), Color.BLACK);
                setColor(grandparentOf(node), Color.RED);
                rotateLeft(grandparentOf(node));
            }

            // case 4.3.4 && 4.3.5
            else if (parentOf(node) == leftOf(grandparentOf(node))) {

                if (node == rightOf(parentOf(node))) {
                    rotateLeft(node = (RedBlackTreeNode<E>) parentOf(node));
                }

                setColor(parentOf(node), Color.BLACK);
                setColor(grandparentOf(node), Color.RED);

                rotateRight(grandparentOf(node));
            }

        }

        setColor(root, Color.BLACK);

    }


    private void setColor(BinaryTreeNode<E> node, Color color) {
        if (null != node) {
            RedBlackTreeNode treeNode = (RedBlackTreeNode) node;
            treeNode.color = color;
        }
    }


    private boolean isRed(BinaryTreeNode<E> node) {
        if (null == node) {
            return false;
        }

        return Color.RED == ((RedBlackTreeNode) node).color;
    }


    public static void main(String[] args) {

        RedBlackTree<Integer> rbt = new RedBlackTree<>();

        rbt.add(99);
        rbt.add(300);
        rbt.add(120);
//        rbt.add(330);
        rbt.add(70);
        rbt.add(220);
        rbt.add(140);
        rbt.add(320);
        rbt.add(80);
        rbt.add(250);
        rbt.add(130);
        rbt.add(340);
        rbt.add(50);


        rbt.traverseInorder(new Visitor() {
            @Override
            public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {

                RedBlackTreeNode rbtn = (RedBlackTreeNode) node;

                String colorStr = rbtn.color == Color.RED? "(red)":"(black)";

                System.out.print(node+colorStr+", ");
            }
        });

        printSplitLine();

        rbt.prettyPrint(new Visitor() {
            @Override
            public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {

                RedBlackTreeNode rbtn = (RedBlackTreeNode) node;

                String colorStr = rbtn.color == Color.RED? "(red)":"(black)";

                System.out.println(node+colorStr+", ");
            }
        },"", true);
    }

    private static void printSplitLine() {
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();
    }

}
