/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示树的节点对象
 *
 * @author wangcong
 * @version $Id: Node.java, v0.1 7/15/19 2:40 PM wangcong Exp $$
 */
public class Node<T> {

    // 节点存储数据
    private T data;
    // 节点的直接子节点
    private List<Node<T>> children = new ArrayList<>();
    // 该节点的父节点
    private Node<T> parent = null;

    public Node(T data) {
        this.data = data;
    }


    public Node<T> setChild(Node<T> child) {
        child.parent = this;
        this.children.add(child);
        return child;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        for (int i = 0; i < children.size(); i++) {
            children.get(i).parent.setParent(this);
        }
        children.addAll(children);
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}
