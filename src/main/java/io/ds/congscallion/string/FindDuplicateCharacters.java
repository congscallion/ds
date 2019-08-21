/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Question1: 在字符串上查找重复字符
 *
 * 解决思路:
 *
 * 从String中获取字符数组，遍历它并构建一个包含字符及其计数的Map。然后遍历该Map并打印出现不止一次的字符。
 * 所以你实际上需要两个循环来完成这项工作，第一个循环来构建Map，第二个循环来打印字符和计数。
 *
 * @author wangcong
 * @version $Id: FindDuplicateCharacters.java, v0.1 8/21/19 10:57 AM wangcong Exp $$
 */
public class FindDuplicateCharacters {

    public static void main(String[] args) {

        printDuplicateCharacters("Programming");
        printDuplicateCharacters("Combination");
        printDuplicateCharacters("Java");

    }


    public static void printDuplicateCharacters(String word) {

        char[] characters = word.toCharArray();

        Map<Character, Integer> charMap = new HashMap<>();

        for (Character ch : characters) {

            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }

        }

        Set<Entry<Character, Integer>> entries = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);

        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }


    }


}
