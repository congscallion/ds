/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

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
 * @version $Id: RedBlackTree.java, v0.1 8/5/19 10:10 AM wangcong Exp $$
 */
public class RedBlackTree<E extends Comparable<E>> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {

        private E e;
        private Node left;
        private Node right;
        private Node parent;
        private boolean color;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.color = RED;
        }

    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }


    private Node rotateLeft(Node x) {

        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x.e.compareTo(x.parent.e) < 0) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;

        return y;
    }


    private Node rotateRight(Node x) {

        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x.e.compareTo(x.parent.e) > 0) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;

        return y;
    }


    public Node insert(E e) {

        Node node = new Node(e);

        Node y = null;
        Node x = this.root;

        while (x != null) {
            y = x;
            if (node.e.compareTo(x.e) < 0) {
                x = x.left;
            } else if (node.e.compareTo(x.e) > 0) {
                x = x.right;
            } else {
                return x;
            }
        }

        // y is parent of x
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.e.compareTo(y.e) < 0) {
            y.left = node;
        } else {
            y.right = node;
        }

        // 不需要平衡
        if (node.parent == null) {
            node.color = BLACK;

            return node;
        }

        // 不需要平衡
        if (node.parent.parent == null) {
            return node;
        }

        balanceTreeOnInsert(node);

        return node;
    }


    /**
     * 本方法用于在树中执行插入操作后，将树重新平衡，保证红黑节点满足红黑树的特征
     *
     * @param k
     */
    private void balanceTreeOnInsert(Node k) {
        Node u;

        while (isRed(k.parent)) {

            if (k.parent.parent.right != null && k.parent.e.compareTo(k.parent.parent.right.e) == 0) {
                u = k.parent.parent.left;

                if (isRed(u)) {
                    u.color = BLACK;
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;
                } else {

                    if (k.parent.left != null && k.e.compareTo(k.parent.left.e) == 0) {
                        k = k.parent;
                        rotateRight(k);
                    }

                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    rotateLeft(k.parent.parent);
                }


            } else {

                u = k.parent.parent.right;

                if (isRed(u)) {
                    u.color = BLACK;
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;

                } else {

                    if (k.parent.right != null && k.e.compareTo(k.parent.right.e) == 0) {
                        k = k.parent;
                        rotateLeft(k);

                    }

                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    rotateRight(k.parent.parent);
                }

            }

            if (k.e.compareTo(root.e) == 0) {
                break;
            }

        }

        root.color = BLACK;

    }


    public void delete(E e) {
        delete(root, e);
    }

    private void delete(Node node, E e) {

        Node z = null;
        Node x;
        Node y;

        while (node != null) {
            if (node.e.compareTo(e) == 0) {
                z = node;
                break;
            } else if (node.e.compareTo(e) < 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (z == null) {
            System.out.println("Couldn't find " + e + " in the tree");
            return;
        }

        y = z;

        boolean yOriginalColor = y.color;

        if (z.left == null) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == null) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {

            y = minimum(z.right);

            yOriginalColor = y.color;
            x = y.right;

            if (y.parent.e.compareTo(z.e) == 0) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (!yOriginalColor) {
            fixDelete(x);
        }

    }

    // fix the rb tree modified by the delete operation
    private void fixDelete(Node x) {
        Node s;
        while (x != root && !isRed(x)) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (isRed(s)) {
                    // case 3.1
                    s.color = BLACK;
                    x.parent.color = RED;
                    rotateLeft(x.parent);
                    s = x.parent.right;
                }

                if (isRed(s.left) && !isRed(s.right)) {
                    // case 3.2
                    s.color = RED;
                    x = x.parent;
                } else {
                    if (!isRed(s.right)) {
                        // case 3.3
                        s.left.color = BLACK;
                        s.color = RED;
                        rotateRight(s);
                        s = x.parent.right;
                    }

                    // case 3.4
                    s.color = x.parent.color;
                    x.parent.color = BLACK;
                    s.right.color = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (isRed(s)) {
                    // case 3.1
                    s.color = BLACK;
                    x.parent.color = RED;
                    rotateRight(x.parent);
                    s = x.parent.left;
                }

                if (!isRed(s.right) && !isRed(s.left)) {
                    // case 3.2
                    s.color = RED;
                    x = x.parent;
                } else {
                    if (!isRed(s.left)) {
                        // case 3.3
                        s.right.color = BLACK;
                        s.color = RED;
                        rotateLeft(s);
                        s = x.parent.left;
                    }

                    // case 3.4
                    s.color = x.parent.color;
                    x.parent.color = BLACK;
                    s.left.color = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK;
    }

    public Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    private void rbTransplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }


    public void prettyPrint() {
        printHelper(this.root, "", true);
    }


    private void printHelper(Node root, String indent, boolean last) {
        if (root != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            String sColor = isRed(root) ? "RED" : "BLACK";
            System.out.println(root.e + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }


}
