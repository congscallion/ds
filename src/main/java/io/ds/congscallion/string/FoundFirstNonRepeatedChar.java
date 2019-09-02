/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * 查找字符串第一个非重复字符串，
 *
 * 例如，如果给定String是“Morning”，那么它应该打印“M”
 *
 * 例如，如果输入字符串是“GeeksforGeeks”，则输出应为“f”
 *
 * 例如，如果输入字符串为“G​​eeksQuiz”，则输出应为“G”
 *
 *
 *
 * @author wangcong
 * @version $Id: FoundFirstNonRepeatedChar.java, v0.1 8/21/19 12:20 PM wangcong Exp $$
 */
public class FoundFirstNonRepeatedChar {

  static Map<Character, CountIndex> getCharCountArray(String str) {
    HashMap<Character, CountIndex> hm = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      if (hm.containsKey(str.charAt(i))) {
        hm.get(str.charAt(i)).incCount();
      } else {
        hm.put(str.charAt(i), new CountIndex(i));
      }
    }

    return hm;

  }

  public static char foundFirstNonRepeatedChar(String str) {
    Map<Character, CountIndex> hm = getCharCountArray(str);
    int result = Integer.MAX_VALUE, i;

    for (i = 0; i < str.length(); i++) {

      if (hm.get(str.charAt(i)).count == 1 && result > hm.get(str.charAt(i)).index) {
        result = hm.get(str.charAt(i)).index;
      }

    }

    if (result == Integer.MAX_VALUE) {
      throw new RuntimeException("Undefined behaviour");
    } else {
      return str.charAt(result);
    }
  }

  public static char firstNonRepeatedCharacter(String word) {
    HashMap<Character, Integer> scoreboard = new HashMap<>(); // build table [char -> count]
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (scoreboard.containsKey(c)) {
        scoreboard.put(c, scoreboard.get(c) + 1);
      } else {
        scoreboard.put(c, 1);
      }
    } // since HashMap doesn't maintain order, going through string again
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (scoreboard.get(c) == 1) {
        return c;
      }
    }
    throw new RuntimeException("Undefined behaviour");
  }

  public static char firstNonRepeatingChar(String word) {

    HashSet<Character> repeating = new HashSet<>();
    List<Character> noRepeating = new ArrayList<>();

    for (int i = 0; i < word.length(); i++) {

      char c = word.charAt(i);

      if (repeating.contains(c)) {
        continue;
      }

      if (noRepeating.contains(c)) {
        noRepeating.remove((Character) c);
        repeating.add(c);
      } else {
        noRepeating.add(c);
      }
    }

    return noRepeating.get(0);
  }

  public static char getFirstNonRepeatedChar(String str) {
    Map<Character, Integer> counts = new LinkedHashMap<>(str.length());

    for (char c : str.toCharArray()) {
      counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
    }

    for (Entry<Character, Integer> entry : counts.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    throw new RuntimeException("didn't find any non repeated Character");
  }

  static class CountIndex {

    int count, index;

    public CountIndex(int index) {
      this.count = 1;
      this.index = index;
    }

    public void incCount() {
      this.count++;
    }
  }


}

