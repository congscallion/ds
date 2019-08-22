/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 * 给出三个串A，B和C.收件，检查C是否是A和B的交织可以假设有A和B之间没有共同的字符.
 * 如果C包含A和B的所有字符，则C被称为交织A和B，并保留各个字符串中所有字符的顺序.
 *
 *  first = "abc" and second = "def",  third = "dabecf" 有效
 *
 *
 *
 * @author wangcong
 * @version $Id: InterleavedTwoCharacters.java, v0.1 8/22/19 10:58 AM wangcong Exp $$
 */
public class InterleavedTwoCharacters {


    public static boolean isInterleaved(String A, String B, String C) {

        int i = 0, j = 0, k = 0;

        // Iterate through all characters of C.
        while (k < C.length()) {
            // Match first character of C with first character
            // of A. If matches them move A to next
            if (i < A.length() && A.charAt(i) == C.charAt(k)) {
                i++;
            }

            // Else Match first character of C with first
            // character of B. If matches them move B to next
            else if (j < B.length() && B.charAt(j) == C.charAt(k)) {
                j++;
            }

            // If doesn't match with either A or B, then return
            // false
            else {
                return false;
            }

            // Move C to next for next iteration
            k++;
        }

        // If A or B still have some characters,
        // then length of C is smaller than sum
        // of lengths of A and B, so return false
        if (i < A.length() || j < B.length()) {
            return false;
        }

        return true;
    }


    static boolean isInterleaved2(String A, String B, String C) {
        int a = 0, b = 0, c;

        for (c = 0; c < C.length(); c++) {

            char t = C.charAt(c);
            if ((b < B.length()) && (t == B.charAt(b))) {

                b++;
            } else if ((a < A.length()) && (t == A.charAt(a))) {

                a++;
            } else {

                return false;
            }

            if ((b == B.length()) && (a == A.length())) {

                return true;
            }
        }

        return false;
    }
}