package io.ds.example.collections;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A simple class for tree nodes, implemented with direct links
 * to its parent and its list of children.
 */
public class ChildListTreeNode<E> implements SimpleTreeNode<E> {

    private E data;
    private ChildListTreeNode<E> parent = null;
    private LinkedList<ChildListTreeNode<E>> children =
            new LinkedList<ChildListTreeNode<E>>();

    /**
     * Constructs a node as the root of its own one-element tree.
     * This is the only public constructor.  The only trees that
     * clients can make directly are simple one-element trees.
     */
    public ChildListTreeNode(E data) {
        this.data = data;
    }

    /**
     * Returns the data stored in this node.
     */
    public E getData() {
        return data;
    }

    /**
     * Modifies the data stored in this node.
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Returns the parent of this node, or null if this node is a root.
     */
    public SimpleTreeNode<E> getParent() {
        return parent;
    }

    /**
     * Returns the children of this node as a list of nodes.  The returned
     * list is read-only to prevent callers from inserting garbage into
     * the actual list of children in the tree!
     */
    public List<? extends SimpleTreeNode<E>> getChildren() {
        return Collections.unmodifiableList(children);
    }

    /**
     * Removes child from its current parent and inserts it
     * at the given index of this node.  Indices start at 0.
     * @exception IndexOutOfBoundsException if the index is
     * out of bounds.
     * @exception IllegalArgumentException if the child is
     * an ancestor of this node, since that would make
     * a cycle in the tree.
     * @exception ClassCastException if child is not a
     * ChildListTreeNode.
     */
    public void insertChildAt(int index, SimpleTreeNode<E> child) {

        // Ensure the child is not an ancestor.
        for (ChildListTreeNode node = this; node != null; node = node.parent) {
            if (node == child) {
                throw new IllegalArgumentException();
            }
        }

        // Ensure that the child is an instance of ChildListTreeNode.
        ChildListTreeNode<E> childNode = (ChildListTreeNode<E>) child;

        // Add the child to this node's child list, unhook child from
        // its old parent and reparent to this node.
        children.add(index, childNode);
        if (childNode != null) {
            childNode.removeFromParent();
            childNode.parent = this;
        }
    }

    /**
     * Removes this node, and all its descendants, from whatever
     * tree it is in.  Does nothing if this node is a root.
     */
    public void removeFromParent() {
        if (parent != null) {
            parent.children.remove(this);
            this.parent = null;
        }
    }

    /**
     * Visits the nodes in this tree in preorder.
     */
    public void traversePreorder(SimpleTreeNode.Visitor<E> visitor) {
        visitor.visit(this);
        for (SimpleTreeNode<E> child : children) {
            child.traversePreorder(visitor);
        }
    }

    /**
     * Visits the nodes in this tree in postorder.
     */
    public void traversePostorder(SimpleTreeNode.Visitor<E> visitor) {
        for (SimpleTreeNode<E> child : children) {
            child.traversePostorder(visitor);
        }
        visitor.visit(this);
    }

    /**
     * Visits the nodes in this tree in breadth-first order.
     */
    public void traverseBreadthFirst(SimpleTreeNode.Visitor<E> visitor) {
        Queue<ChildListTreeNode<E>> queue = new LinkedList<ChildListTreeNode<E>>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            visitor.visit(queue.remove());
            for (ChildListTreeNode<E> node : children) {
                queue.offer(node);
            }
        }
    }
}