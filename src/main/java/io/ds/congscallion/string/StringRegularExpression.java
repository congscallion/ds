/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import java.util.regex.Pattern;

/**
 *
 *
 * @author wangcong
 * @version $Id: CheckStringNumber.java, v0.1 8/21/19 3:18 PM wangcong Exp $$
 */
public class StringRegularExpression {

  public static final String DIGIT1 = ".*[^0-9].*";
  public static final String DIGIT2 = ".*\\D.*";


  public static boolean isDigit(String word) {

    return !Pattern.compile(DIGIT1).matcher(word).matches();
  }


  public static boolean isDigit2(String word) {
    return !Pattern.compile(DIGIT2).matcher(word).matches();
  }

  public static boolean isDigit3(String word) {
    return Pattern.compile("^[0-9]*$").matcher(word).matches();
  }

  public static boolean isDigit4(String word) {

    for (int i = 0; i < word.length(); i++) {
      if (!Character.isDigit(word.charAt(i))) {
        return false;
      }
    }

    return true;
  }


  public static boolean isStringOnlyAlphabet(String str) {
    return ((!str.equals(""))
        && (str != null)
        && (str.matches("^[a-zA-Z]*$")));
  }


}
