/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.stack;

/**
 * 使用链表实现Stack
 *
 * @author wangcong
 * @version $Id: StackAsLinkedList.java, v0.1 7/11/19 8:28 AM wangcong Exp $$
 */
public class StackAsLinkedList {

    StackNode root;

    public boolean isEmpty() {
        return null == root;
    }

    public void push(int data) {

        StackNode newNode = new StackNode(data);

        if (null == root) {
            root = newNode;
        } else {

            StackNode temp = root;
            root = newNode;
            newNode.next = temp;

        }


    }

    public int pop() {

        if (null == root) {
            return Integer.MIN_VALUE;
        } else {

            StackNode temp = root;

            root = temp.next;

            return temp.data;
        }


    }

    public int peek() {
        if (null == root) {
            return Integer.MIN_VALUE;
        } else {
            return root.data;
        }
    }

    static class StackNode {

        int data;
        StackNode next;

        public StackNode(int data) {
            this.data = data;
        }

        public StackNode(int data, StackNode next) {
            this.data = data;
            this.next = next;
        }
    }


}
