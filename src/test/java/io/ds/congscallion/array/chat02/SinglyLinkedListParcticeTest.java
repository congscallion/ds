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
// * @version $Id: SinglyLinkedListParcticeTest.java, v0.1 6/20/19 11:20 AM wangcong Exp $$
// */
//public class SinglyLinkedListParcticeTest {
//
//    @Test
//    public void testCreate() {
//        SinglyLinkedListParctice list = new SinglyLinkedListParctice();
//        IntStream.rangeClosed(1, 10).forEach(i -> list.add(i));
//
//        assertThat(list.toString()).isEqualTo("[1,2,3,4,5,6,7,8,9,10,]");
//    }
//
//    @Test
//    public void TestsearchMiddleElement() {
//        SinglyLinkedListParctice list = new SinglyLinkedListParctice();
//        list.add(5);
//
//        int midVal = list.searchMiddleElement();
//        assertThat(midVal).isEqualTo(5);
//
//        list.add(4);
//        midVal = list.searchMiddleElement();
//        assertThat(midVal).isEqualTo(4);
//
//        list.add(3);
//        midVal = list.searchMiddleElement();
//        assertThat(midVal).isEqualTo(4);
//
//        list.add(2);
//        midVal = list.searchMiddleElement();
//        assertThat(midVal).isEqualTo(3);
//
//        list.add(1);
//        midVal = list.searchMiddleElement();
//        assertThat(midVal).isEqualTo(3);
//
//        list.add(0);
//        midVal = list.searchMiddleElement();
//        assertThat(midVal).isEqualTo(2);
//    }
//
//    @Test
//    public void TestsearchMiddleElement2() {
//        SinglyLinkedListParctice list = new SinglyLinkedListParctice();
//        list.add(5);
//
//        int midVal = list.searchMiddleElement2();
//        assertThat(midVal).isEqualTo(5);
//
//        list.add(4);
//        midVal = list.searchMiddleElement2();
//        assertThat(midVal).isEqualTo(4);
//
//        list.add(3);
//        midVal = list.searchMiddleElement2();
//        assertThat(midVal).isEqualTo(4);
//
//        list.add(2);
//        midVal = list.searchMiddleElement2();
//        assertThat(midVal).isEqualTo(3);
//
//        list.add(1);
//
//        midVal = list.searchMiddleElement2();
//        assertThat(midVal).isEqualTo(3);
//
//        list.add(0);
//        midVal = list.searchMiddleElement2();
//        assertThat(midVal).isEqualTo(2);
//
//    }
//
//
//    @Test
//    public void searchMiddleElement3() {
//
//        SinglyLinkedListParctice list = new SinglyLinkedListParctice();
//        list.add(1);
//
//        int midVal = list.searchMiddleElement3();
//        assertThat(midVal).isEqualTo(1);
//
//        list.add(2);
//        midVal = list.searchMiddleElement3();
//        assertThat(midVal).isEqualTo(2);
//
//        list.add(3);
//        midVal = list.searchMiddleElement3();
//        assertThat(midVal).isEqualTo(2);
//
//        list.add(4);
//        midVal = list.searchMiddleElement3();
//        assertThat(midVal).isEqualTo(3);
//
//        list.add(5);
//
//        midVal = list.searchMiddleElement3();
//        assertThat(midVal).isEqualTo(3);
//
//        list.add(6);
//        midVal = list.searchMiddleElement3();
//        assertThat(midVal).isEqualTo(4);
//
//    }
//
//
//}
