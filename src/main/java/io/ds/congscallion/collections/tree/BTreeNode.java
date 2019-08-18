/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 代表B树的节点
 *
 *
 * @author wangcong
 * @version $Id: BTreeNode.java, v0.1 8/14/19 5:14 PM wangcong Exp $$
 */
public class BTreeNode<T extends Comparable<T>> {


    // 节点存储的数据项列表
    private T[] keys;

    // 节点存储的数据项数量
    private int keysSize = 0;

    // 当前节点的子节点引用
    private BTreeNode<T>[] children = null;

    // 子节点的数量
    private int childrenSize = 0;

    // 节点大小比较器
    private Comparator<BTreeNode<T>> comparator = new Comparator<BTreeNode<T>>() {
        @Override
        public int compare(BTreeNode<T> arg0, BTreeNode<T> arg1) {
            return 0;
        }
    };

    // 当前节点的父节点
    private BTreeNode<T> parent;

    private BTreeNode(BTreeNode<T> parent, int maxKeySize, int maxChildrenSize) {

        this.parent = parent;
        this.keys = (T[]) new Comparable[maxKeySize + 1];
        this.keysSize = 0;
        this.children = new BTreeNode[maxChildrenSize + 1];
        this.childrenSize = 0;

    }


    int numberOfKeys() {
        return keysSize;
    }

    int numberOfChildren() {
        return childrenSize;
    }

    T getKey(int index) {
        return keys[index];
    }

    int indexOf(T value) {
        for (int i = 0; i < keysSize; i++) {
            if (keys[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    void addKey(T value) {
        keys[keysSize++] = value;
        Arrays.sort(keys, 0, keysSize);
    }


}
