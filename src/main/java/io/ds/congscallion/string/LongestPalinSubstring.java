/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 * 给定一个字符串，找到最长的子回文，即回文。
 * 例如，如果给定的字符串是“forgeeksskeegfor”，则输出应为“geeksskeeg”
 *
 *
 * @author wangcong
 * @version $Id: LongestPalinSubstring.java, v0.1 8/22/19 2:57 PM wangcong Exp $$
 */
public class LongestPalinSubstring {


    private static String lpss(String str, int left, int right) {
        if (left < right) {
            int start = left, len = right - left + 1;
            String ret1, ret2;  // to keep return strings
            while (left < right && str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            }

            if (left >= right) {
                return str.substring(start, start + len);
            } else {
                ret1 = lpss(str, start + 1, len + start - 1);

                ret2 = lpss(str, start, start + len - 2);

                // retunr string which is larger one.
                if (ret1.length() > ret2.length()) {
                    return ret1;
                }
                return ret2;
            }

        }
        return "#";
    }

    public static String lpss(String word) {
        return lpss(word, 0, word.length() - 1);
    }


    public static String lpss2(String word) {
        return lpss2(word, 0, word.length() - 1);
    }


    public static String lpss2(String word, int left, int right) {

        if (left >= right) {
            return "#";
        }

        int start = left;
        int len = right - left + 1;
        String str1;
        String str2;
        while (left < right && word.charAt(left) == word.charAt(right)) {
            left++;
            right--;
        }

        if (left >= right) {
            return word.substring(start, start + len);
        } else {
            str1 = lpss2(word, start + 1, start + len - 1);
            str2 = lpss2(word, start, start + len - 2);
        }

        return str1.length() > str2.length() ? str1 : str2;

    }


}
