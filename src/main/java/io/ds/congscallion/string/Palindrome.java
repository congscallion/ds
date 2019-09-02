/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 * 检查给定的字符是否是回文
 *
 * 如果String的反向等于自身，则称一个字符串是回文
 * 例如“aba”是回文，因为“aba”的反向也是“aba”，但是“abc”不是回文，因为“ abc“是”cba“这是不相等的
 *
 *
 * @author wangcong
 * @version $Id: Palindrome.java, v0.1 8/22/19 9:51 AM wangcong Exp $$
 */
public class Palindrome {


  public static boolean isPalindrome(String word) {

    return word.equals(reverse(word));
  }


  public static String reverse(String word) {

    if (word.length() < 2) {
      return word;
    }

    return reverse(word.substring(1)) + word.charAt(0);
  }


}
