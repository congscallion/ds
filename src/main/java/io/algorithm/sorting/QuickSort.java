package io.algorithm.sorting;


import java.util.Arrays;

/**
 * 快速排序
 * <p><pre>
 *
 * 快速排序由C. A. R. Hoare在1960年提出。它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的
 * 所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * 快速排序算法通过多次比较和交换来实现排序，其排序流程如下：
 * (1)首先设定一个分界值，通过该分界值将数组分成左右两部分。
 * (2)将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。此时，左边部分中各元素都小于或等于分界值，
 *    而右边部分中各元素都大于或等于分界值。
 * (3)然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，
 *    同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
 * (4)重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。
 *    当左、右两个部分各数据排序完成后，整个数组的排序也就完成了。
 *  </pre>
 *
 * <p><pre>
 * 主流行选择分界值(枢轴/pivot)的方式：
 *
 *  1、始终选择第一个元素作为枢轴。
 *  2、始终选择最后一个元素为枢轴。
 *  3、选择一个随机元素作为枢轴。
 *  4、选择中位数作为枢轴。
 * </pre>
 *
 * <p><pre>
 *  快速排序的关键过程是partition(). 分区的目标是，给定一个数组和数组中的一个元素x作为分界值(枢轴/pivot).
 *  将x放在排序数组中的正确位置, 并将所有小于x的元素放在x之前, 并将所有大于x的元素放在x之后, 所有排序操作应该在线性时间内完成.
 *
 * </pre>
 */
public class QuickSort {


  public static void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  public static void sort(int[] arr, int from, int to) {

    if (from < to) {

      int pi = partition(arr, from, to);

      sort(arr, from, pi - 1);
      sort(arr, pi + 1, to);

    }


  }


  /**
   * 选择最后一个元素作为pivot.
   */
  private static int partition(int[] arr, int from, int to) {

    int pivot = arr[to];
    int i = from - 1;

    for (int j = from; j < to; j++) {

      if (arr[j] < pivot) {
        i++;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }

    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[to];
    arr[to] = temp;

    return i + 1;
  }


  public static void main(String[] args) {

    int arr[] = {10, 7, 8, 9, 1, 5};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));

    StdRandom.shuffle(arr);
    System.out.println(Arrays.toString(arr));


  }

}
