/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.algorithm.sorting;

import java.util.Arrays;

/**
 *
 * <p><pre>
 *
 *  选择排序算法通过从未排序部分重复查找最小元素（考虑升序）并将其放在开头来对数组进行排序。该算法在给定数组中维护两个子数组。
 *      1）已经排序的子阵列。
 *      2）未分类的剩余子阵列。
 * 在选择排序的每次迭代中，挑选来自未排序子阵列的最小元素（考虑升序）并将其移动到排序的子阵列。
 *
 * 以下示例解释了上述步骤：
 *
 * arr [] = 64 25 12 22 11
 *
 * //找到arr [0 ... 4]中的最小元素
 * //并将其放在开头
 * 11 25 12 22 64
 *
 * //找到arr [1 ... 4]中的最小元素
 * //并将其放在arr [1 ... 4]的开头
 * 11 12 25 22 64
 *
 * //找到arr [2 ... 4]中的最小元素
 * //并将其放在arr [2 ... 4]的开头
 * 11 12 22 25 64
 *
 * //找到arr [3 ... 4]中的最小元素
 * //并将其放在arr [3 ... 4]的开头
 * 11 12 22 25 64
 *
 *
 * </pre></p>
 * {@inheritDoc}
 *
 * @author wangcong
 * @version $Id: SelectionSort.java, v0.1 8/26/19 10:57 AM wangcong Exp $$
 */
public class SelectionSort implements Sort {

  public static void sort(int[] arr) {

    int len = arr.length;

    for (int i = 0; i < len - 1; i++) {

      int min_idx = i;
      for (int j = i + 1; j < len; j++) {
        if (arr[j] < arr[min_idx]) {
          min_idx = j;
        }
      }

      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;

    }

  }


  public static void main(String[] args) {

    int arr[] = {64, 25, 12, 22, 11};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
