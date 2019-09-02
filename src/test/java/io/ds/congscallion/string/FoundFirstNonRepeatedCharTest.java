/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: FoundFirstNonRepeatedCharTest.java, v0.1 8/21/19 2:30 PM wangcong Exp $$
 */
public class FoundFirstNonRepeatedCharTest {


  @Test
  public void testFirstNonRepeatedCharacter() {
    assertEquals('b', FoundFirstNonRepeatedChar.firstNonRepeatedCharacter("abcdefghija"));
    assertEquals('h', FoundFirstNonRepeatedChar.firstNonRepeatedCharacter("hello"));
    assertEquals('J', FoundFirstNonRepeatedChar.firstNonRepeatedCharacter("Java"));
    assertEquals('i', FoundFirstNonRepeatedChar.firstNonRepeatedCharacter("simplest"));
  }

  @Test
  public void testFirstNonRepeatingChar() {
    assertEquals('b', FoundFirstNonRepeatedChar.firstNonRepeatingChar("abcdefghija"));
    assertEquals('h', FoundFirstNonRepeatedChar.firstNonRepeatingChar("hello"));
    assertEquals('J', FoundFirstNonRepeatedChar.firstNonRepeatingChar("Java"));
    assertEquals('i', FoundFirstNonRepeatedChar.firstNonRepeatingChar("simplest"));
  }

  @Test
  public void testGetFirstNonRepeatedChar() {
    assertEquals('b', FoundFirstNonRepeatedChar.getFirstNonRepeatedChar("abcdefghija"));
    assertEquals('h', FoundFirstNonRepeatedChar.getFirstNonRepeatedChar("hello"));
    assertEquals('J', FoundFirstNonRepeatedChar.getFirstNonRepeatedChar("Java"));
    assertEquals('i', FoundFirstNonRepeatedChar.getFirstNonRepeatedChar("simplest"));
  }


  @Test
  public void testFoundFirstNonRepeatedChar() {
    assertEquals('b', FoundFirstNonRepeatedChar.foundFirstNonRepeatedChar("abcdefghija"));
    assertEquals('h', FoundFirstNonRepeatedChar.foundFirstNonRepeatedChar("hello"));
    assertEquals('J', FoundFirstNonRepeatedChar.foundFirstNonRepeatedChar("Java"));
    assertEquals('i', FoundFirstNonRepeatedChar.foundFirstNonRepeatedChar("simplest"));
  }


}
