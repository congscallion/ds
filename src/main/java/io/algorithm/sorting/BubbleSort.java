/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.algorithm.sorting;

import java.util.Arrays;

/**
 *
 * 冒泡排序是最简单的排序算法，通过重复交换相邻元素（后面的大小前面的元素）来工作。
 *
 * @author wangcong
 * @version $Id: BubbleSort.java, v0.1 8/26/19 11:33 AM wangcong Exp $$
 */
public class BubbleSort implements Sort {

  public static void sort(int[] arr) {

    int len = arr.length;

    for (int i = 0; i < len - 1; i++) {

      for (int j = 0; j < len - i - 1; j++) {

        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }

      }

    }

  }


  static void bubbleSort(int arr[]) {

    int len = arr.length;

    int i, j, temp;
    boolean swapped;
    for (i = 0; i < len - 1; i++) {
      swapped = false;
      for (j = 0; j < len - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // swap arr[j] and arr[j+1]
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }

      if (swapped == false) {
        break;
      }
    }
  }

  public static void main(String[] args) {

    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    sort(arr);
    System.out.println(Arrays.toString(arr));

    int arr2[] = {64, 34, 25, 12, 22, 11, 90};
    bubbleSort(arr2);
    System.out.println(Arrays.toString(arr2));

  }


}
