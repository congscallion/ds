package io.algorithm.sorting;


import java.util.Arrays;

/**
 * 合并排序
 */
public class MergeSort implements Sort{

  public  static void sort(int[] arr){
    sort(arr, 0, arr.length-1);
  }

  public static void sort(int[] arr, int left, int right){
    if(right > left){
      int m = (left + right) >> 1;
      sort(arr, left, m);
      sort(arr, m+1, right);
      merge(arr, left, m, right);
    }
  }

  public static void merge(int[] arr, int left, int m, int right){

    int left_length = m-left +1;
    int right_length = right - m;

    int[] left_arr = new int[left_length];
    int[] right_arr = new int[right_length];

    for (int i =0; i < left_length; i++) {
      left_arr[i] = arr[left+i];
    }

    for(int i = 0; i < right_length; i++){
      right_arr[i] = arr[m +1+ i];
    }

    int left_idx = 0;
    int right_idx = 0;
    int origin_idx = left;

    for(;left_idx < left_length && right_idx < right_length; origin_idx++ ){

      if(left_arr[left_idx] <= right_arr[right_idx]){
        arr[origin_idx] = left_arr[left_idx];
        left_idx++;
      }else{
        arr[origin_idx] = right_arr[right_idx];
        right_idx++;
      }

    }

    while(left_idx < left_length){

      arr[origin_idx] = left_arr[left_idx];
      left_idx++;
      origin_idx++;

    }

    while(right_idx < right_length){

      arr[origin_idx] = right_arr[right_idx];
      right_idx++;
      origin_idx++;

    }

  }


  public static void main(String[] args) {
    int[] arr = {12,52,1,23,45,11,25,17};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
