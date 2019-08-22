/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 *
 * @author wangcong
 * @version $Id: RemoveDuplicatesCharactersTest.java, v0.1 8/22/19 10:33 AM wangcong Exp $$
 */
public class RemoveDuplicatesCharactersTest {


    @Test
    public void testRemoveDuplicates() {

        assertThat(RemoveDuplicatesCharacters.removeDuplicates("geeksforgeeks")).isEqualTo("geksfor");
        assertThat(RemoveDuplicatesCharacters.removeDuplicates("characters")).isEqualTo("chartes");
        assertThat(RemoveDuplicatesCharacters.removeDuplicates("")).isEqualTo("");
        assertThat(RemoveDuplicatesCharacters.removeDuplicates("abcdefg")).isEqualTo("abcdefg");

    }


}
