/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: FindMissingNumberTest.java, v0.1 8/23/19 11:16 AM wangcong Exp $$
 */
public class FindMissingNumberTest {

    @Test
    public void testFindOneMissingNum() {

        int[] arr = {1, 2, 3, 5, 6, 7, 8};
        assertThat(FindMissingNumber.findOneMissingNum(arr)).isEqualTo(4);


    }

}
