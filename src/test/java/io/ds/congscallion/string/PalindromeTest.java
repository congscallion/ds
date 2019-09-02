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
 * @version $Id: PalindromeTest.java, v0.1 8/22/19 9:55 AM wangcong Exp $$
 */
public class PalindromeTest {

  @Test
  public void testReverse() {

    assertThat(Palindrome.reverse("abcd")).isEqualTo("dcba");
    assertThat(Palindrome.reverse("qwertyuiop")).isEqualTo("poiuytrewq");

  }


  @Test
  public void testPalindrome() {

    assertThat(Palindrome.isPalindrome("abba")).isTrue();
    assertThat(Palindrome.isPalindrome("abbc")).isFalse();
    assertThat(Palindrome.isPalindrome("ioooi")).isTrue();
    assertThat(Palindrome.isPalindrome("iooo1")).isFalse();
    assertThat(Palindrome.isPalindrome("")).isTrue();

  }

}
