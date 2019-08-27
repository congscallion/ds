/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.algorithm.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 *
 *
 * @author wangcong
 * @version $Id: QuickSort2.java, v0.1 8/27/19 4:33 PM wangcong Exp $$
 */
public class QuickSort2 {

    private QuickSort2() {

    }


    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    public static void sort(Comparable[] arr, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {

        int i = lo;
        int j = hi + 1;

        Comparable v = arr[lo];
        while (true) {

            while (less(arr[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            while (less(v, arr[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(arr, i, j);

        }

        exch(arr, lo, j);

        return j;
    }

    private static void exch(Object[] a, int i, int j) {

        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    private static boolean isSorted(Comparable[] arr) {
        return isSorted(arr, 0, arr.length - 1);
    }

    private static boolean isSorted(Comparable[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }

        return true;
    }

    private static boolean less(Comparable v, Comparable w) {
        if (v == w) {
            return false;
        }
        return v.compareTo(w) < 0;
    }


    public static void main(String[] args) {

//        Integer[] a = new Integer[10];
//        Random r = new Random(System.currentTimeMillis());
//        for (int i = 0; i < 10; i++) {
//            a[i] = 1 + i + r.nextInt(50 - i);
//
//        }

        Integer[] a = {34, 40, 45, 43, 6, 49, 7, 12, 13, 46};
        System.out.println(Arrays.toString(a));

        sort(a);

        System.out.println(Arrays.toString(a));


    }

}
