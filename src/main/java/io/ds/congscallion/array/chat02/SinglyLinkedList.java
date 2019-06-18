/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat02;

import java.util.Objects;

/**
 * 单向列表
 *
 * @author wangcong
 * @version $Id: SinglyLinkedList.java, v0.1 6/18/19 9:23 AM wangcong Exp $$
 */
public class SinglyLinkedList {

    //链表的头节点
    Node head;


    // 链表由节点组成， 定义节点
    static class Node {

        //这里示例，每个节点存储数组为一个数值
        int data;

        //指向下一个节点的引用
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }


    // 遍历链表
    @Override
    public String toString() {

        Node n = head;
        StringBuilder listStr = new StringBuilder("[");
        while (Objects.nonNull(n)) {
            listStr.append(n.data).append(",");
            n = n.next;
        }
        listStr.append("]");
        return listStr.toString();
    }

    /**
     * 在链表头部添加数据, 此操作的时间复杂度为o(1)
     */
    public void push(int data) {
        //创建节点
        Node new_node = new Node(data);
        //新节点的下一个节点引用指向原头节点
        new_node.next = head;
        //头节点引用新的节点
        head = new_node;
    }

    /**
     * 在指定节点后面插入新数据， 此操作的时间复杂为o(1)
     */
    public void insertAfter(Node prev, int data) {

        if (Objects.isNull(prev)) {
            throw new IllegalArgumentException("无效的节点 null");
        }

        Node new_node = new Node(data);
        //新节点的下一个节点指向原节点的下一个节点
        new_node.next = prev.next;
        //原节点的下一个节点指向新节点
        prev.next = new_node;
    }

    /**
     * 在链末添加新的数据，此操作时间复杂度是o(n)， 由链表节点数量决定
     */
    public void add(int data) {

        Node new_node = new Node(data);

        if (Objects.isNull(head)) {
            head = new_node;
            return;
        }

        //遍历链表，找到最后一个节点（下一节点值为null即为链尾）
        Node last = head;
        while (Objects.nonNull(last.next)) {
            last = last.next;
        }

        //将原链尾的节点下一节点引用指向新的节点
        last.next = new_node;
    }


    public static void main(String[] args) {

        //创建一个链表
        SinglyLinkedList sllist = new SinglyLinkedList();

        //创建三个节点
        Node first = new Node(1);
        Node second = new Node(2);
        Node thrid = new Node(3);

        //给链表设置头节点
        sllist.head = first;

        //给链表设置第二节点，即头节点的下一个节点
        first.next = second;

        //设置第三个节点
        second.next = thrid;

        //打印链表
        System.out.println(sllist.toString());

        // 创建链表对象
        SinglyLinkedList list = new SinglyLinkedList();

        list.push(3);
        list.push(2);
        list.push(1);

        Node tmp = list.head.next.next;
        list.insertAfter(tmp, 4);
        list.insertAfter(tmp.next, 5);

        list.add(6);
        list.add(7);
        list.add(8);

        System.out.println(list.toString());
    }


}
