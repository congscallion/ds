/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat01;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author wangcong
 * @version $Id: ArraysTest.java, v0.1 6/5/19 9:14 AM wangcong Exp $$
 */
public class ArraysTest {


    @Test
    public void testBinarySearch() {

        double[] a = {10.0d, 11.02d, 121.132d, 1891.3432423d};
        int index = Arrays.binarySearch(a, 0, a.length, 10.0d);
        Assertions.assertThat(index == 0).isTrue();
        index = Arrays.binarySearch(a, 0, a.length, 1891.3432423d);
        Assertions.assertThat(index == 3).isTrue();
        index = Arrays.binarySearch(a, 0, a.length, 1891.2d);
        Assertions.assertThat(index < 0).isTrue();

    }








}
