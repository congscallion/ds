/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: StringAnagramTest.java, v0.1 8/21/19 11:40 AM wangcong Exp $$
 */
public class StringAnagramTest {


  @Test
  public void testIsAnagram() {
    assertTrue(AnagramCheck.isAnagram("word", "wrdo"));
    assertTrue(AnagramCheck.isAnagram("mary", "army"));
    assertTrue(AnagramCheck.isAnagram("stop", "tops"));
    assertTrue(AnagramCheck.isAnagram("boat", "btoa"));
    assertFalse(AnagramCheck.isAnagram("pure", "in"));
    assertFalse(AnagramCheck.isAnagram("fill", "fil"));
    assertFalse(AnagramCheck.isAnagram("b", "bbb"));
    assertFalse(AnagramCheck.isAnagram("ccc", "ccccccc"));
    assertTrue(AnagramCheck.isAnagram("a", "a"));
    assertFalse(AnagramCheck.isAnagram("sleep", "slep"));

  }

  @Test
  public void testIAnagram() {
    assertTrue(AnagramCheck.isAnagram2("word", "wrdo"));
    assertTrue(AnagramCheck.isAnagram2("boat", "btoa"));
    assertFalse(AnagramCheck.isAnagram2("pure", "in"));
    assertFalse(AnagramCheck.isAnagram2("fill", "fil"));
    assertTrue(AnagramCheck.isAnagram2("a", "a"));
    assertFalse(AnagramCheck.isAnagram2("b", "bbb"));
    assertFalse(AnagramCheck.isAnagram2("ccc", "ccccccc"));
    assertFalse(AnagramCheck.isAnagram2("sleep", "slep"));

  }


}
