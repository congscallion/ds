/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 *
 * <p><pre>
 *  此接口表示数据结构中的树结构。
 * </pre></p>
 *
 *  <p><pre>
 *  在计算机科学中，树（英语：tree）是一种抽象数据类型（ADT）或是实作这种抽象数据类型的数据结构，用来模拟具有树状结构性质的数据集合。
 *  它是由n（n>0）个有限节点组成一个具有层次关系的集合。把它叫做“树”是因为它看起来像一棵倒挂的树，也就是说它是根朝上，而叶朝下的。
 *  它具有以下的特点：
 *
 *  1、每个节点都只有有限个子节点或无子节点；
 *  2、没有父节点的节点称为根节点；
 *  3、每一个非根节点有且只有一个父节点；
 *  4、除了根节点外，每个子节点可以分为多个不相交的子树；
 *  5、树里面没有环路(cycle)
 * </pre></p>
 *
 *
 *  <p><pre>
 *  相关术语：
 *
 *  1、节点的度：一个节点含有的子树的个数称为该节点的度；
 *  2、树的度：一棵树中，最大的节点度称为树的度；
 *  3、叶节点或终端节点：度为零的节点；
 *  4、非终端节点或分支节点：度不为零的节点；
 *  5、父亲节点或父节点：若一个节点含有子节点，则这个节点称为其子节点的父节点；
 *  6、孩子节点或子节点：一个节点含有的子树的根节点称为该节点的子节点；
 *  7、兄弟节点：具有相同父节点的节点互称为兄弟节点；
 *  8、节点的层次：从根开始定义起，根为第1层，根的子节点为第2层，以此类推；
 *  9、深度：对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0；
 *  10、高度：对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0；
 *  11、堂兄弟节点：父节点在同一层的节点互为堂兄弟；
 *  12、节点的祖先：从根到该节点所经分支上的所有节点；
 *  13、子孙：以某节点为根的子树中任一节点都称为该节点的子孙。
 *  14、森林：由m（m>=0）棵互不相交的树的集合称为森林；
 *  </pre></p>
 *
 *
 *  <p><pre>
 *  树的种类：
 *
 *  1、二叉树：每个节点最多含有两个子树的树称为二叉树；
 *      1.1、 满二叉树(Full Binary Tree)： 每个节点要么有两个子节点，要么没有子节点（every node has 0 or 2 children）。
 *      1.2、 完全二叉树(Complete Binary Tree)： 如果所有级别都被完全填充，除了可能是最后一级， 最后一级是尽可能保留所有keys
 *      1.3、 排序二叉树(二叉查找树(Binary Search Tree))：也称二叉搜索树、有序二叉树；
 *      1.4、 笛卡尔树
 *      1.5、 Top tree
 *      1.6、 T树
 *      1.7、 霍夫曼树： 带权路径最短的二叉树称为哈夫曼树或最优二叉树
 *  2、自平衡的二叉搜索树
 *      2.1、 红黑树
 *      2.2、 伸展树（Splay tree）
 *      2.3、 树堆（Treap）
 *      2.4、 AA树
 *      2.5、 节点大小平衡树
 *      2.6、 平衡二叉树（AVL树）：当且仅当任何节点的两棵子树的高度差不大于1的二叉树；
 *
 *  3、B树：一种对读写操作进行优化的自平衡的二叉查找树，能够保持数据有序，拥有多于两个子树。
 *      4.1 B树
 *      4.2 B+树
 *      4.3 B*树
 *      4.4 Bx树
 *      4.5 2-3树
 *      4.6 2-3-4树
 *  5、Trie
 *      5.1 前缀树
 *      5.2 后缀树
 *      5.3 基数树
 *  </pre></p>
 *
 *
 * <p><pre>
 * 树的遍历：
 *
 * 与那些基本上都有标准遍历方式（通常是按线性顺序）的线性数据结构（如链表、一维数组）所不同的是，树结构有多种不同的遍历方式。从二叉树的根节点出发，
 * 节点的遍历分为三个主要步骤：对当前节点进行操作（称为“访问”节点）、遍历左边子节点、遍历右边子节点。这三个步骤的先后顺序也是不同遍历方式的根本区别。
 *
 * 由于从给定的某个节点出发，有多个可以前往的下一个节点（树不是线性数据结构），所以在顺序计算（即非并行计算）的情况下，
 * 只能推迟对某些节点的访问——即以某种方式保存起来以便稍后再访问。常见的做法是采用栈（LIFO）或队列（FIFO）。
 * 由于树本身是一种自我引用（即递归定义）的数据结构，因此很自然也可以用递归方式，或者更准确地说，用corecursion，来实现延迟节点的保存。
 * 这时（采用递归的情况）这些节点被保存在call stack中。
 *
 * 遍历方式的命名，源于其访问节点的顺序。最简单的划分：是深度优先（先访问子节点，再访问父节点，最后是第二个子节点）？
 * 还是广度优先（先访问第一个子节点，再访问第二个子节点，最后访问父节点）？ 深度优先可进一步按照根节点相对于左右子节点的访问先后来划分。
 * 如果把左节点和右节点的位置固定不动，那么根节点放在左节点的左边，称为前序（pre-order）、
 * 根节点放在左节点和右节点的中间，称为中序（in-order）、根节点放在右节点的右边，称为后序（post-order）。
 * 对广度优先而言，遍历没有前序中序后序之分：给定一组已排序的子节点，其“广度优先”的遍历只有一种唯一的结果。
 *
 *  深度优先(Depth-first search)： 对任意一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次。
 *      1、 先序遍历(pre-order):  对任意节点， 先访问根，其次遍历左子树，最后遍历右子树。
 *      <p><blockquote><pre>
 *          public void traversePreorder(Node node) {
 *
 *            System.out.print(node + ", ");
 *
 *            if (null != left) {
 *                traversePreorder(left);
 *            }
 *
 *            if (null != right) {
 *                traversePreorder(right);
 *            }
 *
 *          }
 *      </pre></blockquote></p>
 *
 *      2、 中序遍历(in-order): 对任意节点， 先遍历左子树，其次访问根，最后遍历右子树。
 *      <p><blockquote><pre>
 *          public void traverseInorder(Node node) {
 *
 *            if (null != left) {
 *               traverseInorder(left);
 *           }
 *
 *            System.out.print(node + ", ");
 *
 *            if (null != right) {
 *                traverseInorder(right);
 *            }
 *
 *          }
 *       </pre></blockquote></p>
 *
 *      3、 后序遍历(post-order): 对任意节点，先遍历左子树，其次遍历右子树，最后访问根。
 *      <p><blockquote><pre>
 *          public void traversePostorder(Node node) {
 *
 *            if (null != left) {
 *                traversePostorder(left);
 *            }
 *
 *            if (null != right) {
 *                traversePostorder(right);
 *            }
 *
 *            System.out.print(node + ", ");
 *
 *          }
 *        </pre></blockquote></p>
 *
 *  广度优先(Breadth-First Search)： 进入下一级别之前，访问该级别的所有节点
 *
 *  <p><blockquote><pre>
 *      private void traverseLevelOrder(Node root) {
 *
 *         if (root == null) {
 *           return;
 *         }
 *      
 *         Queue<Node> queue = new LinkedList<>();
 *         queue.add(root);
 *         while (!queue.isEmpty()) {
 *
 *           Node<E> remove = queue.remove();
 *
 *           System.out.print(" " + remove.getData());
 *
 *           if (remove.getLeft() != null) {
 *             queue.add(remove.getLeft());
 *           }
 *
 *           if (remove.getRight() != null) {
 *             queue.add(remove.getRight());
 *           }
 *         }
 *      }
 *  </pre></blockquote></p>
 *
 * </pre></p>
 *
 *
 * @author wangcong
 * @version $Id: Tree.java, v0.1 8/13/19 2:23 PM wangcong Exp $$
 */
public interface Tree {

}
