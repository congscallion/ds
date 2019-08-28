/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.collections.tree;

/**
 *
 * 最小堆
 *
 *
 * @author wangcong
 * @version $Id: MinHeap.java, v0.1 8/28/19 4:51 PM wangcong Exp $$
 */
public class MinHeap<E extends Comparable> extends AbstractHeap<E> {


    public MinHeap(int capacity) {
        super(capacity);
    }

    @Override
    protected void insert(E e) {

        if (size >= capacity) {
            return;
        }

        heap[++size] = e;

        int current = size;

        while ((current >= 1) && (parentOf(current) >= 1) && less(current, parentOf(current))) {
            swap(current, parentOf(current));
            current = parentOf(current);
        }

    }


    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();

    }


}
