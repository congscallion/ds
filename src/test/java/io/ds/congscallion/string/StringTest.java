/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: StringTest.java, v0.1 8/22/19 5:09 PM wangcong Exp $$
 */
public class StringTest {

    @Test
    public void test1() {

        String str2 = "abc";
        String str3 = new String("abc").intern();
        Assertions.assertThat(str2).isSameAs(str3);

        String str4 = new String("def");
        String str5 = new String("def").intern();
        Assertions.assertThat(str4).isNotSameAs(str5);


    }

}
