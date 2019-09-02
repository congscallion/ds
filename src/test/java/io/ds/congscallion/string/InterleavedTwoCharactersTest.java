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
 * @version $Id: InterleavedTwoCharacters.java, v0.1 8/22/19 10:58 AM wangcong Exp $$
 */
public class InterleavedTwoCharactersTest {


  @Test
  public void testInterleved() {

    assertThat(InterleavedTwoCharacters.isInterleaved("abc", "def", "dabecf")).isTrue();
    assertThat(InterleavedTwoCharacters.isInterleaved("AB", "CD", "ACBD")).isTrue();
//        assertThat(InterleavedTwoCharacters.isInterleaved("aab", "axy", "aaxaby")).isTrue();
//        assertThat(InterleavedTwoCharacters.isInterleaved("AA", "AB", "AABA")).isTrue();
//        assertThat(InterleavedTwoCharacters.isInterleaved("AB", "AD", "ADAB")).isTrue();
//        assertThat(InterleavedTwoCharacters.isInterleaved("AB", "AD", "ADAB")).isTrue();

  }


  @Test
  public void testInterleved2() {

    assertThat(InterleavedTwoCharacters.isInterleaved2("abc", "def", "dabecf")).isTrue();
    assertThat(InterleavedTwoCharacters.isInterleaved2("AB", "CD", "ACBD")).isTrue();
//        assertThat(InterleavedTwoCharacters.isInterleaved2("aab", "axy", "aaxaby")).isTrue();
//        assertThat(InterleavedTwoCharacters.isInterleaved2("AA", "AB", "AABA")).isTrue();
//        assertThat(InterleavedTwoCharacters.isInterleaved2("AB", "AD", "ADAB")).isTrue();
//        assertThat(InterleavedTwoCharacters.isInterleaved2("AB", "AD", "ADAB")).isTrue();

  }

}
