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
 * @version $Id: CountCharactersTest.java, v0.1 8/21/19 4:51 PM wangcong Exp $$
 */
public class CountCharactersTest {


    @Test
    public void testCountOccurrencesOf() {

        assertThat(CountCharacters.countOccurrencesOf("abcdefghijklmn", "a")).isEqualTo(1);
        assertThat(CountCharacters.countOccurrencesOf("java", "a")).isEqualTo(2);
        assertThat(CountCharacters.countOccurrencesOf("asdfasdfasdfasdfasdfhjkl", "asdf")).isEqualTo(5);


    }

}
