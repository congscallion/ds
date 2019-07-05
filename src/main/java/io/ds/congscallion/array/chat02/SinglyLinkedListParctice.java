///**
// * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
// */
//package io.ds.congscallion.array.chat02;
//
//import java.util.Objects;
//
///**
// * 单向列表常见算法问题实践
// *
// * @author wangcong
// * @version $Id: SinglyLinkedListParctice.java, v0.1 6/20/19 8:30 AM wangcong Exp $$
// */
//public class SinglyLinkedListParctice {
//
//    /**
//     * 为了不与SinglyLinkedList类混淆， 此类仍声明完整的链表结构
//     */
//
//    private Node head;
//
//
//    private static class Node {
//
//        int data;
//        Node next;
//
//        public Node(int data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    public void add(int data) {
//
//        Node new_node = new Node(data);
//
//        if (Objects.isNull(head)) {
//            head = new_node;
//            return;
//        }
//
//        //遍历链表，找到最后一个节点（下一节点值为null即为链尾）
//        Node last = head;
//        while (Objects.nonNull(last.next)) {
//            last = last.next;
//        }
//
//        //将原链尾的节点下一节点引用指向新的节点
//        last.next = new_node;
//    }
//
//    // 遍历链表
//    @Override
//    public String toString() {
//
//        Node n = head;
//        StringBuilder listStr = new StringBuilder("[");
//        while (Objects.nonNull(n)) {
//            listStr.append(n.data).append(",");
//            n = n.next;
//        }
//        listStr.append("]");
//        return listStr.toString();
//    }
//
//
//    /**
//     * 实践一： 找出链表的中间元素
//     *
//     * <p>
//     * 这样定义链表的中间元素：
//     *
//     * 1、 链表长度是奇数，则中间元素左右两边元素数目相等。 比如： 1->2->3->4->5， 则输出是3。
//     *
//     * 2、链表长度是偶数， 则中间元素有两个，应输出第二个。 比如： 1->2->3->4->5->6， 则输出4。
//     * </p>
//     *
//     * 方法一
//     *
//     * 此方法使用迭代实现
//     *
//     * 第一次统计链表长度count， 第二次迭代至count/2位置，返回该位置元素，即为该链表中间元素。
//     */
//    public int searchMiddleElement() {
//
//        if (Objects.isNull(head)) {
//            throw new IllegalArgumentException("list can't empty!");
//        }
//
//        int count = 0;
//        Node temp = head;
//        while (Objects.nonNull(temp)) {
//            count++;
//            temp = temp.next;
//        }
//
//        int mid = count >>> 1;
//
//        temp = head;
//        for (int i = 0; i < mid; i++) {
//            temp = temp.next;
//        }
//        return temp.data;
//    }
//
//    /**
//     * 方法二：
//     *
//     * 1、使用两个下标， faster_index, slow_index
//     *
//     * 2、faster_index每次后移两个2个位置，slow_index每次后移一个位置。
//     *
//     * 3、faster_index移到链尾后，slow_index所在位置为链表中间元素位置。
//     */
//    public int searchMiddleElement2() {
//
//        if (Objects.isNull(head)) {
//            throw new IllegalArgumentException("list can't empty!");
//        }
//
//        Node faster_index = head;
//        Node slow_index = head;
//        while (Objects.nonNull(faster_index) && Objects.nonNull(faster_index.next)) {
//            faster_index = faster_index.next.next;
//            slow_index = slow_index.next;
//        }
//
//        return slow_index.data;
//    }
//
//
//    /**
//     * 方法三：
//     *
//     * 1、 使用两个Node变量，与一个 int count变量 。
//     *
//     * 2、 每循环一次，count递增，temp变量更新为temp.next. 但只有count为奇数时， mid变量更新成mid.next值。
//     *
//     * 3、 这样，mid变量直经历了链表一半长度。
//     */
//    public int searchMiddleElement3() {
//        Node mid = head;
//        Node temp = head;
//
//        int count = 0;
//
//        while (Objects.nonNull(temp)) {
//            if ((count & 1) == 1) {
//                mid = mid.next;
//            }
//            temp = temp.next;
//            count++;
//        }
//
//        return mid.data;
//    }
//
//
//}
