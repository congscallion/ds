/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: StringReverseTest.java, v0.1 8/21/19 2:50 PM wangcong Exp $$
 */
public class StringReverseTest {


    @Test
    public void testReverse() {

        assertThat(StringReverse.reverse("asdfg")).isEqualTo("gfdsa");
        assertThat(StringReverse.reverse("asdfghjkl")).isEqualTo("lkjhgfdsa");
        assertThat(StringReverse.reverse("qwertyu")).isEqualTo("uytrewq");

    }


    @Test
    public void testResverse2() {
        assertThat(StringReverse.reverse2("asdfg")).isEqualTo("gfdsa");
        assertThat(StringReverse.reverse2("asdfghjkl")).isEqualTo("lkjhgfdsa");
        assertThat(StringReverse.reverse2("qwertyu")).isEqualTo("uytrewq");
    }


    @Test
    public void testResverseRecurively() {
        assertThat(StringReverse.reverseRecursively("asdfg")).isEqualTo("gfdsa");
        assertThat(StringReverse.reverseRecursively("asdfghjkl")).isEqualTo("lkjhgfdsa");
        assertThat(StringReverse.reverseRecursively("qwertyu")).isEqualTo("uytrewq");
    }




}
