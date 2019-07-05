///**
// * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
// */
//package io.ds.congscallion.array.chat02;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.stream.IntStream;
//import org.junit.Test;
//
///**
// * @author wangcong
// * @version $Id: SinglyLinkedListTest.java, v0.1 6/19/19 3:23 PM wangcong Exp $$
// */
//public class SinglyLinkedListTest {
//
//
//    @Test
//    public void testRemove() {
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        assertThat(list.toString()).isEqualTo("[1,2,3,4,]");
//
//        list.remove(2);
//        assertThat(list.toString()).isEqualTo("[1,3,4,]");
//
//        boolean success = list.remove(5);
//        assertThat(list.toString()).isEqualTo("[1,3,4,]");
//        assertThat(success).isFalse();
//
//        list.add(6);
//        assertThat(list.toString()).isEqualTo("[1,3,4,6,]");
//    }
//
//    @Test
//    public void testRemoveByPosition() {
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        assertThat(list.toString()).isEqualTo("[1,2,3,4,]");
//
//        list.removeByPosition(2);
//        assertThat(list.toString()).isEqualTo("[1,2,4,]");
//
//        list.add(6);
//        list.add(7);
//        list.add(78);
//        assertThat(list.toString()).isEqualTo("[1,2,4,6,7,78,]");
//
//        boolean success = list.removeByPosition(6);
//        assertThat(success).isFalse();
//
//        success = list.removeByPosition(7);
//        assertThat(success).isFalse();
//        assertThat(list.toString()).isEqualTo("[1,2,4,6,7,78,]");
//
//        list.removeByPosition(5);
//        assertThat(list.toString()).isEqualTo("[1,2,4,6,7,]");
//
//    }
//
//
//    @Test
//    public void testGetCount() {
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.add(1);
//        assertThat(list.getCount()).isEqualTo(1);
//        assertThat(list.getCount2()).isEqualTo(1);
//
//        IntStream.range(1, 100).forEach(i -> list.add(i));
//        assertThat(list.getCount()).isEqualTo(100);
//        assertThat(list.getCount2()).isEqualTo(100);
//
//        list.removeByPosition(22);
//        assertThat(list.getCount()).isEqualTo(99);
//        assertThat(list.getCount2()).isEqualTo(99);
//    }
//
//
//    @Test
//    public void testIndexOf() {
//        SinglyLinkedList list = new SinglyLinkedList();
//
//        assertThat(list.indexOf(1)).isEqualTo(-1);
//        assertThat(list.indexOf2(1)).isEqualTo(-1);
//
//        IntStream.rangeClosed(1, 10).forEach(i -> list.add(i));
//
//        assertThat(list.indexOf(1)).isEqualTo(0);
//        assertThat(list.indexOf2(1)).isEqualTo(0);
//
//        assertThat(list.indexOf(2)).isEqualTo(1);
//        assertThat(list.indexOf2(2)).isEqualTo(1);
//
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            assertThat(list.indexOf(i)).isEqualTo(i - 1);
//            assertThat(list.indexOf2(i)).isEqualTo(i - 1);
//        });
//
//        assertThat(list.indexOf(11)).isEqualTo(-1);
//        assertThat(list.indexOf2(11)).isEqualTo(-1);
//
//    }
//
//
//    @Test
//    public void testGet() {
//        SinglyLinkedList list = new SinglyLinkedList();
//        IntStream.rangeClosed(1, 100).forEach(i -> list.add(i));
//
//        IntStream.rangeClosed(0, 99).forEach(i -> {
//            assertThat(list.get(i)).isEqualTo(i + 1);
//            assertThat(list.get2(i)).isEqualTo(i + 1);
//        });
//    }
//
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void testGet2() {
//        SinglyLinkedList list = new SinglyLinkedList();
//        IntStream.rangeClosed(1, 10).forEach(i -> list.add(i));
//
//        list.get(-1);
//        list.get(10);
//        list.get2(-1);
//        list.get2(10);
//    }
//
//}
