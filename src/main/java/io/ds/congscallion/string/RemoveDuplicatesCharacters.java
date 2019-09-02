/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import java.util.Arrays;

/**
 *
 * 删除给定字符串重复的字符, 此方法只能包含a-z小写字母的字符串
 *
 * 比如输入: geeksforgeeks, 输出: geksfor
 *    输入: characters     输出: chartes
 *
 *
 *
 *
 * @author wangcong
 * @version $Id: RemoveDuplicatesCharacters.java, v0.1 8/22/19 10:20 AM wangcong Exp $$
 */
public class RemoveDuplicatesCharacters {


  public static String removeDuplicates(String word) {

    int counter = 0;
    char[] array = word.toCharArray();
    int length = 0;

    for (char c : array) {

      int bit = c - 'a';

      int bitLifte = 1 << bit;

      if ((counter & bitLifte) == 0) {

        counter = counter | bitLifte;

        array[length] = c;
        length++;

      }

    }

    return String.valueOf(Arrays.copyOfRange(array, 0, length));
  }

}
