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
 * @version $Id: StringRegularExpressionTest.java, v0.1 8/21/19 3:26 PM wangcong Exp $$
 */
public class StringRegularExpressionTest {


    @Test
    public void testIsDigit1() {

        assertThat(StringRegularExpression.isDigit("123")).isTrue();
        assertThat(StringRegularExpression.isDigit("40")).isTrue();
        assertThat(StringRegularExpression.isDigit("-123")).isFalse();
        assertThat(StringRegularExpression.isDigit("123.12")).isFalse();
        assertThat(StringRegularExpression.isDigit("123b")).isFalse();
        assertThat(StringRegularExpression.isDigit("abc123")).isFalse();

    }


    @Test
    public void testIsDigit2() {

        assertThat(StringRegularExpression.isDigit2("123")).isTrue();
        assertThat(StringRegularExpression.isDigit2("40")).isTrue();
        assertThat(StringRegularExpression.isDigit2("-123")).isFalse();
        assertThat(StringRegularExpression.isDigit2("123.12")).isFalse();
        assertThat(StringRegularExpression.isDigit2("123b")).isFalse();
        assertThat(StringRegularExpression.isDigit2("abc123")).isFalse();
    }


    @Test
    public void testIsDigit3() {

        assertThat(StringRegularExpression.isDigit3("123")).isTrue();
        assertThat(StringRegularExpression.isDigit3("40")).isTrue();
        assertThat(StringRegularExpression.isDigit3("-123")).isFalse();
        assertThat(StringRegularExpression.isDigit3("123.12")).isFalse();
        assertThat(StringRegularExpression.isDigit3("123b")).isFalse();
        assertThat(StringRegularExpression.isDigit3("abc123")).isFalse();
    }


    @Test
    public void testIsDigit4() {

        assertThat(StringRegularExpression.isDigit4("123")).isTrue();
        assertThat(StringRegularExpression.isDigit4("40")).isTrue();
        assertThat(StringRegularExpression.isDigit4("-123")).isFalse();
        assertThat(StringRegularExpression.isDigit4("123.12")).isFalse();
        assertThat(StringRegularExpression.isDigit4("123b")).isFalse();
        assertThat(StringRegularExpression.isDigit4("abc123")).isFalse();
    }


    @Test
    public void testIsStringOnlyAlphabet() {

        assertThat(StringRegularExpression.isStringOnlyAlphabet("123")).isFalse();
        assertThat(StringRegularExpression.isStringOnlyAlphabet("a23")).isFalse();
        assertThat(StringRegularExpression.isStringOnlyAlphabet("abc")).isTrue();
        assertThat(StringRegularExpression.isStringOnlyAlphabet("ABC")).isTrue();
        assertThat(StringRegularExpression.isStringOnlyAlphabet("Abc")).isTrue();

    }


}
