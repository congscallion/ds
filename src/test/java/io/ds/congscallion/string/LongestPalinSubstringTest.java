/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: LongestPalinSubstringTest.java, v0.1 8/22/19 2:58 PM wangcong Exp $$
 */
public class LongestPalinSubstringTest {


  @Test
  public void testLpss() {

    assertThat(LongestPalinSubstring.lpss("forgeeksskeegfor"))
        .isEqualTo("geeksskeeg");

    assertThat(LongestPalinSubstring.lpss("geeksskeeg"))
        .isEqualTo("geeksskeeg");

    assertThat(LongestPalinSubstring.lpss("ab")).isEqualTo("#");


  }

  @Test
  public void testLpss2() {
    assertThat(LongestPalinSubstring.lpss2("forgeeksskeegfor"))
        .isEqualTo("geeksskeeg");

    assertThat(LongestPalinSubstring.lpss2("geeksskeeg"))
        .isEqualTo("geeksskeeg");

    assertThat(LongestPalinSubstring.lpss2("ab")).isEqualTo("#");
  }

}
