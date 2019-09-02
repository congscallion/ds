package io.algorithm.sorting;


import java.util.Arrays;

/**
 * <p><pre>
 * 与QuickSort一样，Merge Sort也是一种Divide and Conquer算法。它将输入数组分为两半，为两半调用自身，然后合并两个已排序的一半。
 * merge（）函数用于合并两半。合并（arr，l，m，r）是假设arr [l..m]和arr [m + 1..r]被排序并将两个排序的子数组合并为一个的关键过程。
 *
 * MergeSort(arr[], l,  r)
 * If r > l
 *      1. Find the middle point to divide the array into two halves:
 *              middle m = (l+r)/2
 *      2. Call mergeSort for first half:
 *              Call mergeSort(arr, l, m)
 *      3. Call mergeSort for second half:
 *              Call mergeSort(arr, m+1, r)
 *      4. Merge the two halves sorted in step 2 and 3:
 *              Call merge(arr, l, m, r)
 * </pre>
 *
 * @author wangcong
 * @version $Id: MergeSort.java, v0.1 8/26/19 3:16 PM wangcong Exp $$
 */
public class MergeSort implements Sort {

  public static void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  public static void sort(int[] arr, int left, int right) {
    if (right > left) {
      int m = (left + right) >> 1;
      sort(arr, left, m);
      sort(arr, m + 1, right);
      merge(arr, left, m, right);
    }
  }

  public static void merge(int[] arr, int left, int m, int right) {

    int left_length = m - left + 1;
    int right_length = right - m;

    int[] left_arr = new int[left_length];
    int[] right_arr = new int[right_length];

    for (int i = 0; i < left_length; i++) {
      left_arr[i] = arr[left + i];
    }

    for (int i = 0; i < right_length; i++) {
      right_arr[i] = arr[m + 1 + i];
    }

    int left_idx = 0;
    int right_idx = 0;
    int origin_idx = left;

    for (; left_idx < left_length && right_idx < right_length; origin_idx++) {

      if (left_arr[left_idx] <= right_arr[right_idx]) {
        arr[origin_idx] = left_arr[left_idx];
        left_idx++;
      } else {
        arr[origin_idx] = right_arr[right_idx];
        right_idx++;
      }

    }

    while (left_idx < left_length) {

      arr[origin_idx] = left_arr[left_idx];
      left_idx++;
      origin_idx++;

    }

    while (right_idx < right_length) {

      arr[origin_idx] = right_arr[right_idx];
      right_idx++;
      origin_idx++;

    }

  }


  public static void main(String[] args) {
    int[] arr = {12, 52, 1, 23, 45, 11, 25, 17};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
