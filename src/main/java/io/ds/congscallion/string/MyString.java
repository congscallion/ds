/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 *
 * @author wangcong
 * @version $Id: String.java, v0.1 8/20/19 6:12 PM wangcong Exp $$
 */
public class MyString implements Serializable, Comparable<String>, CharSequence {

  private static final long serialVersionUID = -6849794470754667710L;

  // 此变量用于字符存储
  private final char[] value;

  // 缓存字符串的的has code
  private int hash;


  // 创建一个字符串对象，代表一个空的字符序列. 请注意，由于字符串是不可变的，因此不必使用此构造函数。
  public MyString() {
    this.value = new char[0];
  }

  /**
   * 初始化一个新创建的String对象，使其表示与参数相同的字符序列; 换句话说，新创建的字符串是参数字符串的副本。
   * 除非需要显式的原始副本，否则不必使用此构造函数，因为字符串是不可变的。
   *
   * @param original
   */
  public MyString(MyString original) {
    this.value = original.value;
    this.hash = original.hash;
  }


  /**
   *
   * 分配一个新的String，使其表示当前包含在字符数组参数中的字符序列。 复制字符数组的内容; 后续修改字符数组不会影响新创建的字符串。
   *
   * @param value
   */
  public MyString(char value[]) {
    this.value = Arrays.copyOf(value, value.length);
  }

  /**
   * 分配一个新的String，其中包含字符数组参数的子数组中的字符。 offset参数是子数组的第一个字符的索引，count参数指定子数组的长度。
   * 子数组的内容被复制; 后续修改字符数组不会影响新创建的字符串。
   *
   * @param value
   * @param offset
   * @param count
   */
  public MyString(char value[], int offset, int count) {

    if (offset < 0) {
      throw new StringIndexOutOfBoundsException(offset);
    }

    if (count < 0) {
      throw new StringIndexOutOfBoundsException(count);
    }

    if (offset > value.length - count) {
      throw new StringIndexOutOfBoundsException(offset + count);
    }

    this.value = Arrays.copyOfRange(value, offset, offset + count);
  }


  /**
   * 分配一个新的String，其中包含Unicode代码点数组参数的子数组中的字符。 offset参数是子数组的第一个代码点的索引，count参数指定子数组的长度。
   * 子数组的内容转换为字符; 后续修改int数组不会影响新创建的字符串。
   *
   * @param codePoints
   * @param offset
   * @param count
   */
  public MyString(int[] codePoints, int offset, int count) {
    if (offset < 0) {
      throw new StringIndexOutOfBoundsException(offset);
    }

    if (count < 0) {
      throw new StringIndexOutOfBoundsException(count);
    }
    if (offset > codePoints.length - count) {
      throw new StringIndexOutOfBoundsException(offset + count);
    }

    final int end = offset + count;

    int n = count;

    for (int i = offset; i < end; i++) {
      int c = codePoints[i];
      if (Character.isBmpCodePoint(c)) {
        continue;
      } else if (Character.isValidCodePoint(c)) {
        n++;
      } else {
        throw new IllegalArgumentException(Integer.toString(c));
      }
    }

    final char[] v = new char[n];

    for (int i = offset, j = 0; i < end; i++, j++) {
      int c = codePoints[i];
      if (Character.isBmpCodePoint(c)) {
        v[j] = (char) c;
      } else {
        j++;
        v[j + 1] = Character.lowSurrogate(c);
        v[j] = Character.highSurrogate(c);
      }
    }

    this.value = v;
  }


  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }

    if (obj instanceof MyString) {
      MyString otherString = (MyString) obj;
      int n = value.length;
      if (n != otherString.length()) {
        return false;
      }

      int j = 0;
      char[] other = otherString.value;
      char[] v1 = value;
      while (n-- != 0) {
        if (v1[j] != other[j]) {
          return false;
        }
      }
      return true;
    }

    return false;
  }

  @Override
  public int length() {
    return value.length;
  }

  @Override
  public char charAt(int index) {
    return value[index];
  }

  @Override
  public CharSequence subSequence(int start, int end) {

    int len = end - start;

    return start == 0 && end == length() ? this : new String(value, start, len);
  }

  @Override
  public int compareTo(String o) {
    return 0;
  }
}
