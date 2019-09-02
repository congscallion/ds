/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 * 使用指定字符串(比如："20%")替换字符串的空白字符
 *
 * @author wangcong
 * @version $Id: ReplaceSpaces.java, v0.1 8/21/19 5:27 PM wangcong Exp $$
 */
public class ReplaceSpaces {


  /**
   *
   * 先统计原字符串中的空白字符， 再计算新字符数组的长度， 最后替换空白字符。
   *
   */
  public static String replaceSpaces(String oldStr, String newStr) {

    int space_count = 0, i;
    for (i = 0; i < oldStr.length(); i++) {
      if (Character.isWhitespace(oldStr.charAt(i))) {
        space_count++;
      }
    }

    // 去掉末尾的空白字符（末尾的空白字符不替换）
    while (Character.isWhitespace(oldStr.charAt(i - 1))) {
      space_count--;
      i--;
    }

    char[] repArr = newStr.toCharArray();

    // 计算新数组的长度， 因为原空白字符占一个长度，所以新增的长度为 数量乘以 长度差
    int new_length = i + space_count * (repArr.length - 1);
    // 创建新的字符数组保存替换后的字符
    char[] new_str = new char[new_length];

    int index = new_length - 1;
    for (int j = i - 1; j >= 0; j--) {
      if (Character.isWhitespace(oldStr.charAt(j))) {

        for (int k = repArr.length - 1; k >= 0; k--) {

          new_str[index--] = repArr[k];

        }

      } else {
        new_str[index] = oldStr.charAt(j);
        index--;
      }
    }

    return new String(new_str);
  }


}
