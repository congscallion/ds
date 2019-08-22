/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 * 根据字符串长度排序字符串数组
 *
 * Input : {"GeeksforGeeeks", "I", "from", "am"}
 * Output : I am from GeeksforGeeks
 *
 * Input :  {"You", "are", "beautiful", "looking"}
 * Output : You are looking beautiful
 *
 *
 * @author wangcong
 * @version $Id: SortArrayOfStringByLen.java, v0.1 8/22/19 4:29 PM wangcong Exp $$
 */
public class SortArrayOfStringByLen {

    private static String[] sort(String[] s, int n) {
        for (int i = 1; i < n; i++) {
            String temp = s[i];

            int j = i - 1;
            while (j >= 0 && temp.length() < s[j].length()) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = temp;
        }

        return s;
    }

    public static String[] sort(String[] arr) {
        return sort(arr, arr.length);
    }

}
