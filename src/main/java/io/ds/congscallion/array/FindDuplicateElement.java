package io.ds.congscallion.array;


/**
 * 找出给定数组出现的重复数字
 */
public class FindDuplicateElement {

  public static void findDuplicate(int[] input) {
    int len = input.length;
    int size = (len >> 5) + 1;
    int i;
    int[] arr = new int[size];
    for (i = 0; i < len; ++i) {
      int e = input[i];
      int right_shift_idx = e >> 5;
      int left_left_idx = 1 << e;

      if ((arr[right_shift_idx] & left_left_idx) != 0) {
        System.out.println(input[i]);
      } else {
        arr[right_shift_idx] |= left_left_idx;
      }
    }
  }


  // Driver program
  public static void main(String[] args) {
    int arr[] = {4, 31, 26, 27, 28, 21, 11, 14, 16, 11, 27, 14, 28, 11, 31};
    findDuplicate(arr);


  }

}
