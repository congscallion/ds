/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.algorithm.sorting;

import java.util.Arrays;

/**
 *
 * 插入排序是一种简单的排序算法，它的工作方式与我们手中的扑克牌排序方式相同。
 * 输入一个元素，检查数组列表中的每个元素，将其插入到一个已经排好序的数列中的适当位置，使数列依然有序，当最后一个元素放入合适位置时，该数组排序完毕。
 * 插入排序会涉及到两个区域：
 *  有序区域:有序区域内的元素，元素从小到大分布（或者从大到小分布）。在开始排序之前有序区域为第一个元素。
 *  无序区域:无序区域内的元素，元素任意分布，在开始排序之前除了第一个元素之外的所有元素都处在无序区域内。
 *
 * @author wangcong
 * @version $Id: InsertionSort.java, v0.1 8/26/19 2:32 PM wangcong Exp $$
 */
public class InsertionSort {

    public static void sort(int[] arr) {

        int len = arr.length;

        for (int i = 1; i < len; i++) {

            int t1 = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > t1) {
                    arr[j + 1] = arr[j];
                    arr[j] = t1;
                }
            }

        }

    }


    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }


}
