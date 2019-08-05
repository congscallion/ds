package io.ds.collections;


import java.util.List;

/**
 * A simple interface for trees.
 */
public interface SimpleTreeNode<E> {

  /**
   * Returns the data stored in this node.
   */
  E getData();

  /**
   * Replaces the data object stored in this node with the given data.
   */
  void setData(E data);

  /**
   * Returns the parent of this node, or null if this node is a root.
   */
  SimpleTreeNode<E> getParent();

  /**
   * Returns the children of this node as a list of nodes.  The returned
   * list is read-only to prevent callers from inserting garbage into
   * the actual list of children in the tree!
   */
  List<? extends SimpleTreeNode<E>> getChildren();

  /**
   * Removes child from its current parent and inserts it
   * at the given index of this node.  Indices start at 0.
   * @exception IndexOutOfBoundsException if the index is
   * out of bounds.
   * @exception IllegalArgumentException if the child is
   * an ancestor of this node, since that would make
   * a cycle in the tree.
   */
  void insertChildAt(int index, SimpleTreeNode<E> child);

  /**
   * Removes this node, and all its descendants, from whatever
   * tree it is in.  Does nothing if this node is a root.
   */
  void removeFromParent();

  /**
   * Visits the nodes in this tree in preorder.
   */
  void traversePreorder(Visitor<E> visitor);

  /**
   * Visits the nodes in this tree in postorder.
   */
  void traversePostorder(Visitor<E> visitor);

  /**
   * Visits the nodes in this tree in breadth-first order.
   */
  void traverseBreadthFirst(Visitor<E> visitor);

  /**
   * Simple visitor interface.
   */
  public interface Visitor<E> {
    void visit(SimpleTreeNode<E> node);
  }
}