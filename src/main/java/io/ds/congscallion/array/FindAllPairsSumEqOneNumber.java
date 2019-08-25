package io.ds.congscallion.array;


import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个程序来查找总和等于给定数字的所有整数对。例如，如果输入的整数数组{2,6，3，9，11}和给定的总和为9，输出应为{6,3}。
 */
public class FindAllPairsSumEqOneNumber {

  public static void printPairs(int[] arr, int num) {

    for (int i = 0; i < arr.length; i++) {
      int temp = arr[i];

      for (int j = i + 1; j < arr.length; j++) {
        int temp2 = arr[j];
        if ((temp + temp2) == num) {
          System.out.printf("(%d, %d) %n", temp, temp2);
        }
      }
    }
  }

  public static void printPairsUseSet(int[] arr, int num) {
    Set<Integer> set = new HashSet<>(arr.length);
    for (int number : arr) {

      int target = num - number;
      if (!set.contains(target)) {
        set.add(number);
      } else {
        System.out.printf("(%d,%d) %n", number, target);
      }
    }
  }

  public static void printPairsUseTwoPoints(int[] arr, int num) {

    int right = 0;
    int left = arr.length - 1;

    while (right < left) {

      int sum = arr[right] + arr[left];

      if (sum == num) {
        System.out.printf("(%d, %d) %n", arr[right], arr[left]);
        right++;
        left--;
      } else if (sum < num) {
        right++;
      } else {
        left--;
      }
    }
  }


  public static void main(String[] args) {

    int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
//    printPairs(arr1, 20);
//    printPairsUseSet(arr1, 20);
    printPairsUseTwoPoints(arr1, 20);
  }

}
