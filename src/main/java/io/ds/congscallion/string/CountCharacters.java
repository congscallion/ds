/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 *  统计字符串指定的子字符串或单字符出现的次数
 *
 * @author wangcong
 * @version $Id: CountCharacters.java, v0.1 8/21/19 4:45 PM wangcong Exp $$
 */
public class CountCharacters {


  public static int countOccurrencesOf(String src, String sub) {

    if (null == src || sub == null || src.length() == 0 || sub.length() == 0) {
      return 0;
    }

    int idx;
    int offset = 0;
    int count = 0;

    while ((idx = src.indexOf(sub, offset)) != -1) {
      ++count;
      offset = idx + sub.length();
    }

    return count;

  }

}
