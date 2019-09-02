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
 * @version $Id: ReplaceSpacesTest.java, v0.1 8/21/19 5:39 PM wangcong Exp $$
 */
public class ReplaceSpacesTest {


  @Test
  public void testReplaceSpaces() {

    assertThat(ReplaceSpaces.replaceSpaces("a b c d", "%20")).isEqualTo("a%20b%20c%20d");
    assertThat(ReplaceSpaces.replaceSpaces("a b c d ", "%%%")).isEqualTo("a%%%b%%%c%%%d");
    assertThat(ReplaceSpaces.replaceSpaces(" a b c d", "%21")).isEqualTo("%21a%21b%21c%21d");

  }


}
