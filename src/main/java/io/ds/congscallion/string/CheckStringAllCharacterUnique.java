/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 * 检查字符串中所有字符是否唯一，字符串应只包含[a-z]的26个小写字母
 *
 * 实现一个节省空间的算法，以确定字符串（从'a'到'z'的字符）是否具有所有唯一字符。 不允许使用其他数据结构，如count数组，哈希等。
 *
 * 我们的想法是使用整数变量并使用其二进制表示中的位来存储字符是否存在。 通常，整数具有至少32位，并且我们需要存储仅存在26个字符的存在/不存在。
 *
 * @author wangcong
 * @version $Id: CheckStringAllCharacterUnique.java, v0.1 8/21/19 4:09 PM wangcong Exp $$
 */
public class CheckStringAllCharacterUnique {


    public static boolean areChractersUnique(String word) {

        int checher = 0;

        for (int i = 0; i < word.length(); i++) {

            int var = (word.charAt(i) - 'a');

            int temp = 1 << var;

            if ((checher & temp) > 0) {
                return false;
            }

            checher |= temp;
        }

        return true;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 26; i++) {
            System.out.println(1 << i);
        }


    }


}
