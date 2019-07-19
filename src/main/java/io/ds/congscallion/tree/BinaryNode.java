/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.tree;

import java.util.Comparator;

/**
 * 本类用于表示二叉数节点
 *
 * @author wangcong
 * @version $Id: BinaryNode.java, v0.1 7/15/19 6:40 PM wangcong Exp $$
 */
public class BinaryNode<T extends Comparable> {

    // 节点数据
    private T data;
    // 左节点
    private BinaryNode<T> left;
    // 右节点
    private BinaryNode<T> right;

    public BinaryNode(T data) {
        this.data = data;
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

}
