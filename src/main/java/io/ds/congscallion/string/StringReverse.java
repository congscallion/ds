/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 * 反转字符串， 不能使用StringBuilder, StringBuffer 两个对象的reverse()方法。
 *
 * @author wangcong
 * @version $Id: StringReverse.java, v0.1 8/21/19 2:45 PM wangcong Exp $$
 */
public class StringReverse {

    public static String reverse(String word) {

        StringBuilder sb = new StringBuilder();
        char[] chars = word.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }


    public static String reverseRecursively(String word) {

        if (word.length() < 2) {
            return word;
        }

        return reverseRecursively(word.substring(1)) + word.charAt(0);

    }


}
