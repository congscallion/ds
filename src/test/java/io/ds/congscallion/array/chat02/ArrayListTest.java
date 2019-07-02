/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat02;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: ArrayListTest.java, v0.1 7/1/19 8:44 AM wangcong Exp $$
 */
public class ArrayListTest {


    @Test
    public void testRetainAll(){

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("h");




        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("e");
        list2.add("f");
        list2.add("h");

        Assertions.assertThat(list1.retainAll(list2)).isTrue();
        Assertions.assertThat(list1.toString()).isEqualTo("[a, b, h]");


    }

    @Test
    public void testSubList(){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("h");

        List<String> subList = list1.subList(1, 4);
        Assertions.assertThat(subList.toString()).isEqualTo("[b, c, d]");


        subList.clear();

        Assertions.assertThat(list1.toString()).isEqualTo("[a, h]");

    }



}
