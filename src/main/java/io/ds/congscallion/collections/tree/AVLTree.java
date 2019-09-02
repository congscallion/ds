/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

import io.ds.congscallion.collections.tree.BinaryTreeNode.Visitor;

/**
 * <p>
 * AVL树是自平衡二叉搜索树。在传统的排序二进制搜索树（BST）中，搜索时间与链表（log n）的搜索时间相同。 但是，由于AVL树通过在树变得不平衡时进行旋转来平衡自身，因此保证了O（log
 * n）搜索时间，从而使AVL树在性能方面非常一致。
 * </pre>
 *
 * 如果应用程序涉及许多频繁的插入和删除，那么应该首选红黑树。如果插入和删除频率较低并且搜索是更频繁的操作，则AVL树应优先于红黑树。
 * </pre></p>
 *
 * <p>
 * 与Hash表相比：
 * <pre>
 * 1、 树可以通过中序遍历(Inorder Traversal)按排列顺序获取所有数据。 Hash表不具备排序的能力，需要提供额外的操作才可以。 2、 树可以优做范围查询，比如统计，查询 x <
 * data < y 某段范围内的数据。  Hash表不具备这样的能力，需要提供额外的操作才可以。 3、 树更易于实现，能够自由地自己实现特定的树逻辑。
 * 但Hash表需要依赖编程语言提供的函数库来计算值。 4、 avl树所有操作都可以保证在 O(log n)时间内完成。 Hash平均时间保证在(O(1))，但某些特定操作可能成本很高，尤其是在表调整大小的时。
 * </pre>
 *
 * <p>
 * 树中，节点高度与深度:
 * <pre>
 * 高度： 对于任意节点n,n的高度为从n到一片树叶的最长路径长，所有树叶的高度为0； 深度： 对于任意节点n,n的深度为从根到n的唯一路径长，根的深度为0；
 * </pre></p>
 *
 * <p>
 * AVL树高度相关计算规则：
 * <pre>
 * 判断树是否平衡： 左子树和右子树高度差不大于1, 则树是平衡的。 计算节点高度公司如下： height = max (leftSubTreeHeight, rightSubTreeHeight)
 * + 1 判断树是否平衡： | leftSubTreeHeight - rightSubTreeHeight | <= 1
 * </pre>
 *
 * <p>
 * 　AVL树平衡方法：
 * <pre>
 * 　左旋 　右旋
 *
 * y                               x / \     Right Rotation          / \ x  T3   - - - - - - - > T1
 * y / \       < - - - - - - -           / \ T1 T2     Left Rotation            T2 　T3
 * </pre>
 *
 * <p>
 * <pre>
 * 　AVL树插入操作逻辑：　将数据K插入树 　１、　使用二叉搜索树插入方法插入值K。 　２、　从节点K向上查找第一个不平衡节点Z, Y是Z子节点, X是Y的子节点。
 * 　３、　通过在以Z为根的子树上执行适当的旋转来重新平衡树。　一共有如下四种情况: 3.1、　Y是Z的左节点且X是Y的左节点。　(left left case)
 *
 * T1, T2, T3 and T4 are subtrees. z                                      y / \ /   \ y   T4
 * Right Rotate (z)          x     z / \          - - - - - - - - -> /  \   / \ x  T3
 * T1  T2 T3 T4 / \ T1 T2
 *
 * 3.2、　Y是Z的左节点且X是Y的右节点。　(left right case)
 *
 * z                              z                           x / \                            / \ /
 *   \ y   T4  Left Rotate (y)        x   T4  Right Rotate(z)    y     z / \ - - - - - - - - ->    /
 * \      - - - - - - - ->  / \   / \ T1   x                          y T3                    T1  T2
 * T3  T4 / \                             / \ T2  T3 T1   T2
 *
 *
 * 3.3、　Y是Z的右节点且X是Y的右节点。　(right right case)
 *
 * z                               y /  \                            /   \ T1   y     Left Rotate(z)
 * z     x /  \   - - - - - - - ->    / \    / \ T2   x                     T1  T2 T3  T4 / \ T3
 * T4
 *
 *
 * 3.4、　Y是Z的右节点且X是Y的左节点。　(right left case)
 *
 * z                            z                            x / \                          / \ /  \
 * T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z     y / \  - - - - - - - - ->     /
 * \   - - - - - - - ->  / \   / \ x   T4                      T2   y T1  T2 T3  T4 / \
 * / \ T2  T3                           T3 T4
 *
 * </pre>
 *
 * @author wangcong
 * @version $Id: AVLTree.java, v0.1 8/12/19 10:19 AM wangcong Exp $$
 */
public class AVLTree<E extends Comparable> extends AbstractBinarySearchTree<E> implements Tree {


  public static void main(String[] args) {

//    add();

    remove();

  }

  private static void remove() {
    AVLTree<Integer> tree = new AVLTree<>();

    tree.add(99);
    tree.add(300);
    tree.add(120);
    tree.add(70);
    tree.add(220);
    tree.add(140);
    tree.add(320);
    tree.add(80);
    tree.add(250);
    tree.add(130);
    tree.add(340);
    tree.add(50);
    tree.add(55);

    tree.prettyPrint(new Visitor() {
      @Override
      public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
        System.out.println(node.getData());
      }
    }, "", true);

    tree.remove(130);

    printSplitLine();

    tree.prettyPrint(new Visitor() {
      @Override
      public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
        System.out.println(node.getData());
      }
    }, "", true);


  }

  private static void add() {
    AVLTree<Integer> tree = new AVLTree<>();

    tree.add(99);
    tree.add(300);
    tree.add(120);
    tree.add(70);
    tree.add(220);
    tree.add(140);
    tree.add(320);
    tree.add(80);
    tree.add(250);
    tree.add(130);
    tree.add(340);
    tree.add(50);
    tree.add(55);

    tree.prettyPrint(new Visitor() {
      @Override
      public <E extends Comparable> void visitor(BinaryTreeNode<E> node) {
        System.out.println(node.getData());
      }
    }, "", true);
  }

  private static void printSplitLine() {
    System.out.println();
    System.out.println("-----------------------------------");
    System.out.println();
  }

  @Override
  protected BinaryTreeNode<E> createNode(E data) {
    return new AVLTreeNode<>(data);
  }

  @Override
  protected boolean needAdjustAfterRemoval(BinaryTreeNode<E> node) {
    return true;
  }

  @Override
  protected void adjustAfterRemoval(BinaryTreeNode<E> node) {
    adjustAfterInsertion(node);
  }

  /**
   * 由于AVL树判断节点是否平衡是计算节点的高度， 因此在平衡前，需要将被删除的节点从父节点处删除。 否则可能会得到错误的高度。
   */
  @Override
  protected void removalLeafNodedAndNotRoot(BinaryTreeNode<E> node) {

    BinaryTreeNode parent = parentOf(node);
    node.removeFromParent();

    if (needAdjustAfterRemoval(parent)) {
      adjustAfterRemoval(parent);
    }
  }

  @Override
  protected void adjustAfterInsertion(BinaryTreeNode<E> node) {
    adjustAfterInsertion0((AVLTreeNode) node);
  }

  private void adjustAfterInsertion0(AVLTreeNode node) {

    if (null == node) {
      return;
    }

    AVLTreeNode n = node;

    while (null != n) {

      // 更新树点的高
      setHeight(n);

      // 判断父节点是否平衡
      int balance = getBalance(n);

      if (balance <= -2) {

        //　判断新插入的节点在当前节点的左子树还是右子树
        //　如果根据平衡规则，　左子树高度大于右子树，则在左子树中插入的新节点；否则是在右子树中插入的新节点
        if (getBalance(rightOf(n)) > 0) {
          rotateRight(rightOf(n));
        }

        rotateLeft(n);

      } else if (balance >= 2) {

        if (getBalance(leftOf(n)) < 0) {

          rotateLeft(leftOf(n));
        }

        rotateRight(n);
      }

      n = (AVLTreeNode) parentOf(n);
    }

  }

  /**
   * 计算节点的平衡因子，　绝对值大于1，　树不平衡
   */
  private int getBalance(BinaryTreeNode node) {

    if (null == node) {
      return 0;
    }

    return heightOf(leftOf(node)) - heightOf(rightOf(node));
  }

  /**
   * 计算节点的高
   */
  private int heightOf(BinaryTreeNode node) {

    return null == node ? -1 : ((AVLTreeNode) node).height;
  }

  private void setHeight(BinaryTreeNode node, int height) {
    ((AVLTreeNode) node).height = height;
  }

  private void setHeight(BinaryTreeNode node) {

    if (null == node) {
      return;
    }

    int height = max(heightOf(leftOf(node)), heightOf(rightOf(node))) + 1;

    setHeight(node, height);
  }

  private int max(int x, int y) {
    return x >= y ? x : y;
  }

  /**
   * 左旋后，需要更新节点的高度信息
   */
  @Override
  protected void rotateLeft(BinaryTreeNode<E> node) {
    super.rotateLeft(node);

    setHeight(node);
    setHeight(node.getRight());
  }

  @Override
  protected void rotateRight(BinaryTreeNode<E> node) {
    super.rotateRight(node);

    setHeight(node);
    setHeight(node.getLeft());
  }


}
