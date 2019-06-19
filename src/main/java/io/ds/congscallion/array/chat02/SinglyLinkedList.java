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


    /**
     * 删除指定数据
     *
     * @param data 被删除的数据
     * @return true, 成功删除数据； 未找到或失败返回false
     */
    public boolean remove(int data) {

        // 被删除节点的前一节点
        Node prev = null;
        // 被删除节点
        Node temp = head;

        // 判断Head节点值是否与被删除数据相等
        if (Objects.nonNull(temp) && data == temp.data) {
            head = temp.next;
            return true;
        }

        // 被删除的数据不在表头，则遍历链表
        while (Objects.nonNull(temp) && (data != temp.data)) {
            prev = temp;
            temp = temp.next;
        }

        // 未找到指定数据
        if (Objects.isNull(temp)) {
            return false;
        }

        // 找到被删除的节点， 修改前节点的连接为被删除节点的下一节点
        prev.next = temp.next;

        return true;
    }


    /**
     * 删除指定的位置的数据
     *
     * @param position 被删除位置
     * @return true，成功删除数据； 其它，false.
     */
    public boolean removeByPosition(int position) {

        // 空链表
        if (Objects.isNull(head)) {
            return false;
        }

        Node temp = head;
        // 删除表头
        if (position == 0) {
            head = temp.next;
            return true;
        }

        // 遍历链表， 找到被删除除节点.
        // 与链表长度相等，最后一次遍历的Node为链尾
        // 如果超过链表长度，最后一次遍历的Node为链尾下一节点的Null引用
        for (int i = 0; Objects.nonNull(temp) && i < position - 1; i++) {
            temp = temp.next;
        }

        // 排除链表长度之外的位置
        if (Objects.isNull(temp) || Objects.isNull(temp.next)) {
            return false;
        }

        // 被删除节点
        Node del = temp.next;

        // 被删除节点的下一节点
        Node next = del.next;

        // 设置新的引用
        temp.next = next;

        return true;

    }

    /**
     * 删除整个列表
     *
     * 只需要将表头设置为null即可， 剩余节点垃圾回收器自动处理。
     */
    public void deleteList() {
        head = null;
    }

    /**
     * 计算链表的长度 即统计一个链表包含节点的数量
     *
     * 使用迭代的方式实现
     */
    public int getCount() {
        int count = 0;
        Node temp = head;

        while (Objects.nonNull(temp)) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 使用递归的方式计算链表的长度
     */
    public int getCount2() {
        return getCount0(head);
    }

    private int getCount0(Node node) {

        // 跳出递归条件
        if (Objects.isNull(node)) {
            return 0;
        }

        return 1 + getCount0(node.next);
    }

    /**
     * 搜索指定值在链表中的位置。 如果链表不包含其值，则返回-1.
     *
     * 使用迭代实现
     */
    public int indexOf(int data) {

        int position = 0;
        Node temp = head;

        // 空链表
        if (Objects.isNull(temp)) {
            return -1;
        }

        while (Objects.nonNull(temp) && (temp.data != data)) {
            position++;
            temp = temp.next;
        }

        // 未找到包含指定数据的节点
        if (Objects.isNull(temp)) {
            return -1;
        }

        return position;
    }

    /**
     * 搜索指定值在链表中的位置。 如果链表不包含其值，则返回-1.
     *
     * 使用递归的方式实现
     */
    public int indexOf2(int data) {
        // 空链表
        if (Objects.isNull(head)) {
            return -1;
        }

        try {
            return indexOf0(head, data);
        } catch (AssertionError e) {
            if ("IndexOutOfBounds".equals(e.getMessage())) {
                return -1;
            }

            throw e;
        }
    }

    private int indexOf0(Node node, int data) {

        // 节点是null,表示已到链尾
        assert (Objects.nonNull(node)) : "IndexOutOfBounds";

        // 找到数据, 跳出递归
        if (node.data == data) {
            return 0;
        }

        return 1 + indexOf0(node.next, data);
    }


    /**
     * 返回链表中指定位置的元素
     *
     * 用迭代实现
     */
    public int get(int position) {

        if (position < 0) {
            throw new IndexOutOfBoundsException("无效的index " + position);
        }

        Node temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }

        if (Objects.isNull(temp)) {
            throw new IndexOutOfBoundsException("无效的index " + position);
        }

        return temp.data;
    }

    /**
     * 返回链表中指定位置的元素
     *
     * 用递归实现
     */
    public int get2(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("无效的index " + position);
        }

        try {
            return get0(head, position);
        } catch (AssertionError error) {
            if ("IndexOutOfBounds".equals(error.getMessage())) {
                throw new IndexOutOfBoundsException("无效的index " + position);
            }

            throw error;
        }

    }

    private int get0(Node node, int position) {

        assert Objects.nonNull(node) : "IndexOutOfBounds";

        if (position == 0) {
            return node.data;
        }

        return get0(node.next, --position);
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
