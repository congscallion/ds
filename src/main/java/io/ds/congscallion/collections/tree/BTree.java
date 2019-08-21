/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 * https://zh.wikipedia.org/wiki/B树
 * <p>
 * <pre>
 * 在计算机科学中，B树是一种自平衡树数据结构，它维护有序数据并允许以对数时间进行搜索，顺序访问，插入和删除。
 * B树是二叉搜索树的一般化，因为节点可以有两个以上的子节点。与其他自平衡二进制搜索树不同，B树非常适合读取和写入相对较大的数据块（如光盘）的存储系统。
 * 它通常用于数据库和文件系统。
 * </pre>
 *
 * <pre>
 * 在B树中，内部（非叶子）节点可以拥有可变数量的子节点（数量范围预先定义好）。当数据被插入或从一个节点中移除，它的子节点数量发生变化。
 * 为了维持在预先设定的数量范围内，内部节点可能会被合并或者分离。因为子节点数量有一定的允许范围，所以B树不需要像其他自平衡查找树那样频繁地重新保持平衡，
 * 但是由于节点没有被完全填充，可能浪费了一些空间。子节点数量的上界和下界依特定的实现而设置。例如，在一个2-3 B树（通常简称2-3树），
 * 每一个内部节点只能有2或3个子节点。
 * </pre>
 *
 * <pre>
 * <b>用阶定义的B树</b>
 * 一个m阶的B树是一个有以下属性的树：
 *
 * 1、每一个节点最多有m个子节点
 * 2、每一个非叶子节点（除根节点）最少有⌈ m/2⌉个子节点
 * 3、如果根节点不是叶子节点，那么它至少有两个子节点
 * 4、有k个子节点的非叶子节点拥有k−1个键
 * 5、所有的叶子节点都在同一层
 * </pre>
 *
 <pre>
 * <b>用度定义的B树</b>
 *
 * 1、所有的叶子节点都在同一层
 * 2、B树由术语最小度't'定义(最小于度't'表示节点存放key是最少数量), t的值取决于磁盘块大小
 * 3、除root之外的每个节点必须至少包含t-1个key, Root可能包含最少1个密钥
 * 4、所有节点（包括root）最多可包含2t-1个key
 * 5、节点的子节点数等于其中的键数加1
 * 6、节点的所有键按递增顺序排序。两个键k1和k2之间的子包含k1和k2范围内的所有键
 * 7、与二进制搜索树不同，B树从根增长和缩小。二元搜索树向下生长，也从向下收缩
 * 8、与其他平衡二进制搜索树一样，搜索，插入和删除的时间复杂度为O（Logn）
 *
 * </pre>
 *
 *
 * @author wangcong
 * @version $Id: BTree.java, v0.1 8/14/19 5:09 PM wangcong Exp $$
 */
public class BTree<E extends Comparable> implements Tree {


  /**
   *
   * 将数据插入B树中
   *
   * @param e
   */
  public void add(E e) {

  }


  /**
   *
   * 在树中搜索包含指定数据的节点
   *
   * @param e
   * @return
   */
  public E search(E e) {

    return e;
  }


  /**
   *
   * 从树中删除指定数据项
   *
   * @param e
   */
  public void delete(E e) {

  }


}