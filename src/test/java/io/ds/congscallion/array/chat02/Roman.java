///**
// * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
// */
//package io.ds.congscallion.array.chat02;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Pattern;
//import org.junit.Test;
//
///**
// * @author wangcong
// * @version $Id: Roman.java, v0.1 6/21/19 10:31 AM wangcong Exp $$
// */
//public class Roman {
//
//    @Test
//    public void test1() {
//
//        System.out.println(romanToInt("I"));
//        System.out.println(romanToInt("V"));
//        System.out.println(romanToInt("X"));
//        System.out.println(romanToInt("L"));
//        System.out.println(romanToInt("C"));
//        System.out.println(romanToInt("D"));
//        System.out.println(romanToInt("M"));
//        System.out.println(romanToInt("IV"));
//        System.out.println(romanToInt("VI"));
//        System.out.println(romanToInt("XIX"));
//        System.out.println(romanToInt("XXI"));
//        System.out.println(romanToInt("MMVI"));
//        System.out.println(romanToInt("MCMXLIV"));
//        System.out.println(romanToInt("IIIIIII"));
//
//
//    }
//
//
//    @Test
//    public void testCheck() {
//
//        assertThat(check("I")).isTrue();
//        assertThat(check("II")).isTrue();
//        assertThat(check("III")).isTrue();
//        assertThat(check("IIII")).isFalse();
//
//        assertThat(check("X")).isTrue();
//        assertThat(check("XX")).isTrue();
//        assertThat(check("XXX")).isTrue();
//        assertThat(check("XXXX")).isFalse();
//        assertThat(check("XXXIX")).isTrue();
//
//        assertThat(check("C")).isTrue();
//        assertThat(check("CC")).isTrue();
//        assertThat(check("CCC")).isTrue();
//        assertThat(check("CCCC")).isFalse();
//        assertThat(check("CCCXC")).isTrue();
//        assertThat(check("CCCII")).isTrue();
//
//
//        assertThat(check("M")).isTrue();
//        assertThat(check("MM")).isTrue();
//        assertThat(check("MMM")).isTrue();
//        assertThat(check("MMMM")).isFalse();
//        assertThat(check("MMMCM")).isTrue();
//        assertThat(check("MMMCMM")).isFalse();
//        assertThat(check("MMMCMMM")).isFalse();
//        assertThat(check("MMMCMIX")).isTrue();
//        assertThat(check("CM")).isTrue();
//        assertThat(check("CMM")).isFalse();
//        assertThat(check("CMMM")).isFalse();
//
//
//
//        assertThat(check("IV")).isTrue();
//
//
//
//    }
//
//
//    private boolean check(String input) {
//
//        String partten = "^M?M?M?(CM|CD|D?C?C?C?)(XC|XL|L?X?X?X?)(IX|CX|IV|V?I?I?I?)$";
//
//        return Pattern.matches(partten, input);
//    }
//
//
//    @Test
//    public void test2() {
//
//    }
//
//
//    private boolean checkM(String input) {
//        String partten = "M{3}(CM{3})*";
//
//        return Pattern.matches(partten, input);
//    }
//
//
//    private static int romanToInt(String roman) {
//
//        Map<Character, Integer> map = new HashMap(7);
//        map.put('I', 1);
//        map.put('V', 5);
//        map.put('X', 10);
//        map.put('L', 50);
//        map.put('C', 100);
//        map.put('D', 500);
//        map.put('M', 1000);
//
//        int length = roman.length();
//        int result = 0;
//        int preVal = 0;
//        for (int i = length - 1; i >= 0; i--) {
//            char key = roman.charAt(i);
//            int value = map.get(key);
//            if (value >= preVal) {
//                result += value;
//            } else {
//                result -= value;
//            }
//
//            preVal = value;
//        }
//        return result;
//
//    }
//
//
//}
