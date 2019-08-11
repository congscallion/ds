/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * @author wangcong
 * @version $Id: HashSetDemoTest.java, v0.1 7/3/19 4:37 PM wangcong Exp $$
 */
public class HashSetDemoTest {

  static final int MAXIMUM_CAPACITY = 1 << 30;

  private static int roundUpToPowerOf2(int number) {
    return number >= MAXIMUM_CAPACITY
        ? MAXIMUM_CAPACITY
        : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
  }

  static int indexFor(int h, int length) {
    return h & (length - 1);
  }

  @Test
  public void test1() {
    Set<String> set = new HashSet<>();
    set.add("a");
    set.add("b");
    set.add("c");
    set.add(null);
    set.add(null);
    set.add(null);

    System.out.println(Arrays.toString(set.toArray()));
  }

  @Test
  public void test2() {

    int number = 10;

    System.out.println(Integer.highestOneBit((number - 1) << 1));

  }

  @Test
  public void test3() {

    HashMap<String, String> map = new HashMap<>();
    for (int i = 65; i < 165; i++) {
      map.put(i + "", i + "");

    }
  }

  @Test
  public void test4() {
    for (int i = 0; i < 100; i++) {
      System.out.println(i + "-> " + roundUpToPowerOf2(i));
    }
  }

  @Test
  public void test5() {

    int len = 16;
    String len_bin_str = Integer.toBinaryString(len - 1);

    long str;
    for (int i = 0; i < 100; i++) {
      str = Long.valueOf(Integer.toBinaryString(i));
      System.out.printf("%010d%n", str);
      System.out.printf("%010d%n", Long.valueOf(len_bin_str));
      System.out.println("i-> " + i + "    :" + indexFor(i, len));

      System.out.println();
      System.out.println();


    }
  }

  @Test
  public void test6() {

    int num = 77;
    for (int i = 0; i < 100; i++) {
      System.out.println(i + " & 77 = " + (i & num) + ";   " + i + " % 77 = " + (i % num));

    }

  }
}
