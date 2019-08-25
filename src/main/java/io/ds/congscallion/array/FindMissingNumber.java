/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array;

import java.util.Arrays;
import java.util.BitSet;

/**
 * 从给定的1-N的数组中查找出缺失的数字
 *
 * @author wangcong
 * @version $Id: FindMissingNumber.java, v0.1 8/23/19 11:10 AM wangcong Exp $$
 */
public class FindMissingNumber {


  /**
   * 从1-N的数组中找出缺失数字， 数组长度是n-1， 不存在重复数字。 因此缺失数字只有一个。
   *
   * x1 = A1 ^ A2 ^ A4 ^ A5
   *
   * x2 = A1 ^ A2 ^ A3 ^ A4 ^ A5
   *
   * x1 ^ x2 = (A1 ^ A1) ^ (A2 ^ A2) ^ A3 ^ (A4 ^ A4) ^ (A5 ^ A5) = 0 ^ 0 ^ A3 ^ 0 ^ 0 = A3
   */
  public static int findOneMissingNum(int[] arr) {

    int len = arr.length;

    int x1 = arr[0];
    int x2 = 1;

    for (int i = 1; i < len; i++) {
      x1 ^= arr[i];
    }

    for (int i = 2; i <= len + 1; i++) {
      x2 ^= i;
    }

    return x1 ^ x2;
  }


  /**
   * 找出给定数组numbers中缺失的数字。 假定numbers数组包含1-N之间的数字，可重复且无序。
   *
   * count表示数组应该达主到的长度。 即 count - numbers.length 的值便是数组缺失的数字数量。
   */
  public static void printMissingNumber(int[] numbers, int count) {

    int minssingCount = count - numbers.length;
    BitSet bitSet = new BitSet(count);

    for (int number : numbers) {
      bitSet.set(number - 1);
    }

    System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
        Arrays.toString(numbers), count);

    int lastMissintIndex = 0;

    for (int i = 0; i < minssingCount; i++) {
      lastMissintIndex = bitSet.nextClearBit(lastMissintIndex);
      System.out.println(++lastMissintIndex);
    }

  }


  public static void main(String args[]) {

    // one missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

    // two missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

    // three missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

    // four missing number
    printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

    // Only one missing number in array
    int[] iArray = new int[]{1, 2, 3, 5};
    int missing = getMissingNumber(iArray, 5);
    System.out.printf("Missing number in array %s is %d %n",
        Arrays.toString(iArray), missing);
  }


  /**
   * Java method to find missing number in array of size n containing numbers from 1 to n only. can
   * be used to find missing elements on integer array of numbers from 1 to 100 or 1 - 1000
   */
  private static int getMissingNumber(int[] numbers, int totalCount) {
    int expectedSum = totalCount * ((totalCount + 1) / 2);
    int actualSum = 0;
    for (int i : numbers) {
      actualSum += i;
    }

    return expectedSum - actualSum;
  }


}
