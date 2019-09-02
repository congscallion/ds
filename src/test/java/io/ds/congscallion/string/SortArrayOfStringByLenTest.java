/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: SortArrayOfStringByLenTest.java, v0.1 8/22/19 4:32 PM wangcong Exp $$
 */
public class SortArrayOfStringByLenTest {


  @Test
  public void testSort() {

    String[] arr = {"GeeksforGeeeks", "I", "from", "am"};
    assertThat(Arrays.toString(SortArrayOfStringByLen.sort(arr)))
        .isEqualTo("[I, am, from, GeeksforGeeeks]");


  }


}
