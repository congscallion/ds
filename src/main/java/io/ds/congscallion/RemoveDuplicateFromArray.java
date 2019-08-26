/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion;

import java.util.Arrays;

/**
 *
 * 从数组中删除重复数字
 *
 *
 * @author wangcong
 * @version $Id: RemoveDuplicateFromArray.java, v0.1 8/26/19 10:00 AM wangcong Exp $$
 */
public class RemoveDuplicateFromArray {


    /**
     *
     * 此方法要求数组已排序。 当数组未排序时，使用此方法， 可能会得到与预期不一致的结果
     *
     * @param arr
     * @return
     */
    public static int[] removeDuplicate(int[] arr) {

        int len = arr == null ? 0 : arr.length;

        if (len == 0 || len == 1) {
            return arr;
        }

        int j = 0;
        for (int i = 0; i < len - 1; i++) {

            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }

        }
        arr[j++] = arr[len - 1];

        int[] result = new int[j];
        System.arraycopy(arr, 0, result, 0, j);

        return result;

    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 3, 4, 2, 4, 4, 5};
        int[] result = removeDuplicate(arr);
        System.out.println(Arrays.toString(result));

        int[] arr2 = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int[] result2 = removeDuplicate(arr2);
        System.out.println(Arrays.toString(result2));

    }


}
