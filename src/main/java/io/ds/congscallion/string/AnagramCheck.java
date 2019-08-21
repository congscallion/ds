/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import java.util.Arrays;

/**
 *
 * Question2: 检查两个字符串是否互为Anagram？
 * 字符串互为Anagram的前提是：字符串内包含的字符一样，且个数一样，只是顺序有可能不一样。
 *
 *
 * @author wangcong
 * @version $Id: AnagramCheck.java, v0.1 8/21/19 11:21 AM wangcong Exp $$
 */
public class AnagramCheck {


    /**
     * 两个字符串非空且长度相等，遍历其中一个字符串的字符， 依次从另一个字符串删除该字符，最后另一个字符串为空，即为anagram
     *
     *
     * @param word
     * @param anagram
     * @return
     */
    public static boolean isAnagram(String word, String anagram) {

        if (!checkValid(word, anagram)) {
            return false;
        }

        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder(anagram);
        for (char c : chars) {
            int index = sb.indexOf(c + "");
            if (index != -1) {
                sb.deleteCharAt(index);
            } else {
                return false;
            }
        }

        return sb.length() == 0;
    }


    public static boolean isAnagram2(String first, String second) {

        if (!checkValid(first, second)) {
            return false;
        }

        char[] charFromWord = first.toCharArray();
        char[] charFromAnagram = second.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);

        return Arrays.equals(charFromWord, charFromAnagram);
    }


    private static boolean checkValid(String word, String anagram) {
        if (null == word || anagram == null) {
            return false;
        }

        if (word.length() != anagram.length()) {
            return false;
        }

        return true;
    }


}
