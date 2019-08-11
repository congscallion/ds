/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author wangcong
 * @version $Id: StackByArrayTest.java, v0.1 7/8/19 9:48 AM wangcong Exp $$
 */
public class StackByArrayTest {


  @Test
  public void testPush() {

    StackByArray stackByArray = new StackByArray();

    assertThat(stackByArray.isEmpty()).isTrue();

    for (int i = 0; i < 100; i++) {
      stackByArray.push(i);
    }

    assertThat(stackByArray.isEmpty()).isFalse();

    assertThat(stackByArray.peek()).isEqualTo(99);


  }


}
